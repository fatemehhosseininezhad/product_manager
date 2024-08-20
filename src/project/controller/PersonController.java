package project.controller;


import project.model.bl.PersonBl;
import project.model.entity.Person;

public class PersonController {
    public static String save(String name,String family, int age){
        System.out.println("Controller - Save");
        try{
            Person person = new Person()
                    .setName(name)
                    .setFamily(family)
                    .setAge(age);

            PersonBl.save(person);
            return "Controller Result : Person Saved";
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
