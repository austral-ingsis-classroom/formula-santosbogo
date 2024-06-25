package edu.austral.ingsis.math;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Number implements Function {
  private final double value;

  public Number(double value) {
    this.value = value;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return value;
  }

  @Override
  public String print() {
    if (value % 1 == 0) {
      return Integer.toString((int) value);
    } else {
      return Double.toString(value);
    }
  }

  @Override
  public Set<String> listVariables() {
    return new HashSet<>();
  }
}
