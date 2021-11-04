package vn.tiki.zeus.consumers.audit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import vn.tiki.zeus.audit.record.AuditRecordModel;
import vn.tiki.zeus.consumers.KafkaConsumerService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuditLogConsumer implements KafkaConsumerService {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * 2 + 1
    );

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    AuditRecordModel auditRecordModel;

    @Override
    @KafkaListener(topics = "platform.activity_audit_log.all",
            groupId = "zeus_consumer_audit_event")
    public void consume(@Payload String event,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
                        @Header(KafkaHeaders.OFFSET) Long offset
    ) throws JsonProcessingException, ExecutionException, InterruptedException {
        //TODO retry mechanism
        EXECUTOR_SERVICE.execute(() -> processEvent(event));
    }

    @SneakyThrows
    private void processEvent(String event) {
        var auditEvent = objectMapper.readValue(event, AuditEventData.class);
        var auditBean = AuditEventMapper.INSTANCE.map(auditEvent);
        auditRecordModel.insert(auditBean);
    }
}
