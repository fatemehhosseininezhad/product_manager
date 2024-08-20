package project.model.entity;

import com.google.gson.Gson;

import java.util.regex.Pattern;

public class Person {
    private int id;
    private String name;
    private String family;
    private int age;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        if(Pattern.matches("^[a-zA-Z]{2,20}$", name)) {
            this.name = name;
            return this;
        }else{
            throw new IllegalArgumentException("Name must be between 2 and 20 characters");
        }
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
