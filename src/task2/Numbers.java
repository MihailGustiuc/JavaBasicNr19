package task2;

public class Numbers {

    private static Numbers DivisibleBy7Counter;

    public void divideBy(int divisor) throws IllegalArgumentException {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }

    }
    public static int countDivisibleBy7Numbers(int lowerLimit, int upperLimit) throws InvalidRangeException {
        if (lowerLimit > upperLimit) {
            throw new InvalidRangeException("Invalid range: lower limit is greater than upper limit");
        }

        int count = 0;
        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (i % 7 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Numbers numbers = new Numbers();

        try {
            numbers.divideBy(10);
            numbers.divideBy(5);
            numbers.divideBy(0); // will throw an exception
            numbers.divideBy(2);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            int count = DivisibleBy7Counter.countDivisibleBy7Numbers(10, 50);
            System.out.println("There are " + count + " numbers divisible by 7 between 10 and 50.");
        } catch (InvalidRangeException e) {
            System.err.println("Invalid range: " + e.getMessage());
        }



    }
}
