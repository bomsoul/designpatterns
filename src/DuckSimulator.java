import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.ReadheadDuck;
import ducks.RubberDuck;
import quack.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate(){
        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
        Quackable redHeadDuck = new QuackEcho(new QuackCounter(new ReadheadDuck()));
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
        System.out.println(QuackCounter.getNumberOfQuacks() + " quack were counts.");
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
