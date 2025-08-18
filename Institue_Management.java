public class Institue_Management implements Student 
{
        int institute_code= 0;
        public String institute_name=null;
        public final String location = "Charusat";
        public static String ChangeInstituteName(String newName) {
            return newName;
        }
        public Institue_Management() {
            System.out.println("Welcome to the Institute Management System");

        }
        public Institue_Management(int institute_code,String institute_name) {
         this.institute_code=institute_code;
                this.institute_name=institute_name;
        }
        public void display() {
            
            System.out.println("Institute Code: " + institute_code);
            System.out.println("Institute Name: " + institute_name);
            System.out.println("Location: " + location);
        }
        public void StringGetName(String name) {
            System.out.println("Institute Name: " + name);
        }
        public void setName(String name)  {
            System.out.println("Setting name in Institue_Management: " + name);
        }
        public void displayclass()
        {
            // System.out.println("This is a class method in Institue_Management throught interface Student");
        }
        public static String getInstituteLocation() {
            return "Gandhinagar";
        }
        public static void main(String[] args) {
            Institue_Management institute = new Institue_Management(101, "Charusat University");
            institute.display();
            institute.StringGetName("Charusat University");
            institute.setName("PARUL UNIVERSITY");
            institute.displayclass();
            System.out.println("Institute Location: " + getInstituteLocation());
            System.out.println("Interface mehthod called ");
            Student in = new Institue_Management();
            // in.displayclass();
            in.setName("New name added");
        }
}
