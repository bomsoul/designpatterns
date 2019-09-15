package decorator;

import adapter.Goose;
import adapter.GooseAdapter;
import adapter.Pigeon;
import adapter.PigeonAdapter;
import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedHeadDuck;
import ducks.RubberDuck;
import quack.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }
    void simulate(){
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

    void simulate(Quackable duck){
        duck.quack();
    }
}
