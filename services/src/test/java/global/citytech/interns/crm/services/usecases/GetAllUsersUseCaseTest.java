package global.citytech.interns.crm.services.usecases;

import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.users.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.services.users.payloads.GetAllUsersResponse;
import global.citytech.interns.crm.services.users.repositories.UserRepository;
import global.citytech.interns.crm.services.users.usecases.GetAllUsersUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

class GetAllUsersUseCaseTest {

    private GetAllUsersUseCase getAllUsersUseCase;
    private UserRepository userRepository;

    @BeforeEach
    void init(){
        userRepository = Mockito.mock(UserRepository.class);
        getAllUsersUseCase = new GetAllUsersUseCase(userRepository);
        Mockito.when(userRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
    }

    @Test
    @DisplayName("GetAllUsersUseCaseTest: shouldSucceedToGetAllUsersWhenNoFiltersApplied")
    void shouldSucceedToGetAllUsersWhenNoFiltersApplied() {
        GetAllUsersRequest request = new GetAllUsersRequest();
        GetAllUsersResponse response = getAllUsersUseCase.execute(UseCaseContext.emptyContext(),request);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.list());
        Assertions.assertEquals(0, response.list().size());
    }
}
