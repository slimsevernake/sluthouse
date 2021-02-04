package repo;

import entity.Slave;

import java.util.ArrayList;

public class SlaveRepo {
    private ArrayList<Slave> slaves;

    public SlaveRepo(ArrayList<Slave> slaves) {
        this.slaves = slaves;
    }

    public SlaveRepo() {
        Slave firstSlave = new Slave("black grandparent", "nosurname1", 100, 100.0);
        Slave firstChildSlave = new Slave("child c:", "nosurname2", 10, 1000.0 );
        Slave secondChildSlave = new Slave("white child 2 :c", "nosurname3", 2, 1.0 );

        this.slaves = new ArrayList<>();

        slaves.add(firstSlave);
        slaves.add(firstChildSlave);
        slaves.add(secondChildSlave);
    }

    public void add(Slave slave) {
        this.slaves.add(slave);
    }

    public ArrayList<Slave> getAll() {
        return slaves;
    }
}
