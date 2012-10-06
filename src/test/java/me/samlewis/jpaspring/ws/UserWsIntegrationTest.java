package me.samlewis.jpaspring.ws;

import me.samlewis.jpaspring.ws.dto.UserDetailDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/cxf-client.xml"})
public class UserWsIntegrationTest {
    @Autowired
    private UserWs userWs;

    @Test
    public void testGetAllUsers() throws Exception {

        List<UserDetailDto> users = userWs.getAllUsers();

        assertThat(users).isNotEmpty();
    }

    @Test
    public void testCreateAndDelete() throws Exception {

        int initialUserCount = userWs.getAllUsers().size();

        UserDetailDto user = new UserDetailDto();
        user.setEmail("banky@gmail.com");
        user.setGender("M");
        user.setFirstName("Banky");
        user.setLastName("Bank-Bank");
        user.setPhone("077223423");
        user.setTitle("Sir");

        long userId = userWs.createUser(user);

        assertThat(userId).isGreaterThan(0);

        int newUserCount = userWs.getAllUsers().size();

        assertThat(newUserCount).isEqualTo(initialUserCount + 1);

        userWs.deleteUser(userId);

        int finalUserCount = userWs.getAllUsers().size();

        assertThat(finalUserCount).isEqualTo(initialUserCount);
    }
}
