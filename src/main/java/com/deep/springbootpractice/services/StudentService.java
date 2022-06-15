package com.deep.springbootpractice.services;

import com.deep.springbootpractice.entities.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    private static List<Student> studentList=new ArrayList<Student>();
    public Student saveStudent(Student s){
        studentList.add(s);
        return s;
    }

    public List<Student> getAllStudent(){
        return studentList;
    }

    public Student updateStudent(Long studentId,Student updatedStudent){

        for(Student student:studentList){
            if(student.getId()==studentId){
                student.setId(updatedStudent.getId());
                student.setName(updatedStudent.getName());
            }
        }
        return updatedStudent;
    }

    public String deleteStudent(Long studentId){
        //Delete API Service using JAVA 8
        studentList.removeIf(s->s.getId()==studentId);

        //Delete API Service using iterator to avoid
//        Iterator<Student> iterator= studentList.iterator();
//        while(iterator.hasNext()){
//            Student s=iterator.next();
//            if(s.getId()==studentId){
//                iterator.remove();;
//            }
//        }
        return "Student Record with "+studentId+" successfully deleted";
    }
}
