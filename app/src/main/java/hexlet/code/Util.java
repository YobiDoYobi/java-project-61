package hexlet.code;

public class Util {
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 100;

    public static int random(int start, int end) {
        return (int) (Math.random() * end + start);
    }

    public static int random() {
        return random(START_RANGE, END_RANGE);
    }
}
