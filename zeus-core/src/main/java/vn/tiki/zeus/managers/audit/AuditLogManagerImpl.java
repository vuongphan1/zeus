package vn.tiki.zeus.managers.audit;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import vn.tiki.zeus.PagingResponse;
import vn.tiki.zeus.audit.AuditLogListingResponse;
import vn.tiki.zeus.audit.record.AuditLogListingCriteria;
import vn.tiki.zeus.audit.record.AuditRecordModel;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuditLogManagerImpl implements AuditLogManager {
    @NonNull
    private AuditRecordModel auditRecordModel;

    @NonNull
    private AuditLogResponseMapper responseMapper;

    @Override
    public AuditLogListingResponse findAll(AuditLogListingCriteria criteria) {
        var auditLogPaging = auditRecordModel.findAll(criteria);
        var auditLogs = auditLogPaging.getData().stream()
                .map(responseMapper::map)
                .collect(Collectors.toList());

        return AuditLogListingResponse.builder()
                .results(auditLogs)
                .paging(PagingResponse.of(auditLogPaging.getTotal(), auditLogPaging.getPerPage(), auditLogPaging.getCurrentPage()))
                .build();
    }
}
