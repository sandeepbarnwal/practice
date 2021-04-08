import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsIntoBaskets {

    public int totalFruit(int[] tree) {
        if(tree.length <= 2)
            return tree.length;

        int maxFruits = Integer.MIN_VALUE;
        int windowMaxFruits = 0;
        int winStart = 0;
        Map<Integer, Integer> treeFruitsMap = new HashMap<>();

        for(int winEnd = 0; winEnd < tree.length; winEnd++){
            treeFruitsMap.put(tree[winEnd], treeFruitsMap.getOrDefault(tree[winEnd], 0) + 1);
            while(treeFruitsMap.size() > 2){
                treeFruitsMap.put(tree[winStart], treeFruitsMap.get(tree[winStart]) - 1);
                if(treeFruitsMap.get(tree[winStart]) == 0)
                    treeFruitsMap.remove(tree[winStart]);
                windowMaxFruits--;
                winStart++;

            }
            windowMaxFruits++;
            maxFruits = Math.max(maxFruits, windowMaxFruits);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        System.out.println(new FruitsIntoBaskets().totalFruit(new int[]{1,2,1}));
    }
}