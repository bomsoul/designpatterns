package abstractfactory;

import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedHeadDuck;
import quack.Quackable;

public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RedHeadDuck();
    }
}
