package dev.kkkkkksssssaaaa.spay.wire;

import dev.kkkkkksssssaaaa.spay.serviceuser.ServiceUser;
import dev.kkkkkksssssaaaa.spay.user.User;
import dev.kkkkkksssssaaaa.spay.user.privacy.Privacy;
import dev.kkkkkksssssaaaa.spay.wallet.Money;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Wire")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WireTest {

    @Nested
    @DisplayName("toServiceUser")
    class ToServiceUserTest {

        @Test
        void 본인에게_송금할_수_없다() {
            assertThrows(IllegalArgumentException.class,
                    () -> user1().wire(user1(), Money.of(10000)));
        }

        @Test
        void 본인이_아닌_다른_서비스_유저에게_송금할_수_있다() {
            assertDoesNotThrow(() -> user1().wire(user2(), Money.of(5000)));
        }
    }

    @Nested
    @DisplayName("money")
    class MoneyTest {

        @Test
        void 송금이_완료되면_잔액을_조회할_수_있다() {
            assertDoesNotThrow(() -> user1().wire(user2(), Money.of(5000)));
        }
    }

    private ServiceUser user1() {
        User user = User.fromPrivacy(
                Privacy.of("왕해삼", "010-1234-5678"));

        return ServiceUser.of(user);
    }

    private ServiceUser user2() {
        User user = User.fromPrivacy(
                Privacy.of("왕멍게", "010-5678-1234"));

        return ServiceUser.of(user);
    }

}