package br.com.deja.api.application.usecases.employee.shared;

public class EmployeeResponse {
    public String id;
    public String cpf;
    public Double salary;

    public EmployeeResponse(String id, String cpf, Double salary) {
        this.id = id;
        this.cpf = cpf;
        this.salary = salary;
    }
}
