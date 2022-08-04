package dev.kkkkkksssssaaaa.spay.wallet;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WalletName")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WalletNameTest {

    @Nested
    @DisplayName("Initialize")
    class InitializeTest {

        @Test
        void 지갑_이름_객체를_생성할_수_있다() {
            assertDoesNotThrow(() -> WalletName.of("김지갑"));
            assertDoesNotThrow(() -> WalletName.of("김 지갑"));
            assertDoesNotThrow(() -> WalletName.of("wallet kim"));
        }

        @Test
        void 지갑_이름이_공백_한_글자여도_IllegalArgumentException을_던진다() {
            assertThrows(IllegalArgumentException.class, () -> WalletName.of(" "));
        }
    }

    @Nested
    @DisplayName("LengthTest")
    class LengthTest {

        @Test
        void 지갑_이름이_한_글자_미만이면_IllegalArgumentException을_던진다() {
            assertThrows(IllegalArgumentException.class, () -> WalletName.of(""));
            assertThrows(IllegalArgumentException.class, () -> WalletName.of(null));
        }

        @Test
        void 지갑_이름이_열_글자를_넘으면_IllegalArgumentException을_던진다() {
            assertThrows(IllegalArgumentException.class, () -> WalletName.of("01234567891"));
        }

        @Test
        void 지갑_이름이_한_글자_이상이면_예외를_반환하지_않는다() {
            assertDoesNotThrow(() -> WalletName.of("0"));
            assertDoesNotThrow(() -> WalletName.of("01"));
            assertDoesNotThrow(() -> WalletName.of("012"));
            assertDoesNotThrow(() -> WalletName.of("0123"));
            assertDoesNotThrow(() -> WalletName.of("01234"));
            assertDoesNotThrow(() -> WalletName.of("012345"));
            assertDoesNotThrow(() -> WalletName.of("0123456"));
            assertDoesNotThrow(() -> WalletName.of("01234567"));
            assertDoesNotThrow(() -> WalletName.of("012345678"));
            assertDoesNotThrow(() -> WalletName.of("0123456789"));
        }
    }
}