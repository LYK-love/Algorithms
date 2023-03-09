class Solution5 {
    /**
     * use two-pointer traversal to speed up the time.
     * For palindromes scanning, we need to make pointers start from the middle of the string
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        String longest_palindrome = "";

        for(int i =0; i < s.length(); i++ )
        {
            //for string with odd length, the begin pointer is just the middle index
            String longest_odd_palindrome = getLongestPalindrome(s, i, i);

            //for string with even length, the begin pointer is just the two middle indexes
            String longest_even_palindrome = getLongestPalindrome(s, i, i+1);
            
            longest_palindrome = longest_odd_palindrome.length() > longest_palindrome.length() ? longest_odd_palindrome : longest_palindrome;
            longest_palindrome = longest_even_palindrome.length() > longest_palindrome.length() ? longest_even_palindrome : longest_palindrome;
        }
        return longest_palindrome;

        
    }

    /**
     * Get the longest palindromic substring, with the given start indexes.
     * We use two pointers, each for one direction, to scan the given string. When one pointer end, the other must end too, and the substring
     * between the two pointers is the longest palindromic substring.
     * @param s
     * @param left start pointer to scan towards left.
     * @param right start pointer to scan towards right.
     * @return
     */
    private String getLongestPalindrome(String s, int left, int right)
    {
        //invalid index or the substring is not palindromic(e.g. "cb" in "cbbc" )
        // just return ""
        if(!two_pointers_valid(s, left, right) || ( s.charAt(left) != s.charAt(right) ) )
            return "";
        
        while( two_pointers_valid(s, left, right)) 
        {
            //try to move the pointer
            left--;
            right++;

            //this move fails due to invalid index or the substring is not palindromic
            if( !two_pointers_valid(s, left, right) || ( s.charAt(left) != s.charAt(right) ))
            {
                //recover from the move
                left++;
                right--;
                break;
            }
            else
            {
                ;
            }
            
        }
        return s.substring(left, right+1);
    }

    /**
     * judge if the given two pointers refer to the valid indexs
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean two_pointers_valid(String s, int left, int right)
    {
        return left >= 0 && right < s.length();
    }

    public static void main(String[] args)
    {
        Solution5 solution = new Solution5();
        String s = "cbbd";
    
        System.out.println(solution.longestPalindrome(s));
    }

}
