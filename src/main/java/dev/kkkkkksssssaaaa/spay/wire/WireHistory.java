package dev.kkkkkksssssaaaa.spay.wire;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 서비스 이용 내역 중 송금 내역에 대한 내역을 저장하는 일급 컬렉션 객체
 * */
public class WireHistory {

    private final Set<Wire> history = new LinkedHashSet<>();

    public boolean add(Wire wire) {
        return this.history.add(wire);
    }

    public Set<Wire> list() {
        return this.history;
    }
}