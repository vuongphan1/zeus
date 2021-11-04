package vn.tiki.zeus;

import lombok.Getter;
import lombok.NonNull;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;
import java.util.function.Function;

public class AbstractMysqlModel implements MysqlJdbiModel {

    @Getter
    @Autowired
    private final Jdbi jdbi;

    protected AbstractMysqlModel(@NonNull Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    protected Handle openHandle() {
        return this.getJdbi().open();
    }

    protected <T, R> R openDaoAndApply(@NonNull Class<T> cls, @NonNull Function<T, R> fn) {
        try (Handle handle = this.openHandle()) {
            return fn.apply(handle.attach(cls));
        }
    }

    protected <T> void openDaoAndAccept(@NonNull Class<T> cls, @NonNull Consumer<T> consumer) {
        try (Handle handle = this.openHandle()) {
            consumer.accept(handle.attach(cls));
        }
    }
}
