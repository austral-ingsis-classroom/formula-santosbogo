package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.functions.*;
import edu.austral.ingsis.math.functions.Module;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {
  Function function;

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    function = new Sum(List.of(new Number(1), new Number(6)));
    Set<String> result = function.listVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    function = new Division(new Number(12), new Variable("div"));
    final Set<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    function =
        new Product(List.of(new Division(new Number(9), new Variable("x")), new Variable("y")));
    final Set<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function division = new Division(new Number(27), new Variable("a"));
    function = new Power(division, new Variable("b"));
    final Set<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function division = new Division(new Number(1), new Number(2));
    function = new Power(new Variable("z"), division);
    final Set<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function module = new Module(new Variable("value"));
    function = new Difference(List.of(module, new Number(8)));
    final Set<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function module = new Module(new Variable("value"));
    function = new Difference(List.of(module, new Number(8)));
    final Set<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function difference = new Difference(List.of(new Number(5), new Variable("i")));
    function = new Product(List.of(difference, new Number(8)));
    final Set<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
