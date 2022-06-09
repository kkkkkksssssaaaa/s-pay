package dev.kkkkkksssssaaaa.spay.serviceuser;

import dev.kkkkkksssssaaaa.spay.user.User;
import dev.kkkkkksssssaaaa.spay.wallet.Money;
import dev.kkkkkksssssaaaa.spay.wallet.Wallet;
import dev.kkkkkksssssaaaa.spay.wire.Wire;

/**
 * 서비스를 사용하는 실제 사용자(고객) 모델
 * */
public class ServiceUser {

    private final User user;
    private final Wallet wallet;

    private ServiceUser(User user) {
        this.user = user;
        this.wallet = Wallet.newWallet();
    }

    public static ServiceUser of(User user) {
        return new ServiceUser(user);
    }

    public void withdraw(Money money) {
        this.wallet.withdraw(money);
    }

    // TODO 별도의 송금 오브젝트를 생성하여 변경
    public void wire(ServiceUser to, Money money) {
        Wire wire = Wire.toServiceUser(this, to, money);

        to.deposit(money);
    }

    private void deposit(Money money) {
        this.wallet.deposit(money);
    }

    @Override
    public boolean equals(Object o) {
        if (!this.getClass().equals(o.getClass())) {
            return false;
        }

        return ((ServiceUser) o).user.equals(this.user);
    }

    @Override
    public int hashCode() {
        return this.user.hashCode();
    }

}
