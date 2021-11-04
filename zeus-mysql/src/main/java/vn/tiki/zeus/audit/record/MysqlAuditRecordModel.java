package vn.tiki.zeus.audit.record;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;
import vn.tiki.zeus.AbstractZeusMysqlModel;
import vn.tiki.zeus.Paging;

@Service
public class MysqlAuditRecordModel extends AbstractZeusMysqlModel implements AuditRecordModel {
    private static final Paging<AuditLogBean> EMPTY_PAGE = Paging.ofEmpty();

    protected MysqlAuditRecordModel(@NonNull Jdbi jdbi) {
        super(jdbi);
    }

    @Override
    public AuditLogBean insert(AuditLogBean auditRecord) {
        try (var handle = openHandle()) {
            var auditDao = handle.attach(AuditLogDao.class);
            var insertedId = auditDao.insert(auditRecord);

            return auditRecord.toBuilder()
                    .id(insertedId)
                    .build();
        }
    }

    @Override
    public Paging<AuditLogBean> findAll(AuditLogListingCriteria criteria) {
        if (criteria.getPage() <= 0) return EMPTY_PAGE;

        try (var handle = openHandle()) {
            var auditDao = handle.attach(AuditLogDao.class);
            var auditRecords = auditDao.findAll(criteria);
            var total = auditDao.countAll(criteria);

            return Paging.of(auditRecords, total, criteria.getPageSize(), criteria.getPage());
        }
    }
}
