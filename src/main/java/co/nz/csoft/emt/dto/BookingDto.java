package co.nz.csoft.emt.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class BookingDto {
    
    @JsonProperty("Key")
    private String key;
    
    @JsonProperty("Data")
    private List<Data> data;
    public static class Data {
        
        @JsonProperty("Type")
        private String type;
        
        @JsonProperty("Data")
        private List<BookData> data;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<BookData> getData() {
			return data;
		}

		public void setData(List<BookData> data) {
			this.data = data;
		}

        
    }

    public static class BookData {
        
        @JsonProperty("Type")
        private String type;
        
        @JsonProperty("ClientRefNo")
        private String clientRefNo;
        
        @JsonProperty("CheckInTime")
        private String checkInTime;
        
        @JsonProperty("CheckOutTime")
        private String checkOutTime;
        
        @JsonProperty("HotelCode")
        private String hotelCode;
        
        @JsonProperty("HotelName")
        private String hotelName;
        
        @JsonProperty("TotalRoom")
        private String totalRoom;
        
        @JsonProperty("TotalAmount")
        private BigDecimal totalAmount;
        
        @JsonProperty("TotalPaid")
        private BigDecimal totalPaid;
        
        @JsonProperty("DiscountAmount")
        private String discountAmount;
        
        @JsonProperty("DiscountCode")
        private String discountCode;
        
        @JsonProperty("CheckInDate")
        private String checkInDate;

        @JsonProperty("CheckOutDate")
        private String checkOutDate;
        
        @JsonProperty("TotalPax")
        private String totalPax;
        
        @JsonProperty("MobileNo")
        private String mobileNo;
        
        @JsonProperty("Email")
        private String email;
        
        @JsonProperty("Title")
        private String title;
        
        @JsonProperty("FirstName")
        private String firstName;
        
        @JsonProperty("MiddleName")
        private String middleName;
        
        @JsonProperty("LastName")
        private String lastName;
        
        @JsonProperty("Data")
        private List<Room> rooms;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getClientRefNo() {
			return clientRefNo;
		}

		public void setClientRefNo(String clientRefNo) {
			this.clientRefNo = clientRefNo;
		}

		public String getCheckInTime() {
			return checkInTime;
		}

		public void setCheckInTime(String checkInTime) {
			this.checkInTime = checkInTime;
		}

		public String getCheckOutTime() {
			return checkOutTime;
		}

		public void setCheckOutTime(String checkOutTime) {
			this.checkOutTime = checkOutTime;
		}

		public String getHotelCode() {
			return hotelCode;
		}

		public void setHotelCode(String hotelCode) {
			this.hotelCode = hotelCode;
		}

		public String getHotelName() {
			return hotelName;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}

		public String getTotalRoom() {
			return totalRoom;
		}

		public void setTotalRoom(String totalRoom) {
			this.totalRoom = totalRoom;
		}

		public BigDecimal getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
		}

		public BigDecimal getTotalPaid() {
			return totalPaid;
		}

		public void setTotalPaid(BigDecimal totalPaid) {
			this.totalPaid = totalPaid;
		}

		public String getDiscountAmount() {
			return discountAmount;
		}

		public void setDiscountAmount(String discountAmount) {
			this.discountAmount = discountAmount;
		}

		public String getDiscountCode() {
			return discountCode;
		}

		public void setDiscountCode(String discountCode) {
			this.discountCode = discountCode;
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

		public String getTotalPax() {
			return totalPax;
		}

		public void setTotalPax(String totalPax) {
			this.totalPax = totalPax;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public List<Room> getRooms() {
			return rooms;
		}

		public void setRooms(List<Room> rooms) {
			this.rooms = rooms;
		}

    }

    public static class Room {
        
        @JsonProperty("RoomCode")
        private String roomCode;
        
        @JsonProperty("RoomType")
        private String roomType;
        
        @JsonProperty("BedType")
        private String bedType;
        
        @JsonProperty("TotalAdult")
        private String totalAdult;
        
        @JsonProperty("TotalChild")
        private String totalChild;
        
        @JsonProperty("TotalInfant")
        private String totalInfant;
        
        @JsonProperty("TotalAmount")
        private double totalAmount;
        
        @JsonProperty("PlanId")
        private String planId;
        
        @JsonProperty("PaxDetails")
        private List<PaxDetail> paxDetails;

		public String getRoomCode() {
			return roomCode;
		}

		public void setRoomCode(String roomCode) {
			this.roomCode = roomCode;
		}

		public String getRoomType() {
			return roomType;
		}

		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}

		public String getBedType() {
			return bedType;
		}

		public void setBedType(String bedType) {
			this.bedType = bedType;
		}

		public String getTotalAdult() {
			return totalAdult;
		}

		public void setTotalAdult(String totalAdult) {
			this.totalAdult = totalAdult;
		}

		public String getTotalChild() {
			return totalChild;
		}

		public void setTotalChild(String totalChild) {
			this.totalChild = totalChild;
		}

		public String getTotalInfant() {
			return totalInfant;
		}

		public void setTotalInfant(String totalInfant) {
			this.totalInfant = totalInfant;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getPlanId() {
			return planId;
		}

		public void setPlanId(String planId) {
			this.planId = planId;
		}

		public List<PaxDetail> getPaxDetails() {
			return paxDetails;
		}

		public void setPaxDetails(List<PaxDetail> paxDetails) {
			this.paxDetails = paxDetails;
		}

    }

    public static class PaxDetail {
        
        @JsonProperty("Title")
        private String title;
        
        @JsonProperty("FirstName")
        private String firstName;
        
        @JsonProperty("MiddleName")
        private String middleName;
        
        @JsonProperty("LastName")
        private String lastName;
        
        @JsonProperty("Type")
        private String type;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

    }
    

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
