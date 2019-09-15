package abstractfactory;

import decorator.QuackCounter;
import decorator.QuackEcho;
import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedHeadDuck;
import quack.Quackable;

public class EchoDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackEcho(new QuackCounter(new MallardDuck()));
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackEcho(new QuackCounter(new RedHeadDuck()));
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackEcho(new QuackCounter(new DuckCall()));
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackEcho(new QuackCounter(new RedHeadDuck()));
    }
}
