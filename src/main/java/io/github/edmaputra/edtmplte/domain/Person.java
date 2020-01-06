package io.github.edmaputra.edtmplte.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@MappedSuperclass
public abstract class Person<T> extends ABaseIdEntity<T> {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "First Name Cannot Null or Empty")
    @Column(name = "first_name", length = 150)
    protected String firstName = "";

    @NotNull(message = "Middle Name Cannot Null, Empty is acceptable")
    @Column(name = "middle_name", length = 150, nullable = false)
    protected String middleName = "";

    @NotNull(message = "Last Name Cannot Null, Empty is acceptable")
    @Column(name = "last_name", length = 150, nullable = false)
    protected String lastName = "";

    @NotNull(message = "Gender Cannot Null")
    @Column(name = "gender", length = 25, nullable = false)
    protected Gender gender = Gender.UNKNOWN;

    @NotNull(message = "Marital Status Cannot Null")
    @Column(name = "marital_status", length = 25, nullable = false)
    protected MaritalStatus maritalStatus = MaritalStatus.SINGLE;

    @NotNull(message = "Birth Place Cannot Null")
    @Column(name = "birth_place", length = 70, nullable = false)
    protected String birthPlace = "";

    @NotNull(message = "Birth Date Cannot Null")
    @Column(name = "birth_date", nullable = false)
    protected LocalDate birthDate = LocalDate.MIN;

    @NotNull(message = "Phone Number Cannot Null")
    @Column(name = "phone_number", length = 20, nullable = false)
    protected String phoneNumber = "";

    @NotNull(message = "Email Cannot Null")
    @Column(name = "email", nullable = false)
    protected String email = "";

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
            @NotNull(message = "Phone Number Cannot Null") String phoneNumber,
            @NotNull(message = "Email Cannot Null") String email
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAge() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
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
