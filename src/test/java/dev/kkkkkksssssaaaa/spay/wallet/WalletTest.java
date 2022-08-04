package dev.kkkkkksssssaaaa.spay.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void 출금할_때마다_잔고가_줄어든다() {
        Wallet wallet = newWallet();

        wallet.withdraw(Money.of(1000));
        wallet.withdraw(Money.of(2000));
        wallet.withdraw(Money.of(3000));

        assertEquals(wallet.checkBalance(), Money.of(44000));
    }

    @Test
    void 입금할_때마다_잔고가_늘어난다() {
        Wallet wallet = newWallet();

        wallet.deposit(Money.of(1000));
        wallet.deposit(Money.of(2000));
        wallet.deposit(Money.of(3000));

        assertEquals(wallet.checkBalance(), Money.of(56000));
    }

    private Wallet newWallet() {
        Wallet wallet = Wallet.openUp();

        wallet.deposit(
                Money.of(50000));

        return wallet;
    }

}