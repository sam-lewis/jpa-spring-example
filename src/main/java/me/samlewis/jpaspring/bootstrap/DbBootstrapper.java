package me.samlewis.jpaspring.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SuppressWarnings("deprecation")
@Component
@DependsOn(value = "entityManagerFactory")
public class DbBootstrapper {
    private DataSource dataSource;

    @Autowired(required = true)
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void bootstrap() {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        SimpleJdbcTestUtils.executeSqlScript(simpleJdbcTemplate, new ClassPathResource("testdata.sql"), false);
    }
}
