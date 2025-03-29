package dev.kkkkkksssssaaaa.spay.serviceuser;

import dev.kkkkkksssssaaaa.spay.user.User;

/**
 * 서비스를 사용하는 실제 사용자(고객) 모델
 * */
public class ServiceUser {

    private final User user;
    private final ServiceHistory history;

    private ServiceUser(User user) {
        this.user = user;
        this.history = ServiceHistory.of();
    }

    public static ServiceUser of(User user) {
        return new ServiceUser(user);
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
