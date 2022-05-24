package dev.kkkkkksssssaaaa.spay.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void 최대_보유_가능_금액은_10억을_초과할_수_없다() {
        assertThrows(IllegalArgumentException.class,
                () -> Money.of(1000000001));
    }

    @Test
    void 최소_보유_가능_금액은_0원_이하일_수_없다() {
        assertThrows(IllegalArgumentException.class,
                () -> Money.of(-1));
    }

    @Test
    void 보유_금액이_0원_이상_10억_이하일_수_있다() {
        assertDoesNotThrow(() -> Money.of(0));
        assertDoesNotThrow(() -> Money.of(1));
        assertDoesNotThrow(() -> Money.of(1000000000));
        assertDoesNotThrow(() -> Money.of(999999999));
    }

}