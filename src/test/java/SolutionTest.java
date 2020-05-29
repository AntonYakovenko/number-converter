import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void positive_test_0() {
        assertThat(solution.convert(123), is("1-3"));
    }

    @Test
    public void positive_test_1() {
        assertThat(solution.convert(135), is("1,3,5"));
    }

    @Test
    public void positive_test_2() {
        assertThat(solution.convert(125), is("1-2,5"));
    }

    @Test
    public void positive_test_3() {
        assertThat(solution.convert(12367), is("1-3,6-7"));
    }

    @Test
    public void positive_test_4() {
        assertThat(solution.convert(134567), is("1,3-7"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_test_0() {
        solution.convert(890);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_test_1() {
        solution.convert(7326);
    }
}