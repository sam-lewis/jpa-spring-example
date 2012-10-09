package me.samlewis.jpaspring.camel;

import com.google.common.base.Stopwatch;
import me.samlewis.jpaspring.ws.UserWs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.Socket;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/cxf-client.xml"})
public class CreateUserBySocketRouteIntegrationTest {

    @Autowired
    private UserWs userWs;

    @Test
    public void testRoute() throws Exception {

        int initialUserCount = userWs.getAllUsers().size();

        String json = "{\"id\":null,\"title\":\"Mr\",\"firstName\":\"Banky\"," +
                "\"lastName\":\"Bank-Bank\",\"gender\":\"M\"," +
                "\"dateOfBirth\":1331251200000,\"phone\":\"077223423\"," +
                "\"email\":\"" + System.currentTimeMillis() + "@gmail.com\",\"role\":null}";

        Socket socket = new Socket("localhost", 9090);

        socket.getOutputStream().write((json + "\r\n").getBytes("ASCII"));

        socket.close();

        Stopwatch stopwatch = new Stopwatch().start();

        while(true) {
            if(userWs.getAllUsers().size() == initialUserCount + 1) {
                return;
            } else if(stopwatch.elapsedMillis() > 10000) {
                throw new IllegalStateException("New user not detected");
            } else {
                Thread.sleep(500);
            }
        }
    }
}
