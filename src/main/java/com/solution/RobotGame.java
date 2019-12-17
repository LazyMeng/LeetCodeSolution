package com.solution;

public class RobotGame {
    public static void main(String args[]) {
        int[][] ob = {{4,5}};
        System.out.println(ob[0][0]);
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        int c= -1,d=-1;
        if (obstacles.length>0) {
            c = obstacles[0][0]+1;
            d = obstacles[0][1]+1;
        }
        int a = 0, b = 0;
        for (int i = 0; ; i++) {
            if (a == c && b == d)
                return false;
            if (command.substring(i, i + 1).equals("U")) {
                a++;
            } else {
                b++;
            }

            if (a == x && b == y)
                return true;
            if(i == command.length() -1){
                i = 0;}
        }

    }
}
