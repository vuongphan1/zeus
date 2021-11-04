package vn.tiki.zeus.exception;

import vn.tiki.zeus.vo.ErrorCode;

public class InvalidArgumentException extends ZeusException {

    public InvalidArgumentException(String messageKey, String message) {
        super(messageKey, message, ErrorCode.INVALID_ARGUMENT.getCode());
    }
}
