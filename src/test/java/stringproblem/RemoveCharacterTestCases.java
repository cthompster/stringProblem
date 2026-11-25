package stringproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * The cases every solution must pass. Each solution has its own test class that extends this
 * one and says which method to call, so both are checked against exactly the same cases.
 */
abstract class RemoveCharacterTestCases {

    /** Calls the solution under test. */
    abstract String remove(String input, char toRemove);

    // ---------- Positive cases: the character is there and every instance goes ----------

    static Stream<Arguments> removesEveryInstance() {
        return Stream.of(
                Arguments.of("my secret message", 'm', "y secret essage"),
                Arguments.of("banana", 'a', "bnn"),
                Arguments.of("apple", 'a', "pple"),                   // first character
                Arguments.of("hello", 'o', "hell"),                   // last character
                Arguments.of("bookkeeper", 'e', "bookkpr"),           // consecutive repeats
                Arguments.of("aaaa", 'a', ""),                        // only that character
                Arguments.of("x", 'x', ""),                           // single character
                Arguments.of("my secret message", ' ', "mysecretmessage"), // spaces
                Arguments.of("a.b.c", '.', "abc"),                    // regex metacharacter
                Arguments.of("price: $5 $10", '$', "price: 5 10"),
                Arguments.of("café", 'é', "caf"));                    // non-ASCII
    }

    @ParameterizedTest(name = "remove(\"{0}\", ''{1}'') = \"{2}\"")
    @MethodSource("removesEveryInstance")
    @DisplayName("removes every instance of the character")
    void removesEveryInstance(String input, char toRemove, String expected) {
        assertEquals(expected, remove(input, toRemove));
    }

    // ---------- Negative cases: nothing to remove, or invalid input ----------

    static Stream<Arguments> leavesStringUnchanged() {
        return Stream.of(
                Arguments.of("hello", 'z'),        // character not present
                Arguments.of("Hello", 'h'),        // case-sensitive: 'h' is not 'H'
                Arguments.of("HELLO", 'l'),
                Arguments.of("", 'a'),             // empty string
                Arguments.of("   ", 'x'));         // whitespace only
    }

    @ParameterizedTest(name = "remove(\"{0}\", ''{1}'') is unchanged")
    @MethodSource("leavesStringUnchanged")
    @DisplayName("returns the same text when the character isn't there")
    void leavesStringUnchanged(String input, char toRemove) {
        assertEquals(input, remove(input, toRemove));
    }

    @Test
    @DisplayName("rejects a null string")
    void rejectsNull() {
        NullPointerException e = assertThrows(NullPointerException.class, () -> remove(null, 'a'));
        assertEquals("input must not be null", e.getMessage());
    }
}
