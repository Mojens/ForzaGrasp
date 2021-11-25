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
import java.util.Locale;
import java.util.Scanner;

/**
 * @Author Simon, Malthe og Mohammad
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
                System.out.println("\033[0;1m" +"#" + counter + ", " + "\033[0;0m"+ member);
            }
        }

        while (done) {
            System.out.println("Indtast MedlemsID: ");
            int medlemsId = Integer.parseInt(input.nextLine());
            if (medlemsId > 0) {
                setMedlemsID(medlemsId);
            }
            System.out.println("Indtast Dato:");
            System.out.println("Det skal skrives således: 24112021");
            int dateOfPrac = Integer.parseInt(input.nextLine());
            setDate(dateOfPrac);
            System.out.println("Er personen en Junior eller Senior svømmer?");
            String ageGroup = input.nextLine().toLowerCase(Locale.ROOT);
            if (ageGroup.toLowerCase().startsWith("j")) {
                setAgeGroup("Junior");
            } else if (ageGroup.startsWith("s")) {
                setAgeGroup("Senior");
            }

            System.out.println("Indtast Svømmedisciplin: ");
            System.out.println("Crawl, Butterfly, Brystsvømning eller Rygcrawl");
            String style = input.nextLine().toLowerCase(Locale.ROOT);
            if (style.toLowerCase().startsWith("cr")) {
                setStyle("Crawl");
            } else if (style.toLowerCase().startsWith("bu")) {
                setStyle("Butterfly");
            } else if (style.toLowerCase().startsWith("br")) {
                setStyle("Brystsvømning");
            } else if (style.toLowerCase().startsWith("ryg")||style.toLowerCase().startsWith("back")) {
                setStyle("Rygcrawl");
            }

            System.out.println("Indtast tid:");
            int time = Integer.parseInt(input.nextLine());
            if (time > 0 && time < 999999) {
                setTime(time);
            }
            addMember(ageGroup, style);
            System.out.println("Er du færdig?");
            String finish = input.nextLine();
            if (finish.equalsIgnoreCase("ja")) {
                done = false;
            }
        }
        System.out.println("\033[0;1m" +"#"+getMedlemsID()+" Er nu tilføjet til listen for "+getAgeGroup()+", Og "+getStyle()+ "\033[0;0m");

    }
    public void addMember(String ageGroup, String style) throws IOException{
        if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrCrawl.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrCrawl,jrCrawl);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("j")&& style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrButterfly.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrButterfly,jrButterfly);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBreaststroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrBreaststroke,jrbreaststroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("ba") | style.toLowerCase().startsWith("ryg")) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBackstroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrBackstroke,jrBackstroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getMedlemsID(), getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorCrawl.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorCrawl, seniorCrawl);
            addTimes(TrainingResults.allPracticesTimes, allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorButterfly.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorButterfly,seniorButterfly);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getMedlemsID(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBreaststroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorBreaststroke,seniorbreaststroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("ba") | style.toLowerCase().startsWith("ryg")) {
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
        int counter = -1;
        for (Member member : MemberList.competitiveList) {
            counter++;
            if (member.getBalance() < 0) {
                System.out.println("\033[0;1m" +"#" + counter + ", " + "\033[0;0m"+ member);
            }
        }

        while (doneComp) {
            System.out.println("Indtast MedlemsID:");
            int medlemsId = Integer.parseInt(input.nextLine());
            if (medlemsId > 0) {
                setMedlemsID(medlemsId);
            }
            System.out.println("Indtast Placering:");
            int place = Integer.parseInt(input.nextLine());
            if (place != 0){
                setPlace(place);
            }
            System.out.println("Indtast Dato:");
            int dateOfComp = Integer.parseInt(input.nextLine());
            if (dateOfComp != 0){
                setDate(dateOfComp);
            }
            System.out.println("Indtast hvilken stævne det er:");
            String location = input.nextLine();
            setLocation(location);
            System.out.println("Er personen en Junior eller Senior svømmer?");
            String ageGroup = input.nextLine().toLowerCase(Locale.ROOT);
            if (ageGroup.toLowerCase().startsWith("j")) {
                setAgeGroup("Junior");
            } else if (ageGroup.toLowerCase().startsWith("s")) {
                setAgeGroup("Senior");
            }

            System.out.println("Indtast Svømmedisciplin: ");
            System.out.println("Crawl, Butterfly, Brystsvømning eller Rygcrawl");
            String style = input.nextLine().toLowerCase(Locale.ROOT);
            if (style.toLowerCase().startsWith("cr")) {
                setStyle("Crawl");
            } else if (style.toLowerCase().startsWith("bu")) {
                setStyle("Butterfly");
            } else if (style.toLowerCase().startsWith("br")) {
                setStyle("Brystsvømning");
            } else if (style.toLowerCase().startsWith("ba") || style.toLowerCase().startsWith("ryg")) {
                setStyle("Rygcrawl");
            }

            System.out.println("Indtast tid:");
            int time = Integer.parseInt(input.nextLine());
            if (time > 0 && time < 9999) {
                setTime(time);
            }
            addMemberCom(ageGroup, style);
            System.out.println("Er du færdig?");
            String finish = input.nextLine();
            if (finish.equalsIgnoreCase("ja")) {
                doneComp = false;
            }
        }
        System.out.println("\033[0;1m" +"#"+getMedlemsID()+" Er nu tilføjet til listen for"+getAgeGroup()+", "+getStyle()+ "\033[0;0m");
    }

    public void addMemberCom(String ageGroup, String style) throws IOException
    {
        if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getMedlemsID(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.jrCrawl.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrCrawl,jrCrawlComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);

        } else if (ageGroup.toLowerCase().startsWith("j")&& style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrButterfly.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrButterfly,jrButterflyComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrBreaststroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrBreaststroke,jrbreaststrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("ba") || style.toLowerCase().startsWith("ryg")) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.jrBackstroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrBackstroke,jrBackstrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorCrawl.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorCrawl,seniorCrawlComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorButterfly.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorButterfly,seniorButterflyComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorBreaststroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorBreaststroke,seniorbreaststrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s")&& style.toLowerCase().startsWith("ba") || style.toLowerCase().startsWith("ryg")) {
            Member member = new Member(getMedlemsID(),getPlace(), getStyle(), getAgeGroup(), getTime(),getLocation(),getDate(), getToStringStatus());
            CompetitionResults.seniorBackstroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorBackstroke,seniorBackstrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        }
    }
    public void showAllMembers() {
        System.out.println("\033[0;1m" +"MedlemsID:, Navn:, Alder:, aldersgruppe:, Medlems type:, " +
            "Svømmedisciplin:, Saldo:, Status:"+ "\033[0;0m");
        int counter = 0;
        for (int i = 0; i < MemberList.competitiveList.size(); i++) {
            counter++;
            System.out.println("#" + counter + ", " + MemberList.competitiveList.get(i));
        }
    }

    public void showTop5(ArrayList<Member> list){
        Collections.sort(list);
        int counter = 1;
        for (Member member : list.subList(0,5)){
            System.out.println("\033[0;1m" + "#" + counter++ + "\033[0;0m" + ": " + member);
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
