package dssc.assignment.fizzbuzz;

import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final IntFunction<String> mapper = i -> {
        if(i%3==0 && i%5==0)
            return "FizzBuzz";
        else if(i%3==0)
            return "Fizz";
        else if(i%5==0)
            return "Buzz";
        else
            return String.valueOf(i);
    };
    public void print(int n) {
        String outputString = IntStream.rangeClosed(1, n)
                .mapToObj(mapper)
                .collect(Collectors.joining(" "));
        System.out.println(outputString);
    }
}
