import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/combination-sum/
*/
 public class CombinationSum {
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> resultList = new ArrayList<>();
            findCombination(resultList, new ArrayList<>(), candidates, candidates.length - 1, target);
            return resultList;
        }

        private static void findCombination(List<List<Integer>> resultList, List<Integer> currentList, int[] candidates,
                                            int currentIndex, int target) {
            if(target == 0) {
                resultList.add(new ArrayList<>(currentList));
                return;
            }
            if (currentIndex < 0 || target < 0)
                return;
            currentList.add(candidates[currentIndex]);
            findCombination(resultList, currentList, candidates, currentIndex, target - candidates[currentIndex]);
            currentList.remove(currentList.size() - 1);
            findCombination(resultList, currentList, candidates, currentIndex - 1, target);
        }

        public static void main(String[] args) {
            System.out.println(combinationSum(new int[] {2,2,3,7}, 7));
        }
    }
