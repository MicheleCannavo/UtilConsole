package org.example.util.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TestValidateNameProject {

  ValidateNameProject vn;

  @Before
  public void preCondition(){
    vn = ValidateNameProject.getInstance();
  }

  @Test
  public void testGetDescriptorRulesValidation() {
    String desc =
      "Il nome progetto deve contenere:"      + System.lineSeparator() +
      "- Iniziare con una lettera MAIUSCOLA"  + System.lineSeparator() +
      "- Una lettera minuscola"               + System.lineSeparator() +
      "- Un numero"                           + System.lineSeparator() +
      "- min 3 caratteri"                     + System.lineSeparator() +
      "- max 25 caratteri"                    + System.lineSeparator();

    assertEquals(desc, vn.getRulesOfValidation());
  }

  @Test
  public void getPattern() {
    assertEquals("^[A-Z]{1,}[a-zA-Z0-9]{2,24}$",
      vn.getPattern());
  }

  @Test
  public void getValidatorName() {
    assertEquals("nome progetto",
      vn.getValidatorName());
  }

  @RunWith(Parameterized.class)
  public static class TestValidateNumberWithInput {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String str;
    private final boolean bool;
    private ValidateNameProject vn= ValidateNameProject.getInstance();

    public TestValidateNumberWithInput(String str, boolean bool) {
      this.str = str;
      this.bool = bool;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParam() {
      return Arrays.asList(
        new Object[] {"AAA",      true},
        new Object[] {"As23.",    false},
        new Object[] {"Assd0",    true},
        new Object[] {"\0",       false},
        new Object[] {"0ds",      false},
        new Object[] {"-..s23s",  false},
        new Object[] {"Asds34f",  true});
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