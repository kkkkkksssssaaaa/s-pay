package dev.kkkkkksssssaaaa.spay.serviceuser;

import dev.kkkkkksssssaaaa.spay.wire.Wire;
import dev.kkkkkksssssaaaa.spay.wire.WireHistory;

/**
 * 서비스 이용자의 이용 내역을 저장
 * */
public class ServiceHistory {

    private final ServiceUser user;
    private final WireHistory wireHistory = new WireHistory();

    private ServiceHistory(ServiceUser user) {
        this.user = user;
    }

    public static ServiceHistory of(ServiceUser user) {
        return new ServiceHistory(user);
    }

    public boolean addWire(Wire wire) {
        return this.wireHistory.add(wire);
    }

    public WireHistory wires() {
        return this.wireHistory;
    }
}
