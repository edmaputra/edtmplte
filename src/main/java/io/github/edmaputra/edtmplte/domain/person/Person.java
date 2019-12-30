package io.github.edmaputra.edtmplte.domain.person;

import io.github.edmaputra.edtmplte.domain.ABaseIdEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public abstract class Person extends ABaseIdEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "First Name Cannot Null or Empty")
    private String firstName = "";

    @NotNull(message = "Middle Name Cannot Null, Empty is acceptable")
    private String middleName = "";

    @NotNull(message = "Last Name Cannot Null, Empty is acceptable")
    private String lastName = "";

    @NotNull(message = "Gender Cannot Null")
    private Gender gender = Gender.UNKNOWN;

    @NotNull(message = "Marital Status Cannot Null")
    private MaritalStatus maritalStatus = MaritalStatus.SINGLE;

    @NotNull(message = "Birth Place Cannot Null")
    private String birthPlace = "";

    @NotNull(message = "Birth Date Cannot Null")
    private LocalDate birthDate = LocalDate.MIN;

    public Person() {
    }

    public Person(@NotBlank(message = "First Name Cannot Null or Empty") String firstName,
                  @NotNull(message = "Middle Name Cannot Null, Empty is acceptable") String middleName,
                  @NotNull(message = "Last Name Cannot Null, Empty is acceptable") String lastName,
                  @NotNull(message = "Gender Cannot Null") Gender gender,
                  @NotNull(message = "Marital Status Cannot Null") MaritalStatus maritalStatus,
                  @NotNull(message = "Birth Place Cannot Null") String birthPlace,
                  @NotNull(message = "Birth Date Cannot Null") LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
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
                '}';
    }
}
