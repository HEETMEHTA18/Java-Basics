public class practice {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("world");
        System.out.println(s1 + " " + s2);

        String str = "Hello Java";
        System.out.println(str.length()); // 10
        System.out.println(str.charAt(0)); // H
        System.out.println(str.toLowerCase()); // hello java
        System.out.println(str.toUpperCase()); // HELLO JAVA
        System.out.println(str.indexOf("Java"));// 6
        System.out.println(str.substring(0, 5)); // Hello
        System.out.println(str.replace("Java", "World")); // Hello World

    }
}