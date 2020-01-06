package io.github.edmaputra.edtmplte.domain;

import org.junit.Test;

import javax.validation.constraints.NotBlank;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest {

    AddressImpl address;

    @Test
    public void whenInitializeWithoutParams_shouldContainDefaultValue() {
        address = new AddressImpl();

        assertThat(address.getStreet()).isEqualTo("");
        assertThat(address.getCity()).isEqualTo("");
        assertThat(address.getCountry()).isEqualTo("");
        assertThat(address.getProvince()).isEqualTo("");
        assertThat(address.getZipCode()).isEqualTo("");
    }

    @Test
    public void whenInitializeWithParams_shouldContainDefaultValue() {
        address = new AddressImpl(
                "Jl. Pasir Kaliki",
                "Bandung",
                "Jawa Barat",
                "40162",
                "Indonesia"
        );

        assertThat(address.getStreet()).isEqualTo("Jl. Pasir Kaliki");
        assertThat(address.getCity()).isEqualTo("Bandung");
        assertThat(address.getCountry()).isEqualTo("Indonesia");
        assertThat(address.getProvince()).isEqualTo("Jawa Barat");
        assertThat(address.getZipCode()).isEqualTo("40162");
    }

    @Test
    public void whenInitializeAndSetWithSetterMethod_shouldReturnCorrectValue() {
        address = new AddressImpl();
        address.setStreet("Jl. Pasir Kaliki");
        address.setCity("Bandung");
        address.setProvince("Jawa Barat");
        address.setZipCode("40162");
        address.setCountry("Indonesia");

        assertThat(address.getStreet()).isEqualTo("Jl. Pasir Kaliki");
        assertThat(address.getCity()).isEqualTo("Bandung");
        assertThat(address.getCountry()).isEqualTo("Indonesia");
        assertThat(address.getProvince()).isEqualTo("Jawa Barat");
        assertThat(address.getZipCode()).isEqualTo("40162");
    }

    private static class AddressImpl extends Address<String> {
        public AddressImpl() {
        }

        public AddressImpl(@NotBlank(message = "Street Name Cannot Null or Empty") String street, @NotBlank(message = "City Name Cannot Null or Empty") String city, @NotBlank(message = "Province Name Cannot Null or Empty") String province, @NotBlank(message = "Zip Code Name Cannot Null or Empty") String zipCode, @NotBlank(message = "Country Name Cannot Null or Empty") String country) {
            super(street, city, province, zipCode, country);
        }
    }

}
