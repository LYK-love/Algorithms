import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> bracket_char_stack = new Stack<>(); //This stack only stores bracket chars.
        for( int i = 0; i < s.length(); i++ )
        {
            Character new_ch = s.charAt(i);

            if( bracket_char_stack.empty() )
            {
                if(isBracketChar(new_ch))
                    bracket_char_stack.push(new_ch);
            }
            else
            {
                //stack not empty

                char ch_on_top = bracket_char_stack.peek();
                if( bracketIsMatch(ch_on_top, new_ch ))
                    bracket_char_stack.pop();
                else
                {
                    if(isBracketChar(new_ch))
                        bracket_char_stack.push(new_ch);
                }
            }

        }
        boolean res = bracket_char_stack.empty(); //if all brackets are matched, then the stack should be empty
        return res;

    }

    private boolean bracketIsMatch(char left_bracket, char right_bracket )
    {
        return left_bracket == '(' && right_bracket == ')' ||
                left_bracket == '{' && right_bracket == '}' ||
                left_bracket == '[' && right_bracket == ']';
    }

    private boolean isBracketChar(char bracket_ch )
    {
        return bracket_ch == '(' || bracket_ch == ')' ||
                bracket_ch == '{' || bracket_ch == '}' ||
                bracket_ch == '[' || bracket_ch == ']';
    }
}