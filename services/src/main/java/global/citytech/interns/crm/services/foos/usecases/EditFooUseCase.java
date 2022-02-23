package global.citytech.interns.crm.services.foos.usecases;

import global.citytech.interns.crm.platform.usecases.UseCase;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.entities.FooEntity;
import global.citytech.interns.crm.services.foos.entities.converters.FooEntityConverter;
import global.citytech.interns.crm.services.foos.payloads.EditFooRequest;
import global.citytech.interns.crm.services.foos.payloads.EditFooResponse;
import global.citytech.interns.crm.services.foos.repositories.FooRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class EditFooUseCase implements UseCase<EditFooRequest, EditFooResponse> {
    private FooRepository fooRepository;

    public EditFooUseCase() {
    }

    @Inject
    public EditFooUseCase(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public EditFooResponse execute(UseCaseContext context, EditFooRequest request){
        if(!this.validateRequest(request)){
            return null;
        }

        FooEntityConverter entityConverter = new FooEntityConverter();
        FooEntity entity = entityConverter.toEntity(request);
        FooEntity updatedEntity = this.fooRepository.update(entity);
        return new EditFooResponse(updatedEntity.getId());
    }

    private boolean validateRequest(EditFooRequest request){
        if(request == null || request.getId() == null){
            return false;
        }
        if(this.fooRepository.findOne(request.getId()) == null){
            return false;
        }
        return true;
    }
}
