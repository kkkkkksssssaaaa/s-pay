package dev.kkkkkksssssaaaa.spay.wire;

import dev.kkkkkksssssaaaa.spay.serviceuser.ServiceUser;
import dev.kkkkkksssssaaaa.spay.util.Dates;
import dev.kkkkkksssssaaaa.spay.wallet.Money;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * 송금에 대한 최소 단위 모델
 *
 * TODO 서비스 사용자가 아닌 일반 사용자도 송금 대상에 포함되어야함
 * */
public final class Wire {

    private final UUID uuid = UUID.randomUUID();
    private final ZonedDateTime wiredAt;
    private final ServiceUser from;
    private final ServiceUser to;
    private final Money money;

    private Wire(ServiceUser from,
                 ServiceUser to,
                 Money money) {
        validateFromTo(from, to);

        this.wiredAt = Dates.now();
        this.from = from;
        this.to = to;
        this.money = money;
    }

    public static Wire toServiceUser(ServiceUser from,
                                     ServiceUser to,
                                     Money money) {
        return new Wire(from, to, money);
    }

    public Money money() {
        return this.money;
    }

    private void validateFromTo(ServiceUser from,
                                ServiceUser to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!this.getClass().equals(o.getClass())) {
            return false;
        }

        return ((Wire) o).uuid.equals(this.uuid);
    }

    @Override
    public int hashCode() {
        return this.uuid.hashCode();
    }

}
