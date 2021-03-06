package operations;

import util.CompetitionResults;
import util.Member;
import util.MemberList;
import util.TrainingResults;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * @Author Simon, Malthe og Mohammad
 */

public class Coach extends Member {
    private boolean done = true;
    private boolean doneComp = true;
    private boolean checkInput = true;
    private Scanner input = new Scanner(System.in);
    private static final DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("d/M/uuuu");

    public static String allPracticeTimes = "Files/AllPracticeTimes.csv";
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


    public void recordPractice() throws IOException {
        setToStringStatus(4);
        showAllMembers();

        while (done){
            name();
            date();
            ageGroup();
            style();
            recordTime();
            addMember(ageGroup,style);
            nowAdded();
            System.out.println("Er du f??rdig?");
            String finish = input.nextLine().toLowerCase();
            if (finish.toLowerCase().startsWith("j")||finish.toLowerCase().startsWith("ja")) {
                done = false;
            }
        }
    }

    public void recordCompetition() throws IOException {
        setToStringStatus(5);
        showAllMembers();

        while (doneComp){
            name();
            rank();
            date();
            location();
            ageGroup();
            style();
            recordTime();
            addMemberCom(ageGroup, style);
            nowAdded();
            System.out.println("Er du f??rdig?");
            String finish = input.nextLine().toLowerCase();
            if (finish.toLowerCase().startsWith("j")||finish.toLowerCase().startsWith("ye")) {
                doneComp = false;
            }
        }


    }

    public void name(){
        checkInput = true;
        while (checkInput){
            System.out.println("Indtast Navn:");
            String name = input.nextLine().toLowerCase();
            if (name.matches(".*[a-zA-Z????????????]+[\\s]*") ){
                setName(capitalizeWord(name));
                checkInput = false;
            } else {
                System.out.println("Forkert Format --> Venligt indtast kun bogstaver");
                checkInput = true;
            }

        }

    }

    public void date() {
        checkInput = true;

        while (checkInput){
                System.out.println("Indtast Dato:");
                System.out.println("Det skal skrives s??ledes: dd/mm/????????");
                String dateOfPrac = input.nextLine();
                try {
                    LocalDate.parse(dateOfPrac, PARSE_FORMATTER);
                    setDate(dateOfPrac);
                    checkInput = false;
                } catch (DateTimeParseException dtpe) {
                    System.out.println("Forkert Format --> Venligst indtast i dette format 22/05/2022 ");
                    checkInput = true;
                }
        }
    }

    public void ageGroup(){
        checkInput = true;
        while (checkInput){
            System.out.println("Er personen Junior(j) eller Senior(s) sv??mmer?");
            ageGroup = input.nextLine().toLowerCase(Locale.ROOT);
            if (ageGroup.toLowerCase().startsWith("j")) {
                setAgeGroup("Junior");
                checkInput = false;
            } else if (ageGroup.toLowerCase().startsWith("s")) {
                setAgeGroup("Senior");
                checkInput = false;
            } else if (!(ageGroup.matches(".*[a-zA-Z????????????]+[\\s]*"))){
                System.out.println("Forkert Format --> Indtast venligst kun bogstaver");
                checkInput = true;
            } else if (!(ageGroup.toLowerCase().startsWith("j") || ageGroup.toLowerCase().startsWith("s"))){
                System.out.println("Forkert indtastning --> j for Junior - s for Senior");
                checkInput = true;
            }

        }

    }

    public void style(){
        checkInput = true;

        while (checkInput){
        System.out.println("Indtast Sv??mmedisciplin: ");
        System.out.println("Crawl, Butterfly, Brystsv??mning eller Rygcrawl");
        style = input.nextLine().toLowerCase(Locale.ROOT);
            if (style.toLowerCase().startsWith("cr")) {
                setStyle("Crawl");
                checkInput = false;
            } else if (style.toLowerCase().startsWith("bu")) {
                setStyle("Butterfly");
                checkInput = false;
            } else if (style.toLowerCase().startsWith("br")) {
                setStyle("Brystsv??mning");
                checkInput = false;
            } else if (style.toLowerCase().startsWith("ryg")||style.toLowerCase().startsWith("back")) {
                setStyle("Rygcrawl");
                checkInput = false;
            } else if (!(style.matches(".*[a-zA-Z????????????]+[\\s]*"))){
                System.out.println("Forkert format - Venligst indtast bogstaver");
                checkInput = true;
            }
        }


    }

    public void recordTime(){

        checkInput = true;
        while (checkInput){
            System.out.println("Indtast tid:");
            System.out.println("Eks. 204201 ---> 20 Min 42 Sek 01 Ms");
        try {
            int time = Integer.parseInt(input.nextLine());
            if (time > 0 && time < 999999) {
                setTime(time);
                checkInput = false;
            }
        } catch(NumberFormatException e) {
            System.out.println("Forket format - Indtast venligt kun tal");
            checkInput = true;
        }
        }

    }

    public void rank(){
        checkInput = true;
        while (checkInput){
            System.out.println("Indtast Placering:");
            try {
                int place = Integer.parseInt(input.nextLine());
                if (place != 0){
                    setPlace(place);
                    checkInput = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Forkert Format --> Venligst indtast et nummer");
                checkInput = true;
            }
        }


    }

    public void location(){

        checkInput = true;
        while (checkInput){
        System.out.println("Indtast navnet p?? st??vnet:");
        String location = input.nextLine();
        if(location.matches(".*[a-zA-Z????????????]+[\\s]*")){
        setLocation(capitalizeWord(location));
        checkInput = false;

        }else{
            System.out.println("Forkert format - Venligst indtast bogstaver");
            checkInput = true;
        }
        }

    }

    public void nowAdded(){
        System.out.println("\033[0;1m" + getName()+ "\033[0;0m" + " Er nu tilf??jet til listen for "+"\033[0;1m" +getAgeGroup()+", "+getStyle()+ "\033[0;0m");
    }

    public void addMember(String ageGroup, String style) throws IOException{
        if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrCrawl.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrCrawl,jrCrawl);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("j")&& style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrButterfly.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrButterfly,jrButterfly);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBreaststroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrBreaststroke,jrbreaststroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("ba") | style.toLowerCase().startsWith("ryg")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.jrBackstroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.jrBackstroke,jrBackstroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorCrawl.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorCrawl, seniorCrawl);
            addTimes(TrainingResults.allPracticesTimes, allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorButterfly.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorButterfly,seniorButterfly);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBreaststroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorBreaststroke,seniorbreaststroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("ba") | style.toLowerCase().startsWith("ryg")) {
            Member member = new Member(getName(),getAgeGroup(), getStyle(), getTime(), getDate(), getToStringStatus());
            TrainingResults.seniorBackstroke.add(member);
            TrainingResults.allPracticesTimes.add(member);
            addTimes(TrainingResults.seniorBackstroke,seniorBackstroke);
            addTimes(TrainingResults.allPracticesTimes,allPracticeTimes);
        }

    }

    public void addMemberCom(String ageGroup, String style) throws IOException
    {
        if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.jrCrawl.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrCrawl,jrCrawlComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);

        } else if (ageGroup.toLowerCase().startsWith("j")&& style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.jrButterfly.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrButterfly,jrButterflyComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.jrBreaststroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrBreaststroke,jrbreaststrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("j") && style.toLowerCase().startsWith("ryg")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.jrBackstroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.jrBackstroke,jrBackstrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("cr")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.seniorCrawl.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorCrawl,seniorCrawlComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("bu")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.seniorButterfly.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorButterfly,seniorButterflyComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s") && style.toLowerCase().startsWith("br")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.seniorBreaststroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorBreaststroke,seniorbreaststrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        } else if (ageGroup.toLowerCase().startsWith("s")&& style.toLowerCase().startsWith("ryg")) {
            Member member = new Member(getName(),getPlace(), getAgeGroup(), getStyle(),getTime(), getLocation(), getDate(), getToStringStatus());
            CompetitionResults.seniorBackstroke.add(member);
            CompetitionResults.competitionList.add(member);
            addTimes(CompetitionResults.seniorBackstroke,seniorBackstrokeComp);
            addTimes(CompetitionResults.competitionList,allCompetitionTimes);
        }
    }

    public void showAllMembers() {
        System.out.println("\033[0;1m" +"ID: Navn: Alder: Aldersgruppe: Medlemstype: " +
                "Sv??mmedisciplin:  Saldo:  Dato:  Status:"+ "\033[0;0m");
        int counter = 0;
        for (int i = 0; i < MemberList.competitiveList.size(); i++) {
            counter++;
            System.out.println("#" + counter + ", " + MemberList.competitiveList.get(i));
        }
    }

    public void showTop5(ArrayList<Member> list){
        System.out.println("\033[0;1m" +"Navn: Aldersgruppe: Disciplin: Dato: " +
            "Tid:"+ "\033[0;0m");
        int counter = 1;
        Collections.sort(list);
        if (list.size()>=5) {
            for (Member member : list.subList(0,5)) {
                System.out.println("\033[0;1m" + "#" + counter++ + "\033[0;0m" + ": " + member);
            }
        }else{
            System.out.println("\nDer er ikke en top 5 lige nu, venligst vend tilbage n??r der er flere tr??nings resultater "
                +"\033[0;1m" +"Tr??ningstider"+ "\033[0;0m");
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

    public static String capitalizeWord(String str){
        String[] words =str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
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
