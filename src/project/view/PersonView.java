package project.view;

import project.controller.PersonController;

import java.util.Scanner;

public class PersonView {
    public static void save(){
        System.out.println("Person View - Save");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Family : ");
        String family = sc.nextLine();

        System.out.print("Enter Age : ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.println("VIEW :" + PersonController.save(name, family, age));
    }
}
