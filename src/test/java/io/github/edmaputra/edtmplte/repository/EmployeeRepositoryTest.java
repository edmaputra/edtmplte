package io.github.edmaputra.edtmplte.repository;

import io.github.edmaputra.edtmplte.domain.Employee;
import io.github.edmaputra.edtmplte.domain.Gender;
import io.github.edmaputra.edtmplte.domain.MaritalStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    EmployeeRepository employeeRepository;

    private Employee e1;
    private Employee e2;
    private Employee e3;

    @Before
    public void setup() {
        e1 = new Employee(
                "Bangun",
                "Edma",
                "Saputra",
                Gender.MALE,
                MaritalStatus.MARRIED,
                "Kota Bangun",
                LocalDate.of(1990, Month.JULY, 8),
                "085348105989",
                "bangun.edma@gmail.com"
        );

        e2 = new Employee(
                "Diar",
                "Resti",
                "Andari",
                Gender.FEMALE,
                MaritalStatus.MARRIED,
                "Situbondo",
                LocalDate.of(1985, Month.NOVEMBER, 11),
                "082250305698",
                "deardee@gmail.com"
        );

        e3 = new Employee(
                "Adiba",
                "Dzakira",
                "Aftani",
                Gender.FEMALE,
                MaritalStatus.SINGLE,
                "Tarakan",
                LocalDate.of(2019, Month.FEBRUARY, 2),
                "085348105989",
                "adiba.dzakira@gmail.com"
        );

        testEntityManager.persist(e1);
        testEntityManager.persist(e2);
        testEntityManager.persist(e3);
    }

    @Test
    public void whenRetrieveAll_shouldReturnCorrectQuantity() {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(employees);
        assertThat(employees.size()).isEqualTo(3);
    }

    @Test
    public void whenRetrieveOne_shouldReturnCorrectResult() {
        Optional<Employee> employee = employeeRepository.findOne(Example.of(e1));
        assertThat(employee.isPresent()).isTrue();
        assertThat(employee.get().getFirstName()).isEqualTo("Bangun");
        assertThat(employee.get().getMaritalStatus()).isEqualTo(MaritalStatus.MARRIED);
    }

    @Test
    public void whenTryToSave_shouldReturnCorrectQuantityInDatabase() {
        Employee e4 = new Employee(
                "Andri",
                "",
                "Gunandi",
                Gender.MALE,
                MaritalStatus.DIVORCEE,
                "Bandung",
                LocalDate.of(1992, Month.FEBRUARY, 12),
                "085348108888",
                "andri.gunandi@gmail.com"
        );
        employeeRepository.save(e4);

        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees.size()).isEqualTo(4);
    }

    @Test
    public void whenTryToUpdateEntity_shouldUpdateSuccessfully() {
        Optional<Employee> optionalEmployee = employeeRepository.findOne(Example.of(e1));
        assertThat(optionalEmployee.isPresent()).isTrue();

        Employee employee = optionalEmployee.get();
        employee.setFirstName("ABC");
        employee.setMiddleName("DEF");
        employee.setLastName("GHI");
        employee.setGender(Gender.FEMALE);
        employee.setMaritalStatus(MaritalStatus.DIVORCEE);
        employee.setBirthDate(LocalDate.of(1991, Month.JANUARY, 1));
        employee.setBirthPlace("Samarinda");
        employee.setEmail("aaa@gmail.com");
        employee.setPhoneNumber("123456");

        Employee saved = employeeRepository.save(employee);
        assertThat(saved.getFirstName()).isEqualTo("ABC");
        assertThat(saved.getMiddleName()).isEqualTo("DEF");
        assertThat(saved.getLastName()).isEqualTo("GHI");
        assertThat(saved.getGender()).isEqualTo(Gender.FEMALE);
        assertThat(saved.getMaritalStatus()).isEqualTo(MaritalStatus.DIVORCEE);
        assertThat(saved.getBirthDate()).isEqualTo(LocalDate.of(1991, Month.JANUARY, 1));
        assertThat(saved.getBirthPlace()).isEqualTo("Samarinda");
        assertThat(saved.getEmail()).isEqualTo("aaa@gmail.com");
        assertThat(saved.getPhoneNumber()).isEqualTo("123456");


    }

    @Test
    public void whenTryToRemoveAnEntity_shouldSuccessAndReturnCorrectQuantityInDatabase() {
        employeeRepository.delete(e3);

        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees.size()).isEqualTo(2);
    }

    @Test
    public void whenTryToRemoveAll_shouldSuccessAndReturnCorrectQuantityInDatabase() {
        employeeRepository.deleteAll();

        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees.size()).isEqualTo(0);
    }

    @After
    public void clear() {

//        testEntityManager.clear();
    }

}