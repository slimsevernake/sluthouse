package repo;

import entity.Whore;

import java.util.ArrayList;

//TODO!!! Singleton instance
public class WhoreRepo {

    private ArrayList<Whore> whores;

    public WhoreRepo() {
        this.whores = new ArrayList<>();
    }

    public WhoreRepo(ArrayList<Whore> whoresFromRussia) {
        this.whores = whoresFromRussia;
    }


    public void add(Whore whore) {
        whores.add(whore);
    }

    public ArrayList<Whore> getAll() {
        return whores;
    }
}
