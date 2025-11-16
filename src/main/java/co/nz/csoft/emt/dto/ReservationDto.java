package co.nz.csoft.emt.dto;

import java.util.List;

public class ReservationDto {

	private boolean Status;
	private Reservations reservations;

	// Getters and setters
	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public Reservations getReservations() {
		return reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}

	// ---------- Nested Classes ----------

	public static class Reservations {
		private List<Reservation> reservation;

		public List<Reservation> getReservation() {
			return reservation;
		}

		public void setReservation(List<Reservation> reservation) {
			this.reservation = reservation;
		}
	}

	public static class Reservation {
		private String commissionamount;
		private String deposit;
		private String taxamount;
		private String currencycode;
		private String servicefee;
		private Customer customer;
		private String date;
		private String hotel_id;
		private String hotel_name;
		private String id;
		private List<Room> room;
		private String status;
		private String time;
		private String totalprice;
		private List<ExtraData> extraData;

		// Getters and setters...
		public String getCommissionamount() {
			return commissionamount;
		}

		public void setCommissionamount(String commissionamount) {
			this.commissionamount = commissionamount;
		}

		public String getDeposit() {
			return deposit;
		}

		public void setDeposit(String deposit) {
			this.deposit = deposit;
		}

		public String getTaxamount() {
			return taxamount;
		}

		public void setTaxamount(String taxamount) {
			this.taxamount = taxamount;
		}

		public String getCurrencycode() {
			return currencycode;
		}

		public void setCurrencycode(String currencycode) {
			this.currencycode = currencycode;
		}

		public String getServicefee() {
			return servicefee;
		}

		public void setServicefee(String servicefee) {
			this.servicefee = servicefee;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getHotel_id() {
			return hotel_id;
		}

		public void setHotel_id(String hotel_id) {
			this.hotel_id = hotel_id;
		}

		public String getHotel_name() {
			return hotel_name;
		}

		public void setHotel_name(String hotel_name) {
			this.hotel_name = hotel_name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List<Room> getRoom() {
			return room;
		}

		public void setRoom(List<Room> room) {
			this.room = room;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getTotalprice() {
			return totalprice;
		}

		public void setTotalprice(String totalprice) {
			this.totalprice = totalprice;
		}

		public List<ExtraData> getExtraData() {
			return extraData;
		}

		public void setExtraData(List<ExtraData> extraData) {
			this.extraData = extraData;
		}
	}

	public static class Customer {
		private String address;
		private String city;
		private String company;
		private String email;
		private String first_name;
		private String last_name;
		private String remarks;
		private String telephone;
		private String zip;

		// Getters and setters...
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}
	}

	public static class Room {
		private String arrival_date;
		private String currencycode;
		private String departure_date;
		private String id;
		private String name;
		private List<Price> price;
		private String roomprice;
		private String remarks;
		private String guest_name;
		private String numberofadult;
		private String numberofchild;

		// Getters and setters...
		public String getArrival_date() {
			return arrival_date;
		}

		public void setArrival_date(String arrival_date) {
			this.arrival_date = arrival_date;
		}

		public String getCurrencycode() {
			return currencycode;
		}

		public void setCurrencycode(String currencycode) {
			this.currencycode = currencycode;
		}

		public String getDeparture_date() {
			return departure_date;
		}

		public void setDeparture_date(String departure_date) {
			this.departure_date = departure_date;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Price> getPrice() {
			return price;
		}

		public void setPrice(List<Price> price) {
			this.price = price;
		}

		public String getRoomprice() {
			return roomprice;
		}

		public void setRoomprice(String roomprice) {
			this.roomprice = roomprice;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getGuest_name() {
			return guest_name;
		}

		public void setGuest_name(String guest_name) {
			this.guest_name = guest_name;
		}

		public String getNumberofadult() {
			return numberofadult;
		}

		public void setNumberofadult(String numberofadult) {
			this.numberofadult = numberofadult;
		}

		public String getNumberofchild() {
			return numberofchild;
		}

		public void setNumberofchild(String numberofchild) {
			this.numberofchild = numberofchild;
		}
	}

	public static class Price {
		private String date;
		private String rate_id;
		private String Rateplanname;
		private String amount;

		// Getters and setters...
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getRate_id() {
			return rate_id;
		}

		public void setRate_id(String rate_id) {
			this.rate_id = rate_id;
		}

		public String getRateplanname() {
			return Rateplanname;
		}

		public void setRateplanname(String rateplanname) {
			Rateplanname = rateplanname;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
	}

	public static class ExtraData {
		private String name;
		private String value;

		// Getters and setters...
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
