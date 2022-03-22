package global.citytech.interns.crm.services.users_jsf.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users_jsf.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users_jsf.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.services.users_jsf.payloads.GetAllUsersResponse;
import global.citytech.interns.crm.services.users_jsf.repositories.UserRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("getAllUserssUseCase")
@RequestScoped
public class GetAllUsersUseCase implements UseCase<GetAllUsersRequest, GetAllUsersResponse> {

    private UserRepository userRepository;

    public GetAllUsersUseCase() {
    }

    @Inject
    public GetAllUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetAllUsersResponse execute(UseCaseContext useCaseContext, GetAllUsersRequest request){
        this.validateRequest(request);

        UserEntityConverter entityConverter = new UserEntityConverter();
        return new GetAllUsersResponse(entityConverter.fromEntity(this.userRepository.findAll()));
    }

    private void validateRequest(GetAllUsersRequest request){
        //validate fields
    }
}
