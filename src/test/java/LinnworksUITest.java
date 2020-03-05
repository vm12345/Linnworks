import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class LinnworksUITest implements IsEmptyInterface {
    private static LinnworksUITest linnworksUITest;

    @BeforeClass
    public static void getBaseStatement() {
        Login();
        linnworksUITest = new LinnworksUITest();
        if (!$x(".//td[text()='Category 2']").exists()) {
            linnworksUITest.addCategory("Category 2");
        }
        if (!$x(".//td[text()='Category 3']").exists()) {
            linnworksUITest.addCategory("Category 3");
        }
    }

    @Test
    public void testAdd() {
        Login();
        linnworksUITest.addCategory("some Category");
    }

    @Test
    public void testDelete() {
        Login();
        $x(".//td[text()='some newCategory']").shouldBe(Condition.visible);
        $x(".//td[text()='some newCategory']/..//a[text()='Delete']").click();
        Selenide.switchTo().alert().accept();
        $x(".//td[text()='some newCategory']").shouldNot(Condition.visible);
    }

    @Test
    public void testEdit() {
        Login();
        $x(".//td[text()='Category 2']/..//a[text()='Edit']").click();
        $x(".//input[@formcontrolname='categoryName']").click();
        $x(".//input[@formcontrolname='categoryName']").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        $x(".//input[@formcontrolname='categoryName']").setValue("test").sendKeys(Keys.ENTER);
        $x(".//td[text()='test']").shouldBe(Condition.visible);
        $x(".//td[text()='test']/..//a[text()='Edit']").click();
        $x(".//input[@formcontrolname='categoryName']").click();
        $x(".//input[@formcontrolname='categoryName']").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        $x(".//input[@formcontrolname='categoryName']").setValue("Category 2").sendKeys(Keys.ENTER);
        $x(".//td[text()='Category 2']").shouldBe(Condition.visible);
    }

    @Test
    public void testDeleteAll() {
        Login();
        $x(".//td[text()='Category 2']").shouldBe(Condition.visible);
        $x(".//td[text()='Category 2']/..//a[text()='Delete']").click();
        Selenide.switchTo().alert().accept();
        $x(".//td[text()='Category 3']").shouldBe(Condition.visible);
        $x(".//td[text()='Category 3']/..//a[text()='Delete']").click();
        Selenide.switchTo().alert().accept();
        $x(".//td[text()='Category 2']").shouldNot(Condition.visible);
        $x(".//td[text()='Category 3']").shouldNot(Condition.visible);
    }

    @Test
    public void testAddAll() {
        Login();
        addCategory("Category 2");
        addCategory("Category 3");
        $x(".//td[text()='Category 3']").shouldBe(Condition.visible);
    }

    private void addCategory(String text) {
        $x(".//a[@ng-reflect-router-link='/add-category']").click();
        $x(".//input[@formcontrolname='categoryName']").setValue(text);
        $x(".//button[@type='submit']").click();
        $x(".//td[text()='" + text + "']").shouldBe(Condition.visible);
    }

    private static void Login() {
        Selenide.open("http://localhost:59509/login");
        $x("//input[@id='token']").click();
        $x("//input[@id='token']").setValue("bccf905c-6592-40f2-8db1-c976791fa40a");
        $x(".//button[@type='submit']").click();
    }

}
