package menus;

import core.MenuSettings;
import interfaces.MenuRun;
import operations.Cashier;
import operations.Chairman;

import java.io.IOException;

/**
 * @Author Malthe og Mohammad
 */

public class CashierMenu implements MenuRun {
  @Override
  public void menuRun() throws IOException {
    MenuRun startMenu = new StartMenu();
    MenuRun cashierMenu = new CashierMenu();
    Cashier cashier = new Cashier();
    String[] menuItem = new String[10];

    menuItem[1] = "Se "+ "\033[0;1m" +"kommende Indbetalinger"+"\033[0;0m";
    menuItem[2] = "Se "+ "\033[0;1m" +"Restance"+"\033[0;0m";
    menuItem[3] = "Foretag "+"\033[0;1m"+ "indbetaling"+"\033[0;0m";
    menuItem[4] = "Se alle "+"\033[0;1m"+ "medlemmere"+"\033[0;0m";
    menuItem[5] = "Log Ud";
    menuItem[9] = "Luk programmet";

    MenuSettings menuSettings = new MenuSettings("\nDu er nu logget ind som "+"\033[0;1m" +"Kasserer"+"\033[0;0m"
        +"\nVenligst vælg en af de "+"\033[0;1m" + "muligheder" +"\033[0;0m"+" forneden"+"\n",
        "Skriv her: ", menuItem);
    menuSettings.printMenu();

    int choice = menuSettings.readChoice();
    boolean checkChoice;

    do {
      switch (choice) {
        case 1:
          System.out.println("Kommende "+"\033[0;1m" + "Indbetalinger:"+"\033[0;0m" +"\n");
          cashier.forecastRev();
          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 2:
          System.out.println("\nNuværende medlemmer med "+"\033[0;1m" +  "restance:"+"\033[0;0m" +"\n");
          cashier.checkDebt();
          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 3:
          System.out.println("Foretag "+"\033[0;1m" + "Indbetaling:"+"\033[0;0m" +"\n");
          cashier.makePayment();
          cashierMenu.menuRun();
          checkChoice = true;
          break;
        case 4:
          System.out.println("Se alle "+"\033[0;1m" +"Medlemmer: "+"\033[0;0m"+"\n");
          cashier.showAllMembers();
          cashierMenu.menuRun();
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
  }

