package br.com.deja.api.application.usecases.employee.get;

import br.com.deja.api.application.usecases.employee.shared.EmployeeResponse;
import br.com.deja.api.domain.employee.Employee;
import br.com.deja.api.domain.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllEmployeesUseCase {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public GetAllEmployeesUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> execute() {
        var employee = employeeRepository.findAll();
        return getResponse(employee);
    }

    private List<EmployeeResponse> getResponse(List<Employee> employees) {
        return employees.stream().map(e -> new EmployeeResponse(e.getId().toString(),
                        e.getCpf().formattedDocument(),
                        e.getSalary().getDoubleAmount()))
                .collect(Collectors.toList());
    }
}
