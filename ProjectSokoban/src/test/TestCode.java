package test;

import main.PlaySokoban;
import org.junit.Test;

import java.util.Scanner;

import static main.Main.STAGE_INFO;

public class TestCode {

    @Test
    public void DivideStage(){
        String[] strArr = STAGE_INFO.split("=====");

        for(String stage : strArr)
            System.out.println(stage);
    }
}
