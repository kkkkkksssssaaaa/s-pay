package dev.kkkkkksssssaaaa.spay.util;

import java.util.Optional;

public class NullCheck {

    private NullCheck(Object o) {
        Optional<Object> optionalObject = Optional.ofNullable(o);

        if (optionalObject.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void of(Object o) {
        new NullCheck(o);
    }
}
