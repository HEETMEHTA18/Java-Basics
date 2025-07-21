package Code;

import java.util.Locale;
import java.util.Arrays;
public class stringClass {
    public static void main(String[] args) {
     String s1="Heet Mehta";
     String s2="Heet";
     String s3 = new String("Heet");
        String s6 = new String("Heet");
     String s4 = s2;

         System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s4));
        System.out.println(s1.intern()==s3.intern());
        System.out.println(s3==s2.intern());
        System.out.println(s4.charAt(0));
        System.out.println(s4.charAt(2));
        System.out.println(s4.charAt(2));
        System.out.println(s4.charAt(3));
        System.out.println(s4.indexOf('e'));
        System.out.println(s4.lastIndexOf('e'));
        System.out.println(s1.length());
        System.out.println(s1.substring(5,10));
        System.out.println(s1.contains("HeetMehta"));
        System.out.println(s1.equalsIgnoreCase("het Mehta"));
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.trim());
//        System.out.println("chatgpt".contains("got"));
        System.out.println(s1.split(s1));
        System.out.println("A,B,C".split(","));
        StringBuffer sb = new StringBuffer("6,D,C");
        System.out.println(sb.toString());
        
    }
}
