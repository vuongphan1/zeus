package vn.tiki.zeus;

import lombok.NonNull;
import org.jdbi.v3.core.Jdbi;

public class AbstractZeusMysqlModel extends vn.tiki.zeus.AbstractMysqlModel {

    protected AbstractZeusMysqlModel(@NonNull Jdbi jdbi) {
        super(jdbi);
    }
}
