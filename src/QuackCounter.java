import quack.Quackable;

public class QuackCounter implements Quackable {
    private Quackable duck;
    static int numberOfQuacks;
    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }
}
