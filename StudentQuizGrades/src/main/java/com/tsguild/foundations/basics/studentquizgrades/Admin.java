/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.studentquizgrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruce_Breslin
 */
public class Admin {

    static UserIO IO = new UserIO();

    public static void addStudent() {
        boolean isFinished = false;
        String studentName = IO.readString("Please input the students name.");
        if (StudentScoresMap.classList.containsKey(studentName)) {
            IO.print("This student is already in the class list already.\nIf you wish to add a new student with this name please modify the name to distinguish the students.");
        } else {
            StudentScoresMap.classList.put(studentName, new ArrayList<>());
        }
        while (!isFinished) {
            int decision = IO.readInt("  1- Add Score to List\n  2- Return to Main Menu");
            switch (decision) {
                case 1:
                    StudentScoresMap.classList.get(studentName).add(IO.readInt("Please enter the students score."));
                    break;
                case 2:
                    isFinished = true;
                    break;
            }
        }
    }

    public static void removeStudent() {
        String studentName = IO.readString("Please select which student to remove.");
        if (StudentScoresMap.classList.containsKey(studentName)) {
            StudentScoresMap.classList.remove(studentName);
        } else {
            IO.print("Student not found in system. Please check your entry and try again.");
        }

    }

    public static void showStudent() {
        boolean isFinished = false;
        int averageGrade = 0;
        int total = 0;

        String studentName = IO.readString("Please input the name of the student you wish to look up.");
        while (!isFinished) {
            for (Map.Entry<String, ArrayList<Integer>> studentEntry : StudentScoresMap.classList.entrySet()) {
                String key = studentEntry.getKey();
                ArrayList<Integer> values = studentEntry.getValue();

                for (int x = 0; x < values.size(); x++) {
                    total += values.get(x);
                    averageGrade = total / values.size();
                }

                if (key.equalsIgnoreCase(studentName)) {
                    IO.print("Student name: " + key + "|| Average Grade: " + averageGrade + "|| Quiz scores: " + values);

                }
                int decision = IO.readInt("  1- Add Score to List\n  2- Return to Main Menu");
                switch (decision) {
                    case 1:
                        StudentScoresMap.classList.get(studentName).add(IO.readInt("Please enter the students score."));
                        IO.print("Student name: " + key + "|| Quiz scores: " + values);
                        break;
                    case 2:
                        isFinished = true;
                        break;
                }
            }
        }

    }

    public static void showClass() {
        int total = 0;
        int averageGrade = 0;
        boolean isFinished = false;
        List<String> highestAverage = new ArrayList<>();
        List<String> lowestAverage = new ArrayList<>();
        int highestAverageInt = 0;
        int lowestAverageInt = 100;
        int classAverageTotal = 0;

        for (Map.Entry<String, ArrayList<Integer>> currentStudent : StudentScoresMap.classList.entrySet()) {
            String key = currentStudent.getKey();
            ArrayList<Integer> values = currentStudent.getValue();

            for (int x = 0; x < values.size(); x++) {
                total += values.get(x);
                averageGrade = total / values.size();
            }
            total = 0;
            classAverageTotal += averageGrade;
                if (averageGrade < lowestAverageInt) {
                    lowestAverageInt = averageGrade;
                    lowestAverage.clear();
                    lowestAverage.add(key);
                } else if (averageGrade == lowestAverageInt) {
                    lowestAverage.add(key);
                }
                if (averageGrade > highestAverageInt) {
                    highestAverageInt = averageGrade;
                    highestAverage.clear();
                    highestAverage.add(key);
                } else if (averageGrade == highestAverageInt) {
                    highestAverage.add(key);
                }

            IO.print("Student name: " + key + "|| Average Grade: " + averageGrade + "|| Quiz scores: " + values);
        }
        for (String highest : highestAverage) {
            IO.print(highest + " has the highest average score.");
        }
        for (String lowest : lowestAverage) {
            IO.print(lowest + " has the lowest average score.");
        }
        int classAverage = classAverageTotal / StudentScoresMap.classList.size();
        IO.print("The class score average is: " + classAverage);
    }
}
