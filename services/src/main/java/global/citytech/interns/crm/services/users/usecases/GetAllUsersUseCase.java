package global.citytech.interns.crm.services.users.usecases;

import global.citytech.interns.crm.services.users.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users.payloads.GetAllUsersResponse;
import global.citytech.interns.crm.services.users.repositories.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
public class GetAllUsersUseCase {

    private UserRepository userRepository;

    public GetAllUsersUseCase() {
    }

    @Inject
    public GetAllUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetAllUsersResponse execute(UseCaseContext UseCaseContext ,GetAllUsersRequest request){
        this.validateRequest(request);

        UserEntityConverter entityConverter = new UserEntityConverter();
        return new GetAllUsersResponse(entityConverter.fromEntity(this.userRepository.findAll()));
        //return new GetAllUsersResponse(this.prepareUsers());
    }

    private void validateRequest(GetAllUsersRequest request){
        //validate fields
    }


}
