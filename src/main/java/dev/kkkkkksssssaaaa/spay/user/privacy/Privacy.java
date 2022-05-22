package dev.kkkkkksssssaaaa.spay.user.privacy;

import java.util.Objects;

public class Privacy {

    private final Name name;
    private final Phone phone;

    private Privacy(Name name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public static Privacy of(String name,
                             String phone) {
        return new Privacy(
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

        return ((Privacy) o).name().equals(this.name())
                && ((Privacy) o).phone().equals(this.phone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name(), phone());
    }

}
