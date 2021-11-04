package vn.tiki.zeus.managers.audit;

import vn.tiki.zeus.audit.AuditLogListingResponse;
import vn.tiki.zeus.audit.record.AuditLogListingCriteria;

public interface AuditLogManager {
    AuditLogListingResponse findAll(AuditLogListingCriteria criteria);
}
