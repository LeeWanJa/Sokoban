package main;

import java.util.ArrayList;

public class RefineStage {
    private ArrayList<Stage> stages;
    private final String stageInfo;

    private RefineStage(String stageInfo) {
        this.stageInfo = stageInfo;
    }

//    public static RefineStage createRefineStages(String stageInfo) {
//        String[] stageArr = stageInfo.split("=====");
//        ArrayList<Stage> refineStages = new ArrayList<>();
//
//        for(String refineStages : stageArr){
//            newStages.add(Stage.returnRefinedStage(stage));
//        }
//    }
}
