package operations;

import util.CompetitionResults;
import util.Member;
import util.MemberList;
import util.TrainingResults;

import java.io.BufferedWriter;
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

    private final String allPracticeTimes = "Files/AllPracticeTimes.csv";
    private final String allCompetitionTimes = "Files/AllPracticeTimes.csv";

    private final String jrCrawl = "Files/JuniorCrawlTimes.csv";
    private final String jrButterfly = "Files/JuniorButterfly.csv";
    private final String jrBackstroke = "Files/JuniorBackstrokeTimes.csv";
    private final String jrbreaststroke = "Files/JuniorBreaststrokeTimes.csv";

    private final String seniorCrawl = "Files/seniorCrawlTimes.csv";
    private final String seniorButterfly = "Files/seniorButterflyTimes.csv";
    private final String seniorBackstroke = "Files/seniorBackstrokeTimes.csv";
    private final String seniorbreaststroke = "Files/seniorBreaststrokeTimes.csv";

    private final String jrCrawlComp = "Files/JuniorCrawlCompTimes.csv";
    private final String jrButterflyComp = "Files/JuniorButterflyCompTimes.csv";
    private final String jrBackstrokeComp = "Files/JuniorBackstrokeCompTimes.csv";
    private final String jrbreaststrokeComp = "Files/JuniorBreaststrokeCompTimes.csv";

    private final String seniorCrawlComp = "Files/seniorCrawlCompTimes.csv";
    private final String seniorButterflyComp = "Files/seniorButterflyCompTimes.csv";
    private final String seniorBackstrokeComp = "Files/seniorBackstrokeCompTimes.csv";
    private final String seniorbreaststrokeComp = "Files/seniorBreaststrokeCompTimes.csv";



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
        for (Member cleaned : TrainingResults.jrCrawl) {
            System.out.println(cleaned.toString());
        }

        for (Member cleaned : TrainingResults.jrButterfly) {
            System.out.println(cleaned.toString());
        }
    }

    public void addMember(int medlemsId, int dateOfPrac, String ageGroup, String style, int time) throws IOException{
        if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("cr")
                || style.equalsIgnoreCase("Cr") && time < 7000 && time > 0 && dateOfPrac != 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrCrawl.add(member);
            addToPracticeTimes(TrainingResults.jrCrawl,jrCrawl);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrButterfly.add(member);
            addToPracticeTimes(TrainingResults.jrButterfly,jrButterfly);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBreaststroke.add(member);
            addToPracticeTimes(TrainingResults.jrBreaststroke,jrbreaststroke);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBackstroke.add(member);
            addToPracticeTimes(TrainingResults.jrBackstroke,jrBackstroke);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorCrawl.add(member);
            addToPracticeTimes(TrainingResults.seniorCrawl,seniorCrawl);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorButterfly.add(member);
            addToPracticeTimes(TrainingResults.seniorButterfly,seniorButterfly);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBreaststroke.add(member);
            addToPracticeTimes(TrainingResults.seniorBreaststroke,seniorbreaststroke);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBackstroke.add(member);
            addToPracticeTimes(TrainingResults.seniorBackstroke,seniorBackstroke);
            addToPracticeTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
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
            addToPracticeTimes(CompetitionResults.jrCrawl,jrCrawlComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrButterfly.add(member);
            addToPracticeTimes(CompetitionResults.jrButterfly,jrButterflyComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrBreaststroke.add(member);
            addToPracticeTimes(CompetitionResults.jrBreaststroke,jrbreaststrokeComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("j") || ageGroup.startsWith("J") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrBackstroke.add(member);
            addToPracticeTimes(CompetitionResults.jrBackstroke,jrBackstrokeComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("cr") || style.equalsIgnoreCase("Cr") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorCrawl.add(member);
            addToPracticeTimes(CompetitionResults.seniorCrawl,seniorCrawlComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("bu") || style.equalsIgnoreCase("Bu") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorButterfly.add(member);
            addToPracticeTimes(CompetitionResults.seniorButterfly,seniorButterflyComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("br") || style.equalsIgnoreCase("Br") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.SeniorBreaststroke.add(member);
            addToPracticeTimes(CompetitionResults.SeniorBreaststroke,seniorbreaststrokeComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (medlemsId > 0 && ageGroup.startsWith("s") || ageGroup.startsWith("S") && style.equalsIgnoreCase("ba") || style.equalsIgnoreCase("Ba") && time < 7000 && time > 0) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorBackstroke.add(member);
            addToPracticeTimes(CompetitionResults.seniorBackstroke,seniorbreaststrokeComp);
            addToPracticeTimes(CompetitionResults.competitionList,allCompetitionTimes);
        }
    }

    public void showAllMembers() {
        int counter = 0;
        for (int i = 0; i < MemberList.competitiveList.size(); i++) {
            counter++;
            System.out.println("#" + counter + ", " + MemberList.competitiveList.get(i));
        }
    }

    public void top5JrBreastStroke(){
        line();
        System.out.println("\u001B[0;1m"+"Crawl"+ "\033[0;0m"+"\n" +" Top 5 for Junior: ");
        Collections.sort(TrainingResults.jrCrawl);
        int counterOne = 1;
        for (Member jrCrawl : TrainingResults.jrCrawl) {
            System.out.println("\033[0;1m" + "#" + counterOne++ + "\033[0;0m" + ": " + jrCrawl);
        }
        line();
        System.out.println("\u001B[0;1m"+"Butterfly"+ "\033[0;0m"+" top 5 for Junior: ");
        Collections.sort(TrainingResults.jrButterfly);
        int counterTwo = 1;
        for (Member jrButterfly : TrainingResults.jrButterfly) {
            System.out.println("\033[0;1m" + "#" + counterTwo++ + "\033[0;0m" + ": " + jrButterfly);
        }
        line();
        System.out.println("\u001B[0;1m"+"RygCrawl"+ "\033[0;0m" +" top 5 for Junior: ");
        Collections.sort(TrainingResults.jrBackstroke);
        int counterThree = 1;
        for (Member jrBackStroke : TrainingResults.jrBackstroke) {
            System.out.println("\033[0;1m" + "#" + counterThree++ + "\033[0;0m" + ": " + jrBackStroke);
        }
        line();
        System.out.println("\u001B[0;1m"+"Brystsvmøning"+"\033[0;0m"+ " top 5 for Junior: ");
        int counterFour = 1;
        for (Member jrBreastStroke : TrainingResults.jrBreaststroke) {
            System.out.println("\033[0;1m" + "#" + counterFour++ + "\033[0;0m" + ": " + jrBreastStroke);
        }
        line();
    }

    public void top5JrCrawl(){

    }

    public void top5JrBackStroke(){

    }

    public void top5JrButterfly(){

    }

    public void addToPracticeTimes(ArrayList<Member> list, String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(list.toString());
        bufferedWriter.close();
        fileWriter.close();
    }
    private void line() {
        System.out.println("\n----------------------------" +
                "-------------------------------" + "\n");
    }
}
