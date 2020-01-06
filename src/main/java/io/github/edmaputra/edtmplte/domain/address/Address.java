package io.github.edmaputra.edtmplte.domain.address;

import io.github.edmaputra.edtmplte.domain.ABaseIdEntity;
import io.github.edmaputra.edtmplte.domain.person.Person;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public abstract class Address<T> extends ABaseIdEntity<T> {

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "addresses")
    private Set<Person> persons = new HashSet<>();

    @NotBlank(message = "Street Name Cannot Null or Empty")
    @Column(name = "street", length = 150, nullable = false)
    private String street;

    @NotBlank(message = "City Name Cannot Null or Empty")
    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @NotBlank(message = "Province Name Cannot Null or Empty")
    @Column(name = "province", length = 100, nullable = false)
    private String province;

    @NotBlank(message = "Zip Code Name Cannot Null or Empty")
    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @NotBlank(message = "Country Name Cannot Null or Empty")
    @Column(name = "country", length = 80, nullable = false)
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    @Override
    public String toString() {
        return "Address{" +
                "persons=" + persons +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
