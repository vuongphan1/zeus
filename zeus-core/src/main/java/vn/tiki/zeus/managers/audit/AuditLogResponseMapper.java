package vn.tiki.zeus.managers.audit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.tiki.zeus.audit.AuditLogResponse;
import vn.tiki.zeus.audit.record.AuditLogBean;

import static vn.tiki.zeus.utils.TimeUtils.time;

@Slf4j
@Service
@AllArgsConstructor
public class AuditLogResponseMapper {
    @NonNull
    private ObjectMapper objectMapper;

    public AuditLogResponse map(AuditLogBean auditLogBean) {
        return AuditLogResponse.builder()
                .group(auditLogBean.getGroup())
                .event(auditLogBean.getEvent())
                .eventId(auditLogBean.getEventId())
                .actor(auditLogBean.getActor())
                .message(auditLogBean.getMessage())
                .data(marshall(auditLogBean.getData()))
                .created(time(auditLogBean.getCreated()))
                .build();
    }

    private JsonNode marshall(String data) {
        if (data == null || data.isEmpty()) return null;

        try {
            return objectMapper.readTree(data);
        } catch (Exception e) {
            log.error("Marshall data failed for string " + data, e);
        }

        return null;
    }
}
