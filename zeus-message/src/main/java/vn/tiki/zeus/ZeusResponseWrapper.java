package vn.tiki.zeus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
public class ZeusResponseWrapper<T> implements ZeusResponse {
    private int errorCode;
    private String messageKey;
    private String errorMessage;
    private T data;

    private ZeusResponseWrapper(T data) {
        this.data = data;
    }

    private ZeusResponseWrapper(T data, int errorCode) {
        this.data = data;
        this.errorCode = errorCode;
    }

    private ZeusResponseWrapper(int errorCode, String messageKey, String message) {
        this.errorCode = errorCode;
        this.messageKey = messageKey;
        this.errorMessage = message;
    }

    public static <RESP> ZeusResponseWrapper<RESP> success(RESP data) {
        return new ZeusResponseWrapper<>(data, 0);
    }

    public static <RESP> ZeusResponseWrapper<RESP> error(String messageKey, String message, int errorCode) {
        return new ZeusResponseWrapper<>(errorCode, messageKey, message);
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
