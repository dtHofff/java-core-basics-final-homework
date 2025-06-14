package school.sorokin.javacore.basics;

import java.util.Scanner;

public class Contacts {

    private String[] phoneNumbers = new String[5];

    private String[] names = new String[5];

    private int countOfContacts = 0;

    Scanner scanner = new Scanner(System.in);


    public void makeContact() {
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                System.out.print("Введите имя: ");
                names[i] = scanner.next();

                System.out.print("Введите номер: ");
                phoneNumbers[i] = scanner.next();

                countOfContacts++;
                return;
            }
        }
        System.out.println("Нет свободного места!");
    }


    public void listContacts() {
        for (int i = 0; i < countOfContacts; i++) {
            System.out.printf("%d. %s - %s%n", i + 1, names[i], phoneNumbers[i]);
        }
    }


    public void findContact() {
        System.out.print("Поиск по имени: ");
        String searchedName = scanner.next();

        for (int i = 0; i < countOfContacts; i++) {
            if (names[i].equalsIgnoreCase(searchedName)) {
                System.out.printf("Телефон %s: %s", names[i], phoneNumbers[i]);
                return;
            }
        }
        System.out.println("Контакт не найден!");
    }


    public void removeContact() {
        System.out.println("Удалить контакт: ");
        String searchedName = scanner.next();

        for (int i = 0; i < countOfContacts; i++) {
            if (names[i].equalsIgnoreCase(searchedName)) {
                for (;i < countOfContacts - 1; i++) {
                    names[i] = names[i + 1];
                    phoneNumbers[i] = phoneNumbers[i + 1];
                }
                countOfContacts--;
                names[countOfContacts] = null;
                System.out.println("Контакт удален!");
                return;
            }
        }
        System.out.println("Контакт не найден!");
    }


    public void showMenu(){

        System.out.println("""
                
                *****
                1. Добавить контакт
                2. Просмотреть контакты
                3. Найти контакт
                4. Удалить контакт
                5. Выйти
                *****
                """);

        switch (scanner.next()) {
            case "1": makeContact();
                break;
            case "2": listContacts();
                break;
            case "3": findContact();
                break;
            case "4": removeContact();
                break;
            case "5": System.exit(0);
            default:
                System.out.println("Некорректный ввод!");

        }
    }


}


