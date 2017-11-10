package me.tomdean.gits.models;

public enum StructureType {
    COMMERCIAL("COMMERCIAL"),
    CITY_GOV("CITY_GOV"),
    FED_GOV("FED_GOV"),
    COUNTY_GOV("COUNTY_GOV"),
    RESIDENTIAL("RESIDENTIAL");

    private String structure;

    StructureType(String structure) {
        this.structure = structure;
    }

    public String getStructure() {
        return structure;
    }
}
