package org.example;

import java.util.List;

public class Test2 {

    class Solution {
        public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
            mergeSort(processorTime, 0, processorTime.size() - 1);
            mergeSort(tasks, 0, tasks.size() - 1); // исправлено
            int result = 0;

            int right = tasks.size() - 1;

            for (int time : processorTime) {

                int maxTask = 0;

                for (int i = 0; i < 4; i++) {
                    maxTask = Math.max(maxTask, tasks.get(right--));
                }

                result = Math.max(result, maxTask + time);
            }

            return result;
        }

        private void mergeSort(List<Integer> nums, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(nums, left, mid);
                mergeSort(nums, mid + 1, right);
                merge(left, mid, right, nums);
            }
        }

        private void merge(int left, int mid, int right, List<Integer> nums) {
            int[] temp = new int[right - left + 1];
            int l = left, r = mid + 1, i = 0;

            while (l <= mid && r <= right) { // исправлено
                if (nums.get(l) <= nums.get(r)) {
                    temp[i++] = nums.get(l++);
                } else {
                    temp[i++] = nums.get(r++);
                }
            }

            while (l <= mid) { // исправлено
                temp[i++] = nums.get(l++);
            }

            while (r <= right) {
                temp[i++] = nums.get(r++);
            }

            for (int j = 0; j < temp.length; j++) {
                nums.set(left + j, temp[j]);
            }
        }
    }

}
