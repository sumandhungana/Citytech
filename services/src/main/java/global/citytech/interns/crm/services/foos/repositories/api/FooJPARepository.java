package global.citytech.interns.crm.services.foos.repositories.api;

import global.citytech.interns.crm.platform.repositories.FilterCriteria;
import global.citytech.interns.crm.platform.repositories.integrations.jpa.CrudRepository;
import global.citytech.interns.crm.platform.repositories.querybuilders.RowLimit;
import global.citytech.interns.crm.platform.repositories.querybuilders.SortMeta;
import global.citytech.interns.crm.platform.utils.HelperUtils;
import global.citytech.interns.crm.services.foos.entities.api.FooEntity;
import global.citytech.interns.crm.services.foos.filters.FooFilter;
import global.citytech.interns.crm.services.foos.repositories.FooRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Named
@Dependent
public class FooJPARepository implements FooRepository {
    private CrudRepository crudRepository;

    @Inject
    public FooJPARepository(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<FooEntity> create(FooEntity entity) {
        System.out.println("REPO CREATE"+ entity.getId());
        entity = this.crudRepository.create(entity);
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<FooEntity> update(FooEntity entity) {
        entity = this.crudRepository.update(entity);
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(FooEntity entity) {

    }

    @Override
    public Optional<FooEntity> findOne(String s) {
        FooFilter filter = new FooFilter();
        filter.setId(s);
        List<FooEntity> list = this.findAll(filter);
        if(list == null || list.isEmpty()){
            return Optional.ofNullable(null);
        }
        return Optional.ofNullable(list.get(0));
    }

    @Override
    public List<FooEntity> findAll(FilterCriteria filters) {
        return this.findAllWithPagination(filters, null, null);
    }

    @Override
    public long findTotalCount(FilterCriteria filters) {
        return 0;
    }

    @Override
    public List<FooEntity> findAllWithPagination(FilterCriteria filters, RowLimit rowLimit, SortMeta sortBy) {
        String namedQuery = "SELECT rs FROM FooJPAEntity rs WHERE 1=1";
        Map<String, Object> filterMap = new HashMap<>();
        if(filters != null) {
            FooFilter filter = (FooFilter) filters;

            if (!HelperUtils.isBlankOrNull(filter.getId())) {
                filterMap.put("id", filter.getId());
                namedQuery += " AND rs.id = :id";
            }
            if (!HelperUtils.isBlankOrNull(filter.getName())) {
                filterMap.put("name", filter.getName());
                namedQuery += " AND rs.name = :name";
            }
        }
        return this.crudRepository.findAll(namedQuery, filterMap, rowLimit, sortBy);
    }
}
