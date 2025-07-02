package Code;
import java.math.*;
public class Bank
{
    int initialPrincipalBalance;
    public int initialPrincipalBalance(int principal) {
        this.initialPrincipalBalance = principal;
        return initialPrincipalBalance;
    }

}
public class Branch extends Bank
{
    int timePeriod;
    int rate;
    public int initialPrincipalBalance(int principal) {
        this.initialPrincipalBalance = principal;
        return initialPrincipalBalance;
    }

}
public class Client extends Branch
{
    double intrest;

        
        public Client(int initialPrincipalBalance, int timePeriod, int rate) {
        this.initialPrincipalBalance = initialPrincipalBalance;
        this.timePeriod = timePeriod;
        this.rate = rate;
         intrest = initialPrincipalBalance(1+(rate/timePeriod))pow(rate*timePeriod);
         return intrest;
    }
}

public class Multilevel {
    public static void main(String[] args) {
        
        Client C1 = new client(10000,2,5);
        System.out.println("The interest is: " + C1.intrest);

    }
    
}
