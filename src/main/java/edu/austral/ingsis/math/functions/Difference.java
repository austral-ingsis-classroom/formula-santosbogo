package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.Function;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Difference implements Function {

  private final List<Function> functions;

  public Difference(List<Function> functions) {
    this.functions = functions;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    double result = functions.getFirst().evaluate(variables);
    for (int i = 1; i < functions.size(); i++) {
      result -= functions.get(i).evaluate(variables);
    }
    return result;
  }

  @Override
  public String print() {
    return functions.stream().map(Function::print).collect(Collectors.joining(" - "));
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
