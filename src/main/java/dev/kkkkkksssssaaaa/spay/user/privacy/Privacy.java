package dev.kkkkkksssssaaaa.spay.user.privacy;

import java.util.Objects;

/**
 * 사용자의 개인 정보에 대한 공개 클래스
 * 해당 클래스의 필드로 사용자의 실제 정보에 대한 private 항목을 가지고 있으며
 * 위 항목들은 해당 클래스를 통해 외부에서 접근할 수 있음
 * */
public class Privacy {

    private final Name name;
    private final Phone phone;

    private Privacy(Name name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public static Privacy of(String name,
                             String phone) {
        return new Privacy(
                Name.of(name),
                Phone.of(phone));
    }

    public Name name() {
        return this.name;
    }

    public Phone phone() {
        return this.phone;
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return ((Privacy) o).name().equals(this.name())
                && ((Privacy) o).phone().equals(this.phone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name(), phone());
    }
}