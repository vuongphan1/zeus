package vn.tiki.zeus;

public interface ZeusResponse extends ZeusMessage {

    int getErrorCode();

    String getErrorMessage();
}
