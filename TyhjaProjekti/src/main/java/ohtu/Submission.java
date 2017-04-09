package ohtu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Submission {
    private String student_number;
    private String last_name;
    private String first_name;
    private String identifier;
    private String comments;
    private String email;
    private String created_at;
    private int week;
    private int done_exercises;
    private int hours;
    private int course_id;
    private List<Boolean> exercises;
    
    private Boolean a1;
    private Boolean a2;
    private Boolean a3;
    private Boolean a4;
    private Boolean a5;
    private Boolean a6;
    private Boolean a7;
    private Boolean a8;
    private Boolean a9;
    private Boolean a10;
    private Boolean a11;
    private Boolean a12;
    private Boolean a13;
    private Boolean a14;
    private Boolean a15;
    private Boolean a16;
    private Boolean a17;
    private Boolean a18;
    private Boolean a19;
    private Boolean a20;
    private Boolean a21;
    
    private String print_teht;

    public Submission() {
    } 
    
    public String getStudent_number() {
        return student_number;
    }

    public String getComments() {
        return comments;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getEmail() {
        return email;
    }

    public List<Boolean> getExercises() {
        return exercises;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getHours() {
        return hours;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getWeek() {
        return week;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExercises(List<Boolean> exercises) {
        this.exercises = exercises;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setWeek(int week) {
        this.week = week;
    }
    
    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public int getDoneExercises() {
        return this.done_exercises;
    }
    
    public int numberOfExercises() {
        this.exercises = new ArrayList<>();
        this.done_exercises = 0;
        
        exercises.add(a1);
        exercises.add(a2);
        exercises.add(a3);
        exercises.add(a4);
        exercises.add(a5);
        exercises.add(a6);
        exercises.add(a7);
        exercises.add(a8);
        exercises.add(a9);
        exercises.add(a10);
        exercises.add(a11);
        exercises.add(a12);
        exercises.add(a13);
        exercises.add(a14);
        exercises.add(a15);
        exercises.add(a16);
        exercises.add(a17);
        exercises.add(a18);
        exercises.add(a19);
        exercises.add(a20);
        exercises.add(a21);
        
        this.print_teht = "";
        int number_of_nulls = 0;
        for (int j = 0; j < exercises.size(); j++) {
            Boolean exercise = exercises.get(j);
            if (exercise != null) {
                if (exercise) {
                    this.done_exercises++;
                    this.print_teht += String.valueOf(j+1) + " ";
                }
            } else {
                number_of_nulls++;
            }
        }
        
        return 21-number_of_nulls;
    }

    @Override
    public String toString() {
        int number = numberOfExercises();
        String print_ret = " viikko" + week + ": tehtyjä tehtäviä yhteensä: " + 
                getDoneExercises() + "(maksimi " + number + "), aikaa kului " +
                hours + ", tehdyt tehtävät: ";
        
        return print_ret + print_teht;
    }
    
}