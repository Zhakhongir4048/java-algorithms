package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BacktrackingTemplate {

    public static void main(String[] args) {
        List<List<Integer>> list = permuteUnique(new int[]{1, 1, 2});
        System.out.println(list);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num)) counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> solution = new LinkedList<>();
        backtracking(solution, counter, nums.length, results);
        return results;
    }

    /**
     * Основной метод backtracking
     *
     * @param solution - текущий путь/частичное решение
     * @param options  - доступные варианты на данном шаге
     */
    private static void backtracking(LinkedList<Integer> solution,
                                     HashMap<Integer, Integer> options,
                                     Integer n,
                                     List<List<Integer>> results) {
        if (isSolution(solution, n)) {
            processSolution(solution, results);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : options.entrySet()) {
            Integer option = entry.getKey();
            Integer count = entry.getValue();
            if (!isValid(count)) continue;

            solution.addLast(option);
            options.put(option, count - 1);

            backtracking(solution, options, n, results);

            solution.removeLast(); // откат
            options.put(option, count);
        }
    }

    /**
     * Проверка, можно ли добавить текущий вариант
     */
    private static boolean isValid(Integer count) {
        return count != 0;
    }

    /**
     * Обработка найденного решения
     */
    private static void processSolution(List<Integer> solution, List<List<Integer>> result) {
        result.add(new ArrayList<>(solution)); // создаем новый список
    }

    /**
     * Проверка, является ли текущее решение полным
     *
     * @param solution - решение
     * @return true, если достигли полного решения
     */
    private static boolean isSolution(List<Integer> solution, Integer n) {
        return solution.size() == n;
    }

}
