package com.jiangbo.serialization;

import java.io.*;

/**
 * <p></p>
 * <p> Date: 13-6-24 Time: 下午7:47 </p>
 *
 * @author jiangbo.wjb
 */
public class ObjectIO {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("testPerson");
        person.setAge(20);
        person.setSex("male");

        FileOutputStream fileOutputStream
                = new FileOutputStream(new File("/src/main/test.txt"));
        ObjectOutputStream outputStream
                = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(person);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream(new File("/src/main/test.txt"));
        ObjectInputStream inputStream
                = new ObjectInputStream(fileInputStream);
//        Byte[] bytes = new Byte[1024];
        Person person1 = (Person)inputStream.readObject();
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1.getSex());

    }

    static class Person implements Serializable{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        private String name;

        private int age;

        private String sex;

    }
}
