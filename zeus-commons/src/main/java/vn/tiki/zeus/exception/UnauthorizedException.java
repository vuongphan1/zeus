package vn.tiki.zeus.exception;


import static vn.tiki.zeus.vo.ErrorCode.UN_AUTHORIZATION;

public class UnauthorizedException extends ZeusException {

    public UnauthorizedException() {
        super(MessageKeys.UNAUTHORIZED, "Unauthorized", UN_AUTHORIZATION.getCode());
    }

    public UnauthorizedException(String message) {
        super(MessageKeys.UNAUTHORIZED, message, UN_AUTHORIZATION.getCode());
    }

    public UnauthorizedException(String messageKey, String message) {
        super(messageKey, message, UN_AUTHORIZATION.getCode());
    }
}
