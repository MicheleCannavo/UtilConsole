package org.example.util.console;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The type Test input.
 */
@RunWith(Parameterized.class)
public class TestInput {

    /**
     * The System in mock.
     */
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String str;

    /**
     * Instantiates a new Test input.
     *
     * @param str the str
     */
    public TestInput(String str) {
        this.str = str;
    }

    /**
     * Gets param.
     *
     * @return the param
     */
    @Parameterized.Parameters
    public static Collection<String> getParam() {

        return Arrays.asList(
                "casa",
                "casetta mia",
                "La cassetta mia",
                "",
                "\0");
    }


    /**
     * Read line.
     */
    @Test
    public void readLine() {
        systemInMock.provideLines(str);
        assertEquals(str, Input.readLine(""));
    }

    /**
     * Read password.
     */
    @Test
    public void readPassword() {
        systemInMock.provideLines(str);
        assertEquals(str, Input.readPassword());
    }
}