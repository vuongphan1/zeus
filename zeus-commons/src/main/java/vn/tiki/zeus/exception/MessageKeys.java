package vn.tiki.zeus.exception;

import lombok.AllArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public class MessageKeys {
    public static final String UNAUTHORIZED = "unauthorized";
    public static final String INTERNAL_SERVER_ERROR = "internal.server.error";
}
