package global.citytech.interns.crm.adminendpoints.users.usecases;

import global.citytech.interns.crm.adminendpoints.users.entities.UserEntity;
import global.citytech.interns.crm.adminendpoints.users.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.adminendpoints.users.payloads.AddUserRequest;
import global.citytech.interns.crm.adminendpoints.users.payloads.AddUserResponse;
import global.citytech.interns.crm.adminendpoints.users.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.adminendpoints.users.payloads.GetAllUsersResponse;
import global.citytech.interns.crm.adminendpoints.users.repositories.users.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;

@Named
public class AddUserUseCase {
    private UserRepository userRepository;

    public AddUserUseCase() {
    }

    @Inject
    public AddUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AddUserResponse execute(AddUserRequest request){
        this.validateRequest(request);
        request.setId(LocalDateTime.now().toString());

        UserEntityConverter entityConverter = new UserEntityConverter();
        UserEntity entity = entityConverter.toEntity(request);
        UserEntity addedEntity = this.userRepository.add(entity);
        return new AddUserResponse(addedEntity.getId());
    }

    private boolean validateRequest(AddUserRequest request){
        return true;
    }
}
