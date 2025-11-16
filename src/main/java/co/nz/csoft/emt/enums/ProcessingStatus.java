package co.nz.csoft.emt.enums;

public enum ProcessingStatus {
    RECEIVED("RECEIVED"),
    IN_PROGRESS("IN_PROGRESS"),
    PROCESSED("PROCESSED"),
    FAILED("FAILED");
    private String status;
    ProcessingStatus(String status)
    {
        this.status=status;
    }
    public String getValue()
    {
        return status;
    }
}
