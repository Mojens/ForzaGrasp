package Operations;
/**
 * @Author Mohammad og Malthe
 */
import Util.Member;
import Util.MemberList;

import java.util.ArrayList;
import java.util.Scanner;

public class Chairman extends Member {

    public void registerCasual() {
        setToStringStatus(1);
        Scanner input = new Scanner(System.in);
        System.out.println("Type name");
        setName(input.nextLine());

        System.out.println("Type age");
        setAge(Integer.parseInt(input.nextLine()));

        System.out.println("Type if active or passive");
        String statusString = input.nextLine();


        if (statusString.equalsIgnoreCase("Active")) {
            setStatus(statusString);
        } else {
            setStatus(statusString);
        }


        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 60) {
            setAgeGroup("Senior");
        } else {
            setAgeGroup("Pensioner");
        }
        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Pensioner") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1200);
        } else {
            setBalance(-500);
        }

       Member member = new Member(getName(), getAge(), getAgeGroup(), getBalance(), getStatus(),getToStringStatus());
       MemberList.casualList.add(member);
       MemberList.allMembers.add(member);

        for (Member cleaned : MemberList.casualList){

            System.out.println(cleaned.toString());
        }

        System.out.println(getName() + "is now added to the Casuallist");

    } //ArrayListen Tilføjes til fil ved all members

    public void registerCompetivive() {
        setToStringStatus(2);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name: ");
        setName(input.nextLine());

        System.out.println("Enter age: ");
        setAge(Integer.parseInt(input.nextLine()));

        System.out.println("Enter Style: ");
        setStyle(input.nextLine());

        System.out.println("Enter if the person is active or passive");
        setStatus(input.nextLine());

        if (getAge() < 18) {
            setAgeGroup("Junior");
        } else if (getAge() >= 18 && getAge() < 60) {
            setAgeGroup("Senior");
        } else if (getAge() >= 60) {
            setAgeGroup("Pensioner");
        }

        if (getAgeGroup().equalsIgnoreCase("Junior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1000);
        } else if (getAgeGroup().equalsIgnoreCase("Senior") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1600);
        } else if (getAgeGroup().equalsIgnoreCase("Pensioner") && getStatus().equalsIgnoreCase("Active")) {
            setBalance(-1200);
        } else
            setBalance(-500);


        Member member = new Member(getName(), getAge(), getAgeGroup(), getStyle(), getBalance(),getStatus(),getToStringStatus());
        MemberList.competitiveList.add(member);
        MemberList.allMembers.add(member);

        for (Member cleaned : MemberList.competitiveList){

            System.out.println(cleaned.toString());

        }

        System.out.println(getName() + " is now added to the list");
    }   //Den her skal have en fil som deles med træner, så han kan se
        // competivive svømmere

    public void showAllMembers(){
        int counter = 0 ;
        for (int i = 0; i < MemberList.allMembers.size(); i++){
            counter++;
            System.out.println("#"+counter+", " + MemberList.allMembers.get(i));
         }
    } //Den her skal have en fil som deles med Kasseren,
      // så der kan ses restance og indbetales.
}