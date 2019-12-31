package io.github.edmaputra.edtmplte.domain.person;

import io.github.edmaputra.edtmplte.domain.ABaseIdEntity;
import io.github.edmaputra.edtmplte.domain.address.Address;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Person extends ABaseIdEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "First Name Cannot Null or Empty")
    @Column(name = "first_name", length = 150)
    private String firstName = "";

    @NotNull(message = "Middle Name Cannot Null, Empty is acceptable")
    @Column(name = "middle_name", length = 150, nullable = false)
    private String middleName = "";

    @NotNull(message = "Last Name Cannot Null, Empty is acceptable")
    @Column(name = "last_name", length = 150, nullable = false)
    private String lastName = "";

    @NotNull(message = "Gender Cannot Null")
    @Column(name = "gender", length = 25, nullable = false)
    private Gender gender = Gender.UNKNOWN;

    @NotNull(message = "Marital Status Cannot Null")
    @Column(name = "marital_status", length = 25, nullable = false)
    private MaritalStatus maritalStatus = MaritalStatus.SINGLE;

    @NotNull(message = "Birth Place Cannot Null")
    @Column(name = "birth_place", length = 70, nullable = false)
    private String birthPlace = "";

    @NotNull(message = "Birth Date Cannot Null")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate = LocalDate.MIN;

    @NotNull(message = "Phone Number Cannot Null")
    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "person_address",
            joinColumns = { @JoinColumn(name = "person_id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "address_id", nullable = false) }
    )
    private Set<Address> addresses = new HashSet<>();

    public Person() {
    }

    public Person(
            @NotBlank(message = "First Name Cannot Null or Empty") String firstName,
            @NotNull(message = "Middle Name Cannot Null, Empty is acceptable") String middleName,
            @NotNull(message = "Last Name Cannot Null, Empty is acceptable") String lastName,
            @NotNull(message = "Gender Cannot Null") Gender gender,
            @NotNull(message = "Marital Status Cannot Null") MaritalStatus maritalStatus,
            @NotNull(message = "Birth Place Cannot Null") String birthPlace,
            @NotNull(message = "Birth Date Cannot Null") LocalDate birthDate,
            @NotNull(message = "Phone Number Cannot Null") String phoneNumber
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", maritalStatus=" + maritalStatus +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
