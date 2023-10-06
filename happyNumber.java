public class happyNumber {
    class Solution {
        public boolean isHappy(int n) {
            int fast = n;
            int slow = n;
            
            do {
               fast = findSquare(findSquare(fast));
                slow = findSquare(slow);
            } while(fast != slow);
            // when fast = slow, we get a linked list cycle and happy number cannot be found generally as it will keep on going in circles
            
            if (slow == 1) {
                return true;
            }
            return false;
        }
        
        private int findSquare(int no) {
            int ans = 0;
            while (no > 0) {
                int lastDigit = no % 10;
                ans += lastDigit * lastDigit;
                no /= 10;
            }
            
            return ans;
        }
    }
}
