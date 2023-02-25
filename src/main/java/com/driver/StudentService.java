package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    public void addStud(Student stud)
    {
        repository.addStudent(stud);
    }
    public void addTeacher(Teacher teacher)
    {
        repository.addTeacher(teacher);
    }
    public void addStudTeacher(String stud,String teacher)
    {
        repository.addStudTeacher(stud,teacher);
    }
    public Student getStudent(String name)
    {
       return repository.getStudent(name);
    }
    public Teacher getTeacher(String name)
    {
        return repository.getTeacher(name);
    }
   public List<String> namesOfStuds(String teacher)
   {
       return repository.getNamesofStud(teacher);
   }
   public List<String> getAllStuds()
   {
       return repository.getAllStuds();
   }
   public void deleteATeacher(String teachername)
   {
       repository.deleteATeacher(teachername);
   }
   public void deleteAllTeacher()
   {
       repository.deleteAllTeacher();
   }

}
