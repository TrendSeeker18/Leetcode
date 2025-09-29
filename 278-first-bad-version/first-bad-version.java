/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        
        while (low <= high) {
            // Refined calculation to prevent integer overflow
            int mid = low + (high - low) / 2; 

            if (isBadVersion(mid)) {
                // mid is bad. It's a possible answer, or the answer is to the left.
                high = mid - 1; 
            } else {
                // mid is good. The answer must be to the right.
                low = mid + 1;
            }
        }
        
        // 'low' will be the index of the first bad version when the search space collapses.
        return low;
    }
}