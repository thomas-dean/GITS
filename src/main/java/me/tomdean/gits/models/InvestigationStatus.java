package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "investigation_status", schema = "gits")
public class InvestigationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status = InvestigationStatusType.NEW.getStatus();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InvestigationStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestigationStatus that = (InvestigationStatus) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getStatus().equals(that.getStatus());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getStatus().hashCode();
        return result;
    }
}
