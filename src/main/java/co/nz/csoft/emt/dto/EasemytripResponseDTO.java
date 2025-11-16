package co.nz.csoft.emt.dto;

import java.util.List;

public class EasemytripResponseDTO {

	private String propertyId;
	private String propertyName;
	private List<Room> rooms;

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public static class Room {
		private String roomId;
		private String roomName;
		private List<RatePlan> ratePlans;

		public Room(String roomId, String roomName, List<RatePlan> ratePlans) {
			this.roomId = roomId;
			this.roomName = roomName;
			this.ratePlans = ratePlans;
		}

		public String getRoomId() {
			return roomId;
		}

		public void setRoomId(String roomId) {
			this.roomId = roomId;
		}

		public String getRoomName() {
			return roomName;
		}

		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

		public List<RatePlan> getRatePlans() {
			return ratePlans;
		}

		public void setRatePlans(List<RatePlan> ratePlans) {
			this.ratePlans = ratePlans;
		}

	}

	public static class RatePlan {
		private String planCode;
		private String planName;

		public RatePlan(String planCode, String planName) {
			this.planCode = planCode;
			this.planName = planName;
		}

		public String getPlanCode() {
			return planCode;
		}

		public void setPlanCode(String planCode) {
			this.planCode = planCode;
		}

		public String getPlanName() {
			return planName;
		}

		public void setPlanName(String planName) {
			this.planName = planName;
		}

	}
}
