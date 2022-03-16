package global.citytech.interns.crm.services.users.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users.entities.UserEntity;
import global.citytech.interns.crm.services.users.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users.payloads.GetUserRequest;
import global.citytech.interns.crm.services.users.payloads.GetUserResponse;
import global.citytech.interns.crm.services.users.repositories.UserRepository;

import jakarta.inject.Inject;


public class GetUserUseCase implements UseCase<GetUserRequest, GetUserResponse> {
    @Inject
    private UserRepository userRepository;

    public GetUserUseCase() {
    }

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetUserResponse execute(UseCaseContext context, GetUserRequest request) {
        UserEntity entity = this.userRepository.findOne(request.getId());
        UserEntityConverter converter = new UserEntityConverter();
        return new GetUserResponse(converter.fromEntity(entity));
    }
}
