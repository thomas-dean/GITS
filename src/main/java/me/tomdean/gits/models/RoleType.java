package me.tomdean.gits.models;

public enum RoleType {
    USER("USER"),
    LAW_ENFORCEMENT("LAW_ENFORCEMENT"),
    ADMIN("ADMIN");

    private String roleType;

    RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}
