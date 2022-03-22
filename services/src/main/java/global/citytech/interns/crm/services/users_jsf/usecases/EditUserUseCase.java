package global.citytech.interns.crm.services.users_jsf.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users_jsf.entities.api.UserEntity;
import global.citytech.interns.crm.services.users_jsf.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users_jsf.payloads.EditUserRequest;
import global.citytech.interns.crm.services.users_jsf.payloads.EditUserResponse;
import global.citytech.interns.crm.services.users_jsf.repositories.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Named("editUserssUseCase")
@RequestScoped
public class EditUserUseCase implements UseCase<EditUserRequest, EditUserResponse> {
    private UserRepository userRepository;

    public EditUserUseCase() {
    }

    @Inject
    public EditUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public EditUserResponse execute(UseCaseContext context, EditUserRequest request){
        if(!this.validateRequest(request)){
            return null;
        }

        UserEntityConverter entityConverter = new UserEntityConverter();
        UserEntity entity = entityConverter.toEntity(request);
        Optional<UserEntity> updatedEntity = this.userRepository.update(entity);
        return new EditUserResponse(updatedEntity.get().getId());
    }

    private boolean validateRequest(EditUserRequest request){
        if(request == null || request.getId() == null){
            return false;
        }
        if(this.userRepository.findOne(request.getId()) == null){
            return false;
        }
        return true;
    }
}
