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
    }
}