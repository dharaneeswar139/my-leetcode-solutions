class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int [] list = new int[nums.length - k + 1 ];
        int ansIndex = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (dq.size() > 0 && dq.peek() < i - k + 1) {
                dq.removeFirst();
            }
            while (dq.size() > 0 && nums[i] > nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                list[ansIndex++]=nums[dq.peekFirst()];

            }
        }
        return list;
    }
}