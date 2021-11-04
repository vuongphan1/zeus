package vn.tiki.zeus.audit.record;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuditLogBean {
    private Long id;
    private String group;
    private String actor;
    private String event;
    private String eventId;
    private String message;
    private String data;
    private LocalDateTime created;
}
