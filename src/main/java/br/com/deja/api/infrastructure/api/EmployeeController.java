package br.com.deja.api.infrastructure.api;

import br.com.deja.api.application.usecases.employee.create.CreateEmployeeUseCase;
import br.com.deja.api.application.usecases.employee.delete.DeleteEmployeeUseCase;
import br.com.deja.api.application.usecases.employee.get.GetAllEmployeesUseCase;
import br.com.deja.api.application.usecases.employee.get.GetEmployeeUseCase;
import br.com.deja.api.application.usecases.employee.shared.EmployeeDetails;
import br.com.deja.api.application.usecases.employee.update.UpdateEmployeeUseCase;
import br.com.deja.api.domain.employee.Identifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final GetAllEmployeesUseCase getAllEmployeesUseCase;
    private final GetEmployeeUseCase getEmployeeUseCase;
    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;

    public EmployeeController(
            GetAllEmployeesUseCase getAllEmployeesUseCase,
            GetEmployeeUseCase getEmployeeUseCase,
            CreateEmployeeUseCase createEmployeeUseCase,
            UpdateEmployeeUseCase updateEmployeeUseCase,
            DeleteEmployeeUseCase deleteEmployeeUseCase) {
        this.getAllEmployeesUseCase = getAllEmployeesUseCase;
        this.getEmployeeUseCase = getEmployeeUseCase;
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.updateEmployeeUseCase = updateEmployeeUseCase;
        this.deleteEmployeeUseCase = deleteEmployeeUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        var responses = getAllEmployeesUseCase.execute();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        var response = getEmployeeUseCase.execute(Identifier.create(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeDetails request, UriComponentsBuilder uriComponentsBuilder) {
        var id = createEmployeeUseCase.execute(request);
        URI uri = uriComponentsBuilder.path("/employees/{id}").buildAndExpand(id.toString()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody EmployeeDetails request) {
        updateEmployeeUseCase.execute(Identifier.create(id), request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        deleteEmployeeUseCase.execute(Identifier.create(id));
        return ResponseEntity.noContent().build();
    }
}
