public interface Student {
    public void displayclass();
    public void StringGetName(String name);

    default void setName(String name)  {
        System.out.println("Setting name in interface: " + name);
    }
}
public class interfaceStudent
{
    
}