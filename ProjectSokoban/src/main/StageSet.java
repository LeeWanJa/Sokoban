package main;

import java.util.ArrayList;

import static main.Stage.returnRefinedStage;

public class StageSet {
    private ArrayList<Stage> stages;

    private StageSet(ArrayList<Stage> stages) {
        this.stages =  stages;
    }

    // 스테이지들을 각각 분류하여, 각 스테이지 정보를 숫자로 변환하고, ArrayList에 담음
    public static StageSet createRefineStages(String stageInfo) {
        String[] stageArr = stageInfo.split("=====");
        ArrayList<Stage> stageSet = new ArrayList<>();

        for(String s : stageArr)
            stageSet.add(returnRefinedStage(s));

        return new StageSet(stageSet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 1;
        for(Stage stage : stages) {
            String order = "Stage " + i++ + "\n";
            sb.append(order).append(stage.toString()).append("\n");
        }

        return sb.toString();
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }
}
