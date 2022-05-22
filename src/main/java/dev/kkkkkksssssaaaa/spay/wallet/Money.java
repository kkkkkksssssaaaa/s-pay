package dev.kkkkkksssssaaaa.spay.wallet;

/**
 * 돈을 나타내는 원자 클래스
 * */
class Money {

    private int money;

    private Money(int money) {
        this.money = money;
    }

    protected static Money of(int money) {
        return new Money(money);
    }

    protected void increase(Money money) {
        this.money += money.money;
    }

    protected void shrink(Money money) {
        this.money -= money.money;
    }

}
