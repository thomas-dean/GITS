package me.tomdean.gits.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "suspect", schema = "gits")
public class Suspect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private byte[] photo;
    @ManyToOne
    private SuspectStatus status;
    @ManyToOne
    private Gang gang;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public SuspectStatus getStatus() {
        return status;
    }

    public void setStatus(SuspectStatus status) {
        this.status = status;
    }

    public Gang getGang() {
        return gang;
    }

    public void setGang(Gang gang) {
        this.gang = gang;
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", status=" + status +
                ", gang=" + gang +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suspect suspect = (Suspect) o;

        if (getId() != null ? !getId().equals(suspect.getId()) : suspect.getId() != null) return false;
        if (getName() != null ? !getName().equals(suspect.getName()) : suspect.getName() != null) return false;
        if (!Arrays.equals(getPhoto(), suspect.getPhoto())) return false;
        if (getStatus() != null ? !getStatus().equals(suspect.getStatus()) : suspect.getStatus() != null) return false;
        return getGang() != null ? getGang().equals(suspect.getGang()) : suspect.getGang() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getPhoto());
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getGang() != null ? getGang().hashCode() : 0);
        return result;
    }
}
