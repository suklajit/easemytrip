package co.nz.csoft.emt.dto;


import java.math.BigDecimal;

public class RoomDetails {
    private String roomTypeId;
    private String roomTypeName;
    private Double roomRate;
    private String plan;
    private Integer noOfRooms;
    private Integer noOfadult;
    private Integer noOfchild;
   // private BigDecimal totalAmount;
    private String checkinDate;
    private String checkoutDate;

    public RoomDetails() {
		super();
	}
    
	public RoomDetails(String roomTypeId, String roomTypeName, Double roomRate, String plan, Integer noOfRooms,
			Integer noOfAdult, Integer noOfchild) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.roomRate = roomRate;
		this.plan = plan;
		this.noOfRooms = noOfRooms;
		this.noOfadult = noOfAdult;
		this.noOfchild = noOfchild;
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

	public Integer getNoOfRooms() {
		return noOfRooms;
	}
    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }


	

    public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
   

    
    /*
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
*/

	public Integer getNoOfadult() {
		return noOfadult;
	}

	public void setNoOfadult(Integer noOfadult) {
		this.noOfadult = noOfadult;
	}

	public Integer getNoOfchild() {
		return noOfchild;
	}

	public void setNoOfchild(Integer noOfchild) {
		this.noOfchild = noOfchild;
	}

	@Override
    public String toString() {
        return "{" +
                "roomTypeId=" + roomTypeId +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", roomRate='" + roomRate + '\'' +
                ", plan='" + plan + '\'' +
                ", noOfRooms='" + noOfRooms + '\'' +
                ", noOfChildren='" + noOfchild + '\'' +
                 ", noOfAdult=" + noOfadult +
                '}';
    }



	
}
