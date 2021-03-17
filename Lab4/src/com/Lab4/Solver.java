package com.Lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {
    //Class members

    private List<Student> studentList;
    private List<School> schoolList;
    private HashMap<Student, List<School>> studentPreferences;
    private HashMap<School, List<Student>> schoolPreferences;

    //Class methods

    //Constructors
    Solver(List<Student> studentList, List<School> schoolList) {
        this.studentList = studentList;
        this.schoolList = schoolList;
    }

    Solver(List<Student> studentList, List<School> schoolList, HashMap<Student, List<School>> studentPreferences, HashMap<School, List<Student>> schoolPreferences) {
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


    public Solution resolveProblem()
    {   HashMap<Student,School> solution=new HashMap<>();
        int[] applied=new int[studentList.size()];

        for (Map.Entry<School, List<Student>> entry : schoolPreferences.entrySet()) {
            List<Student> students = entry.getValue();
            for (Student student : students) {
                if (applied[studentList.indexOf(student)] == 0 && entry.getKey().getCapacity()>0) {
                    solution.put(student, entry.getKey());
                    entry.getKey().setCapacity(entry.getKey().getCapacity()-1);
                    applied[studentList.indexOf(student)] = 1;
                }
            }
        }



        return new Solution(solution);
    }

}
