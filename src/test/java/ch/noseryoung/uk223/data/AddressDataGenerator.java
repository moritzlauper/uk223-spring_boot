package ch.noseryoung.uk223.data;

import ch.noseryoung.uk223.domain.address.Address;

/**
 * @author Santiago Gabriel Vollmar
 */
class AddressDataGenerator implements DataGenerator<Address> {

    /**
     * @return (0L, Boofer Lane, 420, TN 37332, Evensville),<br>
     *         (1L, Blazer Ln, 420, TN 37321, Dayton),<br>
     *         (2L, Acid Mine Rd, 1611, MO 63080, Sullivan)
     */
    @Override
    public DataHolder<Address> generate() {
        return DataHolder.of(
                new Address(0L, "Boofer Lane", "420", "TN 37332", "Evensville"),
                new Address(1L, "Blazer Ln", "420", "TN 37321", "Dayton"),
                new Address(2L, "Acid Mine Rd", "1611", "MO 63080", "Sullivan")
        );
    }
}
