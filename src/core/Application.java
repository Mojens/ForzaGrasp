package core;

/**
 * @Author Malthe og Mohammad
 */

import interfaces.MenuRun;
import menus.StartMenu;
import operations.Chairman;
import operations.Coach;
import util.CompetitionResults;
import util.TrainingResults;

import java.io.IOException;

public class Application {
  public static void main(String[] args) throws IOException {
    MenuRun startPage = new StartMenu();
    Chairman chairman = new Chairman();
    Coach coach = new Coach();

    chairman.loadFromAllMemberfileToAllMembersList();
    chairman.loadFromCompetitionListToAllCompetitionList();

    coach.loadAllPracticeInfo(Coach.allPracticeTimes, TrainingResults.allPracticesTimes);
    coach.loadAllCompetitionInfo(Coach.allCompetitionTimes, CompetitionResults.competitionList);

    coach.loadAllPracticeInfo(Coach.jrButterfly, TrainingResults.jrButterfly);
    coach.loadAllPracticeInfo(Coach.jrBackstroke, TrainingResults.jrBackstroke);
    coach.loadAllPracticeInfo(Coach.jrCrawl, TrainingResults.jrCrawl);
    coach.loadAllPracticeInfo(Coach.jrbreaststroke, TrainingResults.jrBreaststroke);

    coach.loadAllPracticeInfo(Coach.seniorButterfly, TrainingResults.seniorButterfly);
    coach.loadAllPracticeInfo(Coach.seniorBackstroke, TrainingResults.seniorBackstroke);
    coach.loadAllPracticeInfo(Coach.seniorCrawl, TrainingResults.seniorCrawl);
    coach.loadAllPracticeInfo(Coach.seniorbreaststroke, TrainingResults.seniorBreaststroke);

    coach.loadAllCompetitionInfo(Coach.jrButterflyComp, CompetitionResults.jrButterfly);
    coach.loadAllCompetitionInfo(Coach.jrBackstrokeComp, CompetitionResults.jrBackstroke);
    coach.loadAllCompetitionInfo(Coach.jrCrawlComp, CompetitionResults.jrCrawl);
    coach.loadAllCompetitionInfo(Coach.jrbreaststrokeComp, CompetitionResults.jrBreaststroke);

    coach.loadAllCompetitionInfo(Coach.seniorButterflyComp, CompetitionResults.seniorButterfly);
    coach.loadAllCompetitionInfo(Coach.seniorBackstrokeComp, CompetitionResults.seniorBackstroke);
    coach.loadAllCompetitionInfo(Coach.seniorCrawlComp, CompetitionResults.seniorCrawl);
    coach.loadAllCompetitionInfo(Coach.seniorbreaststrokeComp, CompetitionResults.seniorBreaststroke);

    startPage.menuRun();


  }
}
