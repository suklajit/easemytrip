//package co.nz.csoft.mmt.model;
//import co.nz.csoft.mmt.enums.BookingStatus;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import org.hibernate.annotations.Type;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import static javax.persistence.TemporalType.DATE;
//import static javax.persistence.TemporalType.TIMESTAMP;
//
//public class BookoneBooking{
//	private Long id;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String mobile;
//	private Date fromDate;
//	private Date toDate;
//	private java.util.Date fromTime;
//	private java.util.Date toTime;
//	private Double duration;
//	private String locationName;
//	private String resourceName;
//	private String businessName;
//	private String businessTypeName;
//	private String modeOfPayment;
//	private BigDecimal roomTariffBeforeDiscount;
//	private BigDecimal totalRoomTariffBeforeDiscount;
//	private BigDecimal roomPrice;
//	private int noOfNights;
//	private BigDecimal totalAmount;
//	private String businessEmail;
//	private boolean isValid;
//	private String notes;
//	private String externalBookingId;
//	private String externalSite;
//	private Long propertyId;
//	private Long roomId;
//	private BigDecimal payableAmount;
//	private String bookingUrl;
//	private String roomName;
//	private BigDecimal advanceAmount;
//	private BigDecimal totalServiceAmount;
//	private BigDecimal serviceAmountPaid;
//	private BigDecimal serviceAmountPending;
//	private BigDecimal totalExpenseAmount;
//	private BigDecimal totalPaymentAmount;
//	private BigDecimal discountAmount;
//	private Double discountPercentage;
//	private BigDecimal outstandingAmount;
//	private BigDecimal roomTariffPending;
//	private BigDecimal roomTariffPaid;
//	private String paymentUrl;
//	private BigDecimal extraPersonCharge;
//	private BigDecimal extraChildCharge;
//	private Integer noOfExtraPerson;
//	private BigDecimal beforeTaxAmount;
//	private BigDecimal taxAmount;
//	private Integer noOfRooms;
//	private Integer noOfPersons;
//	private java.util.Date checkinTime;
//	private String roomRatePlanName;
//	private Boolean isGroupBooking;
//	private String propertyReservationNumber;
//	private Long customerId;
//	private String invoiceId;
//	private String currency;
//	private Boolean isIncludeService;
//	private String hsnCode;
//	private boolean dayTrip;
//
//
//
//	private BookingStatus bookingStatus;
//
//	public boolean isDayTrip() {
//		return dayTrip;
//	}
//
//	public void setDayTrip(boolean dayTrip) {
//		this.dayTrip = dayTrip;
//	}
//
//	private Long bookOneReviewId;
//	@Transient
//	private BigDecimal totalBookingAmount;
//	// @Transient
//	private BigDecimal totalPayableAmount;
//	@Transient
//	private BigDecimal totalDiscountAmount;
//	@Transient
//	private BigDecimal totalBeforeTaxAmount;
//	@Transient
//	private BigDecimal totalTaxAmount;
//	@Transient
//	private Integer totalNumberOfRooms;
//	@Transient
//	private Integer totalNumberOfSoldRooms;
//	@Transient
//	private Integer totalNumberOfUnSolfRooms;
//	private String arrivingFrom;
//	private String departingTo;
//	private String purposeOfVisit;
//	private String counterNumber;
//	private String counterName;
//	private String operatorName;
//	private Integer noOfChildren;
//	private String roomNumbers;
//	private BigDecimal convenienceFee;
//	private BigDecimal bookingCommissionAmount;
//	private Long companyId;
//	private Long propertyInvoiceNumber;
//
//	// TDS and TCS information
//	private BigDecimal tdsFee;
//	private BigDecimal tcsFee;
//
//	// MultiBooking invoice
//	private Long groupBookingId;
//	private Boolean singleBookingInvoice;
//	private Boolean multiBookingInvoice;
//	private String operatorNotes;
//
//	public String getCounterNumber() {
//		return counterNumber;
//	}
//
//	public void setCounterNumber(String counterNumber) {
//		this.counterNumber = counterNumber;
//	}
//
//	public String getCounterName() {
//		return counterName;
//	}
//
//	public void setCounterName(String counterName) {
//		this.counterName = counterName;
//	}
//
//	public String getOperatorName() {
//		return operatorName;
//	}
//
//	public void setOperatorName(String operatorName) {
//		this.operatorName = operatorName;
//	}
//
//	public Long getBookOneReviewId() {
//		return bookOneReviewId;
//	}
//
//	public void setBookOneReviewId(Long bookOneReviewId) {
//		this.bookOneReviewId = bookOneReviewId;
//	}
//
//	public String getCompanyName() {
//		return companyName;
//	}
//
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
//
//	private String companyName;
//
//	public void setBookingUrl(String bookingUrl) {
//		this.bookingUrl = bookingUrl;
//	}
//
//	public BigDecimal getBeforeTaxAmount() {
//		return beforeTaxAmount;
//	}
//
//	public void setBeforeTaxAmount(BigDecimal beforeTaxAmount) {
//		this.beforeTaxAmount = beforeTaxAmount;
//	}
//
//	public java.util.Date getCheckinTime() {
//		return checkinTime;
//	}
//
//	public void setCheckinTime(java.util.Date checkinTime) {
//		this.checkinTime = checkinTime;
//	}
//
//	public java.util.Date getCheckoutTime() {
//		return checkoutTime;
//	}
//
//	public void setCheckoutTime(java.util.Date checkoutTime) {
//		this.checkoutTime = checkoutTime;
//	}
//
//	private java.util.Date checkoutTime;
//
//	public Integer getNoOfRooms() {
//		return noOfRooms;
//	}
//
//	public void setNoOfRooms(Integer noOfRooms) {
//		this.noOfRooms = noOfRooms;
//	}
//
//	public Integer getNoOfPersons() {
//		return noOfPersons;
//	}
//
//	public void setNoOfPersons(Integer noOfPersons) {
//		this.noOfPersons = noOfPersons;
//	}
//
//	public String getRoomName() {
//		return roomName;
//	}
//
//	public void setRoomName(String roomName) {
//		this.roomName = roomName;
//	}
//
//	public BigDecimal getAirportShuttlePrice() {
//		return airportShuttlePrice;
//	}
//
//	public void setAirportShuttlePrice(BigDecimal airportShuttlePrice) {
//		this.airportShuttlePrice = airportShuttlePrice;
//	}
//
//	public boolean isValid() {
//		return isValid;
//	}
//
//	public void setValid(boolean valid) {
//		isValid = valid;
//	}
//
//	private BigDecimal airportShuttlePrice;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//
//	public Date getFromDate() {
//		return fromDate;
//	}
//
//	public void setFromDate(Date fromDate) {
//		this.fromDate = fromDate;
//	}
//
//	public Date getToDate() {
//		return toDate;
//	}
//
//	public void setToDate(Date toDate) {
//		this.toDate = toDate;
//	}
//
//	public BigDecimal getRoomPrice() {
//		return roomPrice;
//	}
//
//	public void setRoomPrice(BigDecimal roomPrice) {
//		this.roomPrice = roomPrice;
//	}
//
//	public int getNoOfNights() {
//		return noOfNights;
//	}
//
//	public void setNoOfNights(int noOfNights) {
//		this.noOfNights = noOfNights;
//	}
//
//	public String getBusinessName() {
//		return businessName;
//	}
//
//	public void setBusinessName(String businessName) {
//		this.businessName = businessName;
//	}
//
//	public BigDecimal getTotalAmount() {
//		return totalAmount;
//	}
//
//	public void setTotalAmount(BigDecimal totalAmount) {
//		this.totalAmount = totalAmount;
//	}
//
//	public String getBusinessEmail() {
//		return businessEmail;
//	}
//
//	public void setBusinessEmail(String businessEmail) {
//		this.businessEmail = businessEmail;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getNotes() {
//		return notes;
//	}
//
//	public void setNotes(String notes) {
//		this.notes = notes;
//	}
//
//	public String getExternalBookingId() {
//		return externalBookingId;
//	}
//
//	public void setExternalBookingId(String externalBookingId) {
//		this.externalBookingId = externalBookingId;
//	}
//
//	public String getExternalSite() {
//		return externalSite;
//	}
//
//	public void setExternalSite(String externalSite) {
//		this.externalSite = externalSite;
//	}
//
//	public Long getPropertyId() {
//		return propertyId;
//	}
//
//	public void setPropertyId(Long propertyId) {
//		this.propertyId = propertyId;
//	}
//
//	public Long getRoomId() {
//		return roomId;
//	}
//
//	public void setRoomId(Long roomId) {
//		this.roomId = roomId;
//	}
//
//	public BigDecimal getPayableAmount() {
//		return payableAmount;
//	}
//
//	public BigDecimal getTotalServiceAmount() {
//		return totalServiceAmount;
//	}
//
//	public void setTotalServiceAmount(BigDecimal totalServiceAmount) {
//		this.totalServiceAmount = totalServiceAmount;
//	}
//
//	public BigDecimal getTotalExpenseAmount() {
//		return totalExpenseAmount;
//	}
//
//	public void setTotalExpenseAmount(BigDecimal totalExpenseAmount) {
//		this.totalExpenseAmount = totalExpenseAmount;
//	}
//
//	public BigDecimal getTotalPaymentAmount() {
//		return totalPaymentAmount;
//	}
//
//	public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
//		this.totalPaymentAmount = totalPaymentAmount;
//	}
//
//	public BigDecimal getDiscountAmount() {
//		return discountAmount;
//	}
//
//	public void setDiscountAmount(BigDecimal discountAmount) {
//		this.discountAmount = discountAmount;
//	}
//
//	public BigDecimal getOutstandingAmount() {
//		return outstandingAmount;
//	}
//
//	public void setOutstandingAmount(BigDecimal outstandingAmount) {
//		this.outstandingAmount = outstandingAmount;
//	}
//
//	public String getPaymentUrl() {
//		return paymentUrl;
//	}
//
//	public void setPaymentUrl(String paymentUrl) {
//		this.paymentUrl = paymentUrl;
//	}
//
//	public String getRoomRatePlanName() {
//		return roomRatePlanName;
//	}
//
//	public void setRoomRatePlanName(String roomRatePlanName) {
//		this.roomRatePlanName = roomRatePlanName;
//	}
//
//	public void setPayableAmount(BigDecimal payableAmount) {
//		this.payableAmount = payableAmount;
//	}
//
//	public String getBookingUrl() {
//		return bookingUrl;
//	}
//
//	public Long getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(Long customerId) {
//		this.customerId = customerId;
//	}
//
//	public Boolean isGroupBooking() {
//		return isGroupBooking;
//	}
//
//	public void setGroupBooking(Boolean groupBooking) {
//		isGroupBooking = groupBooking;
//	}
//
//	public Boolean getGroupBooking() {
//		return isGroupBooking;
//	}
//
//	public String getPropertyReservationNumber() {
//		return propertyReservationNumber;
//	}
//
//	public void setPropertyReservationNumber(String propertyReservationNumber) {
//		this.propertyReservationNumber = propertyReservationNumber;
//	}
//
//	public String getInvoiceId() {
//		return invoiceId;
//	}
//
//	public void setInvoiceId(String invoiceId) {
//		this.invoiceId = invoiceId;
//	}
//
//	public BigDecimal getExtraPersonCharge() {
//		return extraPersonCharge;
//	}
//
//	public void setExtraPersonCharge(BigDecimal extraPersonCharge) {
//		this.extraPersonCharge = extraPersonCharge;
//	}
//
//	public Integer getNoOfExtraPerson() {
//		return noOfExtraPerson;
//	}
//
//	public void setNoOfExtraPerson(Integer noOfExtraPerson) {
//		this.noOfExtraPerson = noOfExtraPerson;
//	}
//	public Double getDuration() {
//		return duration;
//	}
//
//	public void setDuration(Double duration) {
//		this.duration = duration;
//	}
//
//	public java.util.Date getFromTime() {
//		return fromTime;
//	}
//
//	public void setFromTime(java.util.Date fromTime) {
//		this.fromTime = fromTime;
//	}
//
//	public java.util.Date getToTime() {
//		return toTime;
//	}
//
//	public void setToTime(java.util.Date toTime) {
//		this.toTime = toTime;
//	}
//
//	public String getLocationName() {
//		return locationName;
//	}
//
//	public void setLocationName(String locationName) {
//		this.locationName = locationName;
//	}
//
//	public String getResourceName() {
//		return resourceName;
//	}
//
//	public void setResourceName(String resourceName) {
//		this.resourceName = resourceName;
//	}
//
//	public String getBusinessTypeName() {
//		return businessTypeName;
//	}
//
//	public void setBusinessTypeName(String businessTypeName) {
//		this.businessTypeName = businessTypeName;
//	}
//
//	public String getModeOfPayment() {
//		return modeOfPayment;
//	}
//
//	public void setModeOfPayment(String modeOfPayment) {
//		this.modeOfPayment = modeOfPayment;
//	}
//
//	public String getCurrency() {
//		return currency;
//	}
//
//	public void setCurrency(String currency) {
//		this.currency = currency;
//	}
//
//	public BigDecimal getTotalBookingAmount() {
//		return totalBookingAmount;
//	}
//
//	public void setTotalBookingAmount(BigDecimal totalBookingAmount) {
//		this.totalBookingAmount = totalBookingAmount;
//	}
//
//	public BigDecimal getTotalPayableAmount() {
//		return totalPayableAmount;
//	}
//
//	public void setTotalPayableAmount(BigDecimal totalPayableAmount) {
//		this.totalPayableAmount = totalPayableAmount;
//	}
//
//	public BigDecimal getTotalDiscountAmount() {
//		return totalDiscountAmount;
//	}
//
//	public void setTotalDiscountAmount(BigDecimal totalDiscountAmount) {
//		this.totalDiscountAmount = totalDiscountAmount;
//	}
//
//	public BigDecimal getTotalBeforeTaxAmount() {
//		return totalBeforeTaxAmount;
//	}
//
//	public void setTotalBeforeTaxAmount(BigDecimal totalBeforeTaxAmount) {
//		this.totalBeforeTaxAmount = totalBeforeTaxAmount;
//	}
//
//	public BigDecimal getTotalTaxAmount() {
//		return totalTaxAmount;
//	}
//
//	public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
//		this.totalTaxAmount = totalTaxAmount;
//	}
//
//	public Integer getTotalNumberOfRooms() {
//		return totalNumberOfRooms;
//	}
//
//	public void setTotalNumberOfRooms(Integer totalNumberOfRooms) {
//		this.totalNumberOfRooms = totalNumberOfRooms;
//	}
//
//	public Integer getTotalNumberOfSoldRooms() {
//		return totalNumberOfSoldRooms;
//	}
//
//	public void setTotalNumberOfSoldRooms(Integer totalNumberOfSoldRooms) {
//		this.totalNumberOfSoldRooms = totalNumberOfSoldRooms;
//	}
//
//	public Integer getTotalNumberOfUnSolfRooms() {
//		return totalNumberOfUnSolfRooms;
//	}
//
//	public void setTotalNumberOfUnSolfRooms(Integer totalNumberOfUnSolfRooms) {
//		this.totalNumberOfUnSolfRooms = totalNumberOfUnSolfRooms;
//	}
//
//	public BigDecimal getTaxAmount() {
//		return taxAmount;
//	}
//
//	public void setTaxAmount(BigDecimal taxAmount) {
//		this.taxAmount = taxAmount;
//	}
//
//	public Double getDiscountPercentage() {
//		return discountPercentage;
//	}
//
//	public void setDiscountPercentage(Double discountPercentage) {
//		this.discountPercentage = discountPercentage;
//	}
//
//	public BigDecimal getAdvanceAmount() {
//		return advanceAmount;
//	}
//
//	public void setAdvanceAmount(BigDecimal advanceAmount) {
//		this.advanceAmount = advanceAmount;
//	}
//
//	public String getArrivingFrom() {
//		return arrivingFrom;
//	}
//
//	public void setArrivingFrom(String arrivingFrom) {
//		this.arrivingFrom = arrivingFrom;
//	}
//
//	public String getDepartingTo() {
//		return departingTo;
//	}
//
//	public void setDepartingTo(String departingTo) {
//		this.departingTo = departingTo;
//	}
//
//	public String getPurposeOfVisit() {
//		return purposeOfVisit;
//	}
//
//	public void setPurposeOfVisit(String purposeOfVisit) {
//		this.purposeOfVisit = purposeOfVisit;
//	}
//
//	public Integer getNoOfChildren() {
//		return noOfChildren;
//	}
//
//	public void setNoOfChildren(Integer noOfChildren) {
//		this.noOfChildren = noOfChildren;
//	}
//
//	public BigDecimal getExtraChildCharge() {
//		return extraChildCharge;
//	}
//
//	public void setExtraChildCharge(BigDecimal extraChildCharge) {
//		this.extraChildCharge = extraChildCharge;
//	}
//
//	public String getRoomNumbers() {
//		return roomNumbers;
//	}
//
//	public void setRoomNumbers(String roomNumbers) {
//		this.roomNumbers = roomNumbers;
//	}
//
//	public BigDecimal getRoomTariffBeforeDiscount() {
//		return roomTariffBeforeDiscount;
//	}
//
//	public void setRoomTariffBeforeDiscount(BigDecimal roomTariffBeforeDiscount) {
//		this.roomTariffBeforeDiscount = roomTariffBeforeDiscount;
//	}
//
//	public BigDecimal getTotalRoomTariffBeforeDiscount() {
//		return totalRoomTariffBeforeDiscount;
//	}
//
//	public void setTotalRoomTariffBeforeDiscount(BigDecimal totalRoomTariffBeforeDiscount) {
//		this.totalRoomTariffBeforeDiscount = totalRoomTariffBeforeDiscount;
//	}
//
//	public Boolean getIncludeService() {
//		return isIncludeService;
//	}
//
//	public void setIncludeService(Boolean includeService) {
//		isIncludeService = includeService;
//	}
//
//	public BigDecimal getServiceAmountPaid() {
//		return serviceAmountPaid;
//	}
//
//	public void setServiceAmountPaid(BigDecimal serviceAmountPaid) {
//		this.serviceAmountPaid = serviceAmountPaid;
//	}
//
//	public BigDecimal getServiceAmountPending() {
//		return serviceAmountPending;
//	}
//
//	public void setServiceAmountPending(BigDecimal serviceAmountPending) {
//		this.serviceAmountPending = serviceAmountPending;
//	}
//
//	public BigDecimal getRoomTariffPending() {
//		return roomTariffPending;
//	}
//
//	public void setRoomTariffPending(BigDecimal roomTariffPending) {
//		this.roomTariffPending = roomTariffPending;
//	}
//
//	public BigDecimal getRoomTariffPaid() {
//		return roomTariffPaid;
//	}
//
//	public void setRoomTariffPaid(BigDecimal roomTariffPaid) {
//		this.roomTariffPaid = roomTariffPaid;
//	}
//
//	public String getHsnCode() {
//		return hsnCode;
//	}
//
//	public void setHsnCode(String hsnCode) {
//		this.hsnCode = hsnCode;
//	}
//
//	public BigDecimal getConvenienceFee() {
//		return convenienceFee;
//	}
//
//	public void setConvenienceFee(BigDecimal convenienceFee) {
//		this.convenienceFee = convenienceFee;
//	}
//
//	public BigDecimal getBookingCommissionAmount() {
//		return bookingCommissionAmount;
//	}
//
//	public void setBookingCommissionAmount(BigDecimal bookingCommissionAmount) {
//		this.bookingCommissionAmount = bookingCommissionAmount;
//	}
//
//	public Long getCompanyId() {
//		return companyId;
//	}
//
//	public void setCompanyId(Long companyId) {
//		this.companyId = companyId;
//	}
//
//	public Long getPropertyInvoiceNumber() {
//		return propertyInvoiceNumber;
//	}
//
//	public void setPropertyInvoiceNumber(Long propertyInvoiceNumber) {
//		this.propertyInvoiceNumber = propertyInvoiceNumber;
//	}
//
//	public Boolean getIsGroupBooking() {
//		return isGroupBooking;
//	}
//
//	public void setIsGroupBooking(Boolean isGroupBooking) {
//		this.isGroupBooking = isGroupBooking;
//	}
//
//	public Boolean getIsIncludeService() {
//		return isIncludeService;
//	}
//
//	public void setIsIncludeService(Boolean isIncludeService) {
//		this.isIncludeService = isIncludeService;
//	}
//
//	public BigDecimal getTdsFee() {
//		return tdsFee;
//	}
//
//	public void setTdsFee(BigDecimal tdsFee) {
//		this.tdsFee = tdsFee;
//	}
//
//	public BigDecimal getTcsFee() {
//		return tcsFee;
//	}
//
//	public void setTcsFee(BigDecimal tcsFee) {
//		this.tcsFee = tcsFee;
//	}
//
//	public Long getGroupBookingId() {
//		return groupBookingId;
//	}
//
//	public void setGroupBookingId(Long groupBookingId) {
//		this.groupBookingId = groupBookingId;
//	}
//
//	public Boolean getSingleBookingInvoice() {
//		return singleBookingInvoice;
//	}
//
//	public void setSingleBookingInvoice(Boolean singleBookingInvoice) {
//		this.singleBookingInvoice = singleBookingInvoice;
//	}
//
//	public Boolean getMultiBookingInvoice() {
//		return multiBookingInvoice;
//	}
//
//	public void setMultiBookingInvoice(Boolean multiBookingInvoice) {
//		this.multiBookingInvoice = multiBookingInvoice;
//	}
//	public String getOperatorNotes() {
//		return operatorNotes;
//	}
//
//	public void setOperatorNotes(String operatorNotes) {
//		this.operatorNotes = operatorNotes;
//	}
//	public BookingStatus getBookingStatus() {
//		return bookingStatus;
//	}
//
//	public void setBookingStatus(BookingStatus bookingStatus) {
//		this.bookingStatus = bookingStatus;
//	}
//
//}


