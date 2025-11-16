package co.nz.csoft.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.nz.csoft.emt.dto.Availability;
import co.nz.csoft.emt.dto.BookingDto;
import co.nz.csoft.emt.dto.CancelledBookingDto;
import co.nz.csoft.emt.dto.ExternalReservationDto;
import co.nz.csoft.emt.dto.OTARatesAndAvailabilityDto.PropertyDetails;
import co.nz.csoft.emt.dto.Rate;
import co.nz.csoft.emt.dto.ReservationDto;
import co.nz.csoft.emt.dto.Response;
import co.nz.csoft.emt.service.BookingService;
import co.nz.csoft.emt.service.RatesAndAvailabilityService;
@RestController
@RequestMapping("/api/suphotel/save")
public class RatesAndAvailabilityController {

	    @Autowired
	    private RatesAndAvailabilityService ratesAndAvailabilityService;
	    @Autowired
	    private BookingService BookingDtoService;

	    @PostMapping("/updateinventory")//Final Api Working
	    public ResponseEntity<String> updateInventory(@RequestBody PropertyDetails propertyDetails) {
	        String response = ratesAndAvailabilityService.updateInventory(propertyDetails);
	        return ResponseEntity.ok(response);
	    }
	    @PostMapping("/updaterate")//finalApi working 
	    public ResponseEntity<String> updateRate(@RequestBody PropertyDetails rate) {
	    	String prate=ratesAndAvailabilityService.updateRates(rate);
	        return ResponseEntity.ok(prate);
	    }
//	    @PostMapping("/fetchbooking")
//	    public ResponseEntity<List<ExternalReservationDto>> testBookingDto1(@RequestBody BookingDto book) {
//	    	List<ExternalReservationDto> externalReservationDto=BookingDtoService.fetchBooking(book);
//	        return ResponseEntity.ok(externalReservationDto);
//	    }
	    @PostMapping("/fetchbooking")
	    public ResponseEntity<ExternalReservationDto[]> testBookingDto1(@RequestBody BookingDto book) {
	        // Fetching an array of ExternalReservationDto from the service
	        ExternalReservationDto[] externalReservationDtoArray = BookingDtoService.fetchBooking(book);
	        
	        // Return the array wrapped in ResponseEntity
	        return ResponseEntity.ok(externalReservationDtoArray);
	    }
	    
	    @PostMapping("/fetchReservations")
	    public ResponseEntity<ExternalReservationDto[]> fetchReservations(@RequestBody ReservationDto reservationDto) {
	        // Call your service method to fetch reservations
	    	ExternalReservationDto[] externalReservationDtoArray = BookingDtoService.fetchBookingFromEMT(reservationDto);

	        // Return the array wrapped in ResponseEntity
	        return ResponseEntity.ok(externalReservationDtoArray);
	    }

	    
	    @PostMapping("/cancelBookings")
	    public ResponseEntity<ExternalReservationDto[]> cancelBooking(@RequestBody CancelledBookingDto cancelledBooking) {
	        // Fetching an array of ExternalReservationDto from the service
	        ExternalReservationDto[] externalReservationDtoArray = BookingDtoService.cancelBooking(cancelledBooking);
	        
	        // Return the array wrapped in ResponseEntity
	        return ResponseEntity.ok(externalReservationDtoArray);
	    }

}