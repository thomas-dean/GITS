package me.tomdean.gits.models;

public enum ImageFormatType {
    PNG("PNG"),
    JPG("JPG"),
    JPEG("JPEG"),
    GIF("GIF");

    private String formatType;

    ImageFormatType(String formatType) {
        this.formatType = formatType;
    }

    public String getFormatType() {
        return formatType;
    }
}
