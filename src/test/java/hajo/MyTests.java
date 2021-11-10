package hajo;

import io.github.artsok.RepeatedIfExceptionsTest;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.assertj.core.error.AssertJMultipleFailuresError;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SoftAssertionsExtension.class)
public class MyTests {

    @RepeatedIfExceptionsTest(repeats = 3)
    void testWithJUnit() {
        assertFalse(true, "Fail by JUnit ´hard´ assertion: org.opentest4j.AssertionFailedError");
    }

    @RepeatedIfExceptionsTest(repeats = 3)
    void testWithAssertJ_Soft_Default(SoftAssertions softAssertions) {
        softAssertions.assertThat(1)
                .as("Fail by AssertJ ´soft´ assertion: org.assertj.core.error.AssertJMultipleFailuresError")
                .isEqualTo(2);
    }

    @RepeatedIfExceptionsTest(repeats = 3, exceptions = AssertJMultipleFailuresError.class)
    void testWithAssertJ_Soft(SoftAssertions softAssertions) {
        softAssertions.assertThat(1)
                .as("Fail by AssertJ ´soft´ assertion: org.assertj.core.error.AssertJMultipleFailuresError")
                .isEqualTo(2);
    }

    @RepeatedIfExceptionsTest(repeats = 3)
    void testWithAssertJ_Hard() {
        assertThat(1)
                .as("Fail by AssertJ ´hard´ assertion: org.opentest4j.AssertionFailedError")
                .isEqualTo(2);
    }

}
