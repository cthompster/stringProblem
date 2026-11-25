package stringproblem;

import java.util.Objects;

/**
 * Removes every instance of a character from a string, solved two ways.
 *
 * <p>Both methods are case-sensitive and return a new string; the input is never changed.
 * A {@code null} input is rejected with a {@link NullPointerException}.
 */
public final class RemoveCharacter {

    private RemoveCharacter() {
    }

    /**
     * Solution 1: walks through the string one character at a time and keeps every
     * character that isn't {@code toRemove}.
     *
     * @param input    the string to clean, not {@code null}
     * @param toRemove the character to remove
     * @return {@code input} without any {@code toRemove} characters
     * @throws NullPointerException if {@code input} is {@code null}
     */
    public static String removeByIteration(String input, char toRemove) {
        Objects.requireNonNull(input, "input must not be null");
        StringBuilder result = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current != toRemove) {
                result.append(current);
            }
        }
        return result.toString();
    }

    /**
     * Solution 2: one line with {@link String#replace(CharSequence, CharSequence)}, which
     * replaces every occurrence (not just the first) with an empty string.
     *
     * @param input    the string to clean, not {@code null}
     * @param toRemove the character to remove
     * @return {@code input} without any {@code toRemove} characters
     * @throws NullPointerException if {@code input} is {@code null}
     */
    public static String removeWithReplace(String input, char toRemove) {
        return Objects.requireNonNull(input, "input must not be null").replace(String.valueOf(toRemove), "");
    }

    /** Small demo that prints both solutions for one message. */
    public static void main(String[] args) {
        String message = "my secret message";
        char toRemove = 'm';
        System.out.println("Original:       " + message);
        System.out.println("By iteration:   " + removeByIteration(message, toRemove));
        System.out.println("With replace(): " + removeWithReplace(message, toRemove));
    }
}
