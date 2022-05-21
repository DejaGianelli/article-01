package br.com.deja.api.application.usecases.employee.create;

import br.com.deja.api.application.usecases.employee.shared.EmployeeDetails;
import br.com.deja.api.domain.Money;
import br.com.deja.api.domain.employee.Cpf;
import br.com.deja.api.domain.employee.Employee;
import br.com.deja.api.domain.employee.EmployeeRepository;
import br.com.deja.api.domain.employee.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public CreateEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Identifier execute(EmployeeDetails details) {
        var cpf = Cpf.create(details.cpf);
        var salary = Money.create(details.salary);
        var employee = Employee.create(cpf, salary);
        employeeRepository.save(employee);
        return employee.getId();
    }
}
