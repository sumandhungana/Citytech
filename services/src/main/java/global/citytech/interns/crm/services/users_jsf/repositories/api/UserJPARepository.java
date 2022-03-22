package global.citytech.interns.crm.services.users_jsf.repositories.api;

import global.citytech.interns.crm.platform.repositories.FilterCriteria;
import global.citytech.interns.crm.platform.repositories.integrations.jpa.CrudRepository;
import global.citytech.interns.crm.platform.repositories.querybuilders.RowLimit;
import global.citytech.interns.crm.platform.repositories.querybuilders.SortMeta;
import global.citytech.interns.crm.platform.utils.HelperUtils;
import global.citytech.interns.crm.services.foos.entities.api.FooEntity;
import global.citytech.interns.crm.services.foos.filters.FooFilter;
import global.citytech.interns.crm.services.users_jsf.entities.api.UserEntity;
import global.citytech.interns.crm.services.users_jsf.filters.UserFilter;
import global.citytech.interns.crm.services.users_jsf.repositories.UserRepository;
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
public class UserJPARepository implements UserRepository {

    private CrudRepository crudRepository;

    @Inject
    public UserJPARepository(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<UserEntity> create(UserEntity entity) {
        System.out.println("REPO CREATE"+ entity.getId());
        entity = this.crudRepository.create(entity);
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<UserEntity> update(UserEntity entity) {
        entity = this.crudRepository.update(entity);
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(UserEntity entity) {

    }

    @Override
    public Optional<UserEntity> findOne(String s) {
        UserFilter filter = new UserFilter();
        filter.setId(s);
        List<UserEntity> list = this.findAll(filter);
        if(list == null || list.isEmpty()){
            return Optional.ofNullable(null);
        }
        return Optional.ofNullable(list.get(0));
    }

    @Override
    public List<UserEntity> findAll(FilterCriteria filters) {
        return this.findAllWithPagination(filters, null, null);
    }

    @Override
    public long findTotalCount(FilterCriteria filters) {
        return 0;
    }

    @Override
    public List<UserEntity> findAllWithPagination(FilterCriteria filters, RowLimit rowLimit, SortMeta sortBy) {
        String namedQuery = "SELECT rs FROM UserJPAEntity rs WHERE 1=1";
        Map<String, Object> filterMap = new HashMap<>();
        if(filters != null) {
            UserFilter filter = (UserFilter) filters;

            if (!HelperUtils.isBlankOrNull(filter.getId())) {
                filterMap.put("id", filter.getId());
                namedQuery += " AND rs.id = :id";
            }
            if (!HelperUtils.isBlankOrNull(filter.getName())) {
                filterMap.put("name", filter.getName());
                namedQuery += " AND rs.name = :name";
            }
            if (!HelperUtils.isBlankOrNull(filter.getRole())) {
                filterMap.put("name", filter.getRole());
                namedQuery += " AND rs.role = :role";
            }
            if (!HelperUtils.isBlankOrNull(filter.getEmail())) {
                filterMap.put("name", filter.getEmail());
                namedQuery += " AND rs.email = :email";
            }
            if (!HelperUtils.isBlankOrNull(filter.getStaffid())) {
                filterMap.put("name", filter.getStaffid());
                namedQuery += " AND rs.staffid = :staffid";
            }
            if (!HelperUtils.isBlankOrNull(filter.getBranch())) {
                filterMap.put("name", filter.getBranch());
                namedQuery += " AND rs.branch = :branch";
            }
        }
        return this.crudRepository.findAll(namedQuery, filterMap, rowLimit, sortBy);
    }
}
