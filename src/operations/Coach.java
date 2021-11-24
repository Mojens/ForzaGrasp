package operations;

import util.CompetitionResults;
import util.Member;
import util.MemberList;
import util.TrainingResults;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author Simon
 */

public class Coach extends Member {
    private boolean done = true;
    private boolean doneComp = true;

    public static final String allPracticeTimes = "Files/AllPracticeTimes.csv";
    public static final String allCompetitionTimes = "Files/AllCompetitionTimes.csv";

    public static final String jrCrawl = "Files/JuniorCrawlTimes.csv";
    public static final String jrButterfly = "Files/JuniorButterfly.csv";
    public static final String jrBackstroke = "Files/JuniorBackstrokeTimes.csv";
    public static final String jrbreaststroke = "Files/JuniorBreaststrokeTimes.csv";

    public static final String seniorCrawl = "Files/seniorCrawlTimes.csv";
    public static final String seniorButterfly = "Files/seniorButterflyTimes.csv";
    public static final String seniorBackstroke = "Files/seniorBackstrokeTimes.csv";
    public static final String seniorbreaststroke = "Files/seniorBreaststrokeTimes.csv";

    public static final String jrCrawlComp = "Files/JuniorCrawlCompTimes.csv";
    public static final String jrButterflyComp = "Files/JuniorButterflyCompTimes.csv";
    public static final String jrBackstrokeComp = "Files/JuniorBackstrokeCompTimes.csv";
    public static final String jrbreaststrokeComp = "Files/JuniorBreaststrokeCompTimes.csv";

    public static final String seniorCrawlComp = "Files/seniorCrawlCompTimes.csv";
    public static final String seniorButterflyComp = "Files/seniorButterflyCompTimes.csv";
    public static final String seniorBackstrokeComp = "Files/seniorBackstrokeCompTimes.csv";
    public static final String seniorbreaststrokeComp = "Files/seniorBreaststrokeCompTimes.csv";



    public void recordPractise() throws IOException{
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
            addMember(medlemsId, dateOfPrac, ageGroup, style, time);
            System.out.println("Are you done?");
            String finish = input.nextLine();
            if (finish.equalsIgnoreCase("yes")) {
                done = false;
            }
        }
        for (Member cleaned : TrainingResults.allPracticesTimes) {
            System.out.println(cleaned.toString());
        }

    }

    public void addMember(int medlemsId, int dateOfPrac, String ageGroup, String style, int time) throws IOException{
        if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("cr")
                || style.equalsIgnoreCase("Cr") && time < 7000 && time > 0 && dateOfPrac != 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrCrawl.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrCrawl,jrCrawl);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrButterfly.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrButterfly,jrButterfly);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBreaststroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrBreaststroke,jrbreaststroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBackstroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrBackstroke,jrBackstroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorCrawl.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorCrawl,seniorCrawl);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorButterfly.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorButterfly,seniorButterfly);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBreaststroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorBreaststroke,seniorbreaststroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBackstroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorBackstroke,seniorBackstroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        }
    }

    public void recordCompetion() throws IOException {
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
        for (Member cleaned : CompetitionResults.competitionList) {
            System.out.println(cleaned.toString());
        }

    }

    public void addMemberCom(int medlemsId,int place, String ageGroup, String style, int time, String location, int date) throws IOException
    {
        if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.jrCrawl.add(member);
            addTimes(CompetitionResults.jrCrawl,jrCrawlComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrButterfly.add(member);
            addTimes(CompetitionResults.jrButterfly,jrButterflyComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrBreaststroke.add(member);
            addTimes(CompetitionResults.jrBreaststroke,jrbreaststrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrBackstroke.add(member);
            addTimes(CompetitionResults.jrBackstroke,jrBackstrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorCrawl.add(member);
            addTimes(CompetitionResults.seniorCrawl,seniorCrawlComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorButterfly.add(member);
            addTimes(CompetitionResults.seniorButterfly,seniorButterflyComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorBreaststroke.add(member);
            addTimes(CompetitionResults.seniorBreaststroke,seniorbreaststrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorBackstroke.add(member);
            addTimes(CompetitionResults.seniorBackstroke,seniorBackstrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        }
    }

    public void showAllMembers() {
        int counter = 0;
        for (int i = 0; i < MemberList.competitiveList.size(); i++) {
            counter++;
            System.out.println("#" + counter + ", " + MemberList.competitiveList.get(i));
        }
    }

    public void top5JrCrawl(){
        Collections.sort(TrainingResults.jrCrawl);
        int counterOne = 1;
        for (Member jrCrawl : TrainingResults.jrCrawl.subList(0,5)) {
            System.out.println("\033[0;1m" + "#" + counterOne++ + "\033[0;0m" + ": " + jrCrawl);
        }
    }

    public void top5JrBreastStroke(){
        Collections.sort(TrainingResults.jrBreaststroke);
        int counterFour = 1;
        for (Member jrBreastStroke : TrainingResults.jrBreaststroke) {
            System.out.println("\033[0;1m" + "#" + counterFour++ + "\033[0;0m" + ": " + jrBreastStroke);
        }
    }

    public void top5JrBackStroke(){
        Collections.sort(TrainingResults.jrBackstroke);
        int counterThree = 1;
        for (Member jrBackStroke : TrainingResults.jrBackstroke) {
            System.out.println("\033[0;1m" + "#" + counterThree++ + "\033[0;0m" + ": " + jrBackStroke);
        }
    }

    public void top5JrButterfly(){
        Collections.sort(TrainingResults.jrButterfly);
        int counterTwo = 1;
        for (Member jrButterfly : TrainingResults.jrButterfly) {
            System.out.println("\033[0;1m" + "#" + counterTwo++ + "\033[0;0m" + ": " + jrButterfly);
        }
    }

    public void top5SrCrawl(){
        Collections.sort(TrainingResults.seniorCrawl);
        int counterTwo = 1;
        for (Member seniorCrawl : TrainingResults.seniorCrawl) {
            System.out.println("\033[0;1m" + "#" + counterTwo++ + "\033[0;0m" + ": " + seniorCrawl);
        }
    }

    public void top5SrBreastStroke(){
        Collections.sort(TrainingResults.seniorBreaststroke);
        int counterTwo = 1;
        for (Member seniorBreastStroke : TrainingResults.seniorBreaststroke) {
            System.out.println("\033[0;1m" + "#" + counterTwo++ + "\033[0;0m" + ": " + seniorBreastStroke);
        }
    }

    public void top5SrBackStroke(){
        Collections.sort(TrainingResults.seniorBackstroke);
        int counterTwo = 1;
        for (Member seniorBackStroke : TrainingResults.seniorBackstroke) {
            System.out.println("\033[0;1m" + "#" + counterTwo++ + "\033[0;0m" + ": " + seniorBackStroke);
        }
    }

    public void topSrButterfly(){
        Collections.sort(TrainingResults.seniorButterfly);
        int counterTwo = 1;
        for (Member seniorButterfly : TrainingResults.seniorButterfly) {
            System.out.println("\033[0;1m" + "#" + counterTwo++ + "\033[0;0m" + ": " + seniorButterfly);
        }
    }

    public void addTimes(ArrayList<Member> list, String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(list.toString().replace("[","").replace("]","").replace("\n, ", "\n"));
        bufferedWriter.close();
        fileWriter.close();
    }

    public void line() {
        System.out.println("\n----------------------------" +
                "-------------------------------" + "\n");
    }

    public void loadAllPracticeInfo(String file, ArrayList<Member> list) throws IOException {
        Scanner reader = new Scanner(new File(file));
        while (reader.hasNext()) {
            String lines = reader.nextLine();
            Member member = new Member();
            member.setDataFromLinePrac(lines);
            list.add(member);
        }
    }

    public void loadAllCompetitionInfo(String file, ArrayList<Member> list) throws IOException {
        Scanner reader = new Scanner(new File(file));
        while (reader.hasNext()) {
            String lines = reader.nextLine();
            Member member = new Member();
            member.setDataFromLineComp(lines);
            list.add(member);
        }
    }

}
