package com.Lab4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        LinkedList<Student> studentList = new LinkedList<>(Arrays.asList(students));
        Collections.sort(studentList,Comparator.comparing(Student::getName));

        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i)).toArray(School[]::new);
        TreeSet<School> schoolList = new TreeSet<School>(Arrays.asList(schools));

        Map<Student, List<School>> stdPrefMap = new LinkedHashMap<>();
        Map<School, List<Student>> schoolPrefMap = new LinkedHashMap<>();
        stdPrefMap.put(students[0], Arrays.asList(schools[0],schools[1],schools[2]));
        stdPrefMap.put(students[1],Arrays.asList(schools[0],schools[1],schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0],schools[1]));
        stdPrefMap.put(students[3],Arrays.asList(schools[0],schools[2]));

        LinkedList<Student> studentList1 = new LinkedList<>();
        studentList1.add(students[3]);
        studentList1.add(students[0]);
        studentList1.add(students[1]);
        studentList1.add(students[2]);

        LinkedList<Student> studentList2 = new LinkedList<>();
        studentList2.add(students[0]);
        studentList2.add(students[2]);
        studentList2.add(students[1]);

        LinkedList<Student> studentList3 = new LinkedList<>();
        studentList3.add(students[0]);
        studentList3.add(students[1]);
        studentList3.add(students[3]);



        schoolPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1],students[2]));
        schoolPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schoolPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        for (Map.Entry<Student, List<School>> entry : stdPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName() + " : ");
            List<School> print= entry.getValue();
            for(School school : print){
                System.out.print(school.getName() + " ");
            }
            System.out.println();
        }

        for (Map.Entry<School, List<Student>> entry : schoolPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName() + " : ");
            List<Student> print = entry.getValue();
            for(Student student : print){
                System.out.print(student.getName() + " ");
            }
            System.out.println();
        }


    }
}
