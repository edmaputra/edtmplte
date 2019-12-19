package io.github.edmaputra.edtmplte.domain.person;

import io.github.edmaputra.edtmplte.domain.ABaseIdEntity;
import io.github.edmaputra.edtmplte.domain.address.Address;

import java.util.Date;
import java.util.List;

public abstract class Person extends ABaseIdEntity {

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String middleName;

    private String lastName;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private String birthPlace;

    private Date birthDate;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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
