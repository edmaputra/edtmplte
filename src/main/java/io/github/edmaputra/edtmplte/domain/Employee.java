package io.github.edmaputra.edtmplte.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Employee extends Person<Long> {

    public Employee(@NotBlank(message = "First Name Cannot Null or Empty") String firstName, @NotNull(message = "Middle Name Cannot Null, Empty is acceptable") String middleName, @NotNull(message = "Last Name Cannot Null, Empty is acceptable") String lastName, @NotNull(message = "Gender Cannot Null") Gender gender, @NotNull(message = "Marital Status Cannot Null") MaritalStatus maritalStatus, @NotNull(message = "Birth Place Cannot Null") String birthPlace, @NotNull(message = "Birth Date Cannot Null") LocalDate birthDate, @NotNull(message = "Phone Number Cannot Null") String phoneNumber, @NotNull(message = "Email Cannot Null") String email) {
        super(firstName, middleName, lastName, gender, maritalStatus, birthPlace, birthDate, phoneNumber, email);
    }
}
