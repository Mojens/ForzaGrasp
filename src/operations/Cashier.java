package operations;

import util.Member;
import util.MemberList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author Mohammad og Malthe
 */

public class Cashier extends Member {

private final String allMembersFile = "Files/AllMembers.csv";

  public void forecastRev(){
    double sum = 0;
    for (Member member : MemberList.allMembers) {
      if (member.getAgeGroup().equalsIgnoreCase("Junior") && member.getStatus().equalsIgnoreCase("Aktiv")) {
        sum = sum + 1000;
      }else if (member.getAgeGroup().equalsIgnoreCase("Senior") && member.getStatus().equalsIgnoreCase("Aktiv") && getAge()<=60){
        sum = sum + 1600;
      }else if (member.getAgeGroup().equalsIgnoreCase("Senior") && member.getStatus().equalsIgnoreCase("Aktiv")&&getAge()>60){
        sum = sum + 1600/1.25;
      }else{
        sum = sum + 500;
      }
    }
    System.out.println("\033[0;1m" + "Forventede indtægter dette år: " + "\033[0;0m" + sum + "kr.\n");

  }

  public void checkDebt(){
    System.out.println("\033[0;1m" +"medlemmer, der er i gæld:"+ "\033[0;0m"+"\n");
    int counter = 0;
    for(Member member : MemberList.allMembers){
      counter++;
      if (member.getBalance()<0){
        System.out.println("\033[0;1m" + "#"+counter+ "\033[0;0m"+" "+member);
      }
    }
    double sum = 0;
    for (Member member : MemberList.allMembers) {
      if (member.getBalance()<0)
        sum = sum + member.getBalance();
    }
    System.out.println("\033[0;1m" + "Samlet gældsbeløb: " + "\033[0;0m" + sum + "kr.\n");

  }

  public void makePayment() throws IOException {
    Scanner input = new Scanner(System.in);
    boolean done = true;
    System.out.println("\033[0;1m" + "medlemmer, der er i gæld:" + "\033[0;0m" + "\n");
    System.out.println("\033[0;1m" +"MedlemsID:, Navn:, Alder:, aldersgruppe:, Medlems type:, " +
        "Svømmedisciplin:, Saldo:, Status:"+ "\033[0;0m");
    int counter = -1;
    for (Member member : MemberList.allMembers) {
      counter++;
      if (member.getBalance() < 0) {
        System.out.println("\033[0;1m" + "#" + counter + "\033[0;0m" + " " + member);
      }

      while (done) {
        System.out.println("Skriv MemberID'et på den person du vil indbetale til: ");
        int memberID = input.nextInt();
        System.out.println("Skriv den nye saldo: ");
        double deposit = Double.parseDouble(input.next());
        MemberList.allMembers.get(memberID).setBalance(deposit);
        addToAllMembersFile();
        System.out.println("Er du færdig? ");
        input.nextLine();
        String isDone = input.nextLine();
        if (isDone.equalsIgnoreCase("ja")) {
          done = false;
        } else {
          done = true;
        }
      }

    }
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

  public void addToAllMembersFile() throws IOException {
    FileWriter fileWriter = new FileWriter(allMembersFile, false);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write(MemberList.allMembers.toString().replace("[","").replace("]","").replace("\n, ", "\n"));
    bufferedWriter.close();
    fileWriter.close();
  }

}
