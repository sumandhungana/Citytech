package global.citytech.interns.crm.services.foos.payloads;

import global.citytech.interns.crm.platform.usecases.UseCaseResponse;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;

import java.util.List;

public record GetAllFoosResponse(List<FooInfo> list) implements UseCaseResponse {

}
