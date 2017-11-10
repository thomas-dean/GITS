package me.tomdean.gits.models;

public enum InvestigationStatusType {
    NEW("NEW"),
    IN_PROCESS("IN_PROCESS"),
    IN_LITIGATION("IN_LITIGATION"),
    RESOLVED("RESOLVED");

    private String status;

    InvestigationStatusType(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
