package dev.kkkkkksssssaaaa.spay.atomical;

import dev.kkkkkksssssaaaa.spay.util.Strings;

import java.util.regex.Pattern;

public abstract class AbstractName {

    private final String name;

    protected AbstractName(String name, String regex,
                           int minLength, int maxLength) {
        checkRegex(name, regex);
        checkLength(name, minLength, maxLength);

        this.name = name;
    }

    @Override
    public final boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return ((AbstractName) o).name.equals(this.name);
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode();
    }

    public String primitiveName() {
        return this.name;
    }

    private void checkRegex(String name, String regex) {
        if (Strings.isBlank(name)) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }

        if (notMatch(name, regex)) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }
    }

    private boolean notMatch(String name, String regex) {
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
