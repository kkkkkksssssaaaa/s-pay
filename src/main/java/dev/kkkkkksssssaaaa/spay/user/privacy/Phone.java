package dev.kkkkkksssssaaaa.spay.user.privacy;

import dev.kkkkkksssssaaaa.spay.util.Strings;

import java.util.regex.Pattern;

class Phone {

    private static final int LENGTH = 13;
    private static final String REGEX = "^(010)-([\\d]{4})-([\\d]{4})$";

    private final String phone;

    private Phone(String phone) {
        validate(phone);

        this.phone = phone;
    }

    protected static Phone of(String phone) {
        return new Phone(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return ((Phone) o).phone.equals(this.phone);
    }

    @Override
    public int hashCode() {
        return this.phone.hashCode();
    }

    private void validate(String phone) {
        if (Strings.isEmpty((phone))) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }

        if (notMatch(phone)) {
            // TODO 커스텀 예외 정의
            throw new IllegalArgumentException();
        }
    }

    private boolean notMatch(String name) {
        return !Pattern.matches(REGEX, name);
    }
}
