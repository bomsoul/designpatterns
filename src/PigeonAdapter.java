import quack.Quackable;

public class PigeonAdapter implements Quackable {
    private Pigeon pigeon;

    public PigeonAdapter(Pigeon pegion) {
        this.pigeon = pegion;
    }

    @Override
    public void quack() {
        pigeon.coo();
    }
}
