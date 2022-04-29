package dev.kkkkkksssssaaaa.spay.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    @Test
    void 비어있거나_Null인_문자열에_대해_isNullOrEmpty가_참을_반환한다() {
        String emptyString = "";
        String nullString = null;

        assertTrue(Strings.isNullOrEmpty(""));
        assertTrue(Strings.isNullOrEmpty(null));
        assertTrue(Strings.isNullOrEmpty(emptyString));
        assertTrue(Strings.isNullOrEmpty(nullString));
    }

    @Test
    void 비어있지_않은_문자열에_대해_isNullOrEmpty가_거짓을_반환한다() {
        String notEmptyString = " ";

        assertFalse(Strings.isNullOrEmpty(" "));
        assertFalse(Strings.isNullOrEmpty(notEmptyString));
        assertFalse(Strings.isNullOrEmpty("테스트임다"));
    }

    @Test
    void 비어있거나_Null인_문자열에_대해_isPresent가_거짓을_반환한다() {
        String emptyString = "";
        String nullString = null;

        assertFalse(Strings.isPresent(""));
        assertFalse(Strings.isPresent(null));
        assertFalse(Strings.isPresent(emptyString));
        assertFalse(Strings.isPresent(nullString));
    }

    @Test
    void 비어있지_않은_문자열에_대해_isPresent가_참을_반환한다() {
        String notEmptyString = " ";

        assertTrue(Strings.isPresent(" "));
        assertTrue(Strings.isPresent(notEmptyString));
        assertTrue(Strings.isPresent("테스트임다"));
    }

}