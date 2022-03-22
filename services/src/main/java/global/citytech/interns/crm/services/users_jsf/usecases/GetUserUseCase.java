package global.citytech.interns.crm.services.users_jsf.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users_jsf.entities.api.UserEntity;
import global.citytech.interns.crm.services.users_jsf.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users_jsf.payloads.GetUserRequest;
import global.citytech.interns.crm.services.users_jsf.payloads.GetUserResponse;
import global.citytech.interns.crm.services.users_jsf.repositories.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Optional;

@Named("getUserssUseCase")
@RequestScoped
public class GetUserUseCase implements UseCase<GetUserRequest, GetUserResponse> {

    private UserRepository userRepository;

    public GetUserUseCase() {
    }

    @Inject
    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetUserResponse execute(UseCaseContext context, GetUserRequest request) {
        Optional<UserEntity> entity = this.userRepository.findOne(request.getId());
        UserEntityConverter converter = new UserEntityConverter();
        return new GetUserResponse(converter.fromEntity(entity.get()));
    }
}