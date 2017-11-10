package me.tomdean.gits.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "graffiti_image", schema = "gits")
public class GraffitiImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] data;
    @ManyToOne
    private Incident incident;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    @Override
    public String toString() {
        return "GraffitiImage{" +
                "id=" + id +
                ", data=" + Arrays.toString(data) +
                ", incident=" + incident +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraffitiImage graffitiImage = (GraffitiImage) o;

        if (getId() != null ? !getId().equals(graffitiImage.getId()) : graffitiImage.getId() != null) return false;
        if (!Arrays.equals(getData(), graffitiImage.getData())) return false;
        return getIncident().equals(graffitiImage.getIncident());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getData());
        result = 31 * result + getIncident().hashCode();
        return result;
    }
}
