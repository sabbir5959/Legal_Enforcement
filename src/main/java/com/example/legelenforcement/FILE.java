package com.example.legelenforcement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FILE {

//    public static void main(String[] args)
//    {
//        try {
//            signup();
//        }
//        catch (IOException e){
//            System.out.println("Could not create user");
//        }
//
//    }
//    public static void signup() throws IOException
//    {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter E-mail: ");
//        String email = scanner.nextLine();
//
//        System.out.println("Enter Pass: ");
//        String password = scanner.nextLine();
//
//        System.out.println("Enter Name: ");
//        String name = scanner.nextLine();
//
//        create_user();
//
//        scanner.close();
//    }
//
//    public static void create_user() throws IOException
//    {
//
//
//        File user_folder = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/");
//        boolean is_user_folder_created = user_folder.mkdir();
//
//        File[] files = user_folder.listFiles();
//
//        assert files != null;
//        for (File file : files)
//        {
//            if(file.getName().equals(emaiL))
//            {
//                System.out.println("Account already exists");
//                return;
//            }
//        }
//
//        File userFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + email);
//        boolean is_user_file_created = userFile.mkdir();
//
//        File infoFile = new File("E:/Java Code/Java Files/Sign Up/Victim Sign Up/" + email + "/info.txt");
//        FileWriter writer = new FileWriter(infoFile);
//        writer.write(email + "\n");
//        writer.write(password + "\n");
//        writer.write(name + "\n");
//        writer.close();
//    }
}
