package main.domain;

import java.util.*;

public class Stage {
    private ArrayList<ArrayList<Integer>> map = new ArrayList<>(); // 스테이지 데이터 String -> Integer 변환
    private int row; // 스테이지 가로크기
    private int col; // 스테이지 세로크기
    private int hallNum; // 구멍의 수
    private int ballNum; // 공의 개수
    private int[] playerCoordinate; // 플레이어 위치 // [0]이 y축 - 몇 행 [1]이 x축 - 몇 열

    // 생성자
    private Stage(ArrayList<ArrayList<Integer>> map, int row, int col, int hallNum, int ballNum, int[] playerCoordinate) {
        this.map = map;
        this.row = row;
        this.col = col;
        this.hallNum = hallNum;
        this.ballNum = ballNum;
        this.playerCoordinate = playerCoordinate;
    }

    // 해당 메서드에서 생성자 반환(정적 팩토리 메서드 패턴)
    public static Stage returnRefinedStage(String stageInfoOrigin){
        String[] stageInfoArr = stageInfoOrigin.split("\n");
        ArrayList<ArrayList<Integer>> list = extractMapInfo(stageInfoArr); // 문자열로된 맵 -> 정수로 정제한 맵

        // 나머지 정보 추출 - row/col/hallNum/ballNum/playerCoordinate
        int[] info = extractRemainInfo(list);
        int[] newCoordinate = {info[4], info[5]};

        return new Stage(list, info[0], info[1], info[2], info[3], newCoordinate); // 임시
    }

    // String 스테이지 데이터를 정수 데이터로 변환 -> list에 반환
    private static ArrayList<ArrayList<Integer>> extractMapInfo(String[] stageInfoArr){
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

    // map을 제외한 나머지 정보 추출
    private static int[] extractRemainInfo(ArrayList<ArrayList<Integer>> list) {
        int row = list.size();
        int col = 0; // 가장 길이가 긴 요소의 size
        int hallNum = 0; // 1
        int ballNum = 0; // 2
        int playerX = 0;
        int playerY = 0;

        for(int i = 0; i < list.size(); i++) {
            ArrayList<Integer> oneLine = list.get(i);
            col = Math.max(oneLine.size(), row);

            for(int j =  0; j < oneLine.size(); j++) {
                int intData =  oneLine.get(j);
                if(intData == -1 || intData == 0 || intData == 4)
                    continue;

                switch (intData) {
                    case 1:
                        hallNum++;
                        break;
                    case 2:
                        ballNum++;
                        break;
                    case 3:
                        playerX = j + 1; // 헹
                        playerY = i + 1; // 열
                        break;
                    default:
                        break;
                }
            }
        }

        return new int[]{row, col, hallNum, ballNum, playerY, playerX};
    }

    // Integer로 변환된 스테이지의 맵 정보를 추출할 수 있음
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(ArrayList<Integer> oneLine : map){
            for(Integer integer : oneLine){
                sb.append(integer);
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    // 숫자 데이터로 된 맵 정보
    public ArrayList<ArrayList<Integer>> getMap() {
        return map;
    }

    // 문자열 데이터로 된 맵 정보
    public String getMapWithString(){
        StringBuilder sb = new StringBuilder();

        for(ArrayList<Integer> oneLine : map){
            for(Integer integer : oneLine){
                sb.append(Obstacle.toStr(integer));
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getHallNum() {
        return hallNum;
    }

    public int getBallNum() {
        return ballNum;
    }

    public int[] getPlayerCoordinate() {
        return playerCoordinate;
    }
}
