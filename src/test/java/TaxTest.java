import com.sun.tools.javac.Main;
import org.example.Tax;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;


public class TaxTest {
    protected Tax tax;

    protected int earnings = 1000;
    protected int spendings = 300;
    protected double taxdoh = 0.06;
    protected double taxDohMinusRash = 0.15;

    @BeforeEach
    void setUp(){
       tax = new Tax();
        System.out.println("Вызываюсь до выполнения теста");
    }
    @BeforeAll
    static void setUpAll(){
        System.out.println("Вызываюсь до выполнения всех тестов");
    }
    @AfterEach
    void tearDown(){
        System.out.println("Вызываюсь после выполнения теста");
    }
    @AfterAll
    static void tearDownAll(){
        System.out.println("Вызываюсь после выполнения всех тестов");
    }
    @Test
    @DisplayName("Проверка вычисления УСН Доходы 6%")
    void usnDohod(){
        double result = earnings * taxdoh;
        double expected = 60;
        Assertions.assertEquals(expected, result);
        System.out.println("Тест пройден");
    }
    @Test
    @DisplayName("Проверка разности доходы минус расходы")
    void minus(){
        int result = earnings - spendings;
        int expected = 700;
        Assertions.assertEquals(expected, result);
        System.out.println("Тест пройден");
    }
    @Test
    @DisplayName("Проверка вычисления УСН Доходы минус расходы 15%")
    void multiplication(){
        double result = (earnings - spendings)* 0.15;
        double expected = 105;
        Assertions.assertEquals(expected,result);
        System.out.println("Тест пройден");
    }
}

