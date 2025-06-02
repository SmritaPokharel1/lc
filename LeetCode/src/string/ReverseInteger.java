package string;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/
public class ReverseInteger {

    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;

    public int reverse(int x ){

        int result = 0;

        while (x != 0) {

            int digit = x % 10;

            x /= 10;

            if (result > max / 10 || (result == max / 10 && digit > 7))  return 0;

            if (result < min / 10 || (result == min / 10 && digit < -8))  return 0;

            result = result * 10 + digit;
        }

        return result;
    }

}
