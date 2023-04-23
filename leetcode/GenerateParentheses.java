public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        placeParentheses(n, n, new char[n+n], 0, result);
        return result;
    }
    
    private void placeParentheses(int left, int right, char[] cs, int pos, ArrayList<String> result) {
        if (right == 0) {
            result.add(new String(cs));
            return;
        }
        if (left == right) {
            cs[pos] = '(';
            placeParentheses(left-1, right, cs, pos+1, result);
        } else if (left == 0) {
            cs[pos] = ')';
            placeParentheses(left, right-1, cs, pos+1, result);
        } else {
            cs[pos] = '(';
            placeParentheses(left-1, right, cs, pos+1, result);
            cs[pos] = ')';
            placeParentheses(left, right-1, cs, pos+1, result);
        }
    }
}
