package com.codegym.controller;

import com.codegym.model.PhoneNumber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookManagement implements ReadFile, WriteFile {

    private static PhoneBookManagement phoneBookManagement;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public int size() {
        return phoneNumbers.size();
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.phoneNumbers = (List<PhoneNumber>) ois.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {

    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    private PhoneBookManagement() {
        File file = new File("phoneNumber.csv");
        if (file.exists()) {
            try {
                readFile("phoneNumber.csv");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static PhoneBookManagement getInstance() {
        if (phoneBookManagement == null) {
            phoneBookManagement = new PhoneBookManagement();
        }
        return phoneBookManagement;
    }

    public void showAllPhoneNumber() {
        if (size() == 0) {
            System.out.println("Danh bạ rỗng");
        }
        for (PhoneNumber phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }

    public void addNewPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
        try {
            writeFile("phoneNumber.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updatePhoneNumber(int index, PhoneNumber product) {
        this.phoneNumbers.set(index, product);
        try {
            writeFile("phoneNumber.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deletePhoneNumber(int index) {

        this.phoneNumbers.remove(index);
        try {
            writeFile("phoneNumber.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int findPhoneNumber(String name) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (phoneNumbers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return index;
    }

    public void showByName(int index) {
        System.out.println(phoneNumbers.get(index));
    }

    public void writeToFileCSV(String s) throws IOException {
        File file = new File("phoneNumber.csv");
        FileWriter fileWriter = new FileWriter("phoneNumner.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
        fileWriter.close();
    }

    public String showPhoneBookWriteToFile(int index) {
        return phoneNumbers.get(index).toString();
    }

    public void readFileCSV() throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader("phonebook.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] phonebook = line.split(", ");
                String id = phonebook[0];
                String group = phonebook[1];
                String name = phonebook[2];
                String number = phonebook[3];
                String gender = phonebook[4];
                String address = phonebook[5];
                String email = phonebook[6];
                PhoneNumber phoneBook = new PhoneNumber(id,group,name,number,gender,address,email);
                addNewPhoneNumber(phoneBook);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
