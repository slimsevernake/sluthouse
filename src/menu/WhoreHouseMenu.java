package menu;

import entity.Whore;
import service.WhoreService;

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
        System.out.println("4) Самовыпил");
        int choice = in.nextInt();

        if (choice == 1) {
            Whore whoreFromConsole = getWhoreFromConsole();
            service.addWhore(whoreFromConsole);
        } else if (choice == 2) {
            String nameFromConsole = getWhoresNameFromConsole();
            service.getWhoreByName(nameFromConsole);
        } else if (choice == 3) {
            service.printAllWhoresNames();
        } else if (choice == 4){
            return;
        }
        printServiceMenu();
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
