import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstTest {

    @Test
    public void checkZipCodeInput() {
        WebDriver browser = new SafariDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("[name = 'zip_code']")).sendKeys("1234");
        browser.findElement(By.cssSelector("[value='Continue']")).click();

        boolean IsErrorAppear = browser.findElement(By.cssSelector(".error_message")).isDisplayed();
        assertTrue(IsErrorAppear, "Error message does not appear");

        String errorMessageText = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMessageText, "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void checkZipCodeFiveDigitInput() {
        WebDriver browser = new SafariDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("[name = 'zip_code']")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value='Continue']")).click();

        boolean IsRegisterBthExist = browser.findElement(By.cssSelector("value='Register")).isDisplayed();
        assertTrue(IsRegisterBthExist, "Register bth is not visible");
    }
}

// КРАТНО 5, ВОЗВРАЩАТЬ "Т"

/*
public String TrialCode(int number) {
    if (number % 3 == 0 && number % 5 == 0) {
        return "A";
    } else if (number % 5 == 0) {
        return "F";
    } else if (number % 3 == 0) {
        return "I";
    } else return "T";
}

@Test
public void checkIfatNumber() {
    String actualReasult = TrialCode(9);
    assertEquals(actualReasult, "I", "Ожидалось другое значение");
}

@Test
public void checkIfatFiveNumber() {
    String actualReasult = TrialCode(25);
    assertEquals(actualReasult, "F", "Ожидалось другое значение");
}

@Test
public void checkIfatBothNumber() {
    String actualReasult = TrialCode(15);
    assertEquals(actualReasult, "A", "Ожидалось другое значение");
}

@Test
public void checkIfatNoneNumber() {
    String actualReasult = TrialCode(19);
    assertEquals(actualReasult, "T", "Ожидалось другое значение");
}
}

 */