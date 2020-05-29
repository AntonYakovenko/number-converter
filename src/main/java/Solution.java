import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public String convert(final Integer source) {
        Deque<Integer> digits = splitIntoDigits(source);

        return buildResult(digits);
    }

    private Deque<Integer> splitIntoDigits(final int number) {
        int copy = number;
        Deque<Integer> digits = new LinkedList<>();
        while (copy > 0) {
            int digit = copy % 10;
            if (digit < 1 || digit > 7) {
                throw new IllegalArgumentException(String.format("Digit must be in range 1..7. Got %d", digit));
            }
            digits.addFirst(digit);
            copy = copy / 10;
        }
        return digits;
    }

    private String buildResult(final Deque<Integer> digits) {
        StringBuilder result = new StringBuilder();
        boolean isSequenceStarted = false;

        if (digits.size() == 1) {
            return result.append(digits.peek()).toString();
        }

        while (digits.size() > 1) {
            int curr = digits.remove();
            int next = digits.getFirst();
            int diff = next - curr;

            if (diff < 1) {
                throw new IllegalArgumentException(String.format("Illegal digits order: %d after %d", next, curr));
            }

            boolean isConsecutive = diff == 1;

            if (isConsecutive && !isSequenceStarted) {
                isSequenceStarted = true;
                result.append(curr);
            }
            if (isConsecutive && isSequenceStarted) {
                if (digits.size() == 1) { // check last
                    result.append("-").append(next);
                }
            }
            if (!isConsecutive && !isSequenceStarted) {
                result.append(curr).append(",");
                if (digits.size() == 1) { // check last
                    result.append(next);
                }
            }
            if (!isConsecutive && isSequenceStarted) {
                isSequenceStarted = false;
                result.append("-").append(curr).append(",");
                if (digits.size() == 1) { // check last
                    result.append(next);
                }
            }
        }

        return result.toString();
    }

}
