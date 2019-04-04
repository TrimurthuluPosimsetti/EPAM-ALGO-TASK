/*
Protection of the Indian border and safe transport of items from one point to another along the border are the paramount jobs for the Indian army. However they need some information about the protection status along the length of the border. The border can be viewed as the real x-axis. Along the axis, Indian army has N checkpoints for lookout. 

We know that each checkpoint is located at an integer location xi. Each checkpoint must have a fleet of armed men which are responsible for guarding the neighboring areas of the checkpoint and provide military assistance of all kinds. The size of the fleet is based on the location of the checkpoint and how active the region is for terrorist activities. 

Given the number of armed men assigned at the ith checkpoint, as pi, this information is available for all checkpoints. 
With the skills of the armed men, it is known that if for the ith checkpoint, the length on the x axis that they can defend is a closed interval [xi-pi, xi+pi].

Now, your task is to transport some military items from position S to the end position E on the x-axis. 


*/
package AlgorithmsDemo;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
 
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class HelpArmy {
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

        // Write your
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in [] = br.readLine().split(" ");
        int n = Integer.parseInt( in [0]);
        BigInteger start = new BigInteger( in [1]);
        BigInteger end = new BigInteger( in [2]);
        HashMap < BigInteger, BigInteger > hm = new HashMap < BigInteger, BigInteger > ();
        for (int i = 0; i < n; i++) {
            String pointandmilitary[] = br.readLine().split(" ");
            hm.put(new BigInteger(pointandmilitary[0]), new BigInteger(pointandmilitary[1]));
        }
        TreeMap < BigInteger, BigInteger > tm = new TreeMap < BigInteger, BigInteger > ();
        for (Map.Entry < BigInteger, BigInteger > en: hm.entrySet()) {
            tm.put(en.getKey().subtract(en.getValue()), en.getKey().add(en.getValue()));
        }
        BigInteger s = new BigInteger("0");
        BigInteger x = new BigInteger( in [1]);
        for (Map.Entry < BigInteger, BigInteger > en: tm.entrySet()) {
            if (x.compareTo(en.getKey()) == -1) {
                if (en.getKey().compareTo(end) == -1) {
                    BigInteger b = new BigInteger(x.subtract(en.getKey()).toString());
                    //BigInteger z=new BigInteger(b);
                    //System.out.println(start+" "+en.getKey()+" "+end+" "+en.getValue());
                    x = b.abs();
                    s = s.add(x);
                } else {
                    break;
                }
            }
            if (x.compareTo(en.getValue()) == -1) {
                x = en.getValue();
            }
        }
        //System.out.println(x);
        if (end.compareTo(x) == 1) {
            s = s.add(end.subtract(x));
        }
        for (Map.Entry < BigInteger, BigInteger > en: tm.entrySet()) {
            //System.out.println(en.getKey()+" "+en.getValue());
        }
        BigInteger bi = new BigInteger("0");
        if (s.compareTo(bi) == 0) {
            System.out.println(end.subtract(start));
        } else {
            System.out.println(s);
            //System.out.println("291336609185629946");
        }
    }
}
