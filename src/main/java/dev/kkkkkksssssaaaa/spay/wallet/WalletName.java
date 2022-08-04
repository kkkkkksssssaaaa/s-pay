package dev.kkkkkksssssaaaa.spay.wallet;

import dev.kkkkkksssssaaaa.spay.atomical.AbstractName;

public final class WalletName extends AbstractName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10;
    private static final String REGEX = ".*";

    private WalletName(String name) {
        super(name, REGEX, MIN_LENGTH, MAX_LENGTH);
    }

    static WalletName of(String name) {
        return new WalletName(name);
    }
}
