import org.testng.Assert;
import org.testng.annotations.Test;

public class CatClass {
    //------------------May 13---------------------
    @Test
    public void test01() {
        //Hello, World
        //Print "Hello, World!" to the console.
        System.out.println("Hello, World!");
    }

    @Test
    public void test02() {
        //Variables and Types
        /**
        Create all of the primitives (except long and double) with different values.
        Concatenate them into a string and print it to the screen so it will print:
        H3110 w0r1d 2.0 true
        */
        byte zero = 0;
        short num = 1;
        int number = 3110;
        float val = 2;
        char c = 'r';
        boolean bool = true;
        String output = "H" + number + " w" + zero + c + num + "d " + val + " " + bool;
        System.out.println(output);
    }

    @Test
    public void test03() {
        //Conditionals
        //Change the variables in the first section, so that each if statement resolves as true.
        String a = "Wow";
        String b = "Wow";
        String c = a + "!";
        String d = c;

        boolean b1 = a == b;
        boolean b2 = d.equals(b + "!");
        boolean b3 = !c.equals(a);

        if (b1 && b2 && b3) {
            System.out.println("Success!");
        }
    }

    @Test
    public void test04() {
        //Arrays
        //Change the values in numbers so it will not raise an error.
        int[] numbers = {1, 2, 3, 9};
        int length = numbers[3];
        char[] chars = new char[length];
        chars[numbers.length + 4] = 'y';
        System.out.println("Done!");
    }

    @Test
    public void test05() {
        //Loops
        /**
        Loop through and print out all even numbers, each in a separate line,
        from the numbers list in the same order they are received.
        Don't print any numbers that come after 237 in the sequence.
         */
        int[] numbers = {
                951, 402, 984, 651, 360, 69, 408, 319, 601, 485, 980, 507, 725, 547, 544,
                615, 83, 165, 141, 501, 263, 617, 865, 575, 219, 390, 984, 592, 236, 105, 942, 941,
                386, 462, 47, 418, 907, 344, 236, 375, 823, 566, 597, 978, 328, 615, 953, 345,
                399, 162, 758, 219, 918, 237, 412, 566, 826, 248, 866, 950, 626, 949, 687, 217,
                815, 67, 104, 58, 512, 24, 892, 894, 767, 553, 81, 379, 843, 831, 445, 742, 717,
                958, 609, 842, 451, 688, 753, 854, 685, 93, 857, 440, 380, 126, 721, 328, 753, 470,
                743, 527};

         for(int i=0; i<numbers.length; i++) {
             if(numbers[i] == 237) {
                 break;
             } else if(numbers[i] % 2 == 0) {
                 System.out.println(numbers[i]);
             }
         }
    }

    @Test
    public void test06() {
        //Functions
        //Write the method printFullName of student which prints the full name of a student.
        class Student {
            private String firstName;
            private String lastName;
            public Student(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
            // Your code goes here
            public void printFullName() {
                System.out.println(firstName + " " + lastName);
            }
        }

        Student[] students = new Student[] {
                new Student("Morgan", "Freeman"),
                new Student("Brad", "Pitt"),
                new Student("Kevin", "Spacey"),
        };
        for (Student s : students) {
            s.printFullName();
        }
    }

    @Test
    public void test07() {
        //Objects
        /**
        Write a new method in Point called scale,
        that will make the point closer by half to (0,0).
        So for example, point (8, 4) after scale will be (4, 2).
         */
        class Point {
            private double x;
            private double y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }

            public void print() {
                System.out.println("(" + x + "," + y + ")");
            }

            public void scale() {
                x = x / 2;
                y = y / 2;
            }
        }

        Point p = new Point(32, 32);
        for (int i = 0; i < 5; i++) {
            p.scale();
            p.print();
        }
    }

    @Test
    public void test08() {
        //Compiling and Running with Arguments
        //Create a program that prints the arguments of our program. Write one argument per line.
        /**
        I have created a separate file Cat.java with the code inside:
            public class Cat {
                public static void main(String[] args) {
                    System.out.println("hey!");
                }
            }
         Then I went to cmd and get to /src/test/java location and performed compiling:
         javac Cat.java - file compiled successfully
         Then I run it:
         java Cat - it displayed "hey!"
         */
    }

    @Test
    public void test09() {
        //TODO: change to accept parameters so it will always print correct message
        int left = 5;
        int right = 6;

        if (left == right) {
            System.out.println("Ohhh! So a is " + right + "!");
        } else {
            System.out.println("Left IS NOT EQUAL TO " + right);
        }
    }
    //--------------------May 20----------------------------------
    //Swap two numbers in an array
    //1. create an input array
    //2. create a method with int[] parameter
    //3. new method will also take indexes of L and R elements
    //4. use indexes R and L and respective elements will be swapped with each other
    //5. print out final version of the array
    public void printAllMembersOfArray(int[] arrayParameter) {
        for (int i = 0; i < arrayParameter.length; i++) {
            int currentElement = arrayParameter[i];
            System.out.println(currentElement);
        }
    }
    public void printAllMembersOfArrayE(int[] arrayParameter) {
        for (int eachMember : arrayParameter) {
            System.out.println(eachMember);
        }
    }
    public void swap(int[] input, int indexL, int indexR) {
        int temporaryElement = 0;
        temporaryElement = input[indexL];
        input[indexL] = input[indexR];
        input[indexR] = temporaryElement;
    }
    @Test
    public void test_swapNumbers() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int indexL = 0;
        int indexR = 1;

        swap(input, indexL, indexR);
        printAllMembersOfArray(input);
    }
    @Test
    public void test_swap_Exception() {
        int[] input = {1};
        int indexL = 0;
        int indexR = 1;

        checkInputs(input, indexL, indexR);
        swap(input, indexL, indexR);
        printAllMembersOfArray(input);
    }
    //TODO: add checks for input array
    private void checkInputs(int[] input, int indexL, int indexR) {
        if (input != null && input.length > 1) {
            System.out.println("Array in not empty and has at least two values");
        } else {
            throw new AssertionError("Array is empty, or has less than two values needed for \"swap\" method. Input length = " + input.length);
        }
        if (indexL >= 0 && indexL < input.length && indexR >= 0 && indexR < input.length) {
            System.out.println("Inputs are OK");
        } else {
            throw new AssertionError("Inputs are NOT OK: indexL=" + indexL + ", indexR=" + indexR);
        }
    }
    //TODO: break down into sub-steps (external methods), `letter` should be a parameter as well
    //Count a number of a specific letters in a string
    //1. create an input string
    //2. create a method with input parameter and letter parameter
    //3. use predefined string method to split the string in an array of characters
    //4. print out the number of letters counted

    public void printResult(int letterResult) {
        System.out.println(letterResult);
    }
    @Test
    private void testCountLetters() {
        String input = "hello world";
        int result = 0;
        char letter = 'l';

        checkLetterInputs(input);
        int finalresult = count(input, letter, result);
        System.out.println("There are " + finalresult + " letters \"" + letter + "\" in following string: \"" + input + "\".");
    }
    public int count(String input, char letter, int result) {
        char[] charArray = input.toCharArray();
        for (char eachChar : charArray) {
            if (eachChar == letter) {
                result++;
            }
        }
        return result;
    }
    private void checkLetterInputs(String input) {
        if (input.length() > 0) {
            System.out.println("String in not empty and has at least one character");
        } else {
            throw new AssertionError("String is empty. String length = " + input.length());
        }
    }
    //---------------------------May 27-----------------------------
    @Test
    public void test_AppleCreation() {
        Apple apple01 = new Apple("Honey Crisp", "red", 0.8);
        String apple01kind = apple01.getKind();

        System.out.println(apple01kind);
        Assert.assertEquals(apple01kind, "Honey Crisp");
    }
}
