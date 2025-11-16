package co.nz.csoft.emt.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StopSellRequest {
	 @JsonProperty("Token")
	    private String token;

	    @JsonProperty("FromStopSellDate")
	    private String fromStopSellDate;

	    @JsonProperty("ToStopSellDate")
	    private String toStopSellDate;

	    @JsonProperty("HotelCode")
	    private String hotelCode;

	    @JsonProperty("RoomCode")
	    private String roomCode;

	    @JsonProperty("RatePlanCode")
	    private String ratePlanCode;

	    @JsonProperty("CTAr")  // Use PascalCase only
	    private boolean ctar;

	    @JsonProperty("CTD")  // Use PascalCase only
	    private boolean ctd;

	    @JsonProperty("StpSell")  // Use PascalCase only
	    private boolean stpSell;

	    @JsonProperty("LockLevel")
	    private String lockLevel;

	    @JsonProperty("Type")
	    private String type;

	    @JsonProperty("Status")
	    private String status;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getFromStopSellDate() {
			return fromStopSellDate;
		}

		public void setFromStopSellDate(String fromStopSellDate) {
			this.fromStopSellDate = fromStopSellDate;
		}

		public String getToStopSellDate() {
			return toStopSellDate;
		}

		public void setToStopSellDate(String toStopSellDate) {
			this.toStopSellDate = toStopSellDate;
		}

		public String getHotelCode() {
			return hotelCode;
		}

		public void setHotelCode(String hotelCode) {
			this.hotelCode = hotelCode;
		}

		public String getRoomCode() {
			return roomCode;
		}

		public void setRoomCode(String roomCode) {
			this.roomCode = roomCode;
		}

		public String getRatePlanCode() {
			return ratePlanCode;
		}

		public void setRatePlanCode(String ratePlanCode) {
			this.ratePlanCode = ratePlanCode;
		}

		public boolean isCtar() {
			return ctar;
		}

		public void setCtar(boolean ctar) {
			this.ctar = ctar;
		}

		public boolean isCtd() {
			return ctd;
		}

		public void setCtd(boolean ctd) {
			this.ctd = ctd;
		}

		public boolean isStpSell() {
			return stpSell;
		}

		public void setStpSell(boolean stpSell) {
			this.stpSell = stpSell;
		}

		public String getLockLevel() {
			return lockLevel;
		}

		public void setLockLevel(String lockLevel) {
			this.lockLevel = lockLevel;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
}