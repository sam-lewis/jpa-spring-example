package me.samlewis.jpaspring.service;

import me.samlewis.jpaspring.domain.User;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/me/samlewis/jpaspring/applicationContext-infra.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserServiceIntegrationTest {
    @Autowired
    private UserService userService;

    private static final String[] DATE_PATTERN = new String[]{"dd/MM/yyyy"};

    @Test
    public void testSave() throws Exception {

        User user = new User();

        user.setDateOfBirth(DateUtils.parseDate("09/03/2012", DATE_PATTERN));
        user.setEmail("banky@bank.com");
        user.setGender("M");
        user.setFirstName("Banky");
        user.setLastName("Bank-Bank");
        user.setPhone("077223423");
        user.setTitle("Mr");

        userService.save(user);

        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<User> users = userService.getAll();

        assertThat(users).isNotNull().isNotEmpty();
    }

    @Test
    public void testGet() throws Exception {
        User user = userService.get(1L);

        assertThat(user).isNotNull();
    }
}
