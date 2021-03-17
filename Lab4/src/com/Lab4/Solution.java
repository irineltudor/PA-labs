package com.Lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //Class members

    private List<Student> studentList;
    private List<School> schoolList;
    private HashMap<Student, List<School>> studentPreferences;
    private HashMap<School, List<Student>> schoolPreferences;

    //Class methods

    //Constructors
    Solution(List<Student> studentList, List<School> schoolList) {
        this.studentList = studentList;
        this.schoolList = schoolList;
    }

    Solution(List<Student> studentList, List<School> schoolList, HashMap<Student, List<School>> studentPreferences, HashMap<School, List<Student>> schoolPreferences) {
        this.studentList = studentList;
        this.schoolList = schoolList;
        this.studentPreferences = studentPreferences;
        this.schoolPreferences = schoolPreferences;
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

    public void printSolution()
    {
        HashMap<Student,School> solution=new HashMap<>();
        solution.put(studentList.get(0),schoolList.get(1));
        solution.put(studentList.get(1),schoolList.get(2));
        solution.put(studentList.get(2),schoolList.get(1));
        solution.put(studentList.get(3),schoolList.get(0));

        for (Map.Entry<Student,School> entry : solution.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue().getName());
            }
            System.out.println();
        }
    }


