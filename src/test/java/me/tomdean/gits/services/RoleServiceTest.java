package me.tomdean.gits.services;

import java.util.Arrays;
import java.util.List;
import me.tomdean.gits.models.Role;
import me.tomdean.gits.models.RoleType;
import me.tomdean.gits.GitsApplication;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitsApplication.class)
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void shouldRetrieveAllRoles() throws Exception {
        /*
         * We assume that the database is pre-populated with all possible roles
         * listed in the `me.tomdean.gits.models.RoleType` enum.
         */
        RoleType[] possibleRolesArray = RoleType.class.getEnumConstants();
        List<RoleType> possibleRoles = Arrays.asList(possibleRolesArray);
        List<Role> retrievedRoles = roleService.findAll();
        if (possibleRoles.size() > retrievedRoles.size()) {
            fail("findAll did not find all possible roles.");
        } else if (possibleRoles.size() < retrievedRoles.size()) {
            fail("findAll found too many roles.");
        }
        for (RoleType rt: possibleRoles) {
            boolean foundMatch = false;
            for (Role r: retrievedRoles) {
                if (rt.getRoleType().equals(r.getRole())) {
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                fail("findAll did not find role \"" + rt + "\".");
            }
        }
    }

    @Test
    public void shouldFindRoleById() throws Exception {
        /* 
         * This test depends on `findByRole` to get us a role that came from the
         * database, since the id information is not available to us before
         * hand.
         */
        Role databaseRole = roleService.findByRole(RoleType.USER.getRoleType());
        Role foundRole = roleService.findById(databaseRole.getId());
        assertEquals(databaseRole, foundRole);
    }

    @Test
    public void shouldFindRoleByName() throws Exception {
        Role foundRole = roleService.findByRole(RoleType.ADMIN.getRoleType());
        assertEquals(RoleType.ADMIN.getRoleType(), foundRole.getRole());
    }
}
