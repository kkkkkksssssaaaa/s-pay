package dev.kkkkkksssssaaaa.spay.wallet;

/**
 * 돈을 나타내는 원자 클래스
 * */
class Money {

    private static final int ZERO = 0;
    private static final int FULL = 1000000000;

    private int money = 0;

    protected void increase(Money money) {
        checkFull(money);

        this.money += money.money;
    }

    protected void shrink(Money money) {
        checkZero(money);

        this.money -= money.money;
    }

    private void checkFull(Money money) {
        if (money.money > FULL) {
            throw new IllegalArgumentException(
                    String.format("최대 보유 가능 금액은 %d원 입니다.", FULL));
        }

        if ((this.money + money.money) > FULL) {
            throw new IllegalArgumentException(
                    String.format("최대 보유 가능 금액은 %d원 입니다.", FULL));
        }
    }

    private void checkZero(Money money) {
        if (this.money < money.money) {
            throw new IllegalArgumentException(
                    "소비하려는 금액이 현재 금액보다 더 클 수 없습니다.");
        }

        if (money.money < 0) {
            throw new IllegalArgumentException(
                    String.format("최소 보유 가능 금액은 %d원 입니다.",  ZERO));
        }
    }

}
