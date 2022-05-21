package br.com.deja.api.domain.employee;

import br.com.deja.api.domain.exceptions.DomainException;

import java.util.Objects;
import java.util.UUID;

public class Identifier {

    protected final UUID uuid;

    private Identifier() {
        this.uuid = UUID.randomUUID();
    }

    private Identifier(String uuidString) {
        try {
            Objects.requireNonNull(uuidString);
            this.uuid = UUID.fromString(uuidString);
        } catch (Throwable e) {
            throw new DomainException("Invalid UUID string representation");
        }
    }

    public static Identifier create() {
        return new Identifier();
    }

    public static Identifier create(String uuidString) {
        return new Identifier(uuidString);
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identifier that)) return false;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
