package composite;

import abstractfactory.AbstractDuckFactory;
import adapter.Goose;
import adapter.GooseAdapter;
import adapter.Pigeon;
import adapter.PigeonAdapter;
import decorator.QuackCounter;
import quack.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckCountFactory = new abstractfactory.CountingDuckFactory();
        simulator.simulate(duckCountFactory);
    }


    void simulate(AbstractDuckFactory duckFactory){
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());
        System.out.println("\nDuck Simulator: With Composite - Flocks");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(pigeon);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);
        System.out.println("\nDuck Simulator: Whole composite.Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard composite.Flock Simulation");
        simulate(flockOfMallards);

        System.out.println("\nThe ducks quacked " +
                QuackCounter.getNumberOfQuacks() + " times");

    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
