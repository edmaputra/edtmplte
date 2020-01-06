package io.github.edmaputra.edtmplte.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class Address<T> extends ABaseIdEntity<T> {

    @NotBlank(message = "Street Name Cannot Null or Empty")
    @Column(name = "street", length = 150, nullable = false)
    protected String street = "";

    @NotBlank(message = "City Name Cannot Null or Empty")
    @Column(name = "city", length = 100, nullable = false)
    protected String city = "";

    @NotBlank(message = "Province Name Cannot Null or Empty")
    @Column(name = "province", length = 100, nullable = false)
    protected String province = "";

    @NotBlank(message = "Zip Code Name Cannot Null or Empty")
    @Column(name = "zip_code", length = 10, nullable = false)
    protected String zipCode = "";

    @NotBlank(message = "Country Name Cannot Null or Empty")
    @Column(name = "country", length = 80, nullable = false)
    protected String country = "";

    public Address() {
    }

    public Address(
            @NotBlank(message = "Street Name Cannot Null or Empty") String street,
            @NotBlank(message = "City Name Cannot Null or Empty") String city,
            @NotBlank(message = "Province Name Cannot Null or Empty") String province,
            @NotBlank(message = "Zip Code Name Cannot Null or Empty") String zipCode,
            @NotBlank(message = "Country Name Cannot Null or Empty") String country) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
        this.country = country;
    }

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

    @Override
    public String toString() {
        return "Address{" +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
