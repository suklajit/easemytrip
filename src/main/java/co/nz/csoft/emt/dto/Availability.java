package co.nz.csoft.emt.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Availability {
	
    @JsonProperty("RequestType")
    private String requestType;

    @JsonProperty("Token")
    private String token;

    @JsonProperty("ClientHotelCode")
    private String clientHotelCode;

    @JsonProperty("Data")
    private List<UpdateAllocation> data;

    @Override
    public String toString() {
        return "{" +
                "\"RequestType\":\"" + requestType + "\"," +
                "\"Token\":\"" + token + "\"," +
                "\"ClientHotelCode\":\"" + clientHotelCode + "\"," +
                "\"Data\":" + data +
                "}";
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClientHotelCode() {
        return clientHotelCode;
    }

    public void setClientHotelCode(String clientHotelCode) {
        this.clientHotelCode = clientHotelCode;
    }

    public List<UpdateAllocation> getData() {
        return data;
    }

    public void setData(List<UpdateAllocation> data) {
        this.data = data;
    }

    public void setFrom(String valueOf) {
    }

    public void setTo(String startDate) {			
    }

    public void setCount(int noOfAvailable) {			
    }

    public static class UpdateAllocation {

        @JsonProperty("RequestType")
        private String requestType;

        @JsonProperty("Data")
        private List<Allocation> data;

        @Override
        public String toString() {
            return "{" +
                    "\"RequestType\":\"" + requestType + "\"," +
                    "\"Data\":" + data +
                    "}";
        }

        public String getRequestType() {
            return requestType;
        }

        public void setRequestType(String requestType) {
            this.requestType = requestType;
        }

        public List<Allocation> getData() {
            return data;
        }

        public void setData(List<Allocation> data) {
            this.data = data;
        }

        public static class Allocation {

            @JsonProperty("ClientRoomCode")
            private String clientRoomCode;

            @JsonProperty("From")
            private String from;

            @JsonProperty("To")
            private String to;

            @JsonProperty("Allocation")
            private int allocation;

            @Override
            public String toString() {
                return "{" +
                        "\"ClientRoomCode\":\"" + clientRoomCode + "\"," +
                        "\"From\":\"" + from + "\"," +
                        "\"To\":\"" + to + "\"," +
                        "\"Allocation\":" + allocation +
                        "}";
            }

            public String getClientRoomCode() {
                return clientRoomCode;
            }

            public void setClientRoomCode(String clientRoomCode) {
                this.clientRoomCode = clientRoomCode;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public String getTo() {
                return to;
            }

            public void setTo(String to) {
                this.to = to;
            }

            public int getAllocation() {
                return allocation;
            }

            public void setAllocation(int allocation) {
                this.allocation = allocation;
            }
        }
    }
}
