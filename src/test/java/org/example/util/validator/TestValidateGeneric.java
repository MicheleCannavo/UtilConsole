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

public class TestValidateGeneric {

  ValidateGeneric vg;

  @Before
  public void preCondition(){
    vg = new ValidateGeneric("generic","^[0-6]{1,}$");
  }

  @Test
  public void getDescriptorRulesValidation() {
    assertEquals("",
      vg.getRulesOfValidation());
  }

  @Test
  public void getPattern() {
    assertEquals("^[0-6]{1,}$",
      vg.getPattern());
  }

  @Test
  public void getValidatorName() {
    assertEquals("generic",
      vg.getValidatorName());
  }

  @RunWith(Parameterized.class)
  public static class TestisValid {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String str;
    private final boolean bool;
    private ValidateGeneric vg;

    public TestisValid(String str, Boolean bool) {
      this.str = str;
      this.bool = bool;
      this.vg = new ValidateGeneric("generic","^[0-6]{1,}$");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParam() {

      return Arrays.asList(
        new Object[] {"GFHGl.it", false},
        new Object[] {"ass@rtit", false},
        new Object[] {"sdfs@live.it", false},
        new Object[] {"\0", false},
        new Object[] {"y", false},
        new Object[] {"...@..", false},
        new Object[] {"asds3@4...23", false},
        new Object[] {"@SdfsdSDFS.D", false},
        new Object[] {"00", true},
        new Object[] {"313@5465456", false},
        new Object[] {"49", false},
        new Object[] {"qw ds", false},
        new Object[] {"10632232032023032032000", true});
    }

    @Test
    public void testSetValidationRules(){
      vg.setValidationRules(str);
      assertEquals(vg.getRulesOfValidation(), str);
    }

    @Test
    public void testIsValid() {
      assertEquals(vg.isValid(str), bool);
    }

    @Test
    public void testRequest() {
      systemInMock.provideLines(str);
      assertEquals( str , vg.request());
    }
  }
}