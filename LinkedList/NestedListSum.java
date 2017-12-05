package LinkedList;

/*
Question1 /** * Given a nested list of integers, returns  the sum of all integers in the list weighted by their depth *
For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) *
Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
 */
public class NestedListSum {

    private int getListSum(List<NestedInteger> lni, int depth) {
        int sum = 0;
        NestedInteger ni = null;
        while (lni.hasNext()) {
            ni = lni.next();
            if (ni.isInteger()) sum += ni.getInteger() * depth;
            else sum += getListSum(ni.getList(), depth + 1);
        }
        return sum;
    }

    public int getSum(NestedInteger ni) {
        if (ni.isInteger()) return ni.getInteger();
        else return getListSum(ni.getList(), 1);
    }

}
