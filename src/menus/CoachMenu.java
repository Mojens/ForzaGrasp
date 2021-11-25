package menus;

import core.MenuSettings;
import interfaces.MenuRun;
import operations.Coach;
import util.MemberList;
import util.TrainingResults;

import java.io.IOException;

/**
 * @Author Malthe, Simon og Mohammad
 */

public class CoachMenu implements MenuRun {
  @Override
  public void menuRun() throws IOException {
    MenuRun startMenu = new StartMenu();
    MenuRun coachMenu = new CoachMenu();
    Coach coach = new Coach();
    String[] menuItem = new String[10];

    menuItem[1] = "Registrer Træningstid";
    menuItem[2] = "Registrer Konkurrence informationer";
    menuItem[3] = "Se top 5 Svømmere";
    menuItem[4] = "Se Medlemdsliste";
    menuItem[5] = "Log Ud";
    menuItem[9] = "Luk programmet";

    MenuSettings menuSettings = new MenuSettings("Venligst vælg en af de muligheder\n",
        "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("Registrer Træningstid: \n");
          coach.recordPractise();
          coachMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("Registrer Konkurrence informationer: \n");
          coach.recordCompetion();
          coachMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
          System.out.println("top 5 Svømmere: \n");
          top5MenuRun();
          checkChoice = true;
          break;
        case 4:
          System.out.println("Medlemdsliste: \n");
          coach.showAllMembers();
          coachMenu.menuRun();
          checkChoice = true;
          break;
        case 5:
          System.out.println("Logger ud \n");
          startMenu.menuRun();
          checkChoice = true;
          break;
        case 9:
          System.out.println("Programmet Lukker ned");
          checkChoice = true;
          break;

        default:
          System.out.println("\nDet skal være et tal");
          System.out.println("Prøv igen");
          menuSettings.printMenu();
          choice = menuSettings.readChoice();
          checkChoice = false;
      }
    } while (!checkChoice);
  }

  public void top5MenuRun() throws IOException{
    String[] menuItem = new String[10];
    Coach coach = new Coach();

    menuItem[1] = "Top 5 - Junior - Crawl";
    menuItem[2] = "Top 5 - Junior - Rygcrawl";
    menuItem[3] = "Top 5 - Junior - Butterfly";
    menuItem[4] = "top 5 - Junior - Brystsvømming";
    menuItem[5] = "Top 5 - Senior - Crawl";
    menuItem[6] = "Top 5 - Senior - Rygcrawl";
    menuItem[7] = "Top 5 - Senior - Butterfly";
    menuItem[8] = "Top 5 - Senior - Brystsvømming";
    menuItem[9] = "Tilbage";

    MenuSettings menuSettings = new MenuSettings("Venligst vælg en af de muligheder\n",
            "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;
    do {
      switch (choice){
      case 1:
        coach.line();
        System.out.println("\u001B[0;1m"+"Crawl"+ "\033[0;0m"  +" Top 5 for Junior: \n");
        System.out.println("\u001B[0;1m" + "Junior Informationer : "+ "\033[0;0m"+"\n");
        coach.showTop5(TrainingResults.jrCrawl);
        coach.line();
        top5MenuRun();
          checkChoice = true;
          break;
        case 2:
          coach.line();
          System.out.println("\u001B[0;1m"+"Rygcrawl"+ "\033[0;0m" +" Top 5 for Junior: \n");
          System.out.println("\u001B[0;1m" + "Junior Informationer : "+ "\033[0;0m"+"\n");
          coach.showTop5(TrainingResults.jrBackstroke);
          top5MenuRun();
          coach.line();
          checkChoice = true;
          break;
        case 3:
          coach.line();
          System.out.println("\u001B[0;1m"+"Butterfly"+ "\033[0;0m" +"Top 5 for Junior: \n");
          System.out.println("\u001B[0;1m" + "Junior Informationer : "+ "\033[0;0m"+"\n");
          coach.showTop5(TrainingResults.jrButterfly);
          coach.line();
          top5MenuRun();
          checkChoice = true;
          break;
        case 4:
          coach.line();
          System.out.println("\u001B[0;1m"+"Brystsvømming"+ "\033[0;0m" + "Top 5 for Junior: \n");
          System.out.println("\u001B[0;1m" + "Junior Informationer : "+ "\033[0;0m"+"\n");
          coach.showTop5(TrainingResults.jrBreaststroke);
          coach.line();
          top5MenuRun();
          checkChoice = true;
          break;
        case 5:
          coach.line();
          System.out.println("\u001B[0;1m"+"Crawl"+ "\033[0;0m" +" Top 5 for Senior: \n");
          System.out.println("\u001B[0;1m" + "Senior Informationer : "+ "\033[0;0m"+"\n");
          coach.showTop5(TrainingResults.seniorCrawl);
          coach.line();
          top5MenuRun();
          checkChoice = true;
          break;
        case 6:
          coach.line();
          System.out.println("\u001B[0;1m"+"Rygcrawl"+ "\033[0;0m" +" Top 5 for Senior: \n");
          System.out.println("\u001B[0;1m" + "Senior Informationer : "+ "\033[0;0m"+"\n");
          coach.showTop5(TrainingResults.seniorBackstroke);
          coach.line();
          top5MenuRun();
          checkChoice = true;
          break;
        case 7:
          coach.line();
          System.out.println("\u001B[0;1m"+"Butterfly"+ "\033[0;0m" +" Top 5 for Senior: \n");
          System.out.println("\u001B[0;1m" + "Senior Informationer : "+ "\033[0;0m"+"\n");
          coach.showTop5(TrainingResults.seniorButterfly);
          top5MenuRun();
          coach.line();
          checkChoice = true;
          break;
        case 8:
          coach.line();
          System.out.println("\u001B[0;1m"+"Brystsvømming"+ "\033[0;0m" +" Top 5 for Senior: \n");
          System.out.println("\u001B[0;1m" + "Senior Informationer : "+ "\033[0;0m"+"\n");
          coach.showTop5(TrainingResults.seniorBreaststroke);
          coach.line();
          top5MenuRun();
          checkChoice = true;
          break;
        case 9:
          coach.line();
          System.out.println("Går tilbage til Træner forside");
          menuRun();
          checkChoice = true;
          break;

        default:
          System.out.println("\nDet skal være et tal");
          System.out.println("Prøv igen");
          menuSettings.printMenu();
          choice = menuSettings.readChoice();
          checkChoice = false;
      }
    } while (!checkChoice);
  }
}

