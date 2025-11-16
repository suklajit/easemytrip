package co.nz.csoft.emt.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CancelledBookingDto {
	@JsonProperty("Key")
	private String key;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("AgentCode")
	private String agentCode;

	 @JsonProperty("Data")
	 private List<Data> data;

	// Getters and Setters

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}



	// Inner class for BookingData
	public static class Data {

		@JsonProperty("ResponseKey")
		private String responseKey;

		@JsonProperty("HotelCode")
		private String hotelCode;

		@JsonProperty("CheckInDate")
		private String checkInDate;

		@JsonProperty("CheckOutDate")
		private String checkOutDate;

		// Getters and Setters

		public String getResponseKey() {
			return responseKey;
		}

		public void setResponseKey(String responseKey) {
			this.responseKey = responseKey;
		}

		public String getHotelCode() {
			return hotelCode;
		}

		public void setHotelCode(String hotelCode) {
			this.hotelCode = hotelCode;
		}

		public String getCheckInDate() {
			return checkInDate;
		}

		public void setCheckInDate(String checkInDate) {
			this.checkInDate = checkInDate;
		}

		public String getCheckOutDate() {
			return checkOutDate;
		}

		public void setCheckOutDate(String checkOutDate) {
			this.checkOutDate = checkOutDate;
		}
	}

}
