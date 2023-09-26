package Solutions;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 */
class Solution647 {
    /**
     * Build a reverse-index array idxMapping[]. idxMapping[idx]  == 1 <--> number "idx" in num[].
     * E.g., idxMapping[3] == 1 <--> There's a number "3" in num[].
     * So the duplicatedNum is the bigger-than-0 index of null value in idxMapping[], since the minimum number in num[] is 1.
     */
    public int[] findErrorNums(int[] nums){
        Integer duplicatedNum = null, missingNum = null;
        Integer[] idxMapping = new Integer[nums.length+1];
        for(int element: nums)
        {
            if( idxMapping[element] == null )
                idxMapping[element] = 1;
            else
                duplicatedNum = element;
        }

        for( int i = 1; i < idxMapping.length; i++ )
        {
            if(idxMapping[i] == null)  missingNum = i;
        }
        if( duplicatedNum == null || missingNum == null )
            ;
//            throw new Exception("Impossible");
            
        return new int[]{duplicatedNum,missingNum};
    }
}
