package dev.kkkkkksssssaaaa.spay.wire;

import dev.kkkkkksssssaaaa.spay.serviceuser.ServiceUser;
import dev.kkkkkksssssaaaa.spay.util.Dates;
import dev.kkkkkksssssaaaa.spay.wallet.Money;

import java.time.ZonedDateTime;

/**
 * 송금에 대한 최소 단위 모델
 *
 * TODO 서비스 사용자가 아닌 일반 사용자도 송금 대상에 포함되어야함
 * */
public final class Wire {

    private final ZonedDateTime wiredAt;
    private final ServiceUser from;
    private final ServiceUser to;
    private final Money money;

    private Wire(ServiceUser from,
                 ServiceUser to,
                 Money money) {
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

}
