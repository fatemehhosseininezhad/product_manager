package project.controller;


import project.model.bl.PersonBl;
import project.model.entity.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test1(){
        System.out.println("GET");
        Person person = new Person().setName("Ahmad").setFamily("Messbah");
        return person.toString();
    }

    @POST
    public String test2(){
        System.out.println("POST");
        return "Salam";
    }

    @PUT
    public String test3(){
        System.out.println("PUT");
        return "Salam";
    }

    @DELETE
    public String test4(){
        System.out.println("DELETE");
        return "Salam";
    }


//    public static String save(String name,String family, int age){
//        System.out.println("Controller - Save");
//        try{
//            Person person = new Person()
//                    .setName(name)
//                    .setFamily(family)
//                    .setAge(age);
//
//            PersonBl.save(person);
//            return "Controller Result : Person Saved";
//        }catch(Exception e){
//            return e.getMessage();
//        }
//    }
}
