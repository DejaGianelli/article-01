package br.com.deja.api.infrastructure.persistence.repositories.employee;

import br.com.deja.api.domain.Money;
import br.com.deja.api.domain.employee.Cpf;
import br.com.deja.api.domain.employee.Employee;
import br.com.deja.api.domain.employee.Identifier;

public class EmployeeMapper {
    public static Employee map(EmployeeEntity entity) {
        return Employee.materialize(Identifier.create(entity.getId()),
                Cpf.create(entity.getCpf()),
                Money.create(entity.getSalary()));
    }
}
