package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "cleanup_effort", schema = "gits")
public class CleanupEffort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String effort = CleanupEffortType.LOW.getEffort();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    @Override
    public String toString() {
        return "CleanupEffort{" +
                "id=" + id +
                ", effort='" + effort + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CleanupEffort that = (CleanupEffort) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getEffort().equals(that.getEffort());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getEffort().hashCode();
        return result;
    }
}
