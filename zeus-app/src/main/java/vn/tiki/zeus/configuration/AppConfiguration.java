package vn.tiki.zeus.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.jdbi.v3.core.Jdbi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import vn.tiki.zeus.JdbiHelper;

import java.util.Properties;


@Configuration
public class AppConfiguration {

    @ConfigurationProperties(prefix = "kafka.consumer.properties")
    @Bean
    public Properties getConsumerProperties() {
        return new Properties();
    }

    @ConfigurationProperties(prefix = "mysql")
    @Bean
    public Properties getMySqlDatasourceProperties() {
        return new Properties();
    }

    @Bean
    public Jdbi getJdbi() {
        return JdbiHelper.createJdbiFromProperties(getMySqlDatasourceProperties());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule())
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}
