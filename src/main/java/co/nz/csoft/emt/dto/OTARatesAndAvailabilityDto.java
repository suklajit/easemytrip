package co.nz.csoft.emt.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.nz.csoft.emt.enums.DayOfTheWeek;
import co.nz.csoft.emt.model.OtaAvailability;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OTARatesAndAvailabilityDto {

    private int count;
    private List<PropertyDetails> propertyDetails;
    private String channelManagerUpdateType;

    private String lastRetrivedTimeStamp;


    public List<PropertyDetails> getPropertyDetails() {
        if(propertyDetails == null){
            this.propertyDetails = new ArrayList<PropertyDetails>();
        }
        return propertyDetails;
    }

    public void setPropertyDetails(List<PropertyDetails> propertyDetails) {
        this.propertyDetails = propertyDetails;
    }
    public String getChannelManagerUpdateType() {
        return channelManagerUpdateType;
    }

    public void setChannelManagerUpdateType(String channelManagerUpdateType) {
        this.channelManagerUpdateType = channelManagerUpdateType;
    }
    public String getLastRetrivedTimeStamp() {
        return lastRetrivedTimeStamp;
    }

    public void setLastRetrivedTimeStamp(String lastRetrivedTimeStamp) {
        this.lastRetrivedTimeStamp = lastRetrivedTimeStamp;
    }

    @Override
    public String toString() {
        //OTARatesAndAvailabilityDto
        return "{" +
                "\"count\":\"" + count +
                "\", \"channelManagerUpdateType\":\"" + channelManagerUpdateType +
                "\", \"lastRetrivedTimeStamp\":\"" + lastRetrivedTimeStamp +
                "\", \"propertyDetails\":" + propertyDetails +
                "}";
    }


    public static class RoomTypeDetails {
        private  Long bookoneId;
        private String name;
        private int minLengthOfStay;
        private int maxLengthOfStay;
        private List<Availability> availabilities;
        private List<RatePlanDetails> roomPlanDetails;

        public List<Availability> getAvailabilities() {
            return availabilities;
        }

        public void setAvailabilities(List<Availability> availabilities) {
            this.availabilities = availabilities;
        }


        public int getMinLengthOfStay() {
            return minLengthOfStay;
        }

        public void setMinLengthOfStay(int minLengthOfStay) {
            this.minLengthOfStay = minLengthOfStay;
        }

        public int getMaxLengthOfStay() {
            return maxLengthOfStay;
        }

        public void setMaxLengthOfStay(int maxLengthOfStay) {
            this.maxLengthOfStay = maxLengthOfStay;
        }
        public Long getBookoneId() {
            return bookoneId;
        }

        public void setBookoneId(Long bookoneId) {
            this.bookoneId = bookoneId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public List<RatePlanDetails> getRoomPlanDetails() {
            return roomPlanDetails;
        }

        public void setRoomPlanDetails(List<RatePlanDetails> roomPlanDetails) {
            this.roomPlanDetails = roomPlanDetails;
        }


        @Override
        public String toString() {
            // RoomTypeDetails
            return "{" +
                    "\"bookoneId\":\"" + bookoneId +
                    "\", \"name\":\"" + name +
                    "\", \"minLengthOfStay\":\"" + minLengthOfStay +
                    "\", \"maxLengthOfStay\":\"" + maxLengthOfStay +
                    "\", \"roomPlanDetails\":" + roomPlanDetails +
                    ", \"availabilities\":" + availabilities +
                    "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoomTypeDetails that = (RoomTypeDetails) o;
            return Objects.equals(bookoneId, that.bookoneId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(bookoneId);
        }
    }
    public static class PropertyDetails {
        private  Long bookoneId;
        private String name;
        private int totalNoOfRooms;
        private int noOfAvailable;
        private String otaPropertyId;
        private int noOfBooked;
        private String date;
        private List<RoomTypeDetails> roomTypeDetails;


        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Long getBookoneId() {
            return bookoneId;
        }

        public void setBookoneId(Long bookoneId) {
            this.bookoneId = bookoneId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<RoomTypeDetails> getRoomTypeDetails() {
            if(roomTypeDetails == null){
                this.roomTypeDetails = new ArrayList<RoomTypeDetails>();
            }
            return roomTypeDetails;
        }

        public void setRoomTypeDetails(List<RoomTypeDetails> roomTypeDetails) {
            this.roomTypeDetails = roomTypeDetails;
        }

        public int getTotalNoOfRooms() {
            return totalNoOfRooms;
        }

        public void setTotalNoOfRooms(int totalNoOfRooms) {
            this.totalNoOfRooms = totalNoOfRooms;
        }

        public int getNoOfAvailable() {
            return noOfAvailable;
        }

        public void setNoOfAvailable(int noOfAvailable) {
            this.noOfAvailable = noOfAvailable;
        }

        public int getNoOfBooked() {
            return noOfBooked;
        }

        public void setNoOfBooked(int noOfBooked) {
            this.noOfBooked = noOfBooked;
        }

        public String getOtaPropertyId() {
            return otaPropertyId;
        }

        public void setOtaPropertyId(String otaPropertyId) {
            this.otaPropertyId = otaPropertyId;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PropertyDetails that = (PropertyDetails) o;
            return bookoneId.equals(that.bookoneId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(bookoneId);
        }
        @Override
        public String toString() {
            //PropertyDetails
            return "{" +
                    "\"bookoneId\":\"" + bookoneId +
                    "\", \"name\":\"" + name +
                    "\", \"otaPropertyId\":\"" + otaPropertyId +
                    "\", \"totalNoOfRooms\":\"" + totalNoOfRooms +
                    "\", \"noOfAvailable\":\"" + noOfAvailable +
                    "\", \"noOfBooked\":\"" + noOfBooked +
                    "\", \"date\":\"" + date +
                    "\", \"roomTypeDetails\":" + roomTypeDetails +
                    "}";
        }

    }
    public static class RatePlanDetails {
        private String code;
        private String name;
        private String effectiveDate;
        private String expiryDate;
        private String description;
        private BigDecimal amount;
        private String currency;
        private String status;
        private String restriction;
        private int minimumLengthOfStay;
        private int maximumLengthOfStay;
        private int minimumOccupancy;
        private int maximumOccupancy;
        private BigDecimal minAdvancedBookingOffset;
        private BigDecimal maxAdvancedBookingOffset;
        private BigDecimal extraChargePerPerson;
        private BigDecimal extraChargePerChild;
        private BigDecimal extraChargePerChild3To5yrs;
        private int noOfChildren;
        private List<DayOfTheWeek> dayOfTheWeekList;
        private List<OtaPlan> otaPlanList;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }



        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRestriction() {
            return restriction;
        }

        public void setRestriction(String restriction) {
            this.restriction = restriction;
        }
        public int getMinimumLengthOfStay() {
            return minimumLengthOfStay;
        }

        public void setMinimumLengthOfStay(int minimumLengthOfStay) {
            this.minimumLengthOfStay = minimumLengthOfStay;
        }

        public int getMaximumLengthOfStay() {
            return maximumLengthOfStay;
        }

        public void setMaximumLengthOfStay(int maximumLengthOfStay) {
            this.maximumLengthOfStay = maximumLengthOfStay;
        }
        
        public int getMinimumOccupancy() {
			return minimumOccupancy;
		}

		public void setMinimumOccupancy(int minimumOccupancy) {
			this.minimumOccupancy = minimumOccupancy;
		}

		public int getMaximumOccupancy() {
			return maximumOccupancy;
		}

		public void setMaximumOccupancy(int maximumOccupancy) {
			this.maximumOccupancy = maximumOccupancy;
		}

		public BigDecimal getExtraChargePerPerson() {
			return extraChargePerPerson;
		}

		public void setExtraChargePerPerson(BigDecimal extraChargePerPerson) {
			this.extraChargePerPerson = extraChargePerPerson;
		}

		public BigDecimal getExtraChargePerChild() {
			return extraChargePerChild;
		}

		public void setExtraChargePerChild(BigDecimal extraChargePerChild) {
			this.extraChargePerChild = extraChargePerChild;
		}

		public BigDecimal getExtraChargePerChild3To5yrs() {
			return extraChargePerChild3To5yrs;
		}

		public void setExtraChargePerChild3To5yrs(BigDecimal extraChargePerChild3To5yrs) {
			this.extraChargePerChild3To5yrs = extraChargePerChild3To5yrs;
		}

		public BigDecimal getMinAdvancedBookingOffset() {
			return minAdvancedBookingOffset;
		}

		public void setMinAdvancedBookingOffset(BigDecimal minAdvancedBookingOffset) {
			this.minAdvancedBookingOffset = minAdvancedBookingOffset;
		}

		public BigDecimal getMaxAdvancedBookingOffset() {
			return maxAdvancedBookingOffset;
		}

		public void setMaxAdvancedBookingOffset(BigDecimal maxAdvancedBookingOffset) {
			this.maxAdvancedBookingOffset = maxAdvancedBookingOffset;
		}

		public int getNoOfChildren() {
			return noOfChildren;
		}

		public void setNoOfChildren(int noOfChildren) {
			this.noOfChildren = noOfChildren;
		}

		public List<DayOfTheWeek> getDayOfTheWeekList() {
			return dayOfTheWeekList;
		}

		public void setDayOfTheWeekList(List<DayOfTheWeek> dayOfTheWeekList) {
			this.dayOfTheWeekList = dayOfTheWeekList;
		}

		public List<OtaPlan> getOtaPlanList() {
			return otaPlanList;
		}

		public void setOtaPlanList(List<OtaPlan> otaPlanList) {
			this.otaPlanList = otaPlanList;
		}

		@Override
        public String toString() {
            // RatePlanDetails
            return "{" +
                    "\"code\":\"" + code +
                    "\", \"name\":\"" + name +
                    "\", \"effectiveDate\":\"" + effectiveDate +
                    "\", \"expiryDate\":\"" + expiryDate +
                    "\", \"description\":\"" + description +
                    "\", \"amount\":\"" + amount +
                    "\", \"currency\":\"" + currency +
                    "\", \"status\":\"" + status +
                    "\", \"restriction\":\"" + restriction +
                    "\", \"minimumLengthOfStay\":\"" + minimumLengthOfStay +
                    "\", \"maximumLengthOfStay\":\"" + maximumLengthOfStay +
                    "\", \"dayOfTheWeekList\":" + dayOfTheWeekList +
                    ", \"otaPlanList\":" + otaPlanList +
                   "}";
        }


    }
    public static class Availability{
        private String startDate;
        private String endDate;
        private int noOfAvailable;
        private String status;
        private String restriction;
        private List<OtaAvailability> otaAvailabilities;
        
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRestriction() {
            return restriction;
        }

        public void setRestriction(String restriction) {
            this.restriction = restriction;
        }

        public int getNoOfAvailable() {
            return noOfAvailable;
        }

        public void setNoOfAvailable(int noOfAvailable) {
            this.noOfAvailable = noOfAvailable;
        }
        public String getStartDate() {
            return startDate;
        }

        public void setEndDate(String date) {
            this.endDate = date;
        }
        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }
    	public List<OtaAvailability> getOtaAvailabilities() {
			return otaAvailabilities;
		}

		public void setOtaAvailabilities(List<OtaAvailability> otaAvailabilities) {
			this.otaAvailabilities = otaAvailabilities;
		}
        @Override
        public String toString() {
            // Availability Details
            return "{" +
                    "\"startDate\":\"" + startDate +
                    "\", \"endDate\":\"" + endDate +
                    "\", \"noOfAvailable\":\"" + noOfAvailable +
                    "\", \"status\":\"" + status +
                    "\", \"restriction\":\"" + restriction +
                    "\", \"otaAvailabilities\":" + otaAvailabilities +
                    "}";
        }

    }
    
    public static class OtaPlan{

    	private String otaPlanId;
    	private String planName;
    	private String bookonePlanCode;
    	private String otaName;
    	private BigDecimal price;    	   	
    	private BigDecimal extraChargePerPerson;
        private BigDecimal extraChargePerChild;
    	private Boolean occupancyBased;
    	private Map<Integer, BigDecimal> occupancyRates;
    	
        

    	public Map<Integer, BigDecimal> getOccupancyRates() {
			return occupancyRates;
		}

		public void setOccupancyRates(Map<Integer, BigDecimal> occupancyRates) {
			this.occupancyRates = occupancyRates;
		}

		public Boolean getOccupancyBased() {
			return occupancyBased;
		}

		public void setOccupancyBased(Boolean occupancyBased) {
			this.occupancyBased = occupancyBased;
		}

		public BigDecimal getExtraChargePerPerson() {
			return extraChargePerPerson;
		}

		public void setExtraChargePerPerson(BigDecimal extraChargePerPerson) {
			this.extraChargePerPerson = extraChargePerPerson;
		}

		public BigDecimal getExtraChargePerChild() {
			return extraChargePerChild;
		}

		public void setExtraChargePerChild(BigDecimal extraChargePerChild) {
			this.extraChargePerChild = extraChargePerChild;
		}

		public String getOtaPlanId() {
    		return otaPlanId;
    	}

    	public void setOtaPlanId(String otaPlanId) {
    		this.otaPlanId = otaPlanId;
    	}

    	public String getPlanName() {
    		return planName;
    	}

    	public void setPlanName(String planName) {
    		this.planName = planName;
    	}

    	public String getBookonePlanCode() {
    		return bookonePlanCode;
    	}

    	public void setBookonePlanCode(String bookonePlanCode) {
    		this.bookonePlanCode = bookonePlanCode;
    	}

    	public String getOtaName() {
    		return otaName;
    	}

    	public void setOtaName(String otaName) {
    		this.otaName = otaName;
    	}

    	public BigDecimal getPrice() {
    		return price;
    	}

    	public void setPrice(BigDecimal price) {
    		this.price = price;
    	}
    	
    	@Override
    	public String toString() {
    	    return "OtaPlan{" +
    	            "otaPlanId='" + otaPlanId + '\'' +
    	            ", planName='" + planName + '\'' +
    	            ", bookonePlanCode='" + bookonePlanCode + '\'' +
    	            ", otaName='" + otaName + '\'' +
    	            ", price=" + price +
    	            ", extraChargePerPerson=" + extraChargePerPerson +
    	            ", extraChargePerChild=" + extraChargePerChild +
    	            ", occupancyBased=" + occupancyBased +
    	            ", occupancyRates=" + occupancyRates +
    	            '}';
    	}

    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
