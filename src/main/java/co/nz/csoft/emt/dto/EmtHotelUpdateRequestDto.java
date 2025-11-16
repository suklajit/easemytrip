package co.nz.csoft.emt.dto;

import java.util.List;

public class EmtHotelUpdateRequestDto {
	private String RequestType;
	private String Token;
	private String ClientHotelCode;
	private List<HotelData> Data;

	public String getRequestType() {
		return RequestType;
	}

	public void setRequestType(String requestType) {
		RequestType = requestType;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getClientHotelCode() {
		return ClientHotelCode;
	}

	public void setClientHotelCode(String clientHotelCode) {
		ClientHotelCode = clientHotelCode;
	}

	public List<HotelData> getData() {
		return Data;
	}

	public void setData(List<HotelData> data) {
		Data = data;
	}

	// Inner Class: HotelData
	public static class HotelData {
		private String RequestType;
		private String HotelName;
		private String HotelCode;

		private Double StarRating;
		private Integer NoofRooms;
		private Integer TotalFloor;
		private String BaseCurrency;
		private String Description;
		private TimeFormat CheckIn;
		private TimeFormat CheckOut;

		public String getRequestType() {
			return RequestType;
		}

		public void setRequestType(String requestType) {
			RequestType = requestType;
		}

		public String getHotelName() {
			return HotelName;
		}

		public void setHotelName(String hotelName) {
			HotelName = hotelName;
		}

		public String getHotelCode() {
			return HotelCode;
		}

		public void setHotelCode(String hotelCode) {
			this.HotelCode = hotelCode;
		}

		public Double getStarRating() {
			return StarRating;
		}

		public void setStarRating(Double starRating) {
			StarRating = starRating;
		}

		public Integer getNoofRooms() {
			return NoofRooms;
		}

		public void setNoofRooms(Integer noofRooms) {
			NoofRooms = noofRooms;
		}

		public Integer getTotalFloor() {
			return TotalFloor;
		}

		public void setTotalFloor(Integer totalFloor) {
			TotalFloor = totalFloor;
		}

		public String getBaseCurrency() {
			return BaseCurrency;
		}

		public void setBaseCurrency(String baseCurrency) {
			BaseCurrency = baseCurrency;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public TimeFormat getCheckIn() {
			return CheckIn;
		}

		public void setCheckIn(TimeFormat checkIn) {
			CheckIn = checkIn;
		}

		public TimeFormat getCheckOut() {
			return CheckOut;
		}

		public void setCheckOut(TimeFormat checkOut) {
			CheckOut = checkOut;
		}
	}

	// Inner Class: TimeFormat
	public static class TimeFormat {
		private String Hour;
		private String Minute;
		private String Type;

		public TimeFormat() {
		}

		public TimeFormat(String hour, String minute, String type) {
			this.Hour = hour;
			this.Minute = minute;
			this.Type = type;
		}

		public String getHour() {
			return Hour;
		}

		public void setHour(String hour) {
			Hour = hour;
		}

		public String getMinute() {
			return Minute;
		}

		public void setMinute(String minute) {
			Minute = minute;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}
	}
}
