package vn.tiki.zeus.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.tiki.zeus.ZeusResponseWrapper;
import vn.tiki.zeus.exception.MessageKeys;
import vn.tiki.zeus.exception.ZeusException;

import static vn.tiki.zeus.configuration.ErrorMessageHelpers.createMessage;
import static vn.tiki.zeus.vo.ErrorCode.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class ZeusExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DEFAULT_ERROR_MESSAGE = "Có lỗi xảy ra, vui lòng thử lại sau!";

    @ExceptionHandler({ZeusException.class})
    @ResponseBody
    public ResponseEntity handleZeusException(ZeusException ex) {
        return createMessage(ZeusResponseWrapper.error(ex.getMessageKey(), ex.getMessage(), ex.getCode()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleException(Exception ex) {
        log.error("Error handling request", ex);
        return createMessage(ZeusResponseWrapper.error(MessageKeys.INTERNAL_SERVER_ERROR, DEFAULT_ERROR_MESSAGE, INTERNAL_SERVER_ERROR.getCode()));
    }
}
