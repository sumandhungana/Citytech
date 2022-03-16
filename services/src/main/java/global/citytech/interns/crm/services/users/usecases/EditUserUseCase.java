package global.citytech.interns.crm.services.users.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users.entities.UserEntity;
import global.citytech.interns.crm.services.users.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users.payloads.EditUserRequest;
import global.citytech.interns.crm.services.users.payloads.EditUserResponse;
import global.citytech.interns.crm.services.users.repositories.UserRepository;
import jakarta.inject.Inject;

public class EditUserUseCase implements UseCase<EditUserRequest, EditUserResponse> {
    private UserRepository userRepository;

    public EditUserUseCase() {
    }

    @Inject
    public EditUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public EditUserResponse execute(UseCaseContext context, EditUserRequest request){
        System.out.println("id = "+ request.getId());
        if(!this.validateRequest(request)){
            return null;

        }
        System.out.println("Start to update");
        UserEntityConverter entityConverter = new UserEntityConverter();
        UserEntity entity = entityConverter.toEntity(request);
        UserEntity updatedEntity = this.userRepository.update(entity);
        return new EditUserResponse(updatedEntity.getId());

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
