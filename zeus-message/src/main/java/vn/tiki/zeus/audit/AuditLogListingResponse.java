package vn.tiki.zeus.audit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import vn.tiki.zeus.PagingResponse;

import java.util.List;

@Getter
@Setter
@Builder
public class AuditLogListingResponse {
    private List<AuditLogResponse> results;

    private PagingResponse paging;
}
