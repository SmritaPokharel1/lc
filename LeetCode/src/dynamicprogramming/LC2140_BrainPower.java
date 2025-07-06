package dynamicprogramming;

/**
 *
 * You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
 *
 * The array describes the questions of an exam, where you have to process the questions in order
 * (i.e., starting from question 0) and make a decision whether to solve or skip each question.
 * Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions.
 * If you skip question i, you get to make the decision on the next question.
 *
 * For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 * If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
 * If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
 * Return the maximum points you can earn for the exam.
 *
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC2140_BrainPower {

    public long mostPoints(int[][] questions) {
        int[] memo = new int[questions.length];
        return bottomup(questions);
    }

    public int solve(int[][] questions, int index, int[] memo){

        if(index >= questions.length) return 0;

        if(memo[index] !=0) return memo[index];

        int take = questions[index][0] + solve(questions, index + questions[index][1] +1, memo);
        int skip = solve(questions, index+1, memo);

        memo[index] = Math.max(take,skip);

        return memo[index];
    }

    public long bottomup(int[][] questions){

        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int points = questions[i][0];
            int brainpower = questions[i][1];

            int next = brainpower + i + 1;

            long take = points + (next <= n ? dp[next] : 0);
            long skip = dp[i+1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}
