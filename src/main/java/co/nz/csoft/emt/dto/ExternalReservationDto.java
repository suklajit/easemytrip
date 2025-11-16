package co.nz.csoft.emt.dto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import co.nz.csoft.emt.enums.ProcessingStatus;

public class ExternalReservationDto  {
	
    private Long id;
    private String channelId;
    private String externalTransactionId;
    private String bookoneReservationId;
//    @Temporal(TIMESTAMP)
    private Date createdTimestamp;
//    @Temporal(TIMESTAMP)
    private Date updatedTimestamp;
    private ProcessingStatus status;
    private String payloadType;
    private String otaName;
    private String otaReservationId;
    private String checkinDate;
    private String checkoutDate;
    private String propertyName;
    private String propertyId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String notes;
    private BigDecimal totalAmount;
    private BigDecimal amountBeforeTax;
    private BigDecimal taxAmount;
    private String  currency;
    private BigDecimal paidAmount;
    private String modeOfPayment;
    private String bookingStatus;
    private String propertyBusinessEmail;
    private String resType;
    private Integer noOfPerson;
   // private Integer noOfChildrenAbove5Years;
    //private Integer noOfChildrenBelow5Years;
   // private Integer noOfRooms;
    private String createdBy;
    private java.util.Date createdDate;
    private String lastModifiedBy;
    private java.util.Date lastModifiedDate;

    private List<RoomDetails> roomDetails=new ArrayList<RoomDetails>();
    
    

    public ExternalReservationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExternalReservationDto(Long id, String channelId, String externalTransactionId, String bookoneReservationId,
			Date createdTimestamp, Date updatedTimestamp, ProcessingStatus status, String payloadType, String otaName,
			String otaReservationId, String checkinDate, String checkoutDate, String propertyName, String propertyId,
			String firstName, String lastName, String contactNumber, String email, String notes, BigDecimal totalAmount,
			BigDecimal amountBeforeTax, BigDecimal taxAmount, String currency, BigDecimal paidAmount,
			String modeOfPayment, String bookingStatus, String propertyBusinessEmail, Integer noOfPerson, String resType,
			List<RoomDetails> roomDetails) {
		super();
		this.id = id;
		this.channelId = channelId;
		this.externalTransactionId = externalTransactionId;
		this.bookoneReservationId = bookoneReservationId;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.status = status;
		this.payloadType = payloadType;
		this.otaName = otaName;
		this.otaReservationId = otaReservationId;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.propertyName = propertyName;
		this.propertyId = propertyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.notes = notes;
		this.totalAmount = totalAmount;
		this.amountBeforeTax = amountBeforeTax;
		this.taxAmount = taxAmount;
		this.currency = currency;
		this.paidAmount = paidAmount;
		this.modeOfPayment = modeOfPayment;
		this.bookingStatus = bookingStatus;
		this.propertyBusinessEmail = propertyBusinessEmail;
		this.noOfPerson = noOfPerson;
		this.resType = resType;
		this.roomDetails = roomDetails;
	}

	public String getOtaName() {
        return otaName;
    }

    public void setOtaName(String otaName) {
        this.otaName = otaName;
    }



    public String getOtaReservationId() {
        return otaReservationId;
    }

    public void setOtaReservationId(String otaReservationId) {
        this.otaReservationId = otaReservationId;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getBookoneReservationId() {
        return bookoneReservationId;
    }

    public void setBookoneReservationId(String bookoneReservationId) {
        this.bookoneReservationId = bookoneReservationId;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }



    public ProcessingStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessingStatus status) {
        this.status = status;
    }
    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }
    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    public String getPropertyBusinessEmail() {
        return propertyBusinessEmail;
    }

    public void setPropertyBusinessEmail(String propertyBusinessEmail) {
        this.propertyBusinessEmail = propertyBusinessEmail;
    }
    public List<RoomDetails> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomDetails> roomDetails) {
        this.roomDetails = roomDetails;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public BigDecimal getAmountBeforeTax() {
        return amountBeforeTax;
    }

    public void setAmountBeforeTax(BigDecimal amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }
/*
    public Integer getNoOfChildrenAbove5Years() {
        return noOfChildrenAbove5Years;
    }

    public void setNoOfChildrenAbove5Years(Integer noOfChildrenAbove5Years) {
        this.noOfChildrenAbove5Years = noOfChildrenAbove5Years;
    }

    public Integer getNoOfChildrenBelow5Years() {
        return noOfChildrenBelow5Years;
    }

    public void setNoOfChildrenBelow5Years(Integer noOfChildrenBelow5Years) {
        this.noOfChildrenBelow5Years = noOfChildrenBelow5Years;
    }
*/
//    public Integer getNoOfRooms() {
//		return noOfRooms;
//	}
//
//	public void setNoOfRooms(Integer noOfRooms) {
//		this.noOfRooms = noOfRooms;
//	}
    

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalReservationDto that = (ExternalReservationDto) o;
        return
                Objects.equals(channelId, that.channelId) &&
                Objects.equals(externalTransactionId, that.externalTransactionId);

    }

    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public java.util.Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
    public int hashCode() {
        return Objects.hash(channelId, externalTransactionId);
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", channelId='" + channelId + '\'' +
                ", externalTransactionId='" + externalTransactionId + '\'' +
                ", bookoneReservationId='" + bookoneReservationId + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                ", status=" + status +
                ", payloadType='" + payloadType + '\'' +
                ", otaName='" + otaName + '\'' +
                ", otaReservationId='" + otaReservationId + '\'' +
                ", checkinDate='" + checkinDate + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", notes='" + notes + '\'' +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", propertyBusinessEmail='" + propertyBusinessEmail + '\'' +
                ", noOfPerson='" + noOfPerson + '\'' +
               // ", resStatus'" + resStatus + '\'' +
                ", resType'" + resType + '\'' +
                ", roomDetails=" + roomDetails +
                '}';
    }
}

