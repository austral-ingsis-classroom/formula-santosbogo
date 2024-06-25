package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.Function;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Division implements Function {
  private final Function dividend;
  private final Function divisor;

  public Division(Function dividend, Function divisor) {
    this.dividend = dividend;
    this.divisor = divisor;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    double divisorValue = divisor.evaluate(variables);
    if (divisorValue == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return dividend.evaluate(variables) / divisorValue;
  }

  @Override
  public String print() {
    return dividend.print() + " / " + divisor.print();
  }

  @Override
  public Set<String> listVariables() {
    Set<String> variables = new HashSet<>();
    variables.addAll(dividend.listVariables());
    variables.addAll(divisor.listVariables());
    return variables;
  }
}
