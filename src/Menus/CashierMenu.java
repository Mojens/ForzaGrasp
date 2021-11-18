package Menus;

import Core.MenuSettings;
import Interfaces.MenuRun;

/**
 * @Author Simon, Malthe og Mohammad
 */
public class CashierMenu implements MenuRun {
  @Override
  public void menuRun() {
    MenuRun startMenu = new StartMenu();
    MenuRun cashierMenu = new CashierMenu();
    String[] menuItem = new String[10];

    menuItem[1] = "Se kommende Indbetalinger";
    menuItem[2] = "Se Restance";
    menuItem[3] = "Foretag indbetaling";
    menuItem[4] = "Log Ud";
    menuItem[9] = "Luk programmet";

    MenuSettings menuSettings = new MenuSettings("Venligst vælg en af de muligheder\n",
        "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("Kommende Indbetalinger: \n");
          //Indtast metode
          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("Nuværende medlemmer med restance: \n");
          //Indtast metode
          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
          System.out.println("Foretag Indbetaling: \n");
          //Indtast metode
          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 4:
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
  }

