import mypack.Calculator;
import mypack.Calculator.Subtraction;
import mypack.Calculator.addition;
import mypack.Calculator.subtraction;

public class mainclass {
    public static void main(String[] args) {
        Calculator.Addition add = new addition(10, 5);
        System.out.println("Addition: " + add.subtract());
        Subtraction sub = new subtraction(10, 5);
        System.out.println("Subtraction: " + sub.subtract());
        Calculator.multiplication mul = new Calculator().new multiplication(10, 5);
        System.out.println("Multiplication: " + mul.multiply());
        
          
      
}

}