package dev.kkkkkksssssaaaa.spay.serviceuser;

import dev.kkkkkksssssaaaa.spay.util.NullCheck;
import dev.kkkkkksssssaaaa.spay.wallet.Money;
import dev.kkkkkksssssaaaa.spay.wallet.Wallet;
import dev.kkkkkksssssaaaa.spay.wallet.WalletName;

import java.util.Objects;

/**
 * 서비스 사용자의 지갑 클래스
 * 서비스 사용자는 지갑에 별칭을 붙일 수 있음
 * */
public class ServiceUserWallet {

    private final ServiceUser user;
    private final Wallet wallet;
    private final WalletName name;

    private ServiceUserWallet(ServiceUser user, WalletName name) {
        this.user = user;
        this.wallet = Wallet.openUp();
        this.name = name;
    }

    public static ServiceUserWallet addNew(ServiceUser user, WalletName name) {
        return new ServiceUserWallet(user, name);
    }

    public ServiceUser my() {
        return this.user;
    }

    public void deposit(Money money) {
        this.wallet.deposit(money);
    }

    public void withdraw(Money money) {
        this.wallet.withdraw(money);
    }

    @Override
    public boolean equals(Object o) {
        NullCheck.of(o);

        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return this.user.hashCode() == ((ServiceUserWallet) o).user.hashCode()
                && this.name.hashCode() == ((ServiceUserWallet) o).name.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.user, this.name);
    }
}
