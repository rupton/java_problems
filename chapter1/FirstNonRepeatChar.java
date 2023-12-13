package chapter1;
import java.util.Map;
import java.util.LinkedHashMap;

public class FirstNonRepeatChar {
    private static final int EXTENDED_ASCII_CODES = 256;

    public void printArray(int[] values){
        for(int value: values){
            System.out.print(value +", ");
        }
        System.out.print("\n");
    }
    public char firstNonRepeatedCharacterArray(String str){
        int[] flags = new int[EXTENDED_ASCII_CODES];
        //initialize the flags array
        for(int i = 0; i < EXTENDED_ASCII_CODES; i++){
            flags[i] = -1;
        }
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(flags[ch] == -1){
                flags[ch] = i;
            }else{
                flags[ch] = -2;
            }
        }
        printArray(flags);
        //return the smallest value in the flags array as the position
        int position = Integer.MAX_VALUE;
        for(int i = 0; i < EXTENDED_ASCII_CODES; i++){
            if(flags[i] >=0 ){
                position = Math.min(position, flags[i]);
            }
        }
        if(position == Integer.MAX_VALUE){
            return Character.MIN_VALUE;
        }else{
            return str.charAt(position);
        }
        
    }
    public char firstNonRepeatedCharacterMap(String str){
        Map<Character, Integer>chars = new LinkedHashMap<>();
        for(Character character : str.toCharArray()){
            chars.compute(character, (k, v)-> (v == null)? 1: ++v);
        }

        for(Map.Entry<Character, Integer> entry: chars.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }
    public static void main(String[] args) {
        FirstNonRepeatChar firstNonRepeat = new FirstNonRepeatChar();
        //char result = firstNonRepeat.firstNonRepeatedCharacterMap("aaaabbtttzzz");
        //System.out.println("The first non-repeating character is " + result);
        char result = firstNonRepeat.firstNonRepeatedCharacterArray("aacabbvtttrzzzg");
        System.out.println("The first non-repeating character is " + result);
    }
}
