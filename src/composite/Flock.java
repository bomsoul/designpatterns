package composite;

import quack.Quackable;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();

    public void add(Quackable quacker){
        this.quackers.add(quacker);
    }
    @Override
    public void quack() {
        boolean isFirst = true;
        Iterator iterator = quackers.iterator();
        while ( iterator.hasNext()){
            Quackable quacker = (Quackable)iterator.next();
            if(isFirst){
                System.out.println("--Duck leader--");
                quacker.quack();
                quacker.quack();
                isFirst = false;
            }
            else
                System.out.println("-subodinate-");
                quacker.quack();
        }
    }
}
