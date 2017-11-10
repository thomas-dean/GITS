package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "structure", schema = "gits")
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String structure = StructureType.COMMERCIAL.getStructure();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "id=" + id +
                ", structure='" + structure + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Structure structure1 = (Structure) o;

        if (getId() != null ? !getId().equals(structure1.getId()) : structure1.getId() != null) return false;
        return getStructure().equals(structure1.getStructure());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getStructure().hashCode();
        return result;
    }
}
