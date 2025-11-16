package co.nz.csoft.emt.dto;

import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {

    @JsonProperty("RequestType")
    private String requestType;

    @JsonProperty("Token")
    private String token;

    @JsonProperty("HotelCode")
    private String HotelCode;

    @JsonProperty("Data")
    private List<PriceCancellation> data;

    @Override
    public String toString() {
        return "{" +
                "\"RequestType\":\"" + requestType + "\"," +
                "\"Token\":\"" + token + "\"," +
                "\"HotelCode\":\"" + HotelCode + "\"," +
                "\"Data\":" + data +
                "}";
    }

    // Getters and Setters
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

    public String getHotelCode() {
        return HotelCode;
    }

    public void setHotelCode(String HotelCode) {
        this.HotelCode = HotelCode;
    }

    public List<PriceCancellation> getData() {
        return data;
    }

    public void setData(List<PriceCancellation> data) {
        this.data = data;
    }

    public static class PriceCancellation {

        @JsonProperty("RequestType")
        private String requestType;

        @JsonProperty("Data")
        private List<RoomDetail> data;

        @Override
        public String toString() {
            return "{" +
                    "\"RequestType\":\"" + requestType + "\"," +
                    "\"Data\":" + data +
                    "}";
        }

        // Getters and Setters
        public String getRequestType() {
            return requestType;
        }

        public void setRequestType(String requestType) {
            this.requestType = requestType;
        }

        public List<RoomDetail> getData() {
            return data;
        }

        public void setData(List<RoomDetail> data) {
            this.data = data;
        }

        public static class RoomDetail {

            @JsonProperty("RoomCode")
            private String RoomCode;

            @JsonProperty("ContractCode")
            private String contractCode;

            @JsonProperty("From")
            private String from;

            @JsonProperty("To")
            private String to;

            @JsonProperty("RoomAvailablityDetail")
            private RoomAvailablityDetail roomAvailablityDetail;

            @JsonProperty("RoomCancellation")
            private RoomCancellation roomCancellation;

            @Override
            public String toString() {
                return "{" +
                        "\"RoomCode\":\"" + RoomCode + "\"," +
                        "\"ContractCode\":\"" + contractCode + "\"," +
                        "\"From\":\"" + from + "\"," +
                        "\"To\":\"" + to + "\"," +
                        "\"RoomAvailablityDetail\":" + roomAvailablityDetail + "," +
                        "\"RoomCancellation\":" + roomCancellation +
                        "}";
            }

            // Getters and Setters
            public String getRoomCode() {
                return RoomCode;
            }

            public void setRoomCode(String RoomCode) {
                this.RoomCode = RoomCode;
            }

            public String getContractCode() {
                return contractCode;
            }

            public void setContractCode(String contractCode) {
                this.contractCode = contractCode;
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

            public RoomAvailablityDetail getRoomAvailabilityDetail() {
                return roomAvailablityDetail;
            }

            public void setRoomAvailabilityDetail(RoomAvailablityDetail roomAvailabilityDetail) {
                this.roomAvailablityDetail = roomAvailabilityDetail;
            }

            public RoomCancellation getRoomCancellation() {
                return roomCancellation;
            }

            public void setRoomCancellation(RoomCancellation roomCancellation) {
                this.roomCancellation = roomCancellation;
            }

            public static class RoomAvailablityDetail {

                @JsonProperty("PriceDetail")
                private PriceDetail priceDetail;

                @Override
                public String toString() {
                    return "{" +
                            "\"PriceDetail\":" + priceDetail +
                            "}";
                }

                // Getters and Setters
                public PriceDetail getPriceDetail() {
                    return priceDetail;
                }

                public void setPriceDetail(PriceDetail priceDetail) {
                    this.priceDetail = priceDetail;
                }

                public static class PriceDetail {

                    @JsonProperty("PlanId")
                    private String planId;

                    @JsonProperty("OnePaxRack")
                    private BigDecimal onePaxRack;

                    @JsonProperty("TwoPaxRack")
                    private BigDecimal twoPaxRack;

                    @JsonProperty("OnePaxOccupancy")
                    private BigDecimal onePaxOccupancy;

                    @JsonProperty("TwoPaxOccupancy")
                    private BigDecimal twoPaxOccupancy;

                    @JsonProperty("ThreePaxOccupancy")
                    private BigDecimal threePaxOccupancy;

                    @JsonProperty("FourPaxOccupancy")
                    private BigDecimal fourPaxOccupancy;

                    @JsonProperty("FivePaxOccupancy")
                    private BigDecimal fivePaxOccupancy;

                    @JsonProperty("SixPaxOccupancy")
                    private BigDecimal sixPaxOccupancy;

                    @JsonProperty("ExtraAdultRate")
                    private BigDecimal extraAdultRate;

                    @JsonProperty("ExtraBedRate")
                    private BigDecimal extraBedRate;

                    @JsonProperty("ChildRate")
                    private BigDecimal childRate;

                    @JsonProperty("ChildWithBedRate")
                    private double childWithBedRate;

                    @JsonProperty("GST")
                    private double gst;

                    @JsonProperty("CommissionAmount")
                    private double commissionAmount;

                    @JsonProperty("BT")
                    private String bt;

                    @JsonProperty("CancellationPolicy")
                    private List<CancellationPolicy> cancellationPolicy;

                    @Override
                    public String toString() {
                        return "{" +
                                "\"PlanId\":\"" + planId + "\"," +
                                "\"OnePaxRack\":" + onePaxRack + "," +
                                "\"TwoPaxRack\":" + twoPaxRack + "," +
                                "\"OnePaxOccupancy\":" + onePaxOccupancy + "," +
                                "\"TwoPaxOccupancy\":" + twoPaxOccupancy + "," +
                                "\"ThreePaxOccupancy\":" + threePaxOccupancy + "," +
                                "\"FourPaxOccupancy\":" + fourPaxOccupancy + "," +
                                "\"FivePaxOccupancy\":" + fivePaxOccupancy + "," +
                                "\"SixPaxOccupancy\":" + sixPaxOccupancy + "," +
                                "\"ExtraAdultRate\":" + extraAdultRate + "," +
                                "\"ExtraBedRate\":" + extraBedRate + "," +
                                "\"ChildRate\":" + childRate + "," +
                                "\"ChildWithBedRate\":" + childWithBedRate + "," +
                                "\"GST\":" + gst + "," +
                                "\"CommissionAmount\":" + commissionAmount + "," +
                                "\"BT\":\"" + bt + "\"," +
                                "\"CancellationPolicy\":" + cancellationPolicy +
                                "}";
                    }

               
                    public String getPlanId() {
						return planId;
					}


					public void setPlanId(String planId) {
						this.planId = planId;
					}


					public BigDecimal getOnePaxRack() {
						return onePaxRack;
					}


					public void setOnePaxRack(BigDecimal onePaxRack) {
						this.onePaxRack = onePaxRack;
					}


					public BigDecimal getTwoPaxRack() {
						return twoPaxRack;
					}


					public void setTwoPaxRack(BigDecimal twoPaxRack) {
						this.twoPaxRack = twoPaxRack;
					}


					public BigDecimal getOnePaxOccupancy() {
						return onePaxOccupancy;
					}


					public void setOnePaxOccupancy(BigDecimal onePaxOccupancy) {
						this.onePaxOccupancy = onePaxOccupancy;
					}


					public BigDecimal getTwoPaxOccupancy() {
						return twoPaxOccupancy;
					}


					public void setTwoPaxOccupancy(BigDecimal twoPaxOccupancy) {
						this.twoPaxOccupancy = twoPaxOccupancy;
					}


					public BigDecimal getThreePaxOccupancy() {
						return threePaxOccupancy;
					}


					public void setThreePaxOccupancy(BigDecimal threePaxOccupancy) {
						this.threePaxOccupancy = threePaxOccupancy;
					}


					public BigDecimal getFourPaxOccupancy() {
						return fourPaxOccupancy;
					}


					public void setFourPaxOccupancy(BigDecimal fourPaxOccupancy) {
						this.fourPaxOccupancy = fourPaxOccupancy;
					}


					public BigDecimal getFivePaxOccupancy() {
						return fivePaxOccupancy;
					}


					public void setFivePaxOccupancy(BigDecimal fivePaxOccupancy) {
						this.fivePaxOccupancy = fivePaxOccupancy;
					}


					public BigDecimal getSixPaxOccupancy() {
						return sixPaxOccupancy;
					}


					public void setSixPaxOccupancy(BigDecimal sixPaxOccupancy) {
						this.sixPaxOccupancy = sixPaxOccupancy;
					}


					public BigDecimal getExtraAdultRate() {
						return extraAdultRate;
					}


					public void setExtraAdultRate(BigDecimal bigDecimal) {
						this.extraAdultRate = bigDecimal;
					}


					public BigDecimal getExtraBedRate() {
						return extraBedRate;
					}


					public void setExtraBedRate(BigDecimal extraBedRate) {
						this.extraBedRate = extraBedRate;
					}


					public BigDecimal getChildRate() {
						return childRate;
					}


					public void setChildRate(BigDecimal childRate) {
						this.childRate = childRate;
					}


					public double getChildWithBedRate() {
						return childWithBedRate;
					}


					public void setChildWithBedRate(double childWithBedRate) {
						this.childWithBedRate = childWithBedRate;
					}


					public double getGst() {
						return gst;
					}


					public void setGst(double gst) {
						this.gst = gst;
					}


					public double getCommissionAmount() {
						return commissionAmount;
					}


					public void setCommissionAmount(double commissionAmount) {
						this.commissionAmount = commissionAmount;
					}


					public String getBt() {
						return bt;
					}


					public void setBt(String bt) {
						this.bt = bt;
					}


					public List<CancellationPolicy> getCancellationPolicy() {
						return cancellationPolicy;
					}


					public void setCancellationPolicy(List<CancellationPolicy> cancellationPolicy) {
						this.cancellationPolicy = cancellationPolicy;
					}


					public static class CancellationPolicy {

                        @JsonProperty("ChargeType")
                        private String chargeType;

                        @JsonProperty("FromDate")
                        private String fromDate;

                        @JsonProperty("ToDate")
                        private String toDate;

                        @JsonProperty("Charges")
                        private int charges;

                        @Override
                        public String toString() {
                            return "{" +
                                    "\"ChargeType\":\"" + chargeType + "\"," +
                                    "\"FromDate\":\"" + fromDate + "\"," +
                                    "\"ToDate\":\"" + toDate + "\"," +
                                    "\"Charges\":" + charges +
                                    "}";
                        }

                        // Getters and Setters
                        public String getChargeType() {
                            return chargeType;
                        }

                        public void setChargeType(String chargeType) {
                            this.chargeType = chargeType;
                        }

                        public String getFromDate() {
                            return fromDate;
                        }

                        public void setFromDate(String fromDate) {
                            this.fromDate = fromDate;
                        }

                        public String getToDate() {
                            return toDate;
                        }

                        public void setToDate(String toDate) {
                            this.toDate = toDate;
                        }

                        public int getCharges() {
                            return charges;
                        }

                        public void setCharges(int charges) {
                            this.charges = charges;
                        }
                    }
                }
            }

            public static class RoomCancellation {

                @JsonProperty("PolicyDescription")
                private String policyDescription;

                @Override
                public String toString() {
                    return "{" +
                            "\"PolicyDescription\":\"" + policyDescription + "\"" +
                            "}";
                }

               
                public String getPolicyDescription() {
                    return policyDescription;
                }

                public void setPolicyDescription(String policyDescription) {
                    this.policyDescription = policyDescription;
                }
            }
        }
    }
}
