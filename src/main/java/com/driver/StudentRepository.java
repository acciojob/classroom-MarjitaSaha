package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
  private Map<String,Student> db1 ;
   private Map<String,Teacher> db2 ;
   private Map<String,List<String>> db3 ;
   StudentRepository()
   {
       this.db1=new HashMap<String,Student>();
       this.db2=new HashMap<String,Teacher>();
       this.db3=new HashMap<String,List<String>>();
   }
   public void addStudent(Student student)
   {
      db1.put(student.getName(),student);
   }
   public void addTeacher(Teacher teacher)
   {
      db2.put(teacher.getName(),teacher);
   }
   public void addStudTeacher(String student, String teacher)
   {
      if(db1.containsKey(student) && db2.containsKey(teacher))
      {
          db1.put(student,db1.get(student));
          db2.put(teacher,db2.get(teacher));
          List<String> teacher_student = new ArrayList<>();
          if(db3.containsKey(teacher)) teacher_student=db3.get(teacher);
         teacher_student.add(student);
         db3.put(teacher,teacher_student);
      }
   }
   public Student getStudent(String name)
   {
      return db1.get(name);
   }
    public Teacher getTeacher(String name)
    {
        return db2.get(name);
    }
    public List<String> getNamesofStud(String teachername)
    {
        List<String> studNames= new ArrayList<>();
        if(db3.containsKey(teachername))
            studNames=db3.get(teachername);
        return studNames;
    }
   public List<String> getAllStuds()
   {
       List<String> stu = new ArrayList<>();
       for (String s:db1.keySet())
       {
           stu.add(s);
       }
       return stu;
   }
   public void deleteATeacher(String teacher)
   {
       List<String> student = new ArrayList<>();

       if(db3.containsKey(teacher))
       {
           student=db3.get(teacher);
           for(String s:student)
           {
               if(db1.containsKey(s)) db1.remove(s);
           }
           db3.remove(teacher);
       }
       if(db2.containsKey(teacher)) db2.remove(teacher);
   }
    public void deleteAllTeacher()
    {
        HashSet<String> studSet = new HashSet<>();
        for (String  teacher: db3.keySet())
        {
            for (String stud : db3.get(teacher)) studSet.add(stud);
            db3.remove(teacher);
        }

        for (String stud : studSet)
        {
            if (db1.containsKey(stud)) db1.remove(stud);
        }
    }
//    Get Teacher by teacher name: GET /students/get-teacher-by-name/{name} Pass teacher name as path parameter Return Teacher object wrapped in a ResponseEntity object Controller Name - getTeacherByName
//
//    Get List of students name for a given teacher name: GET /students/get-students-by-teacher-name/{teacher} Pass teacher name as path parameter Return List of students name(List()) wrapped in a ResponseEntity object Controller Name - getStudentsByTeacherName
//
//    Get List of all students added: GET /students/get-all-students No params or body required Return List of students name(List()) wrapped in a ResponseEntity object Controller Name - getAllStudents
//
//    Delete a teacher and its students from the records: DELETE /students/delete-teacher-by-name Pass teacher’s name as request parameter Return success message wrapped in a ResponseEntity object Controller Name - deleteTeacherByName
//
//    Delete all teachers and all students by them from the records: DELETE /students/delete-all-teachers No params or body required Return success message wrapped in a ResponseEntity object Controller Name - deleteAllTeachers
}
