package co.nz.csoft.emt.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.nz.csoft.emt.dto.BookingDto;
import co.nz.csoft.emt.dto.CancelledBookingDto;
import co.nz.csoft.emt.dto.ExternalReservationDto;
import co.nz.csoft.emt.dto.Rate.PriceCancellation.RoomDetail;
import co.nz.csoft.emt.dto.ReservationDto;
import co.nz.csoft.emt.dto.RoomDetails;
import co.nz.csoft.emt.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	@Value("${external.reservation.url}")
	private String externalReservationURL;

	@Value("${emt.bookone.channel.id}")
	private String channelId;

	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper objMapper = new ObjectMapper();

	private static final Logger logger = LoggerFactory.getLogger(RatesAndAvailabilityServiceImpl.class);

	@Override
	public ExternalReservationDto[] fetchBooking(BookingDto booking) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		UUID uuid = UUID.randomUUID();
		now = LocalDateTime.now();
		try {
	        String bookingJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
	        logger.info("Incoming BookingDto payload:\n{}", bookingJson);
	    } catch (Exception e) {
	        logger.error("Failed to log BookingDto payload: {}", e.getMessage());
	    }
		List<ExternalReservationDto> externalReservationDtos = new ArrayList<>();

		logger.info(" Start ** TransationID ** {} ** at **  {} ** ", uuid, now.format(format));
		ExternalReservationDto externalReservationDto = new ExternalReservationDto();

		BookingDto.Data bookingData = booking.getData().get(0);

		// Basic details mapping
		BookingDto.BookData basicData = bookingData.getData().stream().filter(d -> "Basic".equals(d.getType()))
				.findFirst().orElse(null);

		if (basicData != null) {

			// externalReservationDto.setId(null);
			externalReservationDto.setChannelId(channelId);

			externalReservationDto.setExternalTransactionId(basicData.getClientRefNo());
			externalReservationDto.setCreatedTimestamp(new java.util.Date());
			DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			if (basicData.getCheckInDate() != null && !basicData.getCheckInDate().trim().isEmpty()) {
			    try {
			        LocalDate checkInDate = LocalDate.parse(basicData.getCheckInDate(), inputFormat);
			        externalReservationDto.setCheckinDate(checkInDate.format(outputFormat));
			    } catch (Exception e) {
			        logger.warn("Failed to parse CheckInDate: {}", basicData.getCheckInDate(), e);
			    }
			}

			if (basicData.getCheckOutDate() != null && !basicData.getCheckOutDate().trim().isEmpty()) {
			    try {
			        LocalDate checkOutDate = LocalDate.parse(basicData.getCheckOutDate(), inputFormat);
			        externalReservationDto.setCheckoutDate(checkOutDate.format(outputFormat));
			    } catch (Exception e) {
			        logger.warn("Failed to parse CheckOutDate: {}", basicData.getCheckOutDate(), e);
			    }
			}

			externalReservationDto.setPropertyId(basicData.getHotelCode());
			externalReservationDto.setOtaName("Easemytrip");
			externalReservationDto.setPropertyName(basicData.getHotelName());
			externalReservationDto.setTotalAmount(basicData.getTotalAmount());
			externalReservationDto.setPaidAmount(basicData.getTotalPaid());
			externalReservationDto.setNoOfPerson(Integer.parseInt(basicData.getTotalPax()));
			// externalReservationDto.setNoOfRooms(Integer.parseInt(basicData.getTotalRoom()));
			//externalReservationDto.setNoOfPerson(Integer.parseInt(basicData.getTotalPax()));
			externalReservationDto.setBookingStatus("Booked");
			externalReservationDto.setAmountBeforeTax(BigDecimal.valueOf(0));
			externalReservationDto.setTaxAmount(BigDecimal.valueOf(0));
			externalReservationDto.setModeOfPayment("CARD");
			externalReservationDto.setNotes("");
			externalReservationDto.setOtaReservationId(basicData.getClientRefNo());
			externalReservationDto.setUpdatedTimestamp(new java.util.Date());
			externalReservationDto.setCreatedTimestamp(new java.util.Date());

		}
		BookingDto.BookData billingData = bookingData.getData().stream()
				.filter(d -> "BillingDetail".equals(d.getType())).findFirst().orElse(null);

		if (billingData != null) {
			externalReservationDto.setFirstName(billingData.getFirstName());
			externalReservationDto.setLastName(billingData.getLastName());
			externalReservationDto.setContactNumber(billingData.getMobileNo());
			externalReservationDto.setEmail(billingData.getEmail());
		}
		BookingDto.BookData roomsData = bookingData.getData().stream().filter(d -> "Rooms".equals(d.getType()))
				.findFirst().orElse(null);

		if (roomsData != null) {
			List<RoomDetails> roomDetailsList = new ArrayList<>();
			for (BookingDto.Room room : roomsData.getRooms()) {
				RoomDetails roomDetail = new RoomDetails();
				roomDetail.setRoomTypeId(room.getRoomCode());
				roomDetail.setRoomTypeName(room.getRoomType());
				roomDetail.setRoomRate(room.getTotalAmount());
				// roomDetail.setTotalAmount(BigDecimal.valueOf(room.getTotalAmount()));
				//roomDetail.setPlan(room.getPlanId());
				if (room.getPlanId() != null) {
				    roomDetail.setPlan(room.getPlanId());
				} else {
				    roomDetail.setPlan("NA");
				}

				roomDetail.setNoOfadult(Integer.parseInt(room.getTotalAdult()));
				roomDetail.setNoOfchild(Integer.parseInt(room.getTotalChild()));
				roomDetail.setNoOfRooms(Integer.parseInt(basicData.getTotalRoom()));
				roomDetailsList.add(roomDetail);
			}
			externalReservationDto.setRoomDetails(roomDetailsList);
		}
		externalReservationDto.setPayloadType("XML");
		externalReservationDto.setCurrency("INR");
		externalReservationDtos.add(externalReservationDto);
		try {
			// Log before making the POST request
			logger.info("Sending POST request for ** TransactionID ** {} ** to External Reservation URL at ** {}", uuid,
					now.format(format));

			// Print the externalReservationURL and payload (externalReservationDto)
			logger.info("External Reservation URL: {}", externalReservationURL + "/api/external/reservation/");

			// Convert the payload (externalReservationDto) to JSON string for better
			// readability in logs
			String externalReservationDtoJson = objMapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(externalReservationDto);
			
			
			logger.info("[{}]", externalReservationDtoJson);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Post the data to external reservation service
			ResponseEntity<ExternalReservationDto[]> response = restTemplate.postForEntity(
					externalReservationURL + "/api/external/reservation/", externalReservationDtos,
					ExternalReservationDto[].class);
			System.out.println(response.getBody());

			// Log response
			logger.info("Received response for ** TransationID ** {} **: {}", uuid, response.getBody());
			// externalReservationDtos.add(response.getBody());
			ExternalReservationDto[] reservationArray = response.getBody();
			//externalReservationDtos.addAll(Arrays.asList(reservationArray));
			// Convert list to array and return
			return reservationArray;
		} catch (Exception ex) {
			logger.error("Error occurred during POST request for ** TransationID ** {} **: {}", uuid, ex.getMessage());
			throw new RuntimeException("Failed to fetch booking data", ex);
		}
	}
	/*
	@Override
	public ExternalReservationDto[] fetchBookingFromEMT(ReservationDto bookings) {
	    UUID uuid = UUID.randomUUID();
	    DateTimeFormatter logFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDateTime now = LocalDateTime.now();
	    
	    try {
	        String incomingJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookings);
	        logger.info("Incoming ReservationDto payload for TransactionID {}:\n{}", uuid, incomingJson);
	    } catch (Exception e) {
	        logger.warn("Failed to convert ReservationDto to JSON for logging", e);
	    }

	    List<ExternalReservationDto> externalReservationDtos = new ArrayList<>();

	    logger.info("Start ** TransactionID ** {} ** at ** {}", uuid, now.format(logFormat));

	    // Assuming only 1 reservation in the array
	    for (ReservationDto.Reservations resWrapper : Arrays.asList(bookings.getReservations())) {
	        for (ReservationDto.Reservation res : resWrapper.getReservation()) {

	            ExternalReservationDto externalReservationDto = new ExternalReservationDto();

	            externalReservationDto.setChannelId(channelId);
	            externalReservationDto.setExternalTransactionId(res.getId());
	            externalReservationDto.setCreatedTimestamp(new Date());
	            externalReservationDto.setUpdatedTimestamp(new Date());

	            // Dates
	            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            if (res.getRoom() != null && !res.getRoom().isEmpty()) {
	                ReservationDto.Room firstRoom = res.getRoom().get(0);
	                try {
	                    LocalDate checkin = LocalDate.parse(firstRoom.getArrival_date(), inputFormat);
	                    externalReservationDto.setCheckinDate(checkin.format(inputFormat));
	                } catch (Exception e) {
	                    logger.warn("Failed to parse arrival_date: {}", firstRoom.getArrival_date(), e);
	                }
	                try {
	                    LocalDate checkout = LocalDate.parse(firstRoom.getDeparture_date(), inputFormat);
	                    externalReservationDto.setCheckoutDate(checkout.format(inputFormat));
	                } catch (Exception e) {
	                    logger.warn("Failed to parse departure_date: {}", firstRoom.getDeparture_date(), e);
	                }
	            }

	            // Basic details
	            externalReservationDto.setPropertyId(res.getHotel_id());
	            externalReservationDto.setOtaName("Easemytrip");
	            externalReservationDto.setPropertyName(res.getHotel_name());
	            externalReservationDto.setTotalAmount(new BigDecimal(res.getTotalprice()));
	            externalReservationDto.setPaidAmount(new BigDecimal(res.getTotalprice())); // If fully paid
	            externalReservationDto.setBookingStatus("Booked");
	            externalReservationDto.setAmountBeforeTax(
	                new BigDecimal(res.getTotalprice()).subtract(new BigDecimal(res.getTaxamount()))
	            );
	            externalReservationDto.setTaxAmount(new BigDecimal(res.getTaxamount()));
	            externalReservationDto.setModeOfPayment("CARD");
	            externalReservationDto.setNotes(res.getCustomer().getRemarks());
	            externalReservationDto.setOtaReservationId(res.getId());
	            externalReservationDto.setCurrency(res.getCurrencycode());

	            // Customer info
	            if (res.getCustomer() != null) {
	                externalReservationDto.setFirstName(res.getCustomer().getFirst_name());
	                externalReservationDto.setLastName(res.getCustomer().getLast_name());
	                externalReservationDto.setContactNumber(res.getCustomer().getTelephone());
	                externalReservationDto.setEmail(res.getCustomer().getEmail());
	            }

	            // Rooms mapping
	            List<RoomDetails> roomDetailsList = new ArrayList<>();
	            for (ReservationDto.Room room : res.getRoom()) {
	                RoomDetails roomDetail = new RoomDetails();
	                roomDetail.setRoomTypeId(room.getId());
	                roomDetail.setRoomTypeName(room.getName());
	                //roomDetail.setRoomRate(new BigDecimal(room.getRoomprice()).doubleValue());
	                try {
	                    LocalDate arrival = LocalDate.parse(room.getArrival_date(), inputFormat);
	                    LocalDate departure = LocalDate.parse(room.getDeparture_date(), inputFormat);
	                    long nights = ChronoUnit.DAYS.between(arrival, departure);

	                    BigDecimal totalPrice = new BigDecimal(room.getRoomprice());
	                    BigDecimal taxPrice = res.getTaxamount() != null ? new BigDecimal(res.getTaxamount()) : BigDecimal.ZERO;
	                    BigDecimal priceExclTax = totalPrice.subtract(taxPrice);
	                    long effectiveNights = nights > 0 ? nights : 1; // if nights = 0, consider 1
	                    BigDecimal ratePerNight = priceExclTax.divide(BigDecimal.valueOf(effectiveNights), 2, RoundingMode.HALF_UP);

	                    roomDetail.setRoomRate(ratePerNight.doubleValue());
	                } catch (Exception e) {
	                    logger.warn("Failed to calculate room rate per night for room: {}", room.getName(), e);
	                    roomDetail.setRoomRate(new BigDecimal(room.getRoomprice()).doubleValue()); // fallback
	                }


	                // Plan name from price array
	                if (room.getPrice() != null && !room.getPrice().isEmpty()) {
	                    roomDetail.setPlan(room.getPrice().get(0).getRateplanname());
	                } else {
	                    roomDetail.setPlan("NA");
	                }

	                roomDetail.setNoOfadult(Integer.parseInt(room.getNumberofadult()));
	                roomDetail.setNoOfchild(Integer.parseInt(room.getNumberofchild()));
	                roomDetail.setNoOfRooms(1); // Not given directly
	                roomDetailsList.add(roomDetail);
	            }
	            externalReservationDto.setRoomDetails(roomDetailsList);

	            // Add to list
	            externalReservationDtos.add(externalReservationDto);
	        }
	    }

	    // POST to booking service
	    try {
	        logger.info("Sending POST request for ** TransactionID ** {} ** to External Reservation URL at ** {}", uuid,
	                now.format(logFormat));

	        logger.info("External Reservation URL: {}", externalReservationURL + "/api/external/reservation/");

	        String payloadJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(externalReservationDtos);
	        logger.info("[{}]", payloadJson);

	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	        ResponseEntity<ExternalReservationDto[]> response = restTemplate.postForEntity(
	                externalReservationURL + "/api/external/reservation/",
	                externalReservationDtos,
	                ExternalReservationDto[].class
	        );

	        logger.info("Received response for ** TransactionID ** {} **: {}", uuid, response.getBody());

	        return response.getBody();
	    } catch (Exception ex) {
	        logger.error("Error occurred during POST request for ** TransactionID ** {} **: {}", uuid, ex.getMessage());
	        throw new RuntimeException("Failed to create booking from EMT data", ex);
	    }
	}
*/
	
	@Override
	public ExternalReservationDto[] fetchBookingFromEMT(ReservationDto bookings) {
	    UUID uuid = UUID.randomUUID();
	    DateTimeFormatter logFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDateTime now = LocalDateTime.now();

	    try {
	        String incomingJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookings);
	        logger.info("Incoming ReservationDto payload for TransactionID {}:\n{}", uuid, incomingJson);
	    } catch (Exception e) {
	        logger.warn("Failed to convert ReservationDto to JSON for logging", e);
	    }

	    List<ExternalReservationDto> externalReservationDtos = new ArrayList<>();
	    logger.info("Start ** TransactionID ** {} ** at ** {}", uuid, now.format(logFormat));

	    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    for (ReservationDto.Reservations resWrapper : Arrays.asList(bookings.getReservations())) {
	        for (ReservationDto.Reservation res : resWrapper.getReservation()) {

	            // Group rooms by room.id + rate_id
	            Map<String, List<ReservationDto.Room>> groupedRooms = res.getRoom().stream()
	                    .collect(Collectors.groupingBy(r -> r.getId() + "|" +
	                                    ((r.getPrice() != null && !r.getPrice().isEmpty())
	                                            ? r.getPrice().get(0).getRate_id() : "NA"),
	                            LinkedHashMap::new, Collectors.toList()));

	            for (Map.Entry<String, List<ReservationDto.Room>> entry : groupedRooms.entrySet()) {
	                List<ReservationDto.Room> rooms = entry.getValue();
	                ReservationDto.Room firstRoom = rooms.get(0);

	                ExternalReservationDto externalReservationDto = new ExternalReservationDto();
	                externalReservationDto.setChannelId(channelId);
	                externalReservationDto.setExternalTransactionId(res.getId());
	                externalReservationDto.setCreatedTimestamp(new Date());
	                externalReservationDto.setUpdatedTimestamp(new Date());
	                externalReservationDto.setPropertyId(res.getHotel_id());
	                externalReservationDto.setOtaName("Easemytrip");
	                externalReservationDto.setPropertyName(res.getHotel_name());
	                externalReservationDto.setOtaReservationId(res.getId());
	                externalReservationDto.setCurrency(res.getCurrencycode());
	                externalReservationDto.setModeOfPayment("CARD");
	                externalReservationDto.setPayloadType("JSON");

	                // Booking status mapping
	                externalReservationDto.setBookingStatus("Booked");

	                // Customer info
	                if (res.getCustomer() != null) {
	                    externalReservationDto.setFirstName(res.getCustomer().getFirst_name());
	                    externalReservationDto.setLastName(res.getCustomer().getLast_name());
	                    externalReservationDto.setContactNumber(res.getCustomer().getTelephone());
	                    externalReservationDto.setEmail(res.getCustomer().getEmail());
	                    externalReservationDto.setNotes(res.getCustomer().getRemarks());
	                }

	                // Dates
	                LocalDate checkin = null;
	                LocalDate checkout = null;
	                try {
	                    checkin = LocalDate.parse(firstRoom.getArrival_date(), inputFormat);
	                    checkout = LocalDate.parse(firstRoom.getDeparture_date(), inputFormat);
	                    externalReservationDto.setCheckinDate(checkin.format(inputFormat));
	                    externalReservationDto.setCheckoutDate(checkout.format(inputFormat));
	                } catch (Exception e) {
	                    logger.warn("Failed to parse arrival/departure dates for room: {}", firstRoom.getId(), e);
	                }

	                // Pricing aggregation
	                int roomCount = rooms.size();
	                BigDecimal totalPrice = new BigDecimal(firstRoom.getRoomprice());
	                BigDecimal taxAmount = res.getTaxamount() != null ? new BigDecimal(res.getTaxamount()) : BigDecimal.ZERO;

	                long nights = 1;
	                if (checkin != null && checkout != null) {
	                    nights = ChronoUnit.DAYS.between(checkin, checkout);
	                    if (nights == 0) nights = 1;
	                }

	                BigDecimal amountBeforeTax = totalPrice.subtract(taxAmount);
	                BigDecimal ratePerNight = amountBeforeTax.divide(BigDecimal.valueOf(roomCount * nights), 2, RoundingMode.HALF_UP);
	                BigDecimal totalAmount = ratePerNight.multiply(BigDecimal.valueOf(roomCount * nights));

	                externalReservationDto.setTotalAmount(totalAmount);
	                externalReservationDto.setPaidAmount(totalAmount);
	                externalReservationDto.setTaxAmount(taxAmount);
	                externalReservationDto.setAmountBeforeTax(amountBeforeTax);

	                // Room details
	                List<RoomDetails> roomDetailsList = new ArrayList<>();
	                RoomDetails roomDetail = new RoomDetails();
	                roomDetail.setRoomTypeId(firstRoom.getId());
	                roomDetail.setRoomTypeName(firstRoom.getName());
	                roomDetail.setNoOfRooms(roomCount);
	                roomDetail.setNoOfadult(Integer.parseInt(firstRoom.getNumberofadult()));
	                roomDetail.setNoOfchild(Integer.parseInt(firstRoom.getNumberofchild()));
	                roomDetail.setCheckinDate(firstRoom.getArrival_date());
	                roomDetail.setCheckoutDate(firstRoom.getDeparture_date());
	                roomDetail.setPlan((firstRoom.getPrice() != null && !firstRoom.getPrice().isEmpty()
	                        && firstRoom.getPrice().get(0).getRateplanname() != null)
	                        ? firstRoom.getPrice().get(0).getRateplanname() : "NA");
	                roomDetail.setRoomRate(ratePerNight.doubleValue());

	                roomDetailsList.add(roomDetail);
	                externalReservationDto.setRoomDetails(roomDetailsList);

	                externalReservationDtos.add(externalReservationDto);
	            }
	        }
	    }
	    // POST to booking service
	    
	    try {
	        logger.info("Sending POST request for ** TransactionID ** {} ** to External Reservation URL at ** {}", uuid,
	                now.format(logFormat));
	        logger.info("External Reservation URL: {}", externalReservationURL + "/api/external/reservation/");

	        String payloadJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(externalReservationDtos);
	        logger.info("[{}]", payloadJson);

	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	        ResponseEntity<ExternalReservationDto[]> response = restTemplate.postForEntity(
	                externalReservationURL + "/api/external/reservation/",
	                externalReservationDtos,
	                ExternalReservationDto[].class
	        );

	        logger.info("Received response for ** TransactionID ** {} **: {}", uuid, response.getBody());

	        return response.getBody();
	    } catch (Exception ex) {
	        logger.error("Error occurred during POST request for ** TransactionID ** {} **: {}", uuid, ex.getMessage());
	        throw new RuntimeException("Failed to create booking from EMT data", ex);
	    }
	    
	   
	}

	@Override
	public ExternalReservationDto[] cancelBooking(CancelledBookingDto cancelledBookingDto) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a");
		DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timestampFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		// LocalDateTime now = LocalDateTime.now();
		UUID uuid = UUID.randomUUID();

		// Lists to hold ExternalReservationDto objects
		List<ExternalReservationDto> externalReservationDtoArrayList = new ArrayList<>();
		List<ExternalReservationDto> externalReservationDtos = new ArrayList<>();

		// Extract data from CancelledBookingDto
		CancelledBookingDto.Data bookingData = cancelledBookingDto.getData().get(0);
		String bookingId = null;

		// Check if bookingId exists
		if (bookingData.getResponseKey() != null) {
			bookingId = bookingData.getResponseKey();

			// Fetch external reservation by OTA reservation ID
			ResponseEntity<ExternalReservationDto[]> externalReservationList = restTemplate.getForEntity(
					externalReservationURL + "/api/external/reservation/getByOtaReservationId?otaReservationId="
							+ bookingId,
					ExternalReservationDto[].class);

			// Add all fetched reservations to the list
			Collections.addAll(externalReservationDtoArrayList, externalReservationList.getBody());

			// Get the last reservation object and clear the list
			ExternalReservationDto externalReservationDto = externalReservationDtoArrayList
					.get(externalReservationDtoArrayList.size() - 1);
			externalReservationDtoArrayList.clear();
			externalReservationDto
					.setId(bookingData.getResponseKey() != null ? Long.parseLong(bookingData.getResponseKey()) : null);
			externalReservationDto.setStatus(null);
			externalReservationDto.setBookingStatus("CANCELLED");
			LocalDate checkInDate = LocalDate.parse(bookingData.getCheckInDate(), format);
			LocalDate checkOutDate = LocalDate.parse(bookingData.getCheckOutDate(), format);
			externalReservationDto.setCheckinDate(checkInDate.format(formatt));
			externalReservationDto.setCheckoutDate(checkOutDate.format(formatt));
			long currentTimestamp = System.currentTimeMillis();
			Date currentDate = new Date(currentTimestamp);
			externalReservationDto.setCreatedDate(currentDate);
			externalReservationDto.setCreatedTimestamp(currentDate);
			externalReservationDto.setUpdatedTimestamp(currentDate);
			externalReservationDto.setLastModifiedDate(currentDate); 
			externalReservationDtoArrayList.add(externalReservationDto);
		}

		try {
			// Log the reservation
			logger.info("external Reservation: " + externalReservationDtoArrayList.toString());

			// Post the updated reservation to the external system
			ResponseEntity<ExternalReservationDto[]> externalReservationResponse = restTemplate.postForEntity(
					externalReservationURL + "/api/external/reservation/", externalReservationDtoArrayList,
					ExternalReservationDto[].class);

			// Get the response body and add to the final list
			ExternalReservationDto[] externalReservationDtoList = externalReservationResponse.getBody();
			Collections.addAll(externalReservationDtos, externalReservationDtoList);

			// Return the final list as an array
			return externalReservationDtos.toArray(new ExternalReservationDto[0]);

		} catch (Exception e) {
			// Log the exception and return an empty array
			logger.error("Error in cancelBooking: ", e);
			return new ExternalReservationDto[0]; // Return an empty array in case of an error
		}
	}

}
