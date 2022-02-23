package global.citytech.interns.crm.services.foos.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.entities.FooEntity;
import global.citytech.interns.crm.services.foos.entities.converters.FooEntityConverter;
import global.citytech.interns.crm.services.foos.payloads.GetAllFoosRequest;
import global.citytech.interns.crm.services.foos.payloads.GetAllFoosResponse;
import global.citytech.interns.crm.services.foos.repositories.FooRepository;
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
public class GetAllFoosUseCase implements UseCase<GetAllFoosRequest, GetAllFoosResponse> {

    private FooRepository fooRepository;

    public GetAllFoosUseCase() {
    }

    @Inject
    public GetAllFoosUseCase(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public GetAllFoosResponse execute(UseCaseContext useCaseContext, GetAllFoosRequest request){
        this.validateRequest(request);

        FooEntityConverter entityConverter = new FooEntityConverter();
        return new GetAllFoosResponse(entityConverter.fromEntity(this.fooRepository.findAll()));
    }

    private void validateRequest(GetAllFoosRequest request){
        //validate fields
    }
}
