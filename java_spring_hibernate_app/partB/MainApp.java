package com.example.hibernatecrud;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student s1 = new Student();
        s1.setName("Alice");
        s1.setAge(22);
        dao.saveStudent(s1);

        List<Student> list = dao.getStudents();
        for (Student s : list) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getAge());
        }
    }
}
