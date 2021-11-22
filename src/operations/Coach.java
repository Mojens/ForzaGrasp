package operations;
import util.CompetitionResults;
import util.Member;
import util.MemberList;
import util.TrainingResults;
import java.util.Scanner;

/**
 * @Author Simon
 */

public class Coach extends Member{

    private final String allMembersFile = "AllMembers.csv";

    public void recordPractise(){
        setToStringStatus(4);
        Scanner input = new Scanner(System.in);
        System.out.println("Medlems ID: ");
        setMedlemsID(input.nextLine());
        System.out.println("Style: ");
        setStyle(input.nextLine());
        System.out.println("Trænings tid: ");
        setPracticeTime(Integer.parseInt(input.nextLine()));
        System.out.println("Træningstid registreret");
        Member member = new Member(getMedlemsID(),getStyle(), getPracticeTime(),getToStringStatus());
        TrainingResults.practiceTime.add(member);

        //test af code
        for (Member cleaned: TrainingResults.practiceTime) {
            System.out.println(cleaned.toString());
        }

    }
    public void recordCompetion() {
        setToStringStatus(4);
        Scanner input = new Scanner(System.in);
        System.out.println("Medlems ID: ");
        setMedlemsID(input.nextLine());
        System.out.println("Style: ");
        setStyle(input.nextLine());
        System.out.println("Trænings tid: ");
        setPracticeTime(Integer.parseInt(input.nextLine()));
        System.out.println("Træningstid registreret");
        Member member = new Member(getMedlemsID(), getStyle(), getPracticeTime(), getToStringStatus());
        CompetitionResults.competitionList.add(member);
    }

    public void showAllMembers(){
        int counter = 0 ;
        for (int i = 0; i < MemberList.allMembers.size(); i++){
            counter++;
            System.out.println("#"+counter+", " + MemberList.allMembers.get(i));
        }
    }
}
