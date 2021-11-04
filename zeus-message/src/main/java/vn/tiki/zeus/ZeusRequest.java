package vn.tiki.zeus;

public interface ZeusRequest extends ZeusMessage {

    @SuppressWarnings("unchecked")
    default <T extends vn.tiki.zeus.ZeusRequest> T cast() {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default <T extends vn.tiki.zeus.ZeusRequest> T cast(Class<T> cls) {
        return (T) this;
    }
}
