package operations;

/**
 * @Author Simon, Mohammad og Malthe
 */

import util.Member;
import util.MemberList;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Chairman extends Member {
    public final String competiviveFile = "Files/CompetiviveList.csv";
    private final String allMembersFile = "Files/AllMembers.csv";
    boolean done = true;
    boolean secondDone = true;
    boolean styleInput = true;
    private Scanner input = new Scanner(System.in);

    public void registerCasual() throws IOException{
        setToStringStatus(2);
        setMemberType("Motionist");
        setStyle("Ingen");

        name();
        age();
        ageGroup();
        status();
        balance();

        Member member = new Member(getName(), getAge(), getAgeGroup(), getMemberType(), getStyle(),getBalance(), getStatus(), getToStringStatus());
        MemberList.casualList.add(member);
        MemberList.allMembers.add(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println("\033[0;1m" + getName() + "\033[0;0m" + " Er nu tilføjet til listen");

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

        Member member = new Member(getName(), getAge(), getAgeGroup(),getMemberType(),getStyle(), getBalance(), getStatus(), getToStringStatus());
        MemberList.competitiveList.add(member);
        MemberList.allMembers.add(member);

        new Chairman().addToCompetitiveFile(member);
        new Chairman().addToAllMembersFile(member);

        System.out.println("\033[0;1m" + getName() + "\033[0;0m" + " Er nu tilføjet til listen");
    }

    public void showAllMembers(){
        System.out.println("\033[0;1m" +"MedlemsID:, Navn:, Alder:, aldersgruppe:, Medlems type:, " +
            "Svømmedisciplin:, Saldo:, Status:"+ "\033[0;0m");
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
                | input.contains(",");
        if (input.toLowerCase().contains("but") && deli){
            return true;
        } else if (input.toLowerCase().contains("fly") && deli){
            return true;
        }

        return false;
    }

    public boolean crawl(String input){
        final boolean deli = input.contains(" ") | input.contains(",");
        if (input.matches("(?s).*\\bcrawl\\b.*") && deli){
            return true;
        } else if (input.toLowerCase().contains("free") && deli){
            return true;
        } else if (input.toLowerCase().contains("front") && deli){
            return true;
        }

        return false;
    }


    public boolean backstroke(String input){

        final boolean deli = input.contains(",") | input.contains(" ");
        if (input.toLowerCase().contains("ryg") && deli){
            return true;
        } else if (input.toLowerCase().contains("back") && deli){
            return true;
        }

        return false;
    }

    public boolean breast(String input){
        final boolean deli = input.contains(",")
                | input.contains(" ");
        if (input.toLowerCase().contains("bryst") && deli){
            return true;
        } else if (input.toLowerCase().contains("breast") && deli) {
            return true;
        }

        return false;
    }

    public void age(){
        while (done){
            System.out.println("Indtast alder: ");
            int age = Integer.parseInt(input.nextLine());
            if (age<106){
                setAge(age);
                done = false;
            } else {
                System.out.println("Over 105?");
                done = true;
            }

        }
    }

    public void name(){
        System.out.println("Indtast fulde navn:");
        setName(capitalizeWord(input.nextLine()));
    }

    public void ageGroup(){
        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 110) {
            setAgeGroup("Senior");
        }
    }

    public void status(){
        while (secondDone){
            System.out.println("Indtast om personen er aktiv eller passiv: ");
            String statusString = input.nextLine().toLowerCase(Locale.ROOT);

            if (statusString.toLowerCase().startsWith("a")) {
                setStatus("Aktiv");
                secondDone = false;
            } else if (statusString.toLowerCase().startsWith("p")) {
                setStatus("Passiv");
                secondDone = false;
            } else {
                System.out.println("Prøv Igen");
                secondDone = true;
            }
        }
    }

    public void balance(){
        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Aktiv")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Aktiv") && getAge() < 60) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Aktiv") && getAge() >= 60) {
            setBalance(-1200);
        } else {
            setBalance(-500);
        }
    }

    public void style(){
        while (styleInput){
            System.out.println("Indtast aktive svømmediscipliner: ");
            System.out.println("Crawl, Butterfly, Brystsvømning, Rygcrawl");
            String inputStyle = input.nextLine().toLowerCase();
            checkStyleInput(inputStyle);
            if (inputStyle.contains("")){
                styleInput = false;
            } else if (inputStyle.equalsIgnoreCase("Nej")||inputStyle.equalsIgnoreCase("None")||inputStyle.equalsIgnoreCase("ingen")){
                setStyle("Ingen");
                styleInput = true;
            }
        }
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
        FileWriter fileWriter = new FileWriter(competiviveFile, true);
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
        Scanner reader = new Scanner(new File(competiviveFile));
        while (reader.hasNext()) {
            String lines = reader.nextLine();
            Member member = new Member();
            member.setDataFromLine(lines);

            MemberList.competitiveList.add(member);
        }
    }


}
