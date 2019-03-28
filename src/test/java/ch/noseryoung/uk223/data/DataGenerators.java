package ch.noseryoung.uk223.data;

import ch.noseryoung.uk223.domain.address.Address;
import ch.noseryoung.uk223.domain.user.User;

/**
 * @author Santiago Gabriel Vollmar
 */
public class DataGenerators {

    public static <T> DataGenerator<T> forClass(Class<T> clazz) {
        return new DataGenerators().build(clazz);
    }

    public <T> DataGenerator<T> build(Class<T> clazz) {
        DataGenerator<?> gen;

        if (User.class.isAssignableFrom(clazz)) {
            gen = userGen();
        } else if (Address.class.isAssignableFrom(clazz)) {
            gen = addressGen();
        } else {
            throw new RuntimeException();
        }

        return (DataGenerator<T>) gen;
    }

    private AddressDataGenerator addressGen() {
        return new AddressDataGenerator();
    }

    private UserDataGenerator userGen() {
        return new UserDataGenerator(addressGen());
    }
}
