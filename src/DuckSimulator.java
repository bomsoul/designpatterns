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
        Quackable mallardDuck = new MallardDuck();
        Quackable redHeadDuck = new ReadheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("\n Duck Simulator -- with -- goose/pigeon Adapter");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
