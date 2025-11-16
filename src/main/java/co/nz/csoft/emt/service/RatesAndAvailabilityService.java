package co.nz.csoft.emt.service;

import co.nz.csoft.emt.dto.Availability;
//import co.nz.csoft.emt.dto.Booking;
import co.nz.csoft.emt.dto.OTARatesAndAvailabilityDto.PropertyDetails;
import co.nz.csoft.emt.dto.Rate;

public interface RatesAndAvailabilityService {
	String updateInventory(PropertyDetails propertyDetails);

	String updateRates(PropertyDetails rate);


}
