package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PrintTest {
  Function function;

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    function = new Sum(List.of(new Number(1), new Number(6)));
    final String expected = "1 + 6";
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    function = new Division(new Number(12), new Number(2));
    final String expected = "12 / 2";
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    function = new Product(List.of(new Division(new Number(9), new Number(2)), new Number(3)));

    final String expected = "9 / 2 * 3";
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Function division = new Division(new Number(27), new Number(6));
    function = new Power(division, new Number(2));

    final String expected = "27 / 6 ^ 2";
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    function =
        new Product(
            List.of(new Difference(List.of(new Number(5), new Variable("i"))), new Number(8)));
    final String expected = "5 - i * 8";
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }
}
