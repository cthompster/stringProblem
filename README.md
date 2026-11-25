# stringProblem

Define a Java class to solve this problem:<br>
Given a String and a Character, remove all instances of the Character in the String

Solve this two ways:<br>
1. Iterate through the String, one character at a time<br>
2. Find a method in the String class that can solve this in one line<br>

Write methods for each solution.

Afterwards, write a TestNG or JUnit class for each solution which tests these methods.<br>
Include both positive and negative cases for validations.

## Solution

A Java 17 Maven project tested with JUnit 5.

| File | What it holds |
|---|---|
| `src/main/java/stringproblem/RemoveCharacter.java` | `removeByIteration` (solution 1: a loop with a `StringBuilder`), `removeWithReplace` (solution 2: `String.replace(CharSequence, CharSequence)` in one line) and a small `main` demo |
| `src/test/java/stringproblem/RemoveCharacterTestCases.java` | The shared positive and negative cases, as parameterized tests |
| `src/test/java/stringproblem/RemoveByIterationTest.java` | Runs every case against solution 1 |
| `src/test/java/stringproblem/RemoveWithReplaceTest.java` | Runs every case against solution 2 |

Both methods are case-sensitive, return a new string, and throw `NullPointerException` for a `null` string.

**Positive cases:** every instance is removed, including the first or last character, consecutive repeats,
a string made only of that character, spaces, regex characters such as `.` and `$`, and non-ASCII
characters.<br>
**Negative cases:** the character isn't present, a different case (`'h'` vs `"Hello"`), an empty or
whitespace-only string (all returned unchanged), and a `null` string (rejected).

### Running the tests

Requires JDK 17+ and Maven. From the project folder:

```
mvn test
```

Expected: `Tests run: 36, Failures: 0, Errors: 0, Skipped: 0` (18 per solution).

