package vn.tiki.zeus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagingResponse {
    private Long total;
    private Integer perPage;
    private Integer currentPage;
    private Integer lastPage;
    private Long from;
    private Long to;

    public PagingResponse(Long total, Integer perPage, Integer currentPage) {
        this.total = total;
        this.perPage = perPage;
        this.currentPage = currentPage;
    }

    public Integer getLastPage() {
        var lastPage = 0;
        if(total == 0)
            return 0;
        if (total % perPage == 0) {
            lastPage = (int) (total / perPage);
        } else {
            lastPage = (int) ((total / perPage) + 1);
        }
        return lastPage;
    }

    public Long getFrom() {
        if(total == 0 || currentPage > getLastPage())
            return 0L;
        return (long) ((currentPage - 1) * perPage + 1);
    }

    public Long getTo() {
        if(total == 0 || currentPage > getLastPage())
            return 0L;
        if (currentPage.equals(getLastPage())) {
            return total;
        } else {
            return getFrom() + perPage - 1;
        }
    }

    public static PagingResponse of(long total, int perPage, int currentPage) {
        return new PagingResponse(total, perPage, currentPage);
    }
}
