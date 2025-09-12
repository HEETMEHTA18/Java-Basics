import java.util.StringTokenizer;
public class Demo {
   public static void main(String args[]) {
      StringTokenizer st = new StringTokenizer("Java is fun");
      while(st.hasMoreTokens()) {
         System.out.println(st.nextToken());
      }
   }
}
