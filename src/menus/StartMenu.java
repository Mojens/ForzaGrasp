package menus;

import core.MenuSettings;
import interfaces.MenuRun;
import operations.Chairman;

import java.io.IOException;

/**
 * @Author Mohammad og Malthe
 */

public class StartMenu implements MenuRun {

  public void menuRun() throws IOException {
    MenuRun cashierMenu = new CashierMenu();
    MenuRun coachMenu = new CoachMenu();
    MenuRun chairmanMenu = new ChairmanMenu();
    Chairman chairman = new Chairman();
    String[] menuItem = new String[10];

    menuItem[1] = "Kasserer";
    menuItem[2] = "Formand";
    menuItem[3] = "Træner";
    menuItem[9] = "Luk programmet";

    MenuSettings menuSettings = new MenuSettings("Venligst vælg den bruger " +
        "du vil logge ind på", "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("Du logger ind som Kasserer\n");

          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("Du logger ind som Formand\n");
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
          System.out.println("Du logger ind som Træner\n");
          coachMenu.menuRun();
          checkChoice = true;
          break;
        case 9:
          System.out.println("Du lukker programmet\n");
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
}