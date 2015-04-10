import java.util.*;

public class Solution{

   public static void main(String[] args){
      
        String s=args[0];

        int l=lengthOfLongestSubstring(s);

        System.out.println(s+": "+l);
   }

   public static int lengthOfLongestSubstring(String s) {
        
         // p denote the position from where there is no repeated characters
         int p=0;

         // Hashtable, each element is a (character, most recent position pair)
         Hashtable<String, Integer> Dict= new Hashtable<String,Integer>();

         // maximum length
         int max_length=0;

         // current length
         int curr_length;

         for (int i=0; i<s.length(); ++i){
           
             String c=Character.toString(s.charAt(i));

             Integer pre=Dict.get(c);
             
             // if the character c does not appear before, put it into the Hash table
             if (pre==null){
                 Dict.put(c,i);
                 }
             else{
                 // if the previous occurence of c is after p, then there is a repetition
                 if (pre>=p){
                    
                    // the length of the substring from p to i-1
                    curr_length=i-p;

                    // reset p to pre+1
                    p=pre+1;

                    // System.out.println("p is updated to "+p+"; and curr_length="+curr_length);

                    // update maximum length if necessary
                    if (curr_length>max_length) max_length=curr_length;
                 }

                // update Hash table
                Dict.put(c,i);

             }

         }

         // Finally, we need to consider the substring from p to s.length()-1, which has length s.length()-p

        curr_length=s.length()-p;

        if (curr_length>max_length) max_length=curr_length;

        return max_length;
    }

}
