package ch.noseryoung.uk223.domain.user;

import ch.noseryoung.uk223.data.DataGenerators;
import ch.noseryoung.uk223.data.DataHolder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private DataHolder<User> dataHolder;

    @Before
    public void setup() {
        this.dataHolder = DataGenerators.forClass(User.class).generate();
    }

    @Test
    public void findById_idExists_returnsUser() {
        // setup mock
        var user = dataHolder.first();
        when(userRepository.findById(user.getId()))
                .thenReturn(Optional.of(user));

        // test service
        assertThat(userService.findById(user.getId()))
                .isPresent()
                .contains(user);
    }

    @Test
    public void findById_idDoesNotExist_returnsUser() {
        // no mock setup required

        // test service
        assertThat(userService.findById(1312L))
                .isEmpty();
    }

}
