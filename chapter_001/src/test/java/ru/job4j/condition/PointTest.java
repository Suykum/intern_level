package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class PointTest {
    @Test
    public void whenPointDistanceAproximately3() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 2);
        double result = point1.distanceTo(point2);
        double expect = 2.8284271247461903;
        assertThat(result, is(expect));
    }



}
