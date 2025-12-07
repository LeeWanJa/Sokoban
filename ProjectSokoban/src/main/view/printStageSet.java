package main.view;

import main.domain.Stage;
import main.domain.StageSet;

import java.util.ArrayList;

public class printStageSet {
    public static void printStage(StageSet stageSet){
        ArrayList<Stage> stages =  stageSet.getStages();

        for(int i = 0; i < stages.size(); i++){
            Stage stage =  stages.get(i);

            System.out.println("Stage " + (i + 1) + "\n");
            System.out.println(stage.getMapWithString());
            System.out.println("가로크기 : " + stage.getRow());
            System.out.println("세로크기 : " + stage.getCol());
            System.out.println("구멍의 수 : " + stage.getHallNum());
            System.out.println("공의 수 : " + stage.getBallNum());
            System.out.println("플레이어의 위치 : " + stage.getPlayerCoordinate()[0] + "행 "
                    + stage.getPlayerCoordinate()[1] + "열");

            System.out.println("");
        }
    }
}
