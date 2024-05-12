package finaltask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Phonebook implements Comparable<Phonebook>{

    private String nameSurname;
    private int phoneNumber;
    private HashMap<String, ArrayList<Integer>> phoneBook= new HashMap<>();

    public Phonebook(){

    }

    public Phonebook(String nameSurname, int phoneNumber) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(HashMap<String, ArrayList<Integer>> phoneBook) {
        this.phoneBook = phoneBook;
    }


    //-------------------------------------------------------------------------------------//

    public void addInfo(String name, Integer phoneNumber){

        if(phoneBook.containsKey(name)){
            ArrayList<Integer> clientsNumbers = phoneBook.get(name); //.add(phoneNumber) без put
            clientsNumbers.add(phoneNumber);
            phoneBook.put(name, clientsNumbers);
        }else{
            ArrayList<Integer> clientsNumbers = new ArrayList<>();
            clientsNumbers.add(phoneNumber);
            phoneBook.put(name, clientsNumbers);
        }

    }

    public void deleteInfo(String name){

       if(phoneBook.containsKey(name)){
            phoneBook.remove(name);
        }else{
            System.out.println("Такой записи не существует");
        }

    }

    public void editInfo(String name){

        if(phoneBook.containsKey(name)){
            System.out.println("Введите номер телефона, который необходимо изменить");
            Scanner inputNumber = new Scanner(System.in);
            int editNumber = inputNumber.nextInt();

            ArrayList<Integer> clientsNumbers = phoneBook.get(name); //.add(phoneNumber) без put

            if(clientsNumbers.contains(editNumber)){
                clientsNumbers.remove(clientsNumbers.indexOf(editNumber));

                System.out.println("Введите новый номер телефона");
                int newNumber = inputNumber.nextInt();

                clientsNumbers.add(newNumber);

                phoneBook.put(name, clientsNumbers);
            }else{
                System.out.println("Такого номера не существует у выбранного пользователя");
            }


        }else{
            System.out.println("Запись с таким именем не найдена");
        }
    }

    public ArrayList<Integer> findInfo(String name){
        if(phoneBook.containsKey(name)){
            System.out.println("Номер(а) телефона пользователя: ");
            return phoneBook.get(name);
        }else{
            System.out.println("Запись не найдена");
            return new ArrayList<>();
        }
    }



    public HashMap<String, ArrayList<Integer>> printPhoneBook(){

        return phoneBook;
    }


    @Override
    public int compareTo(Phonebook o) {
        return o.phoneBook.values().size() - this.phoneBook.values().size();
    }
}
