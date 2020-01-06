package io.github.edmaputra.edtmplte.domain;

import org.junit.Test;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalField;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    PersonImpl p1;

    @Test
    public void whenInitializeWithoutParams_shouldContainDefaultValue() {
        p1 = new PersonImpl();
        assertThat(p1.getGender()).isEqualTo(Gender.UNKNOWN);
        assertThat(p1.getFirstName()).isEqualTo("");
        assertThat(p1.getLastName()).isEqualTo("");
        assertThat(p1.getMiddleName()).isEqualTo("");
        assertThat(p1.getMaritalStatus()).isEqualTo(MaritalStatus.SINGLE);
        assertThat(p1.getBirthPlace()).isEqualTo("");
        assertThat(p1.getBirthDate()).isEqualTo(LocalDate.MIN);
        assertThat(p1.getPhoneNumber()).isEqualTo("");
        assertThat(p1.getEmail()).isEqualTo("");
    }

    @Test
    public void whenInitializeWithParams_shouldContainDefaultValue() {
        p1 = new PersonImpl(
                "Bangun",
                "Edma",
                "Saputra",
                Gender.MALE,
                MaritalStatus.MARRIED,
                "Kota Bangun",
                LocalDate.of(1990, Month.JULY, 8),
                "085348481919",
                "abc@test.com"
        );

        assertThat(p1.getGender()).isEqualTo(Gender.MALE);
        assertThat(p1.getFirstName()).isEqualTo("Bangun");
        assertThat(p1.getLastName()).isEqualTo("Saputra");
        assertThat(p1.getMiddleName()).isEqualTo("Edma");
        assertThat(p1.getMaritalStatus()).isEqualTo(MaritalStatus.MARRIED);
        assertThat(p1.getBirthPlace()).isEqualTo("Kota Bangun");
        assertThat(p1.getBirthDate()).isEqualTo(LocalDate.of(1990, Month.JULY, 8));
        assertThat(p1.getPhoneNumber()).isEqualTo("085348481919");
        assertThat(p1.getEmail()).isEqualTo("abc@test.com");
    }

    @Test
    public void whenInitializeAndSetWithSetterMethod_shouldReturnCorrectValue() {
        p1 = new PersonImpl();

        p1.setFirstName("Bangun");
        p1.setMiddleName("Edma");
        p1.setLastName("Saputra");
        p1.setGender(Gender.MALE);
        p1.setMaritalStatus(MaritalStatus.MARRIED);
        p1.setBirthPlace("Kota Bangun");
        p1.setBirthDate(LocalDate.of(1990, Month.JULY, 8));
        p1.setPhoneNumber("085348481919");
        p1.setEmail("abc@test.com");

        assertThat(p1.getGender()).isEqualTo(Gender.MALE);
        assertThat(p1.getFirstName()).isEqualTo("Bangun");
        assertThat(p1.getLastName()).isEqualTo("Saputra");
        assertThat(p1.getMiddleName()).isEqualTo("Edma");
        assertThat(p1.getMaritalStatus()).isEqualTo(MaritalStatus.MARRIED);
        assertThat(p1.getBirthPlace()).isEqualTo("Kota Bangun");
        assertThat(p1.getBirthDate()).isEqualTo(LocalDate.of(1990, Month.JULY, 8));
        assertThat(p1.getPhoneNumber()).isEqualTo("085348481919");
        assertThat(p1.getEmail()).isEqualTo("abc@test.com");
    }

    @Test
    public void testAgeCalculation() {
        int year = 1990;
        long expected = LocalDate.now().getYear() - year;

        p1 = new PersonImpl();
        p1.setBirthDate(LocalDate.of(year, Month.JANUARY, 1));
        assertThat(p1.getAge()).isEqualTo(expected);
    }

    private static class PersonImpl extends Person {

        public PersonImpl() {
        }

        public PersonImpl(@NotBlank(message = "First Name Cannot Null or Empty") String firstName, @NotNull(message = "Middle Name Cannot Null, Empty is acceptable") String middleName, @NotNull(message = "Last Name Cannot Null, Empty is acceptable") String lastName, @NotNull(message = "Gender Cannot Null") Gender gender, @NotNull(message = "Marital Status Cannot Null") MaritalStatus maritalStatus, @NotNull(message = "Birth Place Cannot Null") String birthPlace, @NotNull(message = "Birth Date Cannot Null") LocalDate birthDate, @NotNull(message = "Phone Number Cannot Null") String phoneNumber, @NotNull(message = "Email Cannot Null") String email) {
            super(firstName, middleName, lastName, gender, maritalStatus, birthPlace, birthDate, phoneNumber, email);
        }
    }
}