package ch.noseryoung.uk223.domain.user;

import ch.noseryoung.uk223.Uk223Application;
import ch.noseryoung.uk223.data.DataGenerators;
import ch.noseryoung.uk223.data.DataHolder;
import ch.noseryoung.uk223.domain.user.dto.UserMapper;
import ch.noseryoung.uk223.domain.user.validation.UserValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class, includeFilters = {
        @Filter(classes = {UserValidator.class, UserMapper.class},
                type = FilterType.ASSIGNABLE_TYPE)
})
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserMapper userMapper;

    private DataHolder<User> dataHolder;

    @Before
    public void setup() {
        this.dataHolder = DataGenerators.forClass(User.class).generate();
    }

    @Test
    public void test() throws Exception {
        // setup mock
        when(userService.findAll()).thenReturn(dataHolder.asList());

        // create request
        var expectedJson = objectMapper.writeValueAsString(
                userMapper.toDTOs(dataHolder.asList())
        );

        mockMvc.perform(get("/users"))
                // .andDo(print()) prints out request/response info
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}