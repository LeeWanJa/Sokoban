package main;

public class PlaySokoban {
    private final String stageInfo;

    public PlaySokoban(String stageInfo) {
        this.stageInfo = stageInfo;
    }

    public void run(){
        // 각 스테이지 별로 데이터 변환
        RefineStage.createRefineStages(stageInfo);

        // 데이터 출력

    }

    public String getStageInfo(){
        return stageInfo;
    }
}
