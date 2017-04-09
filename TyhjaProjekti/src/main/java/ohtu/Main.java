package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";
        String url_course = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String bodyText = Request.Get(url).execute().returnContent().asString();
        String course = Request.Get(url_course).execute().returnContent().asString();
        
        printData(bodyText, course);
        
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course cou = mapper.fromJson(course, Course.class);
        
        System.out.println( cou );
        System.out.println("opiskelijanumero: " + subs[0].getStudent_number() + "\n\n");
        int sum_hours = 0;
        int sum_exercises = 0;
        int sum_maxexercices = 0;
        
        for (Submission submission : subs) {
            System.out.println(submission);
            sum_maxexercices += submission.numberOfExercises();
            sum_hours += submission.getHours();
            sum_exercises += submission.getDoneExercises();
        }
        
        System.out.println("\n Yhteensä: " + sum_exercises + "/" + sum_maxexercices 
                            + ", " + sum_hours + " tuntia");
    }

    public static void printData(String bodyText, String course) {
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );
        System.out.println("");
        System.out.println("json-muotoinen kurssidata:");
        System.out.println( course );
        System.out.println("");
    }
}
