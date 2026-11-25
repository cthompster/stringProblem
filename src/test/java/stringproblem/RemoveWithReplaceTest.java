package stringproblem;

import org.junit.jupiter.api.DisplayName;

/** Tests solution 2: {@link RemoveCharacter#removeWithReplace(String, char)}. */
@DisplayName("Solution 2: removeWithReplace")
class RemoveWithReplaceTest extends RemoveCharacterTestCases {

    @Override
    String remove(String input, char toRemove) {
        return RemoveCharacter.removeWithReplace(input, toRemove);
    }
}
