//package co.nz.csoft.emt.model;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.hibernate.annotations.Type;
//
//import co.nz.csoft.mmt.enums.ProcessingStatus;
//
//@Entity
//public class MmtPushBookingHistory {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String propertyId;
//	private String bookingId;
//	@Column(columnDefinition = "MEDIUMTEXT")
//	@Type(type = "org.hibernate.type.TextType")
//	private String booking;
//	private Date createdDate;
//	private Date updatedDate;
//	private ProcessingStatus processingStatus;
//	private int retry;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getPropertyId() {
//		return propertyId;
//	}
//
//	public void setPropertyId(String propertyId) {
//		this.propertyId = propertyId;
//	}
//
//	public String getBookingId() {
//		return bookingId;
//	}
//
//	public void setBookingId(String bookingId) {
//		this.bookingId = bookingId;
//	}
//
//	public String getBooking() {
//		return booking;
//	}
//
//	public void setBooking(String booking) {
//		this.booking = booking;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public Date getUpdatedDate() {
//		return updatedDate;
//	}
//
//	public void setUpdatedDate(Date updatedDate) {
//		this.updatedDate = updatedDate;
//	}
//
//	public ProcessingStatus getProcessingStatus() {
//		return processingStatus;
//	}
//
//	public void setProcessingStatus(ProcessingStatus processingStatus) {
//		this.processingStatus = processingStatus;
//	}
//
//	public int getRetry() {
//		return retry;
//	}
//
//	public void setRetry(int retry) {
//		this.retry = retry;
//	}
//
//}
//
//
//
//
//
