package co.nz.csoft.emt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.nz.csoft.emt.dto.BookingDto;
import co.nz.csoft.emt.dto.EasemytripResponseDTO;
import co.nz.csoft.emt.dto.Rate;
import co.nz.csoft.emt.dto.OTARatesAndAvailabilityDto.PropertyDetails;
import co.nz.csoft.emt.model.Auth;
import co.nz.csoft.emt.service.EmtService;

@RestController
@RequestMapping("/api")
public class EmtController {

	@Value("${easemytrip.api.url}")
    private String apiUrl;
	@Value("${channel-token}")
    private String apiToken;
	Auth auth=new Auth();
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private EmtService emtService;

		@RequestMapping(value = "/getHotelList", method = RequestMethod.POST)
		public ResponseEntity<String> getHotelList() {        
		HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        String jsonPayload =auth.getHotelListReq() ;
        HttpEntity<String> request = new HttpEntity<>(jsonPayload, headers);        
        ResponseEntity<String> response = restTemplate.exchange(apiUrl+"/GetDetails", HttpMethod.POST, request, String.class);
        System.out.println(response.getBody());
        return response;
		}
		
		
		
		@RequestMapping(value = "/getRoomList", method = RequestMethod.POST)
	    public ResponseEntity<String> getRoomList() {
	       
			auth.setHotelCode("SHL-2401111496446221");
			
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Content-Type", "application/json");
	        String jsonPayload = auth.getRoomListReq();
	        HttpEntity<String> request = new HttpEntity<>(jsonPayload, headers);
	        ResponseEntity<String> response = restTemplate.exchange(apiUrl+"/GetDetails", HttpMethod.POST, request, String.class);	        
	        System.out.println(""+response.getBody());

	        return response;
	    }
		@RequestMapping(value = "/getRoomRatePlans", method = RequestMethod.POST)
		public ResponseEntity<EasemytripResponseDTO> getRoomRatePlans(@RequestParam String propertyId) {
			EasemytripResponseDTO dto = emtService.fetchRoomRateDetails(propertyId);
			return ResponseEntity.ok(dto);
		}
		
		
}	


