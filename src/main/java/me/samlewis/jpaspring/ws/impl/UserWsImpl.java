package me.samlewis.jpaspring.ws.impl;

import me.samlewis.jpaspring.domain.User;
import me.samlewis.jpaspring.service.UserService;
import me.samlewis.jpaspring.util.BeanMapper;
import me.samlewis.jpaspring.ws.UserWs;
import me.samlewis.jpaspring.ws.dto.UserDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@Component("userWs")
@WebService(endpointInterface = "me.samlewis.jpaspring.ws.UserWs")
public class UserWsImpl implements UserWs {

    private final UserService userService;
    private final BeanMapper beanMapper;

    @Autowired
    public UserWsImpl(UserService userService, BeanMapper beanMapper) {
        this.userService = userService;
        this.beanMapper = beanMapper;
    }

    public List<UserDetailDto> getAllUsers() {
        return beanMapper.map(userService.getAll(), UserDetailDto.class);
    }

    public Long createUser(UserDetailDto userDto) {
        User user = beanMapper.map(userDto, User.class);
        userService.save(user);
        return user.getId();
    }

    public void deleteUser(Long id) {
        userService.delete(id);
    }
}
