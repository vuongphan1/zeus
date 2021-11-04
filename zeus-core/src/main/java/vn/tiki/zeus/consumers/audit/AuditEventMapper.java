package vn.tiki.zeus.consumers.audit;

import vn.tiki.zeus.audit.record.AuditLogBean;

import static vn.tiki.zeus.utils.TimeUtils.mySqlTime;

public class AuditEventMapper {
    public static final AuditEventMapper INSTANCE = new AuditEventMapper();

    public AuditLogBean map(AuditEventData event) {
        return AuditLogBean.builder()
                .group(event.getGroup())
                .event(event.getEvent())
                .eventId(event.getEventId())
                .actor(event.getActor())
                .message(event.getMessage())
                .data(event.getRaw().toString())
                .created(mySqlTime(event.getCreated()))
                .build();
    }
}
