public class BadRevision {

    static boolean hasBug(int revision){
        return false;
    }
    public static void main(String[] args){
        findBadRevision(1,7);
    }

    static int findBadRevision(int goodRevision, int badRevision) {
        while (true) {
            int mid = (goodRevision + badRevision) / 2;
            if (hasBug(mid)) {
                if (mid == 0 || !hasBug(mid-1)) {
                    return mid;
                }
                badRevision = mid-1;
            } else {
                goodRevision = mid+1;
            }
        }
    }
}
