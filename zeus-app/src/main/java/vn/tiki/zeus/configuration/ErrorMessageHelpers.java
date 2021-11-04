package vn.tiki.zeus.configuration;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.tiki.zeus.ZeusResponseWrapper;
import vn.tiki.zeus.vo.ErrorCode;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public class ErrorMessageHelpers {

    public static ResponseEntity createMessage(ZeusResponseWrapper response) {
        return ResponseEntity.status(fromErrorCodeToHttpStatus(response.getErrorCode()))
                .body(response);
    }

    public static int fromErrorCodeToHttpStatus(int errorCode) {
        if (errorCode == ErrorCode.SUCCESS.getCode()) {
            return HttpStatus.OK.value();
        } else if (errorCode == ErrorCode.UN_AUTHENTICATED.getCode()) {
            return HttpStatus.UNAUTHORIZED.value();
        } else if (errorCode == ErrorCode.UN_AUTHORIZATION.getCode()) {
            return HttpStatus.FORBIDDEN.value();
        } else if (errorCode == ErrorCode.INVALID_ARGUMENT.getCode()) {
            return HttpStatus.BAD_REQUEST.value();
        } else if (errorCode == ErrorCode.INTERNAL_SERVER_ERROR.getCode()) {
            return HttpStatus.INTERNAL_SERVER_ERROR.value();
        }

        return HttpStatus.BAD_REQUEST.value();
    }
}
