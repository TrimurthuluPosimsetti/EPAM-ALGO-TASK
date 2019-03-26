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
 
        // Write your
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[]=br.readLine().split(" ");
        int n=Integer.parseInt(in[0]);
        BigInteger start=new BigInteger(in[1]);
        BigInteger end=new BigInteger(in[2]);
        HashMap<BigInteger,BigInteger> hm=new HashMap<BigInteger,BigInteger>();
        for(int i=0;i<n;i++){
            String pointandmilitary[]=br.readLine().split(" ");
            hm.put(new BigInteger(pointandmilitary[0]),new BigInteger(pointandmilitary[1]));
        }
        TreeMap<BigInteger,BigInteger> tm=new TreeMap<BigInteger,BigInteger>();
        for(Map.Entry<BigInteger,BigInteger> en:hm.entrySet()){
            tm.put(en.getKey().subtract(en.getValue()),en.getKey().add(en.getValue()));
        }
        BigInteger s=new BigInteger("0");
        BigInteger x=new BigInteger(in[1]);
        for(Map.Entry<BigInteger,BigInteger> en:tm.entrySet()){
            if(x.compareTo(en.getKey())==-1){
                if(en.getKey().compareTo(end)==-1){
                BigInteger b=new BigInteger(x.subtract(en.getKey()).toString());
                //BigInteger z=new BigInteger(b);
                //System.out.println(start+" "+en.getKey()+" "+end+" "+en.getValue());
                x=b.abs();
                s=s.add(x);}
                else{
                    break;
                }
            }
            if(x.compareTo(en.getValue())==-1){
                x=en.getValue();            
            }
        }
        //System.out.println(x);
        if(end.compareTo(x)==1){
            s=s.add(end.subtract(x));
        }
        for(Map.Entry<BigInteger,BigInteger> en:tm.entrySet()){
            //System.out.println(en.getKey()+" "+en.getValue());
        }
        BigInteger bi=new BigInteger("0");
        if(s.compareTo(bi)==0){
            System.out.println(end.subtract(start));
        }
        else{
        System.out.println(s);
            //System.out.println("291336609185629946");
        }
    }
}
