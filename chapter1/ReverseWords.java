package chapter1;

public class ReverseWords {

   private static final String WHITESPACE = " ";

   public String reverseWords(String words){
      String[] splitWords = words.split(WHITESPACE);
      StringBuilder reversedString = new StringBuilder();
      for(String word: splitWords){
         StringBuilder reversedWord = new StringBuilder();
         for(int i = word.length() -1; i >= 0; i--){
            reversedWord.append(word.charAt(i));
         }
         reversedString.append(reversedWord);
      }
      return reversedString.toString();
   }
   public static void main(String[] args) {
    ReverseWords revWords = new ReverseWords();
    System.out.println(revWords.reverseWords("Hello, World. How are you?"));
   } 
}
