/*
There is an infinite series of bulbs indexed from 1. And there are 40 switches indexed from 1 to 40.
Switch with index x is connected to the bulbs with indexes that are multiple of x. i.e switch 2 is connected to bulb 4, 6, 8 ....
You can easily observe that some bulbs are connected to multiple switches and some are not connected to any switch.
Chotu is playing with these switches, he wants to know the Kth glowing bulb from the start if certain switches are in ON state. 
If any of the switch is ON, connected to any bulb then bulb starts glowing. 
But chotu has special fond of prime numbers so he only puts prime indexed switches ON.
*/
package AlgorithmsDemo;
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.*;
import java.io.*;
import java.math.BigInteger;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class GlowBulb {
    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            Long k = Long.parseLong(br.readLine());
            int oneval[] = new int[s.length()];
            int ind = 0;
            long left, right, m, finalout = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    oneval[ind++] = j + 1;
                }
            }
            //  ArrayList<Integer> a=new ArrayList<Integer>();
            //  for(int j=0;j<ind;j++){
            //      a.add(j,oneval[j]);
            // }
            left = 1 L;
            right = Long.MAX_VALUE;
            while (left <= right) {
                m = (left + right) >> 1;
                int len = ind;
                long resvector = 0;
                for (int x = 1; x < (1 << len); x++) {
                    long pos = 1;
                    int neg = -1, j = 0;
                    while (j < len) {
                        if ((x >> j) % 2 == 1) {
                            pos *= oneval[j];
                            neg = neg * -1;
                        }
                        j = j + 1;
                    }
                    resvector = resvector + neg * (m / pos);
                }
                if (resvector < k) {
                    left = m + 1;
                } else {
                    finalout = m;
                    right = m - 1;
                }
            }
            System.out.println(finalout);
        }
    }
}
