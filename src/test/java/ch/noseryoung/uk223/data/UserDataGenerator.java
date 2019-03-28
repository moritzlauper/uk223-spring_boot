package ch.noseryoung.uk223.data;

import ch.noseryoung.uk223.domain.user.User;

/**
 * @author Santiago Gabriel Vollmar
 */
class UserDataGenerator implements DataGenerator<User> {

    private AddressDataGenerator addressGenerator;

    public UserDataGenerator(AddressDataGenerator addressGenerator) {
        this.addressGenerator = addressGenerator;
    }

    /**
     * @see AddressDataGenerator#generate()
     * @return (0, xXdimitriXx, secret, Dimitri, Dimitrovic, dimitri1337@gmail.com, addresses.first()),<br>
     *         (1, DiamondLucy, secret, Lucy Sarina, Danielsen, l.s.danielsen@gmail.com, addresses.second()),<br>
     *         (2, 41b3r71n0, secret, Albertino, Hofmann, hofmann1337@gmail.com, addresses.third())
     */
    @Override
    public DataHolder<User> generate() {
        var addresses = addressGenerator.generate();
        return DataHolder.of(
                new User(0L, "xXdimitriXx", "secret", "Dimitri", "Dimitrovic", "dimitri1337@gmail.com", addresses.first()),
                new User(1L, "DiamondLucy", "secret", "Lucy Sarina", "Danielsen", "l.s.danielsen@gmail.com", addresses.second()),
                new User(2L, "41b3r71n0", "secret", "Albertino", "Hofmann", "hofmann1337@gmail.com", addresses.third())
        );
    }
}
