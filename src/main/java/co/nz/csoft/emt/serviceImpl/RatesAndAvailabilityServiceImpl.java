
package co.nz.csoft.emt.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.nz.csoft.emt.dto.Availability;
import co.nz.csoft.emt.dto.Availability.UpdateAllocation;
import co.nz.csoft.emt.dto.Availability.UpdateAllocation.Allocation;

import co.nz.csoft.emt.dto.ErrorObject;
import co.nz.csoft.emt.dto.ExternalReservationDto;
import co.nz.csoft.emt.dto.OTARatesAndAvailabilityDto;
import co.nz.csoft.emt.dto.OTARatesAndAvailabilityDto.PropertyDetails;
import co.nz.csoft.emt.dto.OnlineTravelAgencyDto;
import co.nz.csoft.emt.dto.Rate;
import co.nz.csoft.emt.dto.Rate.PriceCancellation;
import co.nz.csoft.emt.dto.Rate.PriceCancellation.RoomDetail;
import co.nz.csoft.emt.dto.Rate.PriceCancellation.RoomDetail.RoomAvailablityDetail;
import co.nz.csoft.emt.dto.Rate.PriceCancellation.RoomDetail.RoomAvailablityDetail.PriceDetail;
import co.nz.csoft.emt.dto.Rate.PriceCancellation.RoomDetail.RoomAvailablityDetail.PriceDetail.CancellationPolicy;
import co.nz.csoft.emt.dto.Rate.PriceCancellation.RoomDetail.RoomCancellation;
import co.nz.csoft.emt.dto.RoomDto;
import co.nz.csoft.emt.dto.StopSellRequest;
import co.nz.csoft.emt.model.OtaAvailability;
import co.nz.csoft.emt.service.RatesAndAvailabilityService;

@Service
public class RatesAndAvailabilityServiceImpl implements RatesAndAvailabilityService {
	@Value("${external.reservation.url}")
	private String channelIntegrationUrl;

	@Value("${emt.bookone.channel.id}")
	private String channelId;

	@Value("${easemytrip.api.url}")
	private String emtUrl;

	@Value("${channel-token}")
	private String channelToken;

	private final RestTemplate restTemplate = new RestTemplate();
	private final ObjectMapper objMapper = new ObjectMapper();

	private static final Logger logger = LoggerFactory.getLogger(RatesAndAvailabilityServiceImpl.class);
	/*
	 * @Override public String updateInventory(PropertyDetails propertyDetails) {
	 * DateTimeFormatter format =
	 * DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); LocalDateTime now =
	 * LocalDateTime.now(); UUID uuid = UUID.randomUUID(); now =
	 * LocalDateTime.now();
	 * logger.info(" Start ** TransationID ** {} ** at **  {} ** ", uuid,
	 * now.format(format)); try { logger.
	 * info(" ***** Availability update request to EaseMyTrip from bookone ***** '{}'"
	 * , propertyDetails.toString());
	 * 
	 * for (OTARatesAndAvailabilityDto.RoomTypeDetails roomTypeDetail :
	 * propertyDetails.getRoomTypeDetails()) { if (roomTypeDetail != null &&
	 * roomTypeDetail.getBookoneId() != null) { ResponseEntity<RoomDto[]>
	 * roomDtoList = restTemplate.getForEntity(channelIntegrationUrl +
	 * "/api/channelManager/getChannelRoomDetails/BookOneProperty/"+propertyDetails.
	 * getBookoneId()+"?BookOneRoomId=" + roomTypeDetail.getBookoneId(),
	 * RoomDto[].class); RoomDto[] roomDtos = roomDtoList.getBody();
	 * 
	 * for (RoomDto roomDto : roomDtos) { List<OnlineTravelAgencyDto>
	 * onlineTravelAgencyDtos = roomDto.getOnlineTravelAgenciesDto(); for
	 * (OnlineTravelAgencyDto onlineTravelAgencyDto : onlineTravelAgencyDtos) { if
	 * (onlineTravelAgencyDto.getId() == Long.parseLong(channelId)) { for
	 * (OTARatesAndAvailabilityDto.Availability availability : roomTypeDetail
	 * .getAvailabilities()) { if (availability.getOtaAvailabilities() != null &&
	 * availability.getOtaAvailabilities().size() > 0) { List<Allocation>
	 * allocations = new ArrayList<>();
	 * 
	 * for (OtaAvailability otaAvailability : availability.getOtaAvailabilities()) {
	 * if (otaAvailability.getOtaName().equals("Easemytrip")) { Allocation
	 * allocation = new Allocation();
	 * allocation.setClientRoomCode(onlineTravelAgencyDto.getRoomId());
	 * allocation.setFrom(availability.getStartDate());
	 * allocation.setTo(availability.getEndDate());
	 * allocation.setAllocation(otaAvailability.getNoOfAvailable());
	 * allocations.add(allocation); } }
	 * 
	 * // Prepare request body for EaseMyTrip if (!allocations.isEmpty()) {
	 * Availability availabilityUpdate = new Availability();
	 * availabilityUpdate.setRequestType("SaveSupplierHotel");
	 * availabilityUpdate.setToken(channelToken); availabilityUpdate
	 * .setClientHotelCode(propertyDetails.getOtaPropertyId());
	 * 
	 * UpdateAllocation updateAllocation = new UpdateAllocation();
	 * updateAllocation.setData(allocations);
	 * updateAllocation.setRequestType("UpdateAllocation");
	 * 
	 * List<UpdateAllocation> updateAllocations = new ArrayList<>();
	 * updateAllocations.add(updateAllocation);
	 * availabilityUpdate.setData(updateAllocations);
	 * 
	 * HttpHeaders headers = new HttpHeaders(); headers.set("Content-Type",
	 * "application/json"); String jsonBody = availabilityUpdate.toString();
	 * logger.info("*******EaseMyTrip Request JSON ******" + jsonBody);
	 * 
	 * HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);
	 * String jsonResponse = null;
	 * 
	 * try { ResponseEntity<String> response = restTemplate.exchange( emtUrl +
	 * "/save", HttpMethod.POST, requestEntity, String.class); if
	 * (response.getStatusCode() == HttpStatus.OK) { jsonResponse =
	 * response.getBody(); logger.info("*******EaseMyTrip JSON Response******" +
	 * jsonResponse); } else {
	 * logger.error("Failed to get a proper response. Status code: {}",
	 * response.getStatusCode()); } } catch (Exception e) {
	 * logger.error("Error in sending request to EaseMyTrip: {}", e.getMessage()); }
	 * } } } } } } } } } catch (Exception ex) {
	 * logger.error("EaseMyTrip Availability Update - Exception", ex); } return
	 * null; }
	 */

	@Override
	public String updateInventory(PropertyDetails propertyDetails) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		UUID uuid = UUID.randomUUID();
		logger.info(" Start ** TransactionID ** {} ** at **  {} ** ", uuid, now.format(format));
		try {
			logger.info(" ***** Availability update request to EaseMyTrip from bookone ***** '{}'",
					propertyDetails.toString());

			for (OTARatesAndAvailabilityDto.RoomTypeDetails roomTypeDetail : propertyDetails.getRoomTypeDetails()) {
				if (roomTypeDetail != null && roomTypeDetail.getBookoneId() != null) {
					ResponseEntity<RoomDto[]> roomDtoList = restTemplate.getForEntity(channelIntegrationUrl
							+ "/api/channelManager/getChannelRoomDetails/BookOneProperty/"
							+ propertyDetails.getBookoneId() + "?BookOneRoomId=" + roomTypeDetail.getBookoneId(),
							RoomDto[].class);
					RoomDto[] roomDtos = roomDtoList.getBody();

					for (RoomDto roomDto : roomDtos) {
						List<OnlineTravelAgencyDto> onlineTravelAgencyDtos = roomDto.getOnlineTravelAgenciesDto();
						for (OnlineTravelAgencyDto onlineTravelAgencyDto : onlineTravelAgencyDtos) {
							if (onlineTravelAgencyDto.getId() == Long.parseLong(channelId)) {
								for (OTARatesAndAvailabilityDto.Availability availability : roomTypeDetail
										.getAvailabilities()) {
									if (availability.getOtaAvailabilities() != null
											&& !availability.getOtaAvailabilities().isEmpty()) {
										List<Allocation> allocations = new ArrayList<>();

										for (OtaAvailability otaAvailability : availability.getOtaAvailabilities()) {
											if (otaAvailability.getOtaName().equals("Easemytrip")) {
												if (otaAvailability.getStopSell() == true) {
													sendStopSellRequest(propertyDetails, roomTypeDetail, onlineTravelAgencyDto, availability, "1");
												    continue;
												    
												} else {
												    sendStopSellRequest(propertyDetails, roomTypeDetail, onlineTravelAgencyDto, availability, "0");
												    
												}
												Allocation allocation = new Allocation();
												allocation.setClientRoomCode(onlineTravelAgencyDto.getRoomId());
												allocation.setFrom(availability.getStartDate());
												allocation.setTo(availability.getEndDate());
												allocation.setAllocation(otaAvailability.getNoOfAvailable());
												allocations.add(allocation);
											}
										}

										// Prepare request body for EaseMyTrip
										if (!allocations.isEmpty()) {
											Availability availabilityUpdate = new Availability();
											availabilityUpdate.setRequestType("SaveSupplierHotel");
											availabilityUpdate.setToken(channelToken);
											availabilityUpdate.setClientHotelCode(propertyDetails.getOtaPropertyId());

											UpdateAllocation updateAllocation = new UpdateAllocation();
											updateAllocation.setData(allocations);
											updateAllocation.setRequestType("UpdateAllocation");

											List<UpdateAllocation> updateAllocations = new ArrayList<>();
											updateAllocations.add(updateAllocation);
											availabilityUpdate.setData(updateAllocations);

											try {
												// Convert Availability object to JSON string and log it
												String requestJson = objMapper.writeValueAsString(availabilityUpdate);
												logger.info("*******EaseMyTrip Request JSON******: {}", requestJson);
											} catch (JsonProcessingException e) {
												logger.error("Error serializing request payload: {}", e.getMessage());
											}

											HttpHeaders headers = new HttpHeaders();
											headers.set("Content-Type", "application/json");
											HttpEntity<Availability> requestEntity = new HttpEntity<>(
													availabilityUpdate, headers);

											try {
												ResponseEntity<String> response = restTemplate.exchange(
														emtUrl + "/save", HttpMethod.POST, requestEntity, String.class);
												if (response.getStatusCode() == HttpStatus.OK) {
													logger.info("*******EaseMyTrip JSON Response******"
															+ response.getBody());
												} else {
													logger.error("Failed to get a proper response. Status code: {}",
															response.getStatusCode());
												}
											} catch (Exception e) {
												logger.error("Error in sending request to EaseMyTrip: {}",
														e.getMessage());
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.error("EaseMyTrip Availability Update - Exception", ex);
		}
		return null;
	}

	private void sendStopSellRequest(PropertyDetails propertyDetails,
			OTARatesAndAvailabilityDto.RoomTypeDetails roomTypeDetail, OnlineTravelAgencyDto onlineTravelAgencyDto,
			OTARatesAndAvailabilityDto.Availability availability,String status) {
		RestTemplate restTemplate = new RestTemplate();
	    ObjectMapper objectMapper = new ObjectMapper();

	    String apiUrl = String.format(
	            "https://api.bookone.io/api-bookone/api/website/property/%s/room/%s/roomPlan",
	            propertyDetails.getBookoneId(), roomTypeDetail.getBookoneId());

	    List<String> easemytripPlanIds = new ArrayList<>();

	    try {
	        String response = restTemplate.getForObject(apiUrl, String.class);
	        JsonNode rootNode = objectMapper.readTree(response);

	        if (rootNode.isArray()) {
	            for (JsonNode planNode : rootNode) {
	                JsonNode otaPlanList = planNode.get("otaPlanList");
	                if (otaPlanList != null && otaPlanList.isArray()) {
	                    for (JsonNode otaPlan : otaPlanList) {
	                        String otaName = otaPlan.path("otaName").asText("");
	                        if ("Easemytrip".equalsIgnoreCase(otaName)) {
	                            String otaPlanId = otaPlan.path("otaPlanId").asText(null);
	                            if (otaPlanId != null && !otaPlanId.isEmpty()) {
	                                easemytripPlanIds.add(otaPlanId);
	                            }
	                        }
	                    }
	                }
	            }
	        }

	        if (easemytripPlanIds.isEmpty()) {
	            logger.warn("No Easemytrip rate plans found for propertyId={} and roomId={}",
	                    propertyDetails.getBookoneId(), roomTypeDetail.getBookoneId());
	            return;
	        }

	        logger.info("Found {} Easemytrip rate plans: {}", easemytripPlanIds.size(), easemytripPlanIds);

	    } catch (Exception e) {
	        logger.error("Error fetching OTA Plan IDs from BookOne API: {}", e.getMessage(), e);
	        return; // Exit gracefully if unable to fetch plans
	    }

	    // For each Easemytrip rate plan, send a Stop Sell request
	    for (String ratePlanId : easemytripPlanIds) {
	        StopSellRequest stopSellRequest = new StopSellRequest();
	        stopSellRequest.setToken(channelToken);
	        stopSellRequest.setFromStopSellDate(availability.getStartDate());
	        stopSellRequest.setToStopSellDate(availability.getEndDate());
	        stopSellRequest.setHotelCode("SHL-" + propertyDetails.getOtaPropertyId());
	        stopSellRequest.setRoomCode(onlineTravelAgencyDto.getRoomId());
	        stopSellRequest.setRatePlanCode(ratePlanId);
	        stopSellRequest.setCtar(true);
	        stopSellRequest.setCtd(true);
	        stopSellRequest.setLockLevel("RatePlan");
	        stopSellRequest.setType("StopSell");
	        stopSellRequest.setStatus(status);

	        boolean isStopSell = "true".equalsIgnoreCase(status) || "stopsell".equalsIgnoreCase(status);
	        stopSellRequest.setStpSell(isStopSell);

	        try {
	            String requestJson = objectMapper.writeValueAsString(stopSellRequest);
	            logger.info("Stop Sell Request Payload for Plan {}: {}", ratePlanId, requestJson);
	        } catch (JsonProcessingException e) {
	            logger.error("Error serializing Stop Sell request for Plan {}: {}", ratePlanId, e.getMessage(), e);
	        }

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<StopSellRequest> requestEntity = new HttpEntity<>(stopSellRequest, headers);

	        String easeMyTripApi = "https://inventoryapi.easemytrip.com/api/suphotel/SetHotelLock";

	        try {
	            ResponseEntity<String> stopSellResponse = restTemplate.exchange(
	                    easeMyTripApi, HttpMethod.POST, requestEntity, String.class);

	            if (stopSellResponse.getStatusCode() == HttpStatus.OK) {
	                logger.info("✅ Stop Sell Request Success for Plan {}: {}", ratePlanId, stopSellResponse.getBody());
	            } else {
	                logger.error("❌ Failed Stop Sell Request for Plan {}. Status: {}, Response: {}",
	                        ratePlanId, stopSellResponse.getStatusCode(), stopSellResponse.getBody());
	            }

	        } catch (Exception e) {
	            logger.error("Error sending Stop Sell request for Plan {} to EaseMyTrip: {}", ratePlanId, e.getMessage(), e);
	        }
	    }
	}

	@Override
	public String updateRates(PropertyDetails propertyDetails) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		UUID uuid = UUID.randomUUID();
		now = LocalDateTime.now();
		logger.info(" Start ** TransationID ** {} ** at ** {} ** ", uuid, now.format(format));

		try {
			logger.info(" ***** Rate update request to EMT from bookone ***** '{}'", propertyDetails.toString());
			for (OTARatesAndAvailabilityDto.RoomTypeDetails roomTypeDetail : propertyDetails.getRoomTypeDetails()) {

				if (roomTypeDetail != null && roomTypeDetail.getBookoneId() != null) {
					ResponseEntity<RoomDto[]> roomDtoList = restTemplate.getForEntity(channelIntegrationUrl
							+ "/api/channelManager/getChannelRoomDetails/BookOneProperty/"
							+ propertyDetails.getBookoneId() + "?BookOneRoomId=" + roomTypeDetail.getBookoneId(),
							RoomDto[].class);
					RoomDto[] roomDtos = roomDtoList.getBody();
					for (RoomDto roomDto : roomDtos) {
						List<OnlineTravelAgencyDto> onlineTravelAgencyDtos = roomDto.getOnlineTravelAgenciesDto();
						for (OnlineTravelAgencyDto onlineTravelAgencyDto : onlineTravelAgencyDtos) {

							if (onlineTravelAgencyDto.getId() == Long.valueOf(channelId)) {

								for (OTARatesAndAvailabilityDto.RatePlanDetails ratePlanDetail : roomTypeDetail
										.getRoomPlanDetails()) {

									for (OTARatesAndAvailabilityDto.OtaPlan otaPlan : ratePlanDetail.getOtaPlanList()) {

										if (otaPlan.getOtaName().equals("Easemytrip")) {

											Rate rateUpdate = new Rate();
											rateUpdate.setRequestType("SaveSupplierHotel");
											rateUpdate.setToken(channelToken);
											rateUpdate.setHotelCode(propertyDetails.getOtaPropertyId());

											RoomCancellation roomCancellation = new RoomCancellation();
											roomCancellation.setPolicyDescription("write something ");
											PriceCancellation priceCancellation = new PriceCancellation();
											priceCancellation.setRequestType("Price_Cancellation");

											RoomDetail roomDetail = new RoomDetail();
											List<RoomDetail> roomDetails = new ArrayList<>();
											roomDetails.add(roomDetail);
											roomDetail.setRoomCancellation(roomCancellation);

											roomDetail.setRoomCode(onlineTravelAgencyDto.getRoomId());
											roomDetail.setContractCode("");
											roomDetail.setFrom(ratePlanDetail.getEffectiveDate());
											roomDetail.setTo(ratePlanDetail.getExpiryDate());

											RoomAvailablityDetail roomAvailabilityDetail = new RoomAvailablityDetail();

											PriceDetail priceDetail = new PriceDetail();

											 Map<Integer, BigDecimal> occupancyRates = otaPlan.getOccupancyRates();
											 for (int i = 1; i <= ratePlanDetail.getMaximumOccupancy(); i++) {
												    BigDecimal amount;

												    if (Boolean.TRUE.equals(otaPlan.getOccupancyBased())) {
												        if (occupancyRates != null && occupancyRates.containsKey(i)) {
												            amount = occupancyRates.get(i);
												        } else {
												            // Fallback to base price
												            amount = otaPlan.getPrice();
												        }
												    } else {
												        amount = otaPlan.getPrice();
												        if (i > ratePlanDetail.getMinimumOccupancy()) {
												            BigDecimal extraCharge = otaPlan.getExtraChargePerPerson();
												            BigDecimal additional = extraCharge != null
												                ? extraCharge.multiply(BigDecimal.valueOf(i - ratePlanDetail.getMinimumOccupancy()))
												                : BigDecimal.ZERO;
												            amount = amount.add(additional);
												        }
												    }

												    switch (i) {
												        case 1: priceDetail.setOnePaxOccupancy(amount); break;
												        case 2: priceDetail.setTwoPaxOccupancy(amount); break;
												        case 3: priceDetail.setThreePaxOccupancy(amount); break;
												        case 4: priceDetail.setFourPaxOccupancy(amount); break;
												        case 5: priceDetail.setFivePaxOccupancy(amount); break;
												        case 6: priceDetail.setSixPaxOccupancy(amount); break;
												    }
												}

											priceDetail.setExtraAdultRate(otaPlan.getExtraChargePerPerson());
											priceDetail.setChildRate(otaPlan.getExtraChargePerChild());
											priceDetail.setPlanId(otaPlan.getOtaPlanId());
											priceDetail.setBt("B2C");

											CancellationPolicy cancellationPolicy = new CancellationPolicy();
											List<CancellationPolicy> cancellationPolicies = new ArrayList<>();
											cancellationPolicy.setCharges(0);
											cancellationPolicy.setFromDate(ratePlanDetail.getEffectiveDate());
											cancellationPolicy.setToDate(ratePlanDetail.getExpiryDate());
											cancellationPolicy.setChargeType("Percentage");
											cancellationPolicies.add(cancellationPolicy);

											priceDetail.setCancellationPolicy(cancellationPolicies);
											roomAvailabilityDetail.setPriceDetail(priceDetail);
											roomDetail.setRoomAvailabilityDetail(roomAvailabilityDetail);

											List<PriceCancellation> priceCancellations = new ArrayList<>();
											priceCancellations.add(priceCancellation);
											priceCancellation.setData(roomDetails);

											List<Rate> rateUpdates = new ArrayList<>();
											rateUpdate.setData(priceCancellations);
											rateUpdates.add(rateUpdate);

											HttpHeaders headers = new HttpHeaders();
											headers.set("Content-Type", "application/json");
											String jsonBody = rateUpdate.toString();
											logger.info("*******EaseMyTrip Request JSON ******" + jsonBody);

											HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);
											String jsonResponse = null;
											try {
												ResponseEntity<String> response = restTemplate.exchange(
														emtUrl + "/save", HttpMethod.POST, requestEntity, String.class);
												if (response.getStatusCode() == HttpStatus.OK) {
													jsonResponse = response.getBody();
													logger.info("*******EaseMyTrip JSON Response******" + jsonResponse);
//													return response.getBody();
												} else {
													System.out.println("Failed to get a proper response. Status code: "
															+ response.getStatusCode());
												}
											} catch (Exception e) {
												e.printStackTrace();
											}

											// return jsonResponse;

										}
									}
								}

							}
						}
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("'EaseMyTrip Rate Update - Exception' {}", ex.fillInStackTrace());
			ErrorObject errorObject = new ErrorObject();
			errorObject.setOrigin("BookOne Channel Manager");
			errorObject.setCode("BOI-EaseMyTrip-Rates-Update-connectivity of property: " + propertyDetails.getName());
			errorObject.setDescription(ex.getLocalizedMessage());
			errorObject.setType("RatesAndAvailabilityUpdate");
			try {
				errorObject.setPayload(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(propertyDetails));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}