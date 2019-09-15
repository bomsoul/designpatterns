import abstractfactory.AbstractDuckFactory;
import abstractfactory.EchoDuckFactory;
import adapter.Goose;
import adapter.GooseAdapter;
import adapter.Pigeon;
import adapter.PigeonAdapter;
import decorator.QuackCounter;
import decorator.QuackEcho;
import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedHeadDuck;
import ducks.RubberDuck;
import quack.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
//        abstractfactory.AbstractDuckFactory duckFactory = new abstractfactory.DuckFactory();
//        abstractfactory.AbstractDuckFactory duckCountFactory = new abstractfactory.CountingDuckFactory();
        AbstractDuckFactory duckEchoFactory = new EchoDuckFactory();
//        simulator.simulate();
        simulator.simulate(duckEchoFactory);
    }


    void simulate(){
        /*Adapter
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedHeadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());
        System.out.println("\n Gosse and Pigeon with adapter");
        */
         //Decorator
        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
        Quackable redHeadDuck = new QuackEcho(new QuackCounter(new RedHeadDuck()));
        Quackable duckCall = new QuackEcho(new QuackCounter(new DuckCall()));
        Quackable rubberDuck = new QuackEcho(new QuackCounter(new RubberDuck()));
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());
        System.out.println("\n Duck Simulator with decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);

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
