package vn.tiki.zeus.consumers.audit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AuditEvent {
    @JsonProperty("activity_audit_log")
    private AuditEventData auditData;
}
