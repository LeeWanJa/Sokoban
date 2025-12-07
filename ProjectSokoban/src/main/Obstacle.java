package main;

public enum Obstacle {
    // 장애물 종류 (문자열, 정수) 쌍으로 상수 정의
    BLANK(" ", 0),
    HALL("o", 1),
    BALL("O", 2),
    PLAYER("P", 3),
    WALL("#", 4);

    private final String inputObstacle;
    private final int obstacleCode;

    Obstacle(String inputObstacle, int obstacleCode) {
        this.inputObstacle = inputObstacle;
        this.obstacleCode = obstacleCode;
    }

    // 문자열이 들어오면 대응되는 정수 반환
    public static int toInt(String input){
        for(Obstacle o : Obstacle.values()){
            if(o.inputObstacle.equals(input))
                return o.obstacleCode;
        }

        // 정의되지 않은 입력은 무시
        return -1;
    }

    // 정수가 들어오면 대응되는 문자열 반환
    public static String toStr(int input){
        for(Obstacle o : Obstacle.values()){
            if(o.obstacleCode == input)
                return o.inputObstacle;
        }

        return "";
    }
}
