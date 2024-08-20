package project.model.bl;

import project.model.da.PersonDa;
import project.model.entity.Person;

public class PersonBl {
    public static void save(Person person) throws Exception {
        System.out.println("BL - Save");
        if(person.getAge()>20 && person.getAge()<35) {
        try(PersonDa personDa = new PersonDa()){
                personDa.save(person);
        }
        }else{
            throw new Exception("Age is out of range !!!");
        }
    }
}
