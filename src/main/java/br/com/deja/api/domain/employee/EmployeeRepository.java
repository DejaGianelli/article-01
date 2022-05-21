package br.com.deja.api.domain.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findById(Identifier id);

    void deleteById(Identifier id);

    void save(Employee employee);

    List<Employee> findAll();
}
