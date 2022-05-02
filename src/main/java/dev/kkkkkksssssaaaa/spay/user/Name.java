package dev.kkkkkksssssaaaa.spay.user;

import dev.kkkkkksssssaaaa.spay.util.Strings;

import java.util.regex.Pattern;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String REGEX = "^[가-힣]*$";

    private final String name;

    private Name(String name) {
        validate(name);

        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return ((Name) o).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    private void validate(String name) {
        if (Strings.isNullOrEmpty(name)) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }

        if (notMatch(name)) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }
    }

    private boolean notMatch(String name) {
        return !Pattern.matches(REGEX, name);
    }

}
