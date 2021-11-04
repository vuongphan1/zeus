package vn.tiki.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.tiki.zeus.consumers.audit.AuditLogConsumer;

@SpringBootApplication(scanBasePackages = "vn.tiki.zeus")
public class AuditLogWorker {

    @Configuration
    public static class auditLogWorkerConfiguration {

        @Bean
        public AuditLogConsumer getAuditLogConsumer() {
            return new AuditLogConsumer();
        }
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AuditLogWorker.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
