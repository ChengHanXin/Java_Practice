package com.jingtai.a01;

import java.util.ArrayList;

public class StudentUtil {
    private StudentUtil() {

    }

    public static int getMaxAge(ArrayList<Student> students) {
        int maxAge = students.get(0).getAge();
        for (int i = 1; i < students.size(); i++) {
//            maxAge = Math.max(maxAge, students.get(i).getAge());
            int tempAge = students.get(i).getAge();
            if (tempAge > maxAge) {
                maxAge = tempAge;
            }
        }
        return maxAge;
    }
}
