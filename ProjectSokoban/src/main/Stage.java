package main;

public class Stage {
    private int[][] map;

    private Stage(int[][] map) {
        this.map = map;
    }

    public static Stage returnRefinedStage(String stageInfoOrigin){
        return new int[1][1];
    }
}
