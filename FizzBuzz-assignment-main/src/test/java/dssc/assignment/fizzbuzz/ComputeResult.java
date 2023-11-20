package dssc.assignment.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeResult {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void given_1_prints_1(){
        new FizzBuzz().print(1);
        assertEquals("1",outputStreamCaptor.toString().replaceAll("[\\n\\r]", ""));
    }
    @Test
    void given_2_prints_1_2(){
        new FizzBuzz().print(2);
        assertEquals("1 2",outputStreamCaptor.toString().replaceAll("[\\n\\r]", ""));
    }

    @Test
    void given_3_prints_1_2_fizz(){
        new FizzBuzz().print(3);
        assertEquals("1 2 Fizz",outputStreamCaptor.toString().replaceAll("[\\n\\r]", ""));
    }
    @Test
    void given_5_prints_1_2_fizz_4_Buzz(){
        new FizzBuzz().print(5);
        assertEquals("1 2 Fizz 4 Buzz",outputStreamCaptor.toString().replaceAll("[\\n\\r]", ""));
    }
    @Test
    void given_15_prints_fizzbuzz(){
        new FizzBuzz().print(15);
        assertEquals("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz",outputStreamCaptor.toString().replaceAll("[\\n\\r]", ""));
    }

}
