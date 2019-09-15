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
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\n Duck Simulator -- with -- goose Adapter");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
