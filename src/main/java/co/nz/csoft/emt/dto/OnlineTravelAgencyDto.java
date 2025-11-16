package co.nz.csoft.emt.dto;

public class OnlineTravelAgencyDto {

    private Long id;
    private String name;
    private String description;
    private String urlReservationUpdate;
    private String urlRatesUpdate;
    private String urlAvailabilityUpdate;
    private String logoUrl;
    private String website;
    private String email;
    private String contactNumber;
    private String bookoneApiToken;
    private String channelManagerApiToken;
    private String roomId;
    private String propertyId;
    private String bookOneUserName;
    private String bookOnePassword;
    private String otaUserName;
    private String otaPassword;
    /*
    private String otaDefaultUri;
    private String otaRequestorId;
    private String otaRequestorIdType;
    private String otaHotelCode;
    */

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlReservationUpdate() {
        return urlReservationUpdate;
    }

    public void setUrlReservationUpdate(String urlReservationUpdate) {
        this.urlReservationUpdate = urlReservationUpdate;
    }

    public String getUrlRatesUpdate() {
        return urlRatesUpdate;
    }

    public void setUrlRatesUpdate(String urlRatesUpdate) {
        this.urlRatesUpdate = urlRatesUpdate;
    }

    public String getUrlAvailabilityUpdate() {
        return urlAvailabilityUpdate;
    }

    public void setUrlAvailabilityUpdate(String urlAvailabilityUpdate) {
        this.urlAvailabilityUpdate = urlAvailabilityUpdate;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBookoneApiToken() {
        return bookoneApiToken;
    }

    public void setBookoneApiToken(String bookoneApiToken) {
        this.bookoneApiToken = bookoneApiToken;
    }

    public String getChannelManagerApiToken() {
        return channelManagerApiToken;
    }

    public void setChannelManagerApiToken(String channelManagerApiToken) {
        this.channelManagerApiToken = channelManagerApiToken;
    }

   
    public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getBookOneUserName() {
        return bookOneUserName;
    }

    public void setBookOneUserName(String bookOneUserName) {
        this.bookOneUserName = bookOneUserName;
    }

    public String getBookOnePassword() {
        return bookOnePassword;
    }

    public void setBookOnePassword(String bookOnePassword) {
        this.bookOnePassword = bookOnePassword;
    }

    public String getOtaUserName() {
        return otaUserName;
    }

    public void setOtaUserName(String otaUserName) {
        this.otaUserName = otaUserName;
    }

    public String getOtaPassword() {
        return otaPassword;
    }

    public void setOtaPassword(String otaPassword) {
        this.otaPassword = otaPassword;
    }
/*
    public String getOtaDefaultUri() {
        return otaDefaultUri;
    }

    public void setOtaDefaultUri(String otaDefaultUri) {
        this.otaDefaultUri = otaDefaultUri;
    }

    public String getOtaRequestorId() {
        return otaRequestorId;
    }

    public void setOtaRequestorId(String otaRequestorId) {
        this.otaRequestorId = otaRequestorId;
    }

    public String getOtaRequestorIdType() {
        return otaRequestorIdType;
    }

    public void setOtaRequestorIdType(String otaRequestorIdType) {
        this.otaRequestorIdType = otaRequestorIdType;
    }

    public String getOtaHotelCode() {
        return otaHotelCode;
    }

    public void setOtaHotelCode(String otaHotelCode) {
        this.otaHotelCode = otaHotelCode;
    }
*/
}
