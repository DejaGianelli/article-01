package br.com.deja.api.application.usecases.employee.get;

import br.com.deja.api.application.usecases.employee.shared.EmployeeResponse;
import br.com.deja.api.domain.employee.Employee;
import br.com.deja.api.domain.employee.Identifier;
import br.com.deja.api.domain.services.GetEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEmployeeUseCase {

    private final GetEmployeeService getEmployeeService;

    @Autowired
    public GetEmployeeUseCase(GetEmployeeService getEmployeeService) {
        this.getEmployeeService = getEmployeeService;
    }

    public EmployeeResponse execute(Identifier id) {
        var employee = getEmployeeService.execute(id);
        return getResponse(employee);
    }

    private EmployeeResponse getResponse(Employee employee) {
        return new EmployeeResponse(employee.getId().toString(),
                employee.getCpf().formattedDocument(),
                employee.getSalary().getDoubleAmount());
    }
}
