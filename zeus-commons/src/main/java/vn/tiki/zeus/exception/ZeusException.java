package vn.tiki.zeus.exception;

import lombok.Getter;

@Getter
public class ZeusException extends RuntimeException {
    private static final long serialVersionUID = -3028005837274056261L;

    private int code;
    private final String messageKey;

    public ZeusException(String messageKey, String message, int code) {
        super(message);
        this.code = code;
        this.messageKey = messageKey;
    }
}
