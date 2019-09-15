package abstractfactory;

import adapter.Goose;
import adapter.GooseAdapter;
import adapter.Pigeon;
import adapter.PigeonAdapter;
import decorator.QuackCounter;
import quack.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
//        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckCountFactory = new CountingDuckFactory();
//        AbstractDuckFactory duckEchoFactory = new EchoDuckFactory();
        simulator.simulate(duckCountFactory);
    }

    void simulate(AbstractDuckFactory duckFactory){
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());
        System.out.println("The ducks quacked "+ QuackCounter.getNumberOfQuacks() + " times");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
        System.out.println(QuackCounter.getNumberOfQuacks() + " quack were counts.");
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
