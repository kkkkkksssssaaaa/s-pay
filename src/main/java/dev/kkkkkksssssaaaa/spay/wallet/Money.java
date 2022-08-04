package dev.kkkkkksssssaaaa.spay.wallet;

/**
 * 돈을 나타내는 원자 클래스
 * */
public final class Money {

    private static final int ZERO = 0;
    private static final int FULL = 1000000000;

    private int money;

    private Money(int money) {
        if (ZERO > money
                || FULL < money) {
            throw new IllegalArgumentException(
                    String.format("최소 %d원, 최대 %d원의 금액만 입력할 수 있습니다.", ZERO, FULL));
        }

        this.money = money;
    }

    public static Money initZero() {
        return new Money(ZERO);
    }

    public static Money of(int money) {
        return new Money(money);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass().equals(Integer.class)) {
            return ((Integer) o).equals(this.money);
        }

        if (!(o.getClass()).equals(this.getClass())) {
            return false;
        }

        return ((Money) o).money == this.money;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.money);
    }

    protected void increase(Money money) {
        checkFull(money.money);

        this.money += money.money;
    }

    protected void shrink(Money money) {
        checkZero(money.money);

        this.money -= money.money;
    }

    private void checkFull(int money) {
        if (money > FULL) {
            throw new IllegalArgumentException(
                    String.format("최대 보유 가능 금액은 %d원 입니다.", FULL));
        }

        if ((this.money + money) > FULL) {
            throw new IllegalArgumentException(
                    String.format("최대 보유 가능 금액은 %d원 입니다.", FULL));
        }
    }

    private void checkZero(int money) {
        if (this.money < money) {
            throw new IllegalArgumentException(
                    "소비하려는 금액이 현재 금액보다 더 클 수 없습니다.");
        }

        if (money < 0) {
            throw new IllegalArgumentException(
                    String.format("최소 보유 가능 금액은 %d원 입니다.",  ZERO));
        }
    }
}