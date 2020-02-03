package io.github.edmaputra.edtmplte.repository;

import io.github.edmaputra.edtmplte.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ABaseRepository<Employee, Long> {

}
