package vn.tiki.zeus.vo;

public enum ErrorCode {
	SUCCESS(0),
	INVALID_ARGUMENT(3),
	UN_AUTHENTICATED(4),
	UN_AUTHORIZATION(5),
	NOT_FOUND(6),
	RULE_EXPIRED(7),
	INTERNAL_SERVER_ERROR(100);
	
	int code;
	
	ErrorCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
}
