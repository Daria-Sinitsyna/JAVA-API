package finaltask;

import seminar6.Phonebook;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Phonebook myPhoneBook = new Phonebook();

        boolean runApp = true;

        while (runApp){
            System.out.println("---Телефонная книга---\n\nВыберите пункт меню\n");
            System.out.println("Ввод 1: добавление записи");
            System.out.println("Ввод 2: удаление записи");
            System.out.println("Ввод 3: редактирование записи");
            System.out.println("Ввод 4: поиск записи");
            System.out.println("Ввод 5: печать телефонной книги");
            System.out.println("Ввод 6: выход из приложения\n");

            Scanner button = new Scanner(System.in);
            int choice = button.nextInt();


            switch (choice){
                case 1:
                    System.out.println("---ДОБАВЛЕНИЕ ЗАПИСИ---");

                    Scanner inputName = new Scanner(System.in);
                    Scanner inputNumber = new Scanner(System.in);

                    System.out.println("Введите имя пользователя: ");
                    String name = inputName.nextLine();

                    System.out.println("Введите номер телефона пользователя: ");
                    int number = inputNumber.nextInt();

                    myPhoneBook.addInfo(name, number);

                    System.out.println("---ЗАПИСЬ ДОБАВЛЕНА---\n");
                    break;

                case 2:
                    System.out.println("---УДAЛЕНИЕ ЗАПИСИ---");

                    Scanner input1 = new Scanner(System.in);
                    System.out.println("Введите имя пользователя: ");
                    String name1 = input1.nextLine();
                    myPhoneBook.deleteInfo(name1);

                    System.out.println("---ЗАПИСЬ УДАЛЕНА---\n");
                    break;

                case 3:
                    System.out.println("---РЕДАКТИРОВАНИЕ ЗАПИСИ---");

                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Введите имя пользователя: ");
                    String name2 = input2.nextLine();
                    myPhoneBook.editInfo(name2);

                    System.out.println("---ЗАПИСЬ ОТРЕДАКТИРОВАНА---\n");
                    break;
                case 4:
                    System.out.println("---ПОИСК ЗАПИСИ---");

                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Введите имя пользователя для поиска: ");
                    String name3 = input3.nextLine();
                    System.out.println(myPhoneBook.findInfo(name3));

                    System.out.println();
                    break;
                case 5:
                    System.out.println("---ПЕЧАТЬ ТЕЛЕФОНОЙ КИНИГИ---");
                    System.out.println(myPhoneBook.printPhoneBook());
                    System.out.println();
                    break;
                case 6:
                    runApp = false;
                    System.out.println("Работа приложения окончена.\n");
                    break;
                default:
                    System.out.println("Некорректный ввод! Попробуйте снова.\n");
            }
        }

    }
}
