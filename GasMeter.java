// interface Diesel1
// {
//     float calculate(float x,float y,float z);
// }
// interface Diesel2
// {
//     float calculate(float x,float y,float z);
// }
// interface Diesel3
// {
//     float calculate(float x,float y,float z);
// }
//  class Refulledamount implements Disesel 1 ,Disesel 2,Disesel 3  {
//     public float calculate(float x,float y,float z)
//     {
//         System.out.println(x+y);
//     }
// }

interface inputlvalue
{
    int fuletaken(float fuel);
}
class f95 implements inputlvalue {
    @Override
    public int fuletaken(float fuel);
    {
        return 0;
    }
    public float value()
    {
        return fuel;
    }
}
class f98 implements inputlvalue {

    @Override
    public int fuletaken(float value);
    {
        return 0;
    }
    public float value()
    {
        return fuel;
    }

}
class diesel implements inputvalue
{

    @Override
    public int fuletaken(float value);
    {
        return 0;
    }
    public float total()
    {


    }

}

public class GasMeter {
    public static float totalfuelused()
    {
        return fuel;

    }
    public static void main(String[] args) {

        totalfuelused();
    }
}
