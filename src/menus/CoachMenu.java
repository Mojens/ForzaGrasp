package menus;

import core.MenuSettings;
import interfaces.MenuRun;
import operations.Coach;
import util.MemberList;

import java.io.IOException;

/**
 * @Author Simon og Mohammad
 */
public class CoachMenu implements MenuRun {
  @Override
  public void menuRun() throws IOException {
    MenuRun startMenu = new StartMenu();
    MenuRun coachMenu = new CoachMenu();
    Coach coach = new Coach();
    MemberList members = new MemberList();
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
          //Indtast metode
          coachMenu.menuRun();
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
          System.out.println("\nDet skal være et tal 1,2,3 eller 9");
          System.out.println("Prøv igen");
          menuSettings.printMenu();
          choice = menuSettings.readChoice();
          checkChoice = false;
      }
    } while (!checkChoice);
  }

  private void toString(MemberList members) {
  }
}

