package dev.kkkkkksssssaaaa.spay.util;

import java.util.Optional;

public final class Strings {

    public static boolean isPresent(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        if (Optional.ofNullable(str).isEmpty()) {
            return true;
        }

        if (str.isEmpty()) {
            return true;
        }

        return false;
    }

}
