package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String STAGE_INFO = "Stage 1\n" +
            "#####\n" +
            "#OoP#\n" +
            "#####\n" +
            "=====\n" +
            "Stage 2\n" +
            "  #######\n" +
            "###  O  ###\n" +
            "#    o    #\n" +
            "# Oo P oO #\n" +
            "###  o  ###\n" +
            " #   O  # \n" +
            " ########";

    public static void main(String[] args) {
        PlaySokoban playSokoban = new PlaySokoban(STAGE_INFO);
        //playSokoban.run();


    }
}
