package br.com.deja.api.infrastructure.persistence.repositories.employee;

import br.com.deja.api.domain.employee.Employee;

public class EmployeeEntityMapper {
    public static EmployeeEntity map(Employee employee) {
        var entity = new EmployeeEntity();
        entity.setId(employee.getId().toString());
        entity.setCpf(employee.getCpf().document());
        entity.setSalary(employee.getSalary().getDoubleAmount());
        return entity;
    }
}
