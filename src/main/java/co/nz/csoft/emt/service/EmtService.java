package co.nz.csoft.emt.service;

import org.springframework.http.ResponseEntity;

import co.nz.csoft.emt.dto.ClientHotelCodeRequestDto;
import co.nz.csoft.emt.dto.EasemytripResponseDTO;

public interface EmtService {
	ResponseEntity<String> setClientHotelCode(ClientHotelCodeRequestDto requestDto);

	EasemytripResponseDTO fetchRoomRateDetails(String propertyId);

}