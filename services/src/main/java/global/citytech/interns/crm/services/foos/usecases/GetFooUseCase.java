package global.citytech.interns.crm.services.foos.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.entities.FooEntity;
import global.citytech.interns.crm.services.foos.entities.converters.FooEntityConverter;
import global.citytech.interns.crm.services.foos.payloads.GetFooRequest;
import global.citytech.interns.crm.services.foos.payloads.GetFooResponse;
import global.citytech.interns.crm.services.foos.repositories.FooRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class GetFooUseCase implements UseCase<GetFooRequest, GetFooResponse> {

    @Inject
    private FooRepository fooRepository;

    public GetFooUseCase() {
    }

    public GetFooUseCase(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public GetFooResponse execute(UseCaseContext context, GetFooRequest request) {
        FooEntity entity = this.fooRepository.findOne(request.getId());
        FooEntityConverter converter = new FooEntityConverter();
        return new GetFooResponse(converter.fromEntity(entity));
    }
}
