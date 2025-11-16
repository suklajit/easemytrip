
package co.nz.csoft.emt.serviceImpl;

import co.nz.csoft.emt.dto.ClientHotelCodeRequestDto;
import co.nz.csoft.emt.dto.EasemytripResponseDTO;
import co.nz.csoft.emt.dto.EmtHotelUpdateRequestDto;
import co.nz.csoft.emt.dto.EmtHotelUpdateRequestDto.HotelData;
import co.nz.csoft.emt.dto.EmtHotelUpdateRequestDto.TimeFormat;
import co.nz.csoft.emt.service.EmtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.tree.RowMapper;

@Service
public class EmtServiceImpl implements EmtService {

	@Value("${easemytrip.api.url}")
	private String apiUrl;

	@Value("${channel-token}")
	private String token;


	private final RestTemplate restTemplate;

	public EmtServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private final ObjectMapper objMapper = new ObjectMapper();

	@Override
	public ResponseEntity<String> setClientHotelCode(ClientHotelCodeRequestDto requestDto) {
		try {
			EmtHotelUpdateRequestDto payload = new EmtHotelUpdateRequestDto();
			payload.setRequestType("SaveSupplierHotel");
			payload.setToken(token);
			payload.setClientHotelCode(requestDto.getClientHotelCode());

			HotelData data = new HotelData();
			data.setRequestType("Basic");
			data.setHotelName(requestDto.getHotelName());
			data.setStarRating(3.0);
			data.setNoofRooms(10);
			data.setTotalFloor(2);
			data.setBaseCurrency("INR");
			data.setDescription("ClientHotelCode Mapping");
			data.setCheckIn(new TimeFormat("12", "00", "PM"));
			data.setCheckOut(new TimeFormat("10", "00", "AM"));

			payload.setData(Collections.singletonList(data));

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<EmtHotelUpdateRequestDto> request = new HttpEntity<>(payload, headers);

			return restTemplate.exchange(apiUrl + "/save", HttpMethod.POST, request, String.class);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("❌ Error while updating ClientHotelCode: " + e.getMessage());
		}
	}

	@Override
	public EasemytripResponseDTO fetchRoomRateDetails(String propertyId) {

		Map<String, Object> request = new HashMap<>();
		Map<String, String> auth = new HashMap<>();
		auth.put("Token", token);
		auth.put("Type", "RoomListWithMealPlan");
		request.put("Auth", auth);
		request.put("HotelCode", propertyId);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

		ResponseEntity<JsonNode> response = restTemplate.exchange(apiUrl + "/GetDetails", HttpMethod.POST, entity,
				JsonNode.class);

		EasemytripResponseDTO result = new EasemytripResponseDTO();
		Map<String, EasemytripResponseDTO.Room> roomMap = new LinkedHashMap<>();

		if (response.getStatusCode() == HttpStatus.OK) {
			JsonNode data = response.getBody().get("Data");

			if (data != null && data.isArray() && data.size() > 0) {
				result.setPropertyId(data.get(0).get("HotelCode").asText());
				result.setPropertyName(data.get(0).get("HotelName").asText());

				for (JsonNode item : data) {
					String roomId = item.get("RoomCode").asText();
					String roomName = item.get("RoomName").asText();
					String planCode = item.get("PlanId").asText();
					String planName = item.get("PlanName").asText();

					EasemytripResponseDTO.Room room = roomMap.computeIfAbsent(roomId,
							k -> new EasemytripResponseDTO.Room(roomId, roomName, new ArrayList<>()));

					room.getRatePlans().add(new EasemytripResponseDTO.RatePlan(planCode, planName));
				}
			}
		}
		result.setRooms(new ArrayList<>(roomMap.values()));
		return result;
	}
}