package main;

import java.util.ArrayList;

import static main.Stage.returnRefinedStage;

public class RefineStage {
    private ArrayList<Stage> stages;
    private final String stageInfo;

    private RefineStage(String stageInfo) {
        this.stageInfo = stageInfo;
    }

    // 스테이지들을 각각 분류하여, 각 스테이지 정보를 숫자로 변환하고, ArrayList에 담음
    public static void createRefineStages(String stageInfo) {
        String[] stageArr = stageInfo.split("=====");
        ArrayList<Stage> stageSet = new ArrayList<>();

        for(String s : stageArr){
            stageSet.add(returnRefinedStage(s));
        }

        for(Stage s  : stageSet){
            System.out.println(s.toString());
        }

    }
}
