package menus;

import core.MenuSettings;
import interfaces.MenuRun;
import operations.Chairman;

import java.io.IOException;

/**
 * @Author Malthe, Mohammad og Simon
 */

public class ChairmanMenu implements MenuRun {

  @Override
  public void menuRun() throws IOException {
    MenuRun startMenu = new StartMenu();
    MenuRun chairmanMenu = new ChairmanMenu();
    Chairman chairman = new Chairman();
    String[] menuItem = new String[10];

    menuItem[1] = "Registrer "+"\033[0;1m" + "Motionist Svømmer"+"\033[0;0m";
    menuItem[2] = "Registrer "+"\033[0;1m" + "Konkurrence Svømmer"+"\033[0;0m";
    menuItem[3] = "Se alle "+"\033[0;1m" + "medlemmer"+"\033[0;0m";
    menuItem[4] = "Log Ud";
    menuItem[9] = "Luk programmet";

    MenuSettings menuSettings = new MenuSettings("\nDu er nu logget ind som "+"\033[0;1m" +"Formand"+"\033[0;0m"
        +"\nVenligst vælg en af de "+"\033[0;1m" + "muligheder" +"\033[0;0m"+" forneden"+"\n",
            "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("Registrer en "+"\033[0;1m" + "Motionist Svømmer:"+"\033[0;0m" +"\n");
          try {
            chairman.registerCasual();
          } catch (IOException e) {
            e.printStackTrace();
          }
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("Registrer en "+"\033[0;1m"+"Konkurrence Svømmer:"+"\033[0;0m"+"\n");
          try {
            chairman.registerCompetitive();
          } catch (IOException e) {
            e.printStackTrace();
          }
          chairmanMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
          System.out.println("Se alle "+"\033[0;1m"+"Medlemmer: "+"\033[0;0m"+"\n");
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
          System.out.println("\nDet skal være et tal");
          System.out.println("Prøv igen");
          menuSettings.printMenu();
          choice = menuSettings.readChoice();
          checkChoice = false;
      }
    } while (!checkChoice);
  }
  }

