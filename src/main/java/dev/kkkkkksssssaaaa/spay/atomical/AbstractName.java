package dev.kkkkkksssssaaaa.spay.atomical;

import dev.kkkkkksssssaaaa.spay.util.Strings;

import java.util.regex.Pattern;

public abstract class AbstractName {

    private final int minLength;
    private final int maxLength;
    private final String regex;

    private final String name;

    protected AbstractName(String name, String regex,
                           int minLength, int maxLength) {
        validate(name);

        this.name = name;
        this.regex = regex;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return ((AbstractName) o).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public String primitiveName() {
        return this.name;
    }

    private void validate(String name) {
        if (Strings.isEmpty(name)) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }

        if (notMatch(name)) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }
    }

    private boolean notMatch(String name) {
        return !Pattern.matches(regex, name);
    }

    private void checkLength(String name, int minLength, int maxLength) {
        if (name.length() < minLength) {
            throw new IllegalArgumentException();
        }

        if (name.length() > maxLength) {
            throw new IllegalArgumentException();
        }
    }
}
