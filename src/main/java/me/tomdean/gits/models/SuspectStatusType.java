package me.tomdean.gits.models;

public enum SuspectStatusType {
    UNKNOWN("UNKNOWN"),
    IDENTIFIED("IDENTIFIED"),
    IN_CUSTODY("IN_CUSTODY"),
    RELEASED("RELEASED");

    private String status;

    SuspectStatusType(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
