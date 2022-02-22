package global.citytech.interns.crm.platform.repositories;

import global.citytech.interns.crm.platform.repositories.querybuilders.RowLimit;
import global.citytech.interns.crm.platform.repositories.querybuilders.SortMeta;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends Entity, ID> {
    Optional<E> create(E entity);

    Optional<E> update(E entity);

    void delete(E entity);

    Optional<E> findOne(ID id);

    List<E> findAll(FilterCriteria filters);

    long findTotalCount(FilterCriteria filters);

    List<E> findAllWithPagination(FilterCriteria filters, RowLimit rowLimit, SortMeta sortBy);

    default List<E> findAll(){
        return findAll(null);
    }

    default long findTotalCount(){
        return findTotalCount(null);
    }
}
