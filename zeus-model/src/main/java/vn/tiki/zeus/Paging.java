package vn.tiki.zeus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging<T> {
	List<T> data;
	private long total;
	private int perPage;
	private int currentPage;
	
	private int lastPage;
	private int from;
	private int to;
	
	public Paging(List<T> data) {
		this.data = data;
	}
	
	public Paging(List<T> data, long total, int perPage, int currentPage) {
		this.data = data;
		this.total = total;
		this.perPage = perPage;
		this.currentPage = currentPage;
	}
	
	public int getLastPage() {
		if (CollectionUtils.isEmpty(data))
			return 0;
		
		var lastPage = 0;
		if (total % perPage == 0) {
			lastPage = (int) (total / perPage);
		} else {
			lastPage = (int) ((total / perPage) + 1);
		}
		return lastPage;
	}
	
	public int getFrom() {
		if (CollectionUtils.isEmpty(data))
			return 0;
		
		return (currentPage - 1) * perPage + 1;
	}
	
	public int getTo() {
		if (CollectionUtils.isEmpty(data))
			return 0;
		
		if (currentPage == getLastPage()) {
			return (int) total;
		} else {
			return getFrom() + perPage - 1;
		}
	}
	
	public static <T> Paging<T> of(List<T> data, long total, int perPage, int currentPage) {
		return new Paging<>(data, total, perPage, currentPage);
	}
	
	public static <T> Paging<T> ofEmpty() {
		return new Paging<>(Collections.emptyList());
	}
}
