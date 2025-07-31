package mypack;
public class Calculator {

   public class addition {
       private int a, b;
    
         public addition(int a, int b) {
              this.a = a;
              this.b = b;
         }
    
         public int subtract() {
              return a + b;
         }

   }
    public class subtraction {
         private int a, b;
    
         public subtraction(int a, int b) {
              this.a = a;
              this.b = b;
         }
    
         public int subtract() {
              return a - b;
         }
    }
    public class multiplication {
         private int a, b;
    
         public multiplication(int a, int b) {
              this.a = a;
              this.b = b;
         }
    
         public int multiply() {
              return a * b;
         }
    }
    public class division {
         private int a, b;
    
         public division(int a, int b) {
              this.a = a;
              this.b = b;
         }
    
         public double divide() {
              if (b == 0) {
                  throw new ArithmeticException("Division by zero is not allowed.");
              }
              return (double) a / b;
         }
    } 
}  