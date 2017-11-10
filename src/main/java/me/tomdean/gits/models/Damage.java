package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "damage", schema = "gits")
public class Damage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String damage = DamageType.LOW.getDamage();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Damage{" +
                "id=" + id +
                ", damage='" + damage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Damage damage1 = (Damage) o;

        if (getId() != null ? !getId().equals(damage1.getId()) : damage1.getId() != null) return false;
        return getDamage().equals(damage1.getDamage());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getDamage().hashCode();
        return result;
    }
}
