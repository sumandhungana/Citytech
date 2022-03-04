package global.citytech.interns.crm.services.foos.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.platform.utils.HelperUtils;
import global.citytech.interns.crm.services.foos.entities.api.FooEntity;
import global.citytech.interns.crm.services.foos.entities.converters.FooEntityConverter;
import global.citytech.interns.crm.services.foos.payloads.AddFooRequest;
import global.citytech.interns.crm.services.foos.payloads.AddFooResponse;
import global.citytech.interns.crm.services.foos.repositories.FooRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.Optional;

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
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public AddFooResponse execute(UseCaseContext context, AddFooRequest request){
        this.validateRequest(request);
        request.setId(HelperUtils.generateRandomId());

        FooEntityConverter entityConverter = new FooEntityConverter();
        FooEntity entity = entityConverter.toEntity(request);
        Optional<FooEntity> addedEntity = this.fooRepository.create(entity);
        return new AddFooResponse(addedEntity.get().getId());
    }

    private boolean validateRequest(AddFooRequest request){
        return true;
    }
}
