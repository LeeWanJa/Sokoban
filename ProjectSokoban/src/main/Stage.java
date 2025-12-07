package main;

import java.util.*;

public class Stage {
    private ArrayList<ArrayList<Integer>> map = new ArrayList<>(); // 스테이지 데이터 String -> Integer 변환
    private int row; // 스테이지 가로크기
    private int col; // 스테이지 세로크기
    private int ballNum; // 공의 개수
    private int[] playerCoordinate; // 플레이어 위치

    // 생성자
    private Stage(ArrayList<ArrayList<Integer>> map, int row, int col, int ballNum,  int[] playerCoordinate) {
        this.map = map;
        this.row = row;
        this.col = col;
        this.ballNum = ballNum;
        this.playerCoordinate = playerCoordinate;
    }

    // 해당 메서드에서 생성자 반환(정적 팩토리 메서드 패턴)
    public static Stage returnRefinedStage(String stageInfoOrigin){
        String[] stageInfoArr = stageInfoOrigin.split("\n");
        ArrayList<ArrayList<Integer>> list = refineIntStage(stageInfoArr); // 문자열로된 맵 -> 정수로 정제한 맵

        return new Stage(list, 1, 1, 1, new int[2]); // 임시
    }

    // String 스테이지 데이터를 정수 데이터로 변환 -> list에 반환
    private static ArrayList<ArrayList<Integer>> refineIntStage(String[] stageInfoArr){
        ArrayList<ArrayList<Integer>> resultIntStage = new ArrayList<>();

        for (String s : stageInfoArr) {
            String[] sArr = s.split(""); // n번째 줄
            ArrayList<Integer> oneLine = new ArrayList<>();

            boolean isStage = true; // 중간에 -1, 즉 Obstacle 필드에 해당하지 않는 데이터를 만나면 추가하지 않음
            for (String string : sArr) {
                int strToInt = Obstacle.toInt(string); // n번째 줄에 있는 문자열 하나하나 체크

                if (strToInt == -1) {
                    isStage = false;
                    break;
                }

                oneLine.add(strToInt);
            }

            if (!isStage)
                continue;

            resultIntStage.add(oneLine);
        }

        return resultIntStage;
    }
}
