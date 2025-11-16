package co.nz.csoft.emt.service;

import co.nz.csoft.emt.dto.BookingDto;
import co.nz.csoft.emt.dto.CancelledBookingDto;
import co.nz.csoft.emt.dto.ExternalReservationDto;
import co.nz.csoft.emt.dto.ReservationDto;

public interface BookingService {
	ExternalReservationDto[] fetchBooking(BookingDto booking);
	ExternalReservationDto[] cancelBooking(CancelledBookingDto cancelledBookingDto);
	ExternalReservationDto[] fetchBookingFromEMT(ReservationDto bookings);
	
}
