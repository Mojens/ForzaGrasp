package operations;

/**
 * @Author Simon, Mohammad og Malthe
 */

import util.Member;
import util.MemberList;
import java.time.LocalDate;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Chairman extends Member {
    public final String competitiveFile = "Files/CompetitiveList.csv";
    private final String allMembersFile = "Files/AllMembers.csv";
    boolean checkInput = true;
    private Scanner input = new Scanner(System.in);
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void registerCasual() throws IOException{
        setToStringStatus(2);
        setMemberType("Motionist");
        setStyle("Ingen");

        name();
        age();
        ageGroup();
        status();
        balance();
        autoDate(LocalDate.now());

        Member member = new Member(getName(), getAge(), getAgeGroup(), getMemberType(), getStyle(),getBalance(), getAutoDate(), getStatus(), getToStringStatus());
        MemberList.casualList.add(member);
        MemberList.allMembers.add(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println("\033[0;1m" + getName() + "\033[0;0m" + " Er nu tilføjet til listen"+"\n");

    }

    public void registerCompetitive() throws IOException {
        setToStringStatus(2);
        setMemberType("Konkurrence");

        name();
        age();
        ageGroup();
        style();
        status();
        balance();
        autoDate(LocalDate.now());

        Member member = new Member(getName(), getAge(), getAgeGroup(),getMemberType(),getStyle(), getBalance(), getAutoDate(), getStatus(), getToStringStatus());
        MemberList.competitiveList.add(member);
        MemberList.allMembers.add(member);

        new Chairman().addToCompetitiveFile(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println("\033[0;1m" + getName() + "\033[0;0m" + " Er nu tilføjet til listen"+"\n");
    }

    public void showAllMembers(){
        System.out.println("\033[0;1m" +"MedlemsID:  Navn:  Alder:  Aldersgruppe:  Medlems type:  " +
            "Svømmedisciplin:  Saldo:  Dato:   Status:"+ "\033[0;0m");
        int counter = 0 ;
        for (int i = 0; i < MemberList.allMembers.size(); i++){
            counter++;
            System.out.println("#"+counter+", " + MemberList.allMembers.get(i));
        }
    }

    public void checkStyleInput(String inputStyle){
            if (crawl(inputStyle) && breast(inputStyle) && butterfly(inputStyle) && backstroke(inputStyle)){
                setStyle("Brystsvømning Butterfly Crawl Rygcrawl");
            } else if (crawl(inputStyle) && breast(inputStyle) && butterfly(inputStyle)){
                setStyle("Brystsvømning Butterfly Crawl");
            } else if (crawl(inputStyle) && breast(inputStyle) && backstroke(inputStyle)) {
                setStyle("Brystsvømning Crawl Rygcrawl");
            } else if (crawl(inputStyle) && butterfly(inputStyle) && backstroke(inputStyle)){
                setStyle("Butterfly Crawl Rygcrawl");
            } else if (butterfly(inputStyle) && backstroke(inputStyle) && breast(inputStyle)){
                setStyle("Brystsvømning Butterfly Rygcrawl");
            } else if (crawl(inputStyle) && breast(inputStyle)){
                setStyle("Brystsvømning Crawl");
            } else if (crawl(inputStyle) && backstroke(inputStyle)){
                setStyle("Crawl Rygcrawl");
            } else if (crawl(inputStyle) && butterfly(inputStyle)){
                setStyle("Butterfly Crawl");
            } else if (breast(inputStyle)&& backstroke(inputStyle)){
                setStyle("Brystsvømning Rygcrawl");
            } else if (breast(inputStyle) && butterfly(inputStyle)){
                setStyle("Brystsvømning Butterfly");
            } else if (butterfly(inputStyle) && backstroke(inputStyle)){
                setStyle("Butterfly Rygcrawl");
            } else if (breast(inputStyle)){
                setStyle("Brystsvømning");
            } else if (crawl(inputStyle)){
                setStyle("Crawl");
            } else if (backstroke(inputStyle)){
                setStyle("Rygcrawl");
            } else if (butterfly(inputStyle)){
                setStyle("Butterfly");
            } else {
                setStyle("Ingen");
            }
            }

    public boolean butterfly(String input){
        final boolean deli = input.contains(" ")
                || input.contains(",");
        if (input.toLowerCase().contains("but") && deli){
            return true;
        } else if (input.toLowerCase().contains("but")){
            return true;
        }

        return false;
    }

    public boolean crawl(String input) {
        final boolean deli = input.contains(" ") || input.contains(",");
        if (input.matches("(?s).*\\bcrawl\\b.*") && deli) {
            return true;
        } else if (input.matches("(?s).*\\bcrawl\\b.*")) {
            return true;
        }
        return false;
    }

    public boolean backstroke(String input){

        final boolean deli = input.contains(",") || input.contains(" ");
        if (input.toLowerCase().contains("ryg") && deli) {
            return true;
        } else if (input.toLowerCase().contains("ryg")) {
            return true;
        }
        return false;
    }

    public boolean breast(String input){
        final boolean deli = input.contains(",")
                || input.contains(" ");
        if (input.toLowerCase().contains("bryst") && deli){
            return true;
        } else if (input.toLowerCase().contains("bryst")) {
            return true;
        }

        return false;
    }

    public void age(){
        checkInput = true;

        while (checkInput){
            System.out.println("Indtast alder: ");
            int age = Integer.parseInt(input.nextLine());
            if (age<106){
                setAge(age);
                checkInput = false;
            } else {
                System.out.println("Over 105?");
                checkInput = true;
            }

        }
    }

    public void name(){
        checkInput = true;
        while (checkInput){
            System.out.println("Indtast Navn:");
            String name = input.nextLine().toLowerCase();
            if (name.matches(".*[a-zA-ZæøåÆØÅ]+[\\s]*") ){
                setName(capitalizeWord(name));
                checkInput = false;
            } else {
                System.out.println("Forkert Format --> Venligt indtast kun bogstaver");
                checkInput = true;
            }

        }
    }

    public void ageGroup(){

            if (getAge() < 18 && getAge() > 0) {
                setAgeGroup("Junior");

            } else if (getAge() >= 18 && getAge() < 110) {
                setAgeGroup("Senior");

            }

    }

    public void status(){
        checkInput = true;

        while (checkInput){
            System.out.println("Indtast om personen er [a]Aktiv eller [p]Passiv: ");
            String statusString = input.nextLine().toLowerCase(Locale.ROOT);

            if (statusString.toLowerCase().startsWith("a")) {
                setStatus("Aktiv");
                checkInput = false;
            } else if (statusString.toLowerCase().startsWith("p")) {
                setStatus("Passiv");
                checkInput = false;
            } else if (statusString.matches("[0-9]+")){
                System.out.println("Forkert Format --> Venligst forsøg igen");
                checkInput = true;
            }
            else {
                System.out.println("Prøv Igen");
                checkInput = true;
            }
        }
    }

    public void balance(){
        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Aktiv")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Aktiv") && getAge() <= 60) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Aktiv") && getAge() > 60) {
            setBalance(-1200);
        } else {
            setBalance(-500);
        }
    }

    public void style(){
        checkInput = true;

        while (checkInput){
            System.out.println("Indtast aktive svømmediscipliner: ");
            System.out.println("Crawl, Butterfly, Brystsvømning, Rygcrawl");
            String inputStyle = input.nextLine().toLowerCase();
            checkStyleInput(inputStyle);
            if (inputStyle.contains("")){
                checkInput = false;
            } else if (inputStyle.equalsIgnoreCase("Nej")||inputStyle.equalsIgnoreCase("None")||inputStyle.equalsIgnoreCase("ingen")){
                setStyle("Ingen");
                checkInput = true;
            }
        }
    }

    public void autoDate(LocalDate date){

        setAutoDate(DATE_FORMATTER.format(date));
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

    public void addToCompetitiveFile(Member member) throws IOException {
        FileWriter fileWriter = new FileWriter(competitiveFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(member.toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public void addToAllMembersFile(Member member) throws IOException {
        FileWriter fileWriter = new FileWriter(allMembersFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(member.toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public void loadFromAllMemberfileToAllMembersList() throws IOException {
        Scanner reader = new Scanner(new File(allMembersFile));
        while (reader.hasNext()) {
            String lines = reader.nextLine();
            Member member = new Member();
            member.setDataFromLine(lines);

            MemberList.allMembers.add(member);

        }
    }

    public void loadFromCompetitionListToAllCompetitionList() throws IOException {
        Scanner reader = new Scanner(new File(competitiveFile));
        while (reader.hasNext()) {
            String lines = reader.nextLine();
            Member member = new Member();
            member.setDataFromLine(lines);

            MemberList.competitiveList.add(member);
        }
    }

}
