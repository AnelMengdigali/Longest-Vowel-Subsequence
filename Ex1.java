import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result{
    
    static Map< Character, Integer > count = new HashMap<>();
    
    public static int longestVowelSubsequence( String s ){
        
        int result;
        
        char vowels[] = { 'a', 'e', 'i', 'o', 'u' };
        
        for( int i = 0; i < vowels.length; i ++ ){
            
            count.put( vowels[i], 0 );
            
        }
        
        for( int i = 0; i < s.length(); i ++ ){
            
            if( s.charAt(i) == vowels[0] ){
                
                count.put( vowels[0], count.get( vowels[0] ) + 1 );
                
            }
            
            if( s.charAt(i) == vowels[1] && count.get( vowels[0] ) != 0 ){
                
                count.put( vowels[1], Math.max( count.get( vowels[1] ), count.get( vowels[0] ) ) + 1 );
                
            }
            
            if( s.charAt(i) == vowels[2] && count.get( vowels[1] ) != 0 ){
                
                count.put( vowels[2], Math.max( count.get( vowels[2] ), count.get( vowels[1] ) ) + 1 );
                
            }
            
            if( s.charAt(i) == vowels[3] && count.get( vowels[2] ) != 0 ){
                
                count.put( vowels[3], Math.max( count.get( vowels[3] ), count.get( vowels[2] ) ) + 1 );
                
            }
            
            if( s.charAt(i) == vowels[4] && count.get( vowels[3] ) != 0 ){
                
                count.put( vowels[4], Math.max( count.get( vowels[4] ), count.get( vowels[3] ) ) + 1 );
                
            }
            
        }
        
        result = count.get( vowels[4] );
        return result;
        
    }
    
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s = bufferedReader.readLine();
        
        int result = Result.longestVowelSubsequence(s);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
