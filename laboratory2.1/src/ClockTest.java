import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClockTest {

    private Clock clock;

    @BeforeAll
    static void initAll() {
        System.out.println(" Запуск всех тестов Clock...");
    }

    @BeforeEach
    void setUp() {
        clock = new Clock(10, 15);
        System.out.println(" Создан новый объект Clock: " + clock.getTime());
    }

    @AfterEach
    void tearDown() {
        System.out.println(" Тест завершен");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println(" Все тесты Clock завершены");
    }

    @Test
    @DisplayName("Тест: Конструктор корректно создает время ")
    void testConstructor() {
        Clock testClock = new Clock(8, 5);

        assertEquals("08:05", testClock.getTime());

        System.out.println(" Выполняется testConstructor");
    }

    @Test
    @DisplayName("Тест: Метод setTime устанавливает время ")
    void testSetTime() {
        clock.setTime(15, 45);

        assertEquals("15:45", clock.getTime());

        System.out.println(" Выполняется testSetTime");
    }

    @Test
    @DisplayName("Тест: tick увеличивает минуты на 1")
    void testTickMinute() {
        clock.tick();

        assertEquals("10:16", clock.getTime());

        System.out.println(" Выполняется testTickMinute");
    }

    @Test
    @DisplayName("Тест: После 59 минут начинается новый час ")
    void testTickHourTransition() {
        clock.setTime(12, 59);

        clock.tick();

        assertEquals("13:00", clock.getTime());

        System.out.println(" Выполняется testTickHourTransition");
    }

    @Test
    @DisplayName("Тест: Переход через полночь ")
    void testMidnightTransition() {
        clock.setTime(23, 59);

        clock.tick();

        assertEquals("00:00", clock.getTime());

        System.out.println(" Выполняется testMidnightTransition");
    }
}