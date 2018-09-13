package ru.job4j.pattern;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PatternTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("****").append("\n")
                                .append("*  *").append("\n")
                                .append("*  *").append("\n")
                                .append("****").append("\n")
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(),is(new StringBuilder()
                                        .append("   *   ").append("\n")
                                        .append("  * *  ").append("\n")
                                        .append(" *   * ").append("\n")
                                        .append("*******").append("\n")
                                        .toString()));
    }

    @Test
    public void whenDrawSquareViaPaint() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфур для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("****").append("\n")
                                .append("*  *").append("\n")
                                .append("*  *").append("\n")
                                .append("****").append("\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}
