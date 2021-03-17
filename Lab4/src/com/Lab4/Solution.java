package com.Lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //Class members
    private HashMap<Student,School> solution;
    //Class methods
    Solution(){}
    Solution(HashMap<Student,School> solution)
    {
        this.solution=solution;
    }

    @Override
    public String toString() {

        StringBuilder stb = new StringBuilder();
        for (Map.Entry<Student, School> entry : solution.entrySet()) {
            stb.append(entry.getKey().getName()).append(" : ").append(entry.getValue().getName()).append("\n");
        }
        return stb.toString();
    }
}



