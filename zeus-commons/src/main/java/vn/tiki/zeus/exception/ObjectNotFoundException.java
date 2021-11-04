package vn.tiki.zeus.exception;

import vn.tiki.zeus.vo.ErrorCode;

public class ObjectNotFoundException extends ZeusException {

    public ObjectNotFoundException(String messageKey, String message) {
        super(messageKey, message, ErrorCode.NOT_FOUND.getCode());
    }
}
