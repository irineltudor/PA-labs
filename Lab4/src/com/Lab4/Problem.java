package com.Lab4;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    //Class members

    private List<Student> studentList;
    private List<School> schoolList;
    private HashMap<Student , List<School>> studentPreferences;
    private HashMap<School, List<Student>> schoolPreferences;

    //Class methods

    //Constructors
    Problem(List<Student> studentList, List<School> schoolList){
        this.studentList=studentList;
        this.schoolList=schoolList;}
    Problem(List<Student> studentList, List<School> schoolList,HashMap<Student , List<School>> studentPreferences,HashMap< School, List<Student>> schoolPreferences){
        this.studentList=studentList;
        this.schoolList=schoolList;
        this.studentPreferences=studentPreferences;
        this.schoolPreferences=schoolPreferences;
    }

    //Setters


    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setSchoolPreferences(HashMap<School, List<Student>> schoolPreferences) {
        this.schoolPreferences = schoolPreferences;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    public void setStudentPreferences(HashMap<Student, List<School>> studentPreferences) {
        this.studentPreferences = studentPreferences;
    }

    //Getters

    public HashMap<School, List<Student>> getSchoolPreferences() {
        return schoolPreferences;
    }

    public HashMap<Student, List<School>> getStudentPreferences() {
        return studentPreferences;
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
    //Functions

    public List<School> schoolAccepts(List<Student> target)
    {
        return schoolList.stream().filter(sch -> schoolPreferences.get(sch).containsAll(target)).collect(Collectors.toList());
    }
    public List<Student> studentsAccepts(List<School> target)
    {
        return studentList.stream().filter(std -> studentPreferences.get(std).containsAll(target)).collect(Collectors.toList());
    }

    public void printStudentsAndSchoolAccepts()
    { List<School> newList = schoolAccepts(getStudentList());
        List<Student> newList1=studentsAccepts(getSchoolList());
        for (School school:newList
        ) {
            System.out.print(school.getName() + " ");

        }
        System.out.println();

        for (Student student:newList1
        ) {
            System.out.print(student.getName() + " ");

        }
        System.out.println();

    }



}
