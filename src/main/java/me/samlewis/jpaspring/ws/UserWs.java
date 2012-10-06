package me.samlewis.jpaspring.ws;

import me.samlewis.jpaspring.ws.dto.UserDetailDto;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserWs {
    List<UserDetailDto> getAllUsers();

    Long createUser(UserDetailDto user);

    void deleteUser(Long id);
}
