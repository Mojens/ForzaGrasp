package Menus;

import Core.MenuSettings;
import Interfaces.MenuRun;

/**
 * @Author Mohammad Adel Murtada
 */
public class ChairmanMenu implements MenuRun {

  @Override
  public void menuRun() {
    MenuRun startMenu = new StartMenu();
    MenuRun chairmanMenu = new ChairmanMenu();
    String[] menuItem = new String[10];

    menuItem[1] = "Registrer almindelig Svømmer";
    menuItem[2] = "Registrer Konkurrence Svømmer";
    menuItem[3] = "Log Ud";
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
          //Indtast metode
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("Registrer en Konkurrence svømmer: \n");
          //Indtast metode
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
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

