package dev.kkkkkksssssaaaa.spay.serviceuser;

import dev.kkkkkksssssaaaa.spay.wallet.Money;
import dev.kkkkkksssssaaaa.spay.wire.Wire;

public class ServiceUserWire {

    public void wire(ServiceUserWallet from, ServiceUserWallet to, Money money) {
        Wire wire = Wire.toServiceUser(from.my(), to.my(), money);

        if (history.addWire(wire)) {
            to.deposit(wire.money());
        }
    }
}
