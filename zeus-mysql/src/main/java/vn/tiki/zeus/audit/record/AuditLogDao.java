package vn.tiki.zeus.audit.record;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface AuditLogDao {
    String AUDIT_RECORD = "audit_logs";

    @SqlUpdate("INSERT INTO " + AUDIT_RECORD + " (`group`, actor, event, event_id, message, created, data)" +
            " VALUE (:group, :actor, :event, :eventId, :message, :created, :data)")
    @GetGeneratedKeys
    long insert(@BindBean AuditLogBean auditRecord);
    
    @SqlQuery("select *" +
            " from " + AUDIT_RECORD +
            " where (:actor is null or actor = :actor)" +
            " and (:group is null or `group` = :group)" +
            " and (:event is null or event = :event)" +
            " and (:eventId is null or event_id = :eventId)" +
            " and (:from is null or created > :from)" +
            " and (:to is null or created < :to)" +
            " order by created desc" +
            " limit :limit offset :offset")
    @RegisterBeanMapper(AuditLogBean.class)
    List<AuditLogBean> findAll(@BindBean AuditLogListingCriteria criteria);

    @SqlQuery("select count(*)" +
            " from " + AUDIT_RECORD +
            " where (:actor is null or actor = :actor)" +
            " and (:group is null or `group` = :group)" +
            " and (:event is null or event = :event)" +
            " and (:eventId is null or event_id = :eventId)" +
            " and (:from is null or created > :from)" +
            " and (:to is null or created < :to)" +
            " order by created desc" +
            " limit :limit offset :offset")
    Long countAll(@BindBean AuditLogListingCriteria criteria);
}
