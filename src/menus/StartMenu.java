package menus;

import core.MenuSettings;
import interfaces.MenuRun;
import operations.Chairman;
import operations.Coach;

import java.io.IOException;

/**
 * @Author Mohammad og Malthe
 */

public class StartMenu implements MenuRun {

  public void menuRun() throws IOException {
    MenuRun cashierMenu = new CashierMenu();
    MenuRun coachMenu = new CoachMenu();
    MenuRun chairmanMenu = new ChairmanMenu();
    String[] menuItem = new String[10];

    menuItem[1] = "\033[0;1m" + "Kasserer" + "\033[0;0m";
    menuItem[2] = "\033[0;1m" + "Formand" + "\033[0;0m";
    menuItem[3] = "\033[0;1m" + "Træner" + "\033[0;0m";
    menuItem[9] = "Luk programmet";

    MenuSettings menuSettings = new MenuSettings("Velkommen til "+"\033[0;1m" +"Svømmeklubben Delfinen"+"\033[0;0m"
        +"\nVenligst vælg den "+"\033[0;1m" + "bruger"+"\033[0;0m" +" du vil logge ind på"+"\n",
        "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("Du logger ind som "+"\033[0;1m"+"Kasserer"+"\033[0;0m"+"\n");
          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("Du logger ind som "+"\033[0;1m"+"Formand"+"\033[0;0m"+"\n");
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
          System.out.println("Du logger ind som "+"\033[0;1m"+"Træner"+"\033[0;0m"+"\n");
          coachMenu.menuRun();
          checkChoice = true;
          break;
        case 9:
          System.out.println("Du lukker programmet\n");
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