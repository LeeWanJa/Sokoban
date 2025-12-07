package main.service;

import main.domain.StageSet;
import main.view.printStageSet;

public class PlaySokoban {
    private final String stageInfo;

    public PlaySokoban(String stageInfo) {
        this.stageInfo = stageInfo;
    }

    public void run(){
        // 각 스테이지 별로 데이터 변환
        StageSet stageSet = StageSet.createRefineStages(stageInfo);

        // 데이터 출력
        printStageSet.printStage(stageSet);
    }
}
