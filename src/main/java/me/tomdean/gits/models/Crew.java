package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "crew", schema = "gits")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "crew_id", length = 5)
    private String crewId;
    private String supervisor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "id=" + id +
                ", crewId='" + crewId + '\'' +
                ", supervisor='" + supervisor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Crew crew = (Crew) o;

        if (getId() != null ? !getId().equals(crew.getId()) : crew.getId() != null) return false;
        if (!getCrewId().equals(crew.getCrewId())) return false;
        return getSupervisor().equals(crew.getSupervisor());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getCrewId().hashCode();
        result = 31 * result + getSupervisor().hashCode();
        return result;
    }
}
