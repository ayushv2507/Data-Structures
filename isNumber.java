public class isNumber {
    public boolean isNumber(String s) {
        boolean signOccured = false;
        boolean dotOccured = false;
        boolean started = false;

        s = s.trim();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '+':
                case '-':
                    if (started || signOccured || dotOccured) {
                        return false;
                    } else {
                        signOccured = true;
                    }
                    break;
                case (char) ('0' - '9'):
                    started = true;
                    break;
                case '.':
                    if (dotOccured) {
                        return false;
                    } else {
                        dotOccured = true;
                    }
                default:
                    return false;
            }
        }
        return true;
    }
}
