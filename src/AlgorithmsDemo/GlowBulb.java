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
import java.math.BigInteger;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class GlowBulb {
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
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String s=br.readLine();
            Long k=Long.parseLong(br.readLine());
            int oneval[]=new int[s.length()];
            int ind=0;
            long left,right,m,finalout=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    oneval[ind++]=j+1;
                }
            }
            //  ArrayList<Integer> a=new ArrayList<Integer>();
            //  for(int j=0;j<ind;j++){
            //      a.add(j,oneval[j]);
            // }
            left=1L;
            right=Long.MAX_VALUE;
            while (left<=right){
                m=(left+right) >> 1;
                int len = ind;   
                long resvector = 0;
                for(int x=1; x< (1 << len); x++ ){
                    long pos = 1;
                    int neg = -1 ,j=0;
                    while(j<len){
                        if((x>>j)% 2==1){
                            pos*=oneval[j];
                            neg=neg*-1;
                        }
                        j=j+1;
                    }
                    resvector =resvector+ neg*(m/pos);
                }
                if(resvector < k){
                    left = m+1;
                }
                else{
                    finalout = m;
                    right = m-1;
                }
            }
            System.out.println(finalout);            
            // int num=1,c=ind;
            // for(int j=ind;c<k;j++){
            //     for(int m=0;m<ind;m++){
            //         if(num>oneval[m]&num%oneval[m]==0){
            //         //a.add(c,num);
            //         c=c+1;
            //         break;}
            //     }
            //     num=num+1;
            // }
            // Long lo=Long.valueOf(1);
            // if(k<ind){
            // System.out.println(oneval[k.intValue()]);}
            // else{
            // System.out.println(num-1);}
        }
    }
}

