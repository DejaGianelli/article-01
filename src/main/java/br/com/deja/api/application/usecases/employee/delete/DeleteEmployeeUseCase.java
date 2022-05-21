package br.com.deja.api.application.usecases.employee.delete;

import br.com.deja.api.domain.employee.EmployeeRepository;
import br.com.deja.api.domain.employee.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DeleteEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void execute(Identifier id) {
        employeeRepository.deleteById(id);
    }
}
