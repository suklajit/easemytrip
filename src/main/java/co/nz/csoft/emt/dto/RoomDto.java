package co.nz.csoft.emt.dto;


import java.util.List;


public class RoomDto {
    private Long id ;
    private String name ;
    private String description ;
    private Long bookoneRoomId;
    private Long  onlineTravelAgencyRoomId;
    private List<OnlineTravelAgencyDto> onlineTravelAgenciesDto;
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

    public Long getBookoneRoomId() {
        return bookoneRoomId;
    }

    public void setBookoneRoomId(Long bookoneRoomId) {
        this.bookoneRoomId = bookoneRoomId;
    }

    public List<OnlineTravelAgencyDto> getOnlineTravelAgenciesDto() {
        return onlineTravelAgenciesDto;
    }

    public void setOnlineTravelAgenciesDto(List<OnlineTravelAgencyDto> onlineTravelAgenciesDto) {
        this.onlineTravelAgenciesDto = onlineTravelAgenciesDto;
    }
    public Long getOnlineTravelAgencyRoomId() {
        return onlineTravelAgencyRoomId;
    }

    public void setOnlineTravelAgencyRoomId(Long onlineTravelAgencyRoomId) {
        this.onlineTravelAgencyRoomId = onlineTravelAgencyRoomId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
