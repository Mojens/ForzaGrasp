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


    public void recordPractise(){
        setToStringStatus(4);
        Scanner input = new Scanner(System.in);

        int counter = -1;
        for (Member member : MemberList.competitiveList) {
            counter++;
            if (member.getBalance() < 0) {
                System.out.println("#" + counter + ", " + member);
            }
        }

        while (done) {
            System.out.println("Medlems ID: ");
            int medlemsId = Integer.parseInt(input.nextLine());
            if (medlemsId > 0) {
                setMedlemsID(medlemsId);
            }
            System.out.println("Date:");
            int dateOfPrac = Integer.parseInt(input.nextLine());
            setDate(dateOfPrac);
            System.out.println("Junior eller Senior?");
            String ageGroup = input.nextLine();
            if (ageGroup.startsWith("J") || ageGroup.startsWith("j")) {
                setAgeGroup("Junior");
            } else if (ageGroup.startsWith("S") || ageGroup.startsWith("s")) {
                setAgeGroup("Senior");
            }

            System.out.println("Style:");
            String style = input.nextLine();
            if (style.startsWith("Cr") || style.startsWith("cr")) {
                setStyle("Crawl");
            } else if (style.startsWith("Bu") || style.startsWith("bu")) {
                setStyle("Butterfly");
            } else if (style.startsWith("Br") || style.startsWith("br")) {
                setStyle("Breaststroke");
            } else if (style.startsWith("Ba") || style.startsWith("ba")) {
                setStyle("Backstroke");
            }

            System.out.println("Practice time");
            int pracTime = Integer.parseInt(input.nextLine());
            if (pracTime > 0 && pracTime < 9999) {
                setPracticeTime(pracTime);
            }
            addMember(medlemsId, dateOfPrac, ageGroup, style, pracTime);
            System.out.println("Are you done?");
            String finish = input.nextLine();
            if (finish.equalsIgnoreCase("yes")) {
                done = false;
            }
        }
        for (Member cleaned : TrainingResults.jrCrawl) {
            System.out.println(cleaned.toString());
        }

        for (Member cleaned : TrainingResults.jrButterfly) {
            System.out.println(cleaned.toString());
        }
    }
    public void recordCompetion() {
        setToStringStatus(5);
        Scanner input = new Scanner(System.in);
        System.out.println("Medlems ID: ");
        setMedlemsID(input.nextLine());
        System.out.println("Junior eller senior: ");
        setAgeGroup(input.nextLine());
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
