package br.com.deja.api.infrastructure.persistence.repositories.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}
