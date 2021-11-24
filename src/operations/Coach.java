package operations;

import util.CompetitionResults;
import util.Member;
import util.MemberList;
import util.TrainingResults;

import java.util.Scanner;

/**
 * @Author Simon
 */

public class Coach extends Member {
    private boolean done = true;
    private boolean doneComp = true;

    public void recordPractise() {
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
            int time = Integer.parseInt(input.nextLine());
            if (time > 0 && time < 9999) {
                setTime(time);
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

    public void addMember(int medlemsId, int dateOfPrac, String ageGroup, String style, int pracTime) {
        if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("cr")
                || style.equalsIgnoreCase("Cr") && pracTime < 7000 && pracTime > 0 && dateOfPrac != 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.jrCrawl.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && pracTime < 7000 && pracTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.jrButterfly.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && pracTime < 7000 && pracTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.jrBrystsvømning.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && pracTime < 7000 && pracTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.jrRygcrawl.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && pracTime < 7000 && pracTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.seniorCrawl.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && pracTime < 7000 && pracTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.seniorButterfly.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && pracTime < 7000 && pracTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBrystsvømning.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && pracTime < 7000 && pracTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getPracticeTime(), getDate(), getToStringStatus());
            TrainingResults.seniorRygcrawl.add(member);
        }
    }

    public void recordCompetion() {
        setToStringStatus(5);
        Scanner input = new Scanner(System.in);

        while (doneComp) {
            System.out.println("Medlems ID:");
            int medlemsId = Integer.parseInt(input.nextLine());
            if (medlemsId > 0) {
                setMedlemsID(medlemsId);
            }
            System.out.println("Placering:");
            int place = Integer.parseInt(input.nextLine());
            if (place != 0){
                setPlace(place);
            }
            System.out.println("Date:");
            int dateOfComp = Integer.parseInt(input.nextLine());
            if (dateOfComp != 0){
                setDate(dateOfComp);
            }
            System.out.println("Location of competition");
            String location = input.nextLine();
            setLocation(location);
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

            System.out.println("Competition time");
            int time = Integer.parseInt(input.nextLine());
            if (time > 0 && time < 9999) {
                setTime(time);
            }
            addMemberCom(medlemsId,place, ageGroup, style, time,location,dateOfComp);
            System.out.println("Are you done?");
            String finish = input.nextLine();
            if (finish.equalsIgnoreCase("yes")) {
                doneComp = false;
            }
        }
        for (Member cleaned : CompetitionResults.jrCrawl) {
            System.out.println(cleaned.toString());
        }

        for (Member cleaned : CompetitionResults.jrButterfly) {
            System.out.println(cleaned.toString());
        }
    }

    public void addMemberCom(int medlemsId, String ageGroup, String style, int compTime, String location, int date) {
        if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(),getCompTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.jrCrawl.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(), getStyle(), getAgeGroup(), getCompTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrButterfly.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(), getStyle(), getAgeGroup(), getCompTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrBrystsvømning.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(), getStyle(), getAgeGroup(), getCompTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrRygcrawl.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(), getStyle(), getAgeGroup(), getCompTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorCrawl.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(), getStyle(), getAgeGroup(), getCompTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorButterfly.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(), getStyle(), getAgeGroup(), getCompTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorBrystsvømning.add(member);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && compTime < 7000 && compTime > 0) {
            Member member = new Member(getMedlemsID(), getStyle(), getAgeGroup(), getCompTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorRygcrawl.add(member);
        }
    }

    public void showAllMembers() {
        int counter = 0;
        for (int i = 0; i < MemberList.allMembers.size(); i++) {
            counter++;
            System.out.println("#" + counter + ", " + MemberList.allMembers.get(i));
        }
    }
}
