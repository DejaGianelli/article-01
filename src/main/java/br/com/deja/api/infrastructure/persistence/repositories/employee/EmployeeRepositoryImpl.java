package br.com.deja.api.infrastructure.persistence.repositories.employee;

import br.com.deja.api.domain.employee.Employee;
import br.com.deja.api.domain.employee.EmployeeRepository;
import br.com.deja.api.domain.employee.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SpringDataEmployeeRepository springData;

    @Autowired
    public EmployeeRepositoryImpl(SpringDataEmployeeRepository springData) {
        this.springData = springData;
    }

    @Override
    public Optional<Employee> findById(Identifier id) {
        var optionalEntity = springData.findById(id.toString());
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(EmployeeMapper.map(optionalEntity.get()));
    }

    @Override
    public void deleteById(Identifier id) {
        springData.deleteById(id.toString());
    }

    @Override
    public void save(Employee employee) {
        springData.save(EmployeeEntityMapper.map(employee));
    }

    @Override
    public List<Employee> findAll() {
        var entities = springData.findAll();
        return entities.stream().map(EmployeeMapper::map).collect(Collectors.toList());
    }
}
