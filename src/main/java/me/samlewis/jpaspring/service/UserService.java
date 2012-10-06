package me.samlewis.jpaspring.service;

import com.google.common.collect.Iterables;
import me.samlewis.jpaspring.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository(value = "employeeService")
public class UserService extends AbstractJpaService<User> {
    public UserService() {
        super(User.class);
    }

    public User get(String emailAddress) {
        TypedQuery<User> query = getEntityManager().createQuery(
                "SELECT u from User u "
                        + "where u.emailAddress = :emailAddress", User.class);
        query.setParameter("emailAddress", emailAddress);

        List<User> results = query.getResultList();

        return Iterables.getOnlyElement(results, null);
    }

}
