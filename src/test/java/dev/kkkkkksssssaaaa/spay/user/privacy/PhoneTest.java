package dev.kkkkkksssssaaaa.spay.user.privacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void 필드_값은_하이픈이_포함된_010으로_시작되는_전화번호_형식만_허용된다() {
        assertThrows(IllegalArgumentException.class, () -> Phone.of("01012341234"));
        assertThrows(IllegalArgumentException.class, () -> Phone.of("010-1234-234"));
        assertThrows(IllegalArgumentException.class, () -> Phone.of(""));
        assertThrows(IllegalArgumentException.class, () -> Phone.of("010-123-1234"));
        assertThrows(IllegalArgumentException.class, () -> Phone.of("011-1234-1234"));
        assertThrows(IllegalArgumentException.class, () -> Phone.of("02-1234-1234"));
    }


    @Test
    void 같은_필드_값을_가지면_동등성을_보장한다() {
        Phone right = Phone.of("010-1234-1234");
        Phone left = Phone.of("010-1234-1234");

        assertEquals(right, left);
    }

    @Test
    void 필드_값이_같아도_인스턴스가_다르다면_동등하지_않다() {
        Phone right = Phone.of("010-1234-1234");
        String left = "010-1234-1234";

        assertNotEquals(right, left);
    }

}