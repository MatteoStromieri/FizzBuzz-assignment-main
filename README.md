# Notes
We want to write a method ```print(n)``` that prints the numbers from 1 up to n according to the rules listed in the readme file 

- 1 &rarr; "1"
- 2 &rarr; "1 2"
- 3 &rarr; "1 2 Fizz"
- 5 &rarr; "1 2 Fizz 4 Buzz"
- 15 &rarr; "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz"

# Summary 
## Test 1
```{Java}
@Test
void given_1_prints_1(){
        new FizzBuzz().print(1);
        assertEquals("1\r\n",outputStreamCaptor.toString());
    } 
```
First of all, we run this test on a primitive ```FizzBuzz().print()``` method:
```{Java}
public void print(int i) {
        System.out.println("1");
```
## Test 2
Then, we introduce a second test
```{Java}
@Test
void given_2_prints_1_2(){
     new FizzBuzz().print(2);
     assertEquals("1 2\r\n",outputStreamCaptor.toString());
}
```
Now only the first test is successful, the second one fails. Therefore we upgrade our print() function
```
public void print(int i) {
    if(i==1)
        System.out.println("1");
    else 
        System.out.println("1 2");
```
And both the test are successful.
## Test 3
```
void given_3_prints_1_2_fizz(){
    new FizzBuzz().print(3);
    assertEquals("1 2 Fizz\r\n",outputStreamCaptor.toString());
}
```
And the test fails, so we upgrade the function
```
public void print(int i) {
        if(i==1)
            System.out.println("1");
        else if(i==2)
            System.out.println("1 2");
        else
            System.out.println("1 2 Fizz");
    }
```
## Test 4
Now we test 5 &rarr; "1 2 Fizz 4 Buzz":
```
void given_5_prints_1_2_fizz_4_Buzz(){
        new FizzBuzz().print(3);
        assertEquals("1 2 Fizz 4 Buzz\r\n",outputStreamCaptor.toString());
    }
```
While modifying the print() method we start noticing a pattern, so we can refactor the method to make it more general: 
```
public void print(int i) {
        if(i==1)
            System.out.println("1");
        else if(i==2)
            System.out.println("1 2");
        else if(i==3)
            System.out.println("1 2 Fizz");
        else
            System.out.println("1 2 Fizz 4 Buzz");
    }
```
So, we can refactor it into:
```{Java}
public void print(int n) {
    String outputString = IntStream.rangeClosed(1, n)
        .mapToObj(i -> {
            else if(i%3==0)
                return "Fizz";
            else if(i%5==0)
                return "Buzz";
            else
                return String.valueOf(i);
           })
        .collect(Collectors.joining(" "));
    System.out.println(outputString);
    }
```
## Test 5
Now we introduce the test for "FizzBuzz":
```{Java}
void given_15_prints_fizzbuzz(){
    new FizzBuzz().print(15);
    assertEquals("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz\r\n",outputStreamCaptor.toString());
}
```
Since our function causes this fail to test, we apply some changes:
```{Java}
public void print(int n) {
    String outputString = IntStream.rangeClosed(1, n)
        .mapToObj(i -> {
            if(i%3==0 && i%5==0)
                return "FizzBuzz";
            else if(i%3==0)
                return "Fizz";
            else if(i%5==0)
                return "Buzz";
            else
                return String.valueOf(i);
           })
        .collect(Collectors.joining(" "));
    System.out.println(outputString);
    }
```
And the test passes
## Final refactor
To conclude, I propose a final refactor of the ```FizzBuzz``` class
```{Java}
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
```