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
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


public class TestValidateName  {

  ValidateName vn;

  @Before
  public void preCondition(){
    vn = ValidateName.getInstance();
  }

  @Test
  public void testGetDescriptorRulesValidation() {
    String desc ="Il nick deve contenere:" + System.lineSeparator() +
      "- l' iniziale MAIUSCOLA" + System.lineSeparator() +
      "- lettere minuscoli e numeri" + System.lineSeparator() +
      "- min 3 caratteri" + System.lineSeparator() +
      "- max 25 caratteri"+ System.lineSeparator();

    assertEquals(desc, vn.getRulesOfValidation());
  }

  @Test
  public void getPattern() {
    assertEquals("^[A-Z]{1,}[a-z0-9]{3,25}$",
      vn.getPattern());
  }

  @Test
  public void getValidatorName() {
    assertEquals("nome utente",
      vn.getValidatorName());
  }

  @RunWith(Parameterized.class)
  public static class TestValidateNumberWithInput {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String str;
    private final boolean bool;
    private ValidateName vn;

    public TestValidateNumberWithInput(String str, boolean bool) {
      this.str = str;
      this.bool = bool;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParam() {
      return Arrays.asList(
        new Object[] {"AAA",      false},
        new Object[] {"As23.",    false},
        new Object[] {"Assd0",    true},
        new Object[] {"\0",       false},
        new Object[] {"A0ds",     true},
        new Object[] {"-..s23s",  false},
        new Object[] {"Asds34fdsfsdfsdfsdfsdfsdfsdfsdsdfsdsdfdsfsdfsdfsdfsdfsdf",  false});
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