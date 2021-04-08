import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    String[] keyWords = new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;

        findCombinations(digits, result);
        return result;
    }

    private void findCombinations(String digits, List<String> result){

        Queue<String> queue = new LinkedList<>();
        queue.add("");
        while(!queue.isEmpty()){
            String temp = queue.remove();
            if(temp.length() == digits.length()){
                result.add(temp);
            }else{
                String word = keyWords[digits.charAt(temp.length()) - '0'];
                for(char c: word.toCharArray()){
                    queue.add(temp + c);
                }
            }
        }
    }

    public static void main(String[] args) {
        String digits = "25";
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations(digits));
    }
}
