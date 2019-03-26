package AlgorithmsDemo;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;
import java.io.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class Comp implements Comparator<String>{
    int k;
    Comp(int x){
        k=x;
    }
    public int compare(String s1,String s2){
        if(Integer.parseInt(s1)%k==Integer.parseInt(s2)%k){
            return Integer.parseInt(s1)-Integer.parseInt(s2);
        }
        else{
            return Integer.parseInt(s2)%k-Integer.parseInt(s1)%k;}
    }
}


public class Sort {
    public static void main(String args[] ) throws Exception {
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
        String a[]=br.readLine().split(" ");
        int n=Integer.parseInt(a[0]);
        int k=Integer.parseInt(a[1]);
        String ar[]=br.readLine().split(" ");
        Arrays.sort(ar,new Comp(k));
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
}

