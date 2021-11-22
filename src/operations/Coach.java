package operations;
import util.Member;
import util.TrainingResults;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Simon
 */

public class Coach extends Member{



    public void recordPractise(){
        setToStringStatus(4);
        Scanner input = new Scanner(System.in);
        System.out.println("Medlems ID: ");
        setMedlemsID(input.nextLine());
        System.out.println("Trænings tid: ");
        setPractiseTime(Integer.parseInt(input.nextLine()));
        System.out.println("Træningstid registreret");
        Member member = new Member(getMedlemsID(), getPractiseTime());
        TrainingResults.practiseTime.add(member);

        for (Member cleaned:
             TrainingResults.practiseTime) {
            System.out.println(cleaned.toString());
        }
        System.out.println(TrainingResults.practiseTime);
    }
}
