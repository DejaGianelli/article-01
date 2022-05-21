package br.com.deja.api.domain.employee;

import br.com.deja.api.domain.Money;

public class Employee {
    private final Identifier id;
    private Cpf cpf;
    private Money salary;

    private Employee(Identifier id, Cpf cpf, Money salary) {
        this.id = id;
        this.cpf = cpf;
        this.salary = salary;
    }

    private Employee(Cpf cpf, Money salary) {
        this.id = Identifier.create();
        this.cpf = cpf;
        this.salary = salary;
    }

    public static Employee create(Cpf cpf, Money salary) {
        return new Employee(cpf, salary);
    }

    public static Employee materialize(Identifier id, Cpf cpf, Money salary) {
        return new Employee(id, cpf, salary);
    }

    public void updateDetails(Cpf cpf, Money salary) {
        this.cpf = cpf;
        this.salary = salary;
    }

    public Identifier getId() {
        return id;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Money getSalary() {
        return salary;
    }
}
