package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "image_format", schema = "gits")
public class ImageFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String format = ImageFormatType.PNG.getFormatType();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "ImageFormat{" +
                "id=" + id +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageFormat imageFormat = (ImageFormat) o;

        if (getId() != null ? !getId().equals(imageFormat.getId()) : imageFormat.getId() != null) return false;
        return getFormat() != null ? getFormat().equals(imageFormat.getFormat()) : imageFormat.getFormat() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFormat() != null ? getFormat().hashCode() : 0);
        return result;
    }
}
