package com.Lab4;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    /*
       Creates the School - Students Map for the problem
     */
    public static HashMap<School,List<Student>> createMapSchoolPreff(HashMap<Student, List<School>> stdPrefMap,List<School> schools,List<Student> students)
    {   HashMap<School, List<Student>> schoolPrefMap =new LinkedHashMap<>();
        for (School school: schools)
        { List<Student> nw=new LinkedList<>();
          schoolPrefMap.put(school,nw);

        }

        for(int i=0;i<students.size();i++)
        {
            List<School> list= stdPrefMap.get(students.get(i));
            for (School school:list)
            {
                schoolPrefMap.get(school).add(students.get(i));

            }
        }

        for (Map.Entry<School, List<Student>> entry : schoolPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName() + " : [");
            List<Student> print = entry.getValue();
            for(Student student : print){
                System.out.print(student.getName() + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();




        return schoolPrefMap;
    }
    /*
      Compulsory exercise + solution for the example + using problem acceptance methods
     */
    public static void firstProblemAndSolution()
    {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i )).toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>(Arrays.asList(students));
        studentList.sort(Comparator.comparing(Student::getName));
        int[] capacity={1,2,2};
        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i ,capacity[i])).toArray(School[]::new);
        List<School> schoolList = new LinkedList<>(Arrays.asList(schools));


        HashMap<Student, List<School>> stdPrefMap = new LinkedHashMap<>();
        HashMap<School, List<Student>> schoolPrefMap = new LinkedHashMap<>();
        stdPrefMap.put(students[0], Arrays.asList(schools[0],schools[1],schools[2]));
        stdPrefMap.put(students[1],Arrays.asList(schools[0],schools[1],schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0],schools[1]));
        stdPrefMap.put(students[3],Arrays.asList(schools[0],schools[2]));


        schoolPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1],students[2]));
        schoolPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schoolPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        for (Map.Entry<Student, List<School>> entry : stdPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName() + " : ");
            List<School> print= entry.getValue();
            for(School school : print){
                System.out.print(school.getName() + ", ");
            }
            System.out.println();
        }

        for (Map.Entry<School, List<Student>> entry : schoolPrefMap.entrySet()) {
            System.out.print(entry.getKey().getName() + " : ");
            List<Student> print = entry.getValue();
            for(Student student : print){
                System.out.print(student.getName() + ", ");
            }
            System.out.println();
        }

        Problem problem=new Problem(studentList,schoolList,stdPrefMap,schoolPrefMap);
        problem.printStudentsAndSchoolAccepts();

        Solver solution=new Solver(studentList,schoolList,stdPrefMap,schoolPrefMap);
        System.out.println(solution.resolveProblem());
    }

    /*
     New input for the problem using fake names for students and universities ,then solving the problem for this input
     */
    public static void fakeNamesAndAlgorithm()
    {   Faker faker=new Faker();
        var students = IntStream.rangeClosed(0, 4).mapToObj(i -> new Student(faker.name ().fullName())).toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>(Arrays.asList(students));
        studentList.sort(Comparator.comparing(Student::getScore));
        Collections.reverse(studentList);
        int[] capacity={1,1,2,2};
        var schools = IntStream.rangeClosed(0, 3).mapToObj(i -> new School(faker.university().name() ,capacity[i])).toArray(School[]::new);
        List<School> schoolList = new LinkedList<>(Arrays.asList(schools));
        schoolList.sort(Comparator.comparing(School::getCapacity));
        System.out.println("Students scores : ");
        for (Student student:studentList
        ) { System.out.println(student.getName() + " : " + student.getScore());

        }
        System.out.println();

        System.out.println("University capacity : ");

        for (School school:schoolList
             ) { System.out.println(school.getName() + " : " + school.getCapacity());

        }
        System.out.println();
        HashMap<Student, List<School>> stdPrefMap = new LinkedHashMap<>();

        stdPrefMap.put(students[0], Arrays.asList(schools[0],schools[1],schools[2],schools[3]));
        stdPrefMap.put(students[1],Arrays.asList(schools[0],schools[1],schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0],schools[1],schools[3]));
        stdPrefMap.put(students[3],Arrays.asList(schools[0],schools[2]));
        stdPrefMap.put(students[4],Arrays.asList(schools[0],schools[2],schools[3]));
        HashMap<School, List<Student>> schoolPrefMap =createMapSchoolPreff(stdPrefMap,schoolList,studentList);
        Solver solution=new Solver(studentList,schoolList,stdPrefMap,schoolPrefMap);
        System.out.println(solution.resolveProblem());

    }
    public static void main(String[] args) {
        firstProblemAndSolution();
        fakeNamesAndAlgorithm();

    }
}
