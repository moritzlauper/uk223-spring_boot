package ch.noseryoung.uk223.domain.user;

import ch.noseryoung.uk223.data.DataGenerators;
import ch.noseryoung.uk223.data.DataHolder;
import ch.noseryoung.uk223.domain.address.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
//@ContextConfiguration()
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

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
    public void findAll_returnsAll() {
        assertThat(userRepository.findAll()).containsExactlyElementsOf(dataHolder.asList());
    }
}
