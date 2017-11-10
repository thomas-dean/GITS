package me.tomdean.gits.models;

public enum CleanupEffortType {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");

    private String effort;

    CleanupEffortType(String effort) {
        this.effort = effort;
    }

    public String getEffort() {
        return effort;
    }
}
