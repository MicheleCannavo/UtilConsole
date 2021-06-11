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

public class TestValidateNumber {

  ValidateNumber vn;

  @Before
  public void preCondition(){
    vn = ValidateNumber.getInstance();
  }

  @Test
  public void testGetDescriptorRulesValidation() {
    String desc = "";
    assertEquals(desc, vn.getRulesOfValidation());
  }

  @Test
  public void getPattern() {
    assertEquals("^[0-9]+$",
      vn.getPattern());
  }

  @Test
  public void getValidatorName() {
    assertEquals("number",
      vn.getValidatorName());
  }

  @RunWith(Parameterized.class)
  public static class TestValidateNumberWithInput {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String str;
    private final boolean bool;
    private ValidateNumber vn= ValidateNumber.getInstance();

    public TestValidateNumberWithInput(String str, boolean bool) {
      this.str = str;
      this.bool = bool;
    }

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

    @Test
    public void testisValid() {
      System.out.println(str);
      assertEquals(vn.isValid(str), bool);
    }

    @Test
    public void TestRequest() {
      systemInMock.provideLines(str);
      assertEquals(bool ? str : null, vn.request());
    }
  }
}