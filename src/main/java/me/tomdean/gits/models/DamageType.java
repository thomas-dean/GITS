package me.tomdean.gits.models;

public enum DamageType {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");

    private String damage;

    DamageType(String damage) {
        this.damage = damage;
    }

    public String getDamage() {
        return damage;
    }
}
