package service;

import entity.Slave;
import entity.Whore;
import repo.SlaveRepo;
import repo.WhoreRepo;

import java.util.ArrayList;

public class SlaveService {

    private WhoreRepo whoreRepo;
    private SlaveRepo slaveRepo;

    public SlaveService() {
        whoreRepo = new WhoreRepo();
        slaveRepo = new SlaveRepo();
    }

    public void addWhore(Whore whore) {
        whoreRepo.add(whore);
    }

    public void addSlave(Slave slave) {
        slaveRepo.add(slave);
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

    public ArrayList<Slave> getSortedSlavesByStrange() {
        ArrayList<Slave> sortedSlaves = slaveRepo.getAll();
        for (int i = 0; i < sortedSlaves.size() - 1; i++) {
            for (int j = sortedSlaves.size() - 1; j > i; j--) {
                if (sortedSlaves.get(j - 1).getStrange() > sortedSlaves.get(j).getStrange()) {
                    Slave tempSlave = sortedSlaves.get(j - 1);
                    sortedSlaves.set(j - 1, sortedSlaves.get(j));
                    sortedSlaves.set(j, tempSlave);
                }
            }
        }
        return sortedSlaves;
    }
}


