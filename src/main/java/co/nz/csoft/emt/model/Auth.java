package co.nz.csoft.emt.model;

public class Auth {
	 private String token="inK5Pkw2asD+O0ewV9txZ7CUoHBYuJb8OUzGN3g+Vfnk0tY0glMs+w==";
	 private String type;
	 private String hotelCode;
	 
	public Auth(String token, String type, String hotelCode) {
		super();
		this.token = token;
		this.type = type;
		this.hotelCode = hotelCode;
	}
	public Auth() {
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHotelCode() {
		return hotelCode;
	}
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	
	public String getHotelListReq() {
		return "{ \"Auth\":{ \"Token\":\""+token+"\", \"Type\":\"HotelList\" } }";
	}
	public String getRoomListReq() {
		return "{ \"Auth\":{ \"Token\":\"" +token+"\", \"Type\":\"RoomList\" }, \"HotelCode\":\"" + hotelCode + "\" }";
	}
}
