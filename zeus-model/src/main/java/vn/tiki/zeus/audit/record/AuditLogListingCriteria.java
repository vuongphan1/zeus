package vn.tiki.zeus.audit.record;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static vn.tiki.zeus.utils.TimeUtils.mySqlTime;

@Builder
public class AuditLogListingCriteria {
    private static final Integer FIRST_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 20;
    private static final Integer MAX_PAGE_SIZE = 100;

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer pageSize = 20;

    @Getter
    private String group;

    @Getter
    private String event;

    @Getter
    private String eventId;

    @Getter
    private String actor;

    private String from;

    private String to;

    public Integer getLimit() {
        return getPageSize();
    }

    public Integer getOffset() {
        return (getPage() - 1) * getPageSize();
    }

    public LocalDateTime getFrom() {
        return mySqlTime(from);
    }

    public LocalDateTime getTo() {
        return mySqlTime(to);
    }

    public Integer getPage() {
        if (page == null || page < FIRST_PAGE)
            return FIRST_PAGE;
        else
            return page;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 0 || pageSize > MAX_PAGE_SIZE)
            return DEFAULT_PAGE_SIZE;
        else
            return pageSize;
    }
}
