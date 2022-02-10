package global.citytech.interns.crm.adminendpoints.users.usecases;

import global.citytech.interns.crm.adminendpoints.users.payloads.GetAllUsersRequest;
import global.citytech.interns.crm.adminendpoints.users.payloads.GetAllUsersResponse;
import global.citytech.interns.crm.adminendpoints.users.repositories.users.UserRepository;
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
        GetAllUsersResponse response = getAllUsersUseCase.execute(request);
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.list());
        Assertions.assertEquals(0, response.list().size());
    }
}
