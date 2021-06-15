package org.example.util.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The type Test validate number.
 */
public class TestValidateNumber {

    /**
     * The Vn.
     */
    ValidateNumber vn;

    /**
     * Pre condition.
     */
    @Before
  public void preCondition(){
    vn = ValidateNumber.getInstance();
  }

    /**
     * Test get descriptor rules validation.
     */
    @Test
  public void testGetDescriptorRulesValidation() {
    String desc = "";
    assertEquals(desc, vn.getRulesOfValidation());
  }

    /**
     * Gets pattern.
     */
    @Test
  public void getPattern() {
    assertEquals("^[0-9]+$",
      vn.getPattern());
  }

    /**
     * Gets validator name.
     */
    @Test
  public void getValidatorName() {
    assertEquals("number",
      vn.getValidatorName());
  }

    /**
     * The type Test validate number with input.
     */
    @RunWith(Parameterized.class)
  public static class TestValidateNumberWithInput {

        /**
         * The System in mock.
         */
        @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
        /**
         * The Str.
         */
        private final String str;
        /**
         * The Bool.
         */
        private final boolean bool;
        /**
         * The Vn.
         */
        private ValidateNumber vn= ValidateNumber.getInstance();

        /**
         * Instantiates a new Test validate number with input.
         *
         * @param str  the str
         * @param bool the bool
         */
        public TestValidateNumberWithInput(String str, boolean bool) {
      this.str = str;
      this.bool = bool;
    }

        /**
         * Gets param.
         *
         * @return the param
         */
        @Parameterized.Parameters
    public static Collection<Object[]> getParam() {
      return Arrays.asList(
        new Object[] {"003",           true},
        new Object[] {"-6",            false},
        new Object[] {"0.0",           false},
        new Object[] {"\0",            false},
        new Object[] {"0",             true},
        new Object[] {"-..s23s",       false},
        new Object[] {"Asds34fAS3423", false});
    }

        /**
         * Testis valid.
         */
        @Test
    public void testisValid() {
      System.out.println(str);
      assertEquals(vn.isValid(str), bool);
    }

  }
}