package me.tomdean.gits.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "image", schema = "gits")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private ImageFormat format;
    private byte[] data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageFormat getFormat() {
        return format;
    }

    public void setFormat(ImageFormat format) {
        this.format = format;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", format=" + format +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (getId() != null ? !getId().equals(image.getId()) : image.getId() != null) return false;
        if (getFormat() != null ? !getFormat().equals(image.getFormat()) : image.getFormat() != null)
            return false;
        return Arrays.equals(getData(), image.getData());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFormat() != null ? getFormat().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getData());
        return result;
    }
}
