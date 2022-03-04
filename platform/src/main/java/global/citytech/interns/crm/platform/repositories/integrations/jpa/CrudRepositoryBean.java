package global.citytech.interns.crm.platform.repositories.integrations.jpa;

import global.citytech.interns.crm.platform.repositories.querybuilders.RowLimit;
import global.citytech.interns.crm.platform.repositories.querybuilders.SortMeta;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Named
@Dependent
@Transactional(Transactional.TxType.REQUIRED)
public class CrudRepositoryBean implements CrudRepository{
    @PersistenceContext(name = "PU_CRM")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    public <T> T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    public <T> T update(T t) {
        T upT = this.em.merge(t);
        this.em.flush();
        return (T) upT;
    }

    @Override
    public int updateWithCondition(String namedQuery, Map<String, Object> parameters) {
        Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = this.em.createQuery(namedQuery);
        for (Map.Entry<String, Object> entry : rawParameters) {
            System.out.println("Named Query = " + entry.getKey() + ", "+ entry.getValue());
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return  query.executeUpdate();
    }

    @Override
    public boolean delete(Object t) {
        return false;
    }

    @Override
    public <T> T findOne(Object id, Class<T> type) {
        if (id == null) {
            return null;
        }
        return (T) this.em.find(type, id);
    }

    @Override
    public <T> T findOneForUpdate(Object id, Class<T> type) {
        if (id == null) {
            return null;
        }
        return (T) this.em.find(type, id, LockModeType.PESSIMISTIC_WRITE);
    }

    @Override
    public List findAll(String namedQuery, Map<String, Object> parameters) {
        return findAll(namedQuery, parameters, null, null);
    }

    @Override
    public List findAll(String namedQuery, Map<String, Object> parameters, SortMeta sortBy) {
        return findAll(namedQuery, parameters, null, sortBy);
    }

    @Override
    public List findAll(String namedQuery, Map<String, Object> parameters, RowLimit rowLimit, SortMeta sortBy) {
        Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        //Query query = this.em.createNamedQuery(namedQuery);
        Query query = this.em.createQuery(namedQuery);
        if(rowLimit != null) {
            query.setFirstResult(rowLimit.offset());
            query.setMaxResults(rowLimit.pageSize());
        }
        for (Map.Entry<String, Object> entry : rawParameters) {

            System.out.println("Named Query = " + entry.getKey() + ", "+ entry.getValue());
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }
}
