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

    public void getWhoreByName(String name) {
        ArrayList<Whore> whoresFromRepo = whoreRepo.getAll();
        if (!whoresFromRepo.isEmpty()) {
            for (Whore currentWhore : whoresFromRepo) {
                if (name.equals(currentWhore.getName())) {
                    System.out.println(
                            "Проститутка " + currentWhore.getName() + " ждет вас :)");
                }
            }
            return;
        }
        System.out.println("Шлюх нет :(");
    }

    public void printAllWhoresNames() {
        ArrayList<Whore> whoresFromRepo = whoreRepo.getAll();
        for (Whore currentWhore : whoresFromRepo) {
            System.out.println(currentWhore.getName() + " ");
        }
    }
}


