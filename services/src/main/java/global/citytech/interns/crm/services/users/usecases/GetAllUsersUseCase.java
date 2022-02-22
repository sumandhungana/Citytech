package global.citytech.interns.crm.services.users.usecases;

import global.citytech.interns.crm.services.users.entities.converters.UserEntityConverter;
import global.citytech.interns.crm.services.users.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.services.users.payloads.GetAllUsersResponse;
import global.citytech.interns.crm.services.users.payloads.dto.UserInfo;
import global.citytech.interns.crm.services.users.repositories.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
public class GetAllUsersUseCase {

    private UserRepository userRepository;

    public GetAllUsersUseCase() {
    }

    @Inject
    public GetAllUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetAllUsersResponse execute(GetAllUsersRequest request){
        this.validateRequest(request);

        UserEntityConverter entityConverter = new UserEntityConverter();
        return new GetAllUsersResponse(entityConverter.fromEntity(this.userRepository.findAll()));
        //return new GetAllUsersResponse(this.prepareUsers());
    }

    private void validateRequest(GetAllUsersRequest request){
        //validate fields
    }

    private List<UserInfo> prepareUsers(){
        List<UserInfo> users = new ArrayList<>();
        users.add(new UserInfo("U001", "USER1", "USER ONE"));
        users.add(new UserInfo("U002", "USER2", "USER TWO"));
        users.add(new UserInfo("U003", "USER3", "USER THREE"));
        users.add(new UserInfo("U004", "USER4", "USER FOUR"));
        users.add(new UserInfo("U005", "USER5", "USER FIVE"));
        return users;
    }
}
