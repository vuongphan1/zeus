package vn.tiki.zeus.audit;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuditLogResponse {
    private String group;
    private String actor;
    private String event;
    private String eventId;
    private String message;
    private String created;
    private JsonNode data;
}
