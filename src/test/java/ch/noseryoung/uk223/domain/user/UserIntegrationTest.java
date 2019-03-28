package ch.noseryoung.uk223.domain.user;

import ch.noseryoung.uk223.data.DataGenerators;
import ch.noseryoung.uk223.data.DataHolder;
import ch.noseryoung.uk223.domain.address.Address;
import ch.noseryoung.uk223.domain.address.AddressRepository;
import ch.noseryoung.uk223.domain.user.dto.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Santiago Gabriel Vollmar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserMapper userMapper;

    private DataHolder<User> dataHolder;

    @Before
    public void setup() {
        // persist addresses
        var addresses = DataGenerators.forClass(Address.class).generate()
                .asList().stream()
                .peek(a -> a.setId(null))
                .peek(entityManager::persist)
                .collect(Collectors.toCollection(ArrayList::new));

        // merge IDs
        dataHolder = DataGenerators.forClass(User.class).generate();
        for (int i = 0; i < addresses.size(); i++) {
            dataHolder.asList().get(i)
                    .setAddress(new Address(addresses.get(i).getId(),
                            null, null, null, null));
        }

        // persist users
        dataHolder.asList().stream()
                .peek(u -> u.setId(null))
                .forEach(entityManager::persist);
    }

    @Test
    public void test() throws Exception {
        var expectedJson = objectMapper.writeValueAsString(
                userMapper.toDTOs(dataHolder.asList())
        );

        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
