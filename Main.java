package Assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Timer;

public class Main{
    public static void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in) ;
    System.out.println("copy file path here --> D:\\jortor\\abstract\\java\\Assignment2\\input1.txt");
    System.out.print("Enter file path : ") ;
    String filepath = input.nextLine() ;

    File scan = new File(filepath) ;
    BufferedReader readFile = new BufferedReader(new FileReader(scan)) ;

    String line = "" ;
    int palindrome = 0 ;
    int totalChar = 0 ;
    int emoticon = 0 ;
    int token = 0 ;
    int longestTok = 0 ;
    int lines = 0 ;
    int tokenSize = 0 ;
    HashSet<String> listEmoticons = new HashSet<>();
    listEmoticons.add(":D") ;
    listEmoticons.add(":)") ;
    listEmoticons.add("TvT") ;
    listEmoticons.add("*0*") ;
    listEmoticons.add("XD") ;
    listEmoticons.add(":P") ;


    Timer time = new Timer();
    long startCountTime = System.nanoTime();

    while ((line = readFile.readLine()) != null) {
        totalChar += line.length();
        lines++;
        String[] words = line.split("\\s+");
        for (String word : words) {
            token++;
            palindrome += isPalindrome(word);
            emoticon += isEmoticon(listEmoticons, word);
            tokenSize += word.length();
            longestTok = Math.max(longestTok, word.length());

            }
        }
        
        long endCountTime = System.nanoTime() ;
        long totalTime = (endCountTime - startCountTime) / 1000000 ;
        double second = totalTime / 1000.0 ;
        System.out.println("Total # Character count: " + totalChar) ;
        System.out.println("Total # Palindrome found: " + palindrome ) ; 
        System.out.println("Total Number of tokens: " + token) ; 
        System.out.println("Total Number of emoticon: " + emoticon) ; 
        System.out.println("Total # of new line: " + line) ; 
        System.out.println("The longest token was " + longestTok + " The average token size is " + (tokenSize / token));
        System.out.println("Total time to execute the program: " + second + " secs");
        System.out.println("Program terminated!"); 

        readFile.close() ;
        System.exit(0) ;
        
    }

    public static int isPalindrome(String word) {
        int left = 0 ;
        int right = 0 ;
        while(left < right) {
            if(word.charAt(left) != word.charAt(right)) {
                return 0 ;
            }
            left++ ;
            right-- ;
        }
        return 1 ;
    }

    public static int isEmoticon(HashSet<String> emoticon , String phrase) {
        return emoticon.contains(phrase) ? 1 : 0 ;
    }
}
