package dev.kkkkkksssssaaaa.spay.user.privacy;

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

    @Test
    void 필드_값으로_한글만_입력할_수_있다() {
        assertThrows(Exception.class, () -> Name.of("name"));
        assertThrows(Exception.class, () -> Name.of("123"));
        assertThrows(Exception.class, () -> Name.of("dlfma"));
        assertThrows(Exception.class, () -> Name.of("이human"));
        assertThrows(Exception.class, () -> Name.of("김이름1"));
        assertThrows(Exception.class, () -> Name.of("김이름 "));
        assertThrows(Exception.class, () -> Name.of(" "));
    }
}