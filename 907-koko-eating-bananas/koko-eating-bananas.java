class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // piles: an array representing the number of bananas in each pile
        // h: the maximum number of hours Koko has to eat all the bananas

        int low = 1; // The minimum possible eating speed is 1 banana per hour.
        int high = 0; // We'll find the maximum pile size to set the upper bound for the eating speed.

        // Find the largest pile size, as Koko can't eat faster than this.
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int result = high; // Initialize the result with the maximum possible eating speed.

        // Binary search to find the minimum eating speed.
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle eating speed. Avoids potential overflow.
            long hours = 0; // Calculate the total hours needed to eat all bananas at the 'mid' speed.

            // Calculate the hours needed for each pile
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // Equivalent to Math.ceil((double)pile / mid). Calculates how many hours it takes for one pile.
                // (pile + mid - 1) / mid is a clever way to round up the division to the nearest integer.
            }

            // Adjust the search range based on the total hours.
            if (hours <= h) {
                // If Koko can eat all the bananas within the allowed hours,
                // try a slower speed (move the high pointer).
                result = mid; // Update the result to the current speed. This could be our answer.
                high = mid - 1; // Try a lower speed, as we're looking for the *minimum* possible speed.
            } else {
                // If Koko needs more than 'h' hours,
                // increase the eating speed (move the low pointer).
                low = mid + 1; // Koko needs to eat faster, so we increase the lower bound of our search.
            }
        }

        return result; // Return the minimum eating speed that allows Koko to finish within 'h' hours.
    }
}