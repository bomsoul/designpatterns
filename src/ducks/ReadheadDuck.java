package ducks;

import quack.Quackable;

public class ReadheadDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
