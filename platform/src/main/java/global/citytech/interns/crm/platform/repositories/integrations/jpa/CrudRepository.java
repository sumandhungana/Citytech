package global.citytech.interns.crm.platform.repositories.integrations.jpa;

import global.citytech.interns.crm.platform.repositories.querybuilders.RowLimit;
import global.citytech.interns.crm.platform.repositories.querybuilders.SortMeta;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Map;

public interface CrudRepository {
    EntityManager getEntityManager();

    <T> T create(T t);

    <T> T update(T t);

    int updateWithCondition(String namedQuery, Map<String, Object> parameters);

    boolean delete(Object t);

    <T> T findOne(Object id, Class<T> type);

    <T> T findOneForUpdate(Object id, Class<T> type);

    List findAll(String namedQuery, Map<String, Object> parameters);

    List findAll(String namedQuery, Map<String, Object> parameters, SortMeta sortBy);

    List findAll(String namedQuery, Map<String, Object> parameters, RowLimit rowLimit, SortMeta sortBy);

}
