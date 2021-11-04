package vn.tiki.zeus.audit.record;

import vn.tiki.zeus.Paging;

public interface AuditRecordModel {
    AuditLogBean insert(AuditLogBean auditRecord);

    Paging<AuditLogBean> findAll(AuditLogListingCriteria criteria);
}
