package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.Function;
import java.util.Map;
import java.util.Set;

public class Power implements Function {
  private final Function base;
  private final Function exponent;

  public Power(Function base, Function exponent) {
    this.base = base;
    this.exponent = exponent;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return Math.pow(base.evaluate(variables), exponent.evaluate(variables));
  }

  @Override
  public String print() {
    return base.print() + " ^ " + exponent.print();
  }

  @Override
  public Set<String> listVariables() {
    Set<String> variables = base.listVariables();
    variables.addAll(exponent.listVariables());
    variables.addAll(base.listVariables());
    return variables;
  }
}
