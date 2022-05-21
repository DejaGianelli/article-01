package br.com.deja.api.application.usecases.employee.update;

import br.com.deja.api.application.usecases.employee.shared.EmployeeDetails;
import br.com.deja.api.domain.Money;
import br.com.deja.api.domain.employee.Cpf;
import br.com.deja.api.domain.employee.EmployeeRepository;
import br.com.deja.api.domain.employee.Identifier;
import br.com.deja.api.domain.services.GetEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;
    private final GetEmployeeService getEmployeeService;

    @Autowired
    public UpdateEmployeeUseCase(EmployeeRepository employeeRepository, GetEmployeeService getEmployeeService) {
        this.employeeRepository = employeeRepository;
        this.getEmployeeService = getEmployeeService;
    }

    public void execute(Identifier id, EmployeeDetails details) {
        var employee = getEmployeeService.execute(id);
        var cpf = Cpf.create(details.cpf);
        var salary = Money.create(details.salary);
        employee.updateDetails(cpf, salary);
        employeeRepository.save(employee);
    }
}
