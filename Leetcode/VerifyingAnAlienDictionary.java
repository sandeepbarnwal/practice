/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charSequenceArray = new int[26];
        int count = 0;
        for(Character c: order.toCharArray()){
            charSequenceArray[c - 'a'] = count;
            count++;
        }

        for(int i =1; i< words.length; i++){
            if(!isSorted(words[i-1], words[i], charSequenceArray))
                return false;
        }
        return true;
    }

    private boolean isSorted(String w1, String w2, int[] charSequenceArray){
        int length = Math.min(w1.length(), w2.length());
        for(int i = 0; i < length; i++){
            if(w2.charAt(i) != w1.charAt(i)){
                return charSequenceArray[w2.charAt(i) - 'a'] > charSequenceArray[w1.charAt(i)- 'a'];
            }
        }
        return w2.length() >= w1.length();
    }

    public static void main(String[] args) {
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}