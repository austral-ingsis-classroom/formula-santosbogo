package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.Function;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Sum implements Function {
  private final List<Function> functions;

  public Sum(List<Function> functions) {
    this.functions = functions;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    double result = 0;
    for (Function function : functions) {
      result += function.evaluate(variables);
    }
    return result;
  }

  @Override
  public String print() {
    return functions.stream().map(Function::print).collect(Collectors.joining(" + "));
  }

  @Override
  public Set<String> listVariables() {
    Set<String> variables = new HashSet<>();
    for (Function function : functions) {
      variables.addAll(function.listVariables());
    }
    return variables;
  }
}
