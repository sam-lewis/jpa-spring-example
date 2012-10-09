package me.samlewis.jpaspring.camel;

import com.google.common.io.Files;
import me.samlewis.jpaspring.domain.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

import java.io.File;

public class CreateUserBySocketRoute extends RouteBuilder {

    public void configure() {
        File tempDir = Files.createTempDir();
        System.out.println("Temp dir: " + tempDir.getAbsolutePath());

        from("mina:tcp://localhost:9090?textline=true&sync=false")
                .to("file://" + tempDir.getAbsolutePath());

        from("file://" + tempDir.getAbsolutePath() + "?preMove=inprogress&move=done")
                .unmarshal(new JacksonDataFormat(User.class))
                .beanRef("userService", "save");
    }
}
