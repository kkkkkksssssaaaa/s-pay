package dev.kkkkkksssssaaaa.spay.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void 같은_필드_값을_가지면_동등성을_보장한다() {
        Name right = Name.of("이름");
        Name left = Name.of("이름");

        assertEquals(right, left);
    }

    @Test
    void 필드_값이_같아도_인스턴스가_다르다면_동등하지_않다() {
        Name right = Name.of("이름");
        String left = "이름";

        assertNotEquals(right, left);
    }

}