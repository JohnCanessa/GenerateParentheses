import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * LeetCode 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {


    /**
     * Given n pairs of parentheses, 
     * generate all combinations of well-formed parentheses.
     * Use backtracking.
     * 
     * Runtime: 1 ms, faster than 72.74% of Java online submissions.
     * Memory Usage: 39.5 MB, less than 15.88% of Java online submissions.
     * 
     */
    static public List<String> generateParenthesis0(int n) {
        
        // **** sanity check(s) ****
        if (n == 1)
            return Arrays.asList("()");

        // **** initialization ****
        ArrayList<String> al = new ArrayList<>();

        // **** backtrack ****
        backtrack0(al, "", 0, 0, n);

        // **** return list of parenthesis ****
        return al;
    }


    /**
     * Recursive call.
     */
    static private void backtrack0(List<String> al, String cs, int open, int close, int n) {

        // **** base case (valid pair of parenthesis) ****
        if (cs.length() == n * 2) {
            al.add(cs);
            return;
        }

        // **** decision(s) ****
        if (open < n)
            backtrack0(al, cs + "(", open + 1, close, n);

        if (close < open)
            backtrack0(al, cs + ")", open, close + 1, n);
    }


    /**
     * Given n pairs of parentheses, 
     * generate all combinations of well-formed parentheses.
     * Use backtracking.
     * 
     * Runtime: 1 ms, faster than 72.74% of Java online submissions.
     * Memory Usage: 39 MB, less than 73.93% of Java online submissions.
     */
    static public List<String> generateParenthesis1(int n) {
        
        // **** sanity check(s) ****
        if (n == 1)
            return Arrays.asList("()");

        // **** initialization ****
        List<String> al = new ArrayList<>();

        // **** recursion ****
        backtrack1(al, "", n, n);

        // **** ****
        return al;
    }


    /**
     * Recursive call.
     */
    static private void backtrack1(List<String> al, String cs, int open, int close) {

        // **** base case(s) ****
        if (open < 0 || open > close)
            return;

        if (open == 0 && close == 0) {
            al.add(cs);
            return;
        }

        // **** recursion ****
        backtrack1(al, cs + "(", open - 1, close);
        backtrack1(al, cs + ")", open, close - 1);
    }


    /**
     * Test scaffold.
     * NOT PART OF THE SOLUTION
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the number of pairs of parentheses ****
        int n = Integer.parseInt(br.readLine().trim());

        // **** close the buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** generate and display list ****
        System.out.println("main <<< output: " + generateParenthesis0(n));

        // **** generate and display list ****
        System.out.println("main <<< output: " + generateParenthesis1(n));
    }
}