package menu;

import entity.Whore;
import service.WhoreService;

import java.util.ArrayList;
import java.util.Scanner;

public class WhoreHouseMenu {

    private Scanner in;
    private WhoreService service;

    public WhoreHouseMenu() {
        in = new Scanner(System.in);
        service = new WhoreService();
        printMenu();
    }

    private void printMenu() {
        System.out.println("Привет! Ты попал на улицу красных фонарей :)");
        System.out.println("Наши услуги: ");
        printServiceMenu();
    }

    private void printServiceMenu() {
        System.out.println("1) Добавить шлюху");
        System.out.println("2) Найти шлюху по имени");
        System.out.println("3) Вывести имена всех шлюх");
        System.out.println("4) Выкупить проститутку :(");
        System.out.println("0) Самовыпил");
        int choice = in.nextInt();

        if (choice == 1) {
            Whore whoreFromConsole = getWhoreFromConsole();
            service.addWhore(whoreFromConsole);
        } else if (choice == 2) {
            String nameFromConsole = getWhoresNameFromConsole();
            Whore whoreFromDB = service.getWhoreByName(nameFromConsole);
            System.out.println(whoreFromDB);
        } else if (choice == 3) {
            printAllWhoresNames(service.getAllWhores());
        } else if (choice == 4) {
            String nameFromConsole = getWhoresNameFromConsole();
            double price = getPriceFromConsole();
            if (service.buyWhore(nameFromConsole, price)) {
                System.out.println("Ура вы купили малышку");
            } else {
                System.out.println("брат тебе не хватит..");
            }
        } else if (choice == 0){
            return;
        }
        printServiceMenu();
    }

    private double getPriceFromConsole() {
        System.out.println("Введите ваше количество денег: ");
        return in.nextDouble();
    }

    private void printAllWhoresNames(ArrayList<Whore> allWhores) {
        for (Whore whore : allWhores) {
            System.out.println(whore.getName());
        }
    }

    private String getWhoresNameFromConsole() {
        System.out.println("Введите имя шлюхи, которую хотите найти:");
        return in.next();
    }

    private Whore getWhoreFromConsole() {
        Whore whore = new Whore();
        System.out.println("Введите имя:");
        whore.setName(in.next());
        System.out.println("Введите фамилия:");
        whore.setSurname(in.next());
        System.out.println("Введите возраст:");
        whore.setAge(in.nextInt());
        System.out.println("Цена:");
        whore.setPrice(in.nextDouble());
        return whore;
    }
}
