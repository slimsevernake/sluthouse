package service;

import entity.Whore;
import repo.WhoreRepo;

import java.util.ArrayList;

public class WhoreService {

    private WhoreRepo whoreRepo;

    public WhoreService() {
        whoreRepo = new WhoreRepo();
    }

    public void addWhore(Whore whore) {
        whoreRepo.add(whore);
    }

    public Whore getWhoreByName(String name) {
        ArrayList<Whore> whoresFromRepo = whoreRepo.getAll();
        if (!whoresFromRepo.isEmpty()) {
            for (Whore currentWhore : whoresFromRepo) {
                if (name.equals(currentWhore.getName())) {
                    return currentWhore;
                }
            }
        }
        return null;
    }

    public boolean buyWhore(String name, double moneyThatClientHave) {
        Whore whoreThatICouldBuy = getWhoreByName(name);
        if (whoreThatICouldBuy != null) {
            if (whoreThatICouldBuy.getPrice() <= moneyThatClientHave) {
                whoreRepo.remove(whoreThatICouldBuy);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Whore> getAllWhores() {
        return whoreRepo.getAll();
    }
}


