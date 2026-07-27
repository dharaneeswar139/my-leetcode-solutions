class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int i = -1, j = 0, n = asteroids.length;
        while(j < n) {
            if(i == -1) asteroids[++i] = asteroids[j];
            else if(asteroids[i] > 0 && asteroids[j] < 0) {
                while(i != -1 && j < n && asteroids[i] > 0 && asteroids[j] < 0) {
                    if(asteroids[i] > Math.abs(asteroids[j])) j++;
                    else if(asteroids[i] < Math.abs(asteroids[j])) i--;
                    else {
                        i--;
                        j++;
                    }
                }
                j--;
            } else asteroids[++i] = asteroids[j];
            j++;
        }
        return Arrays.copyOfRange(asteroids, 0, i + 1);
    }
}