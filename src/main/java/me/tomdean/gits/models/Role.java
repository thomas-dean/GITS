package me.tomdean.gits.models;

import javax.persistence.*;

@Entity
@Table(name = "role", schema = "gits")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role = RoleType.USER.getRoleType();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (!getId().equals(role1.getId())) return false;
        return getRole().equals(role1.getRole());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getRole().hashCode();
        return result;
    }
}
