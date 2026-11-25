package stringproblem;

import org.junit.jupiter.api.DisplayName;

/** Tests solution 1: {@link RemoveCharacter#removeByIteration(String, char)}. */
@DisplayName("Solution 1: removeByIteration")
class RemoveByIterationTest extends RemoveCharacterTestCases {

    @Override
    String remove(String input, char toRemove) {
        return RemoveCharacter.removeByIteration(input, toRemove);
    }
}
