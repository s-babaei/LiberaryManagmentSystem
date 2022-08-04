package model.pojo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class User {
    private Long Id;
    private String name;
    private String family;




    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }



    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }

    public User(Long id, String name, String family) {
        Id = id;
        this.name = name;
        this.family = family;
    }

    public User(String name, String family) {
        this.name = name;
        this.family = family;
    }
//
//    public static void main(String[] args) {
//        try {
//            Class<?> aClass = Class.forName("model.pojo.Book");
//            Constructor<?>[] constructors = aClass.getConstructors();
           // Method[] constructors = aClass.getMethods();
          //  String constructors = aClass.getName();
            //Class<?>[] constructors = aClass.getInterfaces();
//            Method[] constructors = aClass.getDeclaredMethods();
//            Stream.of(constructors).forEach(System.out::println);
//           // int modifier = aClass.getModifiers();
//
//           Stream.of(modifier).forEach(System.out::println);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
       }
//    }
//}
