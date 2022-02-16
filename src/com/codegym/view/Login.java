package com.codegym.view;

import com.codegym.controller.PhoneBookManagement;
import com.codegym.model.PhoneNumber;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    public Scanner scanner = new Scanner(System.in);
    PhoneBookManagement phoneBookManagement = PhoneBookManagement.getInstance();
    private void menu() {
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
    }

    public void run() {
        int choice = -1;
        do {
            menu();
            System.out.println("Chọn chức năng");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    phoneBookManagement.showAllPhoneNumber();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Nhập số điện thoại cần thêm");
                    PhoneNumber phoneNumber = inputPhoneNumber();
                    phoneBookManagement.addNewPhoneNumber(phoneNumber);
                    break;
                case 3:
                    showUpdatePhoneNumber();
                    break;
                case 4:
                    showDeletePhoneNumber();
                    break;
                case 5:
                    findPhoneNumber();
                    break;
                case 6:
                    System.out.println("---Đọc từ file CSV---");
                    try {
                        phoneBookManagement.readFileCSV();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("---Ghi vào file CSV---");
                    for (int i = 0; i < phoneBookManagement.size(); i++) {
                        String phonebook = phoneBookManagement.showPhoneBookWriteToFile(i) + "\n";
                        try {
                            phoneBookManagement.writeToFileCSV(phonebook);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Đã ghi vào file CSV");
                    break;
            }
        } while (choice != 8);
    }

    private PhoneNumber inputPhoneNumber() {
        System.out.println("Nhập STT");
        String id = scanner.nextLine();
        System.out.println("Nhập nhóm : Bạn bè/ Đồng nghiệp/ Gia đình");
        String group = scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String number = scanner.nextLine();
        System.out.println("Nhập giới tính (Nam/Nữ)");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        PhoneNumber phoneNumber = new PhoneNumber(id, name, number,gender,address,group,email);
        return phoneNumber;
    }

    private void showUpdatePhoneNumber() {
        scanner.nextLine();
        System.out.println("Nhập tên người mà bạn cần sửa");
        String id = scanner.nextLine();
        int index = phoneBookManagement.findPhoneNumber(id);
        if (index != -1) {
            System.out.println("Nhập thông tin mới");
            PhoneNumber phoneNumber1 = inputPhoneNumber();
            phoneBookManagement.updatePhoneNumber(index, phoneNumber1);
        } else {
            System.out.println("Không có số của người này trong danh bạ");
        }
    }

    private void showDeletePhoneNumber() {
        scanner.nextLine();
        System.out.println("Nhập tên người mà bạn cần xóa");
        String name = scanner.nextLine();
        int index = phoneBookManagement.findPhoneNumber(name);
        if (index != -1) {
            phoneBookManagement.deletePhoneNumber(index);
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tồn tại người này trong danh bạ");
        }
    }

    private void findPhoneNumber() {
        scanner.nextLine();
        System.out.println("Nhập tên người mà bạn muốn tìm");
        String name = scanner.nextLine();
        int index = phoneBookManagement.findPhoneNumber(name);
        if (index != -1) {
            phoneBookManagement.showByName(index);
        } else {
            System.out.println("Không tìm thấy");
        }
        return;
    }
}
