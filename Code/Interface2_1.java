package Code;

interface A
{
    int a=20;
    void display();

}
interface B  extends A
{

    float b=12.5f;
    void display();

}
interface C  extends A
{
    float c=12.5f;
    void display();

}
interface D extends B,C
{
    double d =50l;

    void display();

}
class E implements D
{
    public void display()
    {
        System.out.println("display value");
    }
    double calculate(int a, float b, float c, double d)
    {
         double result=a*b*c*d;
        System.out.println("result="+result);
        return result;
    }
}
public class Interface2_1 {
    public static void main(String[] args) {
        E e = new E();
        e.display();
        e.calculate(20,12.5f,12.5f,50L);

    }
}
