package chapter1;
import java.util.Map;
import java.util.HashMap;

public class DuplicateCharacters {

    public Map<Character, Integer> countHelper(String string){
        Map<Character, Integer> result = new HashMap<>();
        for(Character character: string.toCharArray()){
            result.compute(character, (k, v)-> (v == null)? 1: ++v);
        }
        return result;
    }
    public static void main(String[] args) {
        DuplicateCharacters dupeCount = new DuplicateCharacters();
        String testString = "nnnabcfghhh";
        Map<Character, Integer> duplicates = dupeCount.countHelper(testString);
        duplicates.forEach((key, value)->System.out.println(key +": " + value));
    }
}