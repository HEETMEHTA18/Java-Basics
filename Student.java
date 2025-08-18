public interface Student {
    public void displayclass();
    public void StringGetName(String name);
    default void setName(String name)  {
        System.out.println(name);
    }
    final double PI = 3.14; // Example of a constant
    static String getInstituteLocation() {
        return "Charusat";
    }
}
