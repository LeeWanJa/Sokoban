package test;

import java.util.*;
import main.domain.Obstacle;
import org.junit.Test;


import static main.Main.STAGE_INFO;

public class TestCode {

    @Test
    public void returnRefinedStageTest(){
        String[] strArr = STAGE_INFO.split("=====");
        String[] stage1 = strArr[1].split("\n");
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        System.out.println(strArr[1]);

        int col = 0;
        int row = 0;
        int[] coordinates = new int[2];
        for(int i = 0; i < stage1.length; i++){
            String[] s = stage1[i].split("");
            ArrayList<Integer> oneLine = new ArrayList<>();

            int j;
            boolean isStage = true; // 게임 안 인지 아닌지 판별
            for(j = 0; j < s.length; j++) {
                int strToInt = Obstacle.toInt(s[j]);

                if(strToInt == -1){
                    isStage = false;
                    break;
                }

                oneLine.add(Obstacle.toInt(s[j]));
            }

            if(!isStage)
                continue;

            col = Math.max(j, col);
            list.add(oneLine);
        }
        row = list.size();
        System.out.println(row + " " + col);

        for(ArrayList<Integer> l : list){
            System.out.println(l);
        }
        System.out.println(coordinates[0] + " " + coordinates[1]);
    }
}
