package global.citytech.interns.crm.platform.usecases;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@FunctionalInterface
public interface UseCase <I extends UseCaseRequest, O extends UseCaseResponse>{

    O execute(@NotNull @Valid UseCaseContext context, @Valid I request);
}
