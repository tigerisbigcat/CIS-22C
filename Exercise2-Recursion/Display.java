// 22C
// TTh 9:30-11:15
// Name : Lei Hao

package com.company;

public class Display {


//    public class createTriangle {
//        private char stars;
//        private int counter;
//
//        private createTriangle(char star, int count) {
//            stars = star;
//            counter = count;
//        } // end constructor
//    }
    public static void main(String[] args) {
        createTriangle('*', 10);
    }

    public static void createTriangle (char c, int count) {
        if (count <= 0) {
            return;
        }

        createTriangle(c, count - 1);
        for (int x = 1; x <= count; x++) {
            System.out.print(c);
        }
        System.out.print("\n");
    }
}
