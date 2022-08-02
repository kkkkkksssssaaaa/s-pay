package dev.kkkkkksssssaaaa.spay.user.privacy;

import dev.kkkkkksssssaaaa.spay.atomical.AbstractName;

final class Name extends AbstractName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String REGEX = "^[가-힣]*$";

    private Name(String name) {
        super(name, REGEX, MIN_LENGTH, MAX_LENGTH);
    }

    static Name of(String name) {
        return new Name(name);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
