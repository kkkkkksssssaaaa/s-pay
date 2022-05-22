package dev.kkkkkksssssaaaa.spay.user;

import java.util.Objects;

public class User {

    private final Name name;
    private final Phone phone;

    private User(Name name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public static User of(String name,
                          String phone) {
        return new User(
                Name.of(name),
                Phone.of(phone));
    }

    public Name name() {
        return this.name;
    }

    public Phone phone() {
        return this.phone;
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return ((User) o).name().equals(this.name())
                && ((User) o).phone().equals(this.phone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name(), phone());
    }

}
