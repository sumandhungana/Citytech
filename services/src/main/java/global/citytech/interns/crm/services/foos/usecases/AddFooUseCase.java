package global.citytech.interns.crm.services.foos.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.entities.FooEntity;
import global.citytech.interns.crm.services.foos.entities.converters.FooEntityConverter;
import global.citytech.interns.crm.services.foos.payloads.AddFooRequest;
import global.citytech.interns.crm.services.foos.payloads.AddFooResponse;
import global.citytech.interns.crm.services.foos.repositories.FooRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;

@Named
public class AddFooUseCase implements UseCase<AddFooRequest, AddFooResponse> {
    private FooRepository fooRepository;

    public AddFooUseCase() {
    }

    @Inject
    public AddFooUseCase(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public AddFooResponse execute(UseCaseContext context, AddFooRequest request){
        this.validateRequest(request);
        request.setId(LocalDateTime.now().toString());

        FooEntityConverter entityConverter = new FooEntityConverter();
        FooEntity entity = entityConverter.toEntity(request);
        FooEntity addedEntity = this.fooRepository.add(entity);
        return new AddFooResponse(addedEntity.getId());
    }

    private boolean validateRequest(AddFooRequest request){
        return true;
    }
}
