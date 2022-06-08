package dev.kkkkkksssssaaaa.spay.wallet;

/**
 * 사용자의 지갑 클래스
 *
 * 새 지갑을 발행받을 때 초기 잔액은 0원으로 설정됨
 * */
public class Wallet {

    private final Money balance;

    private Wallet() {
        this.balance = Money.initZero();
    }

    public static Wallet newWallet() {
        return new Wallet();
    }

    public Money getBalance() {
        return this.balance;
    }

    public void deposit(int money) {
        this.getBalance().increase(money);
    }

    public void withdraw(int money) {
        this.getBalance().shrink(money);
    }

    public Money checkBalance() {
        return this.balance;
    }

}
