package global.citytech.interns.crm.services.users_jsf.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.platform.utils.HelperUtils;
import global.citytech.interns.crm.services.users_jsf.entities.api.UserEntity;
import global.citytech.interns.crm.services.users_jsf.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users_jsf.payloads.AddUserRequest;
import global.citytech.interns.crm.services.users_jsf.payloads.AddUserResponse;
import global.citytech.interns.crm.services.users_jsf.repositories.UserRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Named("addAllUserssUseCase")
@RequestScoped
public class AddUserUseCase implements UseCase<AddUserRequest, AddUserResponse> {
    private UserRepository userRepository;

    public AddUserUseCase() {
    }

    @Inject
    public AddUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public AddUserResponse execute(UseCaseContext context, AddUserRequest request){
        this.validateRequest(request);
        request.setId(HelperUtils.generateRandomId());

        UserEntityConverter entityConverter = new UserEntityConverter();
        UserEntity entity = entityConverter.toEntity(request);
        System.out.println("ENTITY BRANCH ="+ entity.getBranch());
        Optional<UserEntity> addedEntity = this.userRepository.create(entity);
        return new AddUserResponse(addedEntity.get().getId());
    }

    private boolean validateRequest(AddUserRequest request){
        return true;
    }
}
