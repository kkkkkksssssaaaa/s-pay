package dev.kkkkkksssssaaaa.spay.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void Integer와_동등성을_비교할_수_있다() {
        assertEquals(Money.of(1), 1);
    }

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

    @Test
    void 돈이_증가될_때_기존_금액과_합산된_금액이_10억을_넘을_수_없다() {
        Money left = Money.of(1);

        assertThrows(IllegalArgumentException.class,
                () -> left.increase(1000000000));
    }

    @Test
    void 돈이_감소할_때_기존_금액에서_차감된_금액이_0원_미만일_수_없다() {
        Money left = Money.of(1);

        assertThrows(IllegalArgumentException.class,
                () -> left.shrink(2));
    }

    @Test
    void 돈이_감소할_때_기존_금액보다_큰_금액을_차감시킬_수_없다() {
        Money left = Money.of(5000);

        assertThrows(IllegalArgumentException.class,
                () -> left.shrink(5001));
    }

    @Test
    void 돈이_증가될_때_기존_금액과_합산된_금액이_10억_이하면_유효하다() {
        Money left = Money.of(0);

        assertDoesNotThrow(() -> left.increase(0));
        assertDoesNotThrow(() -> left.increase(50000));
        assertDoesNotThrow(() -> left.increase(499950000));
        assertDoesNotThrow(() -> left.increase(500000000));
    }

    @Test
    void 돈이_감소할_때_감소된_금액이_0원보다_많으면_유효하다() {
        Money left = Money.of(1000000000);

        assertDoesNotThrow(() -> left.shrink(0));
        assertDoesNotThrow(() -> left.shrink(50000));
        assertDoesNotThrow(() -> left.shrink(499950000));
        assertDoesNotThrow(() -> left.shrink(500000000));
    }

}