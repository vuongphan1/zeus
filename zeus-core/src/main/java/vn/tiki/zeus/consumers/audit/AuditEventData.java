package vn.tiki.zeus.consumers.audit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Getter;

@Getter
public class AuditEventData {
    private String group;
    private String actor;
    private String event;
    private String eventId;
    private String message;
    private String created;
    private JsonNode raw;
}
