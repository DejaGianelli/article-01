package br.com.deja.api.domain.services;

import br.com.deja.api.domain.employee.Employee;
import br.com.deja.api.domain.employee.EmployeeRepository;
import br.com.deja.api.domain.employee.Identifier;
import br.com.deja.api.domain.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public GetEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee execute(Identifier id) {
        var optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty())
            throw new DomainException(String.format("Employee %s not found", id.toString()));
        return optionalEmployee.get();
    }
}
