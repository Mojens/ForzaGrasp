package menus;

import core.MenuSettings;
import interfaces.MenuRun;
import operations.Chairman;

import java.io.IOException;

/**
 * @Author Malthe
 */

public class ChairmanMenu implements MenuRun {

  @Override
  public void menuRun() throws IOException {
    MenuRun startMenu = new StartMenu();
    MenuRun chairmanMenu = new ChairmanMenu();
    Chairman chairman = new Chairman();
    String[] menuItem = new String[10];

    menuItem[1] = "Registrer almindelig Svømmer";
    menuItem[2] = "Registrer Konkurrence Svømmer";
    menuItem[3] = "Se alle medlemmer";
    menuItem[4] = "Log Ud";
    menuItem[9] = "Luk programmet";

    MenuSettings menuSettings = new MenuSettings("Venligst vælg en af de muligheder \n",
        "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("Registrer en almindelig svømmer: \n");
          try {
            chairman.registerCasual();
          } catch (IOException e) {
            e.printStackTrace();
          }
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("Registrer en Konkurrence svømmer: \n");
          try {
            chairman.registerCompetivive();
          } catch (IOException e) {
            e.printStackTrace();
          }
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
          System.out.println("Se alle medlemmer: \n");
          chairman.showAllMembers();
          chairmanMenu.menuRun();
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

