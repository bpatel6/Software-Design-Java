public class Test {
    public static void main(String[] args) {
        OneTimePad p1 = new OneTimePad("MEET ME AT THREE");
        System.out.println(p1.encrypt());
        System.out.println(p1.encryptmedium());

        OneTimePad p2 = new OneTimePad("HEHE YOU ARE THE BEST");
        System.out.println(p2.encrypt());
        System.out.println(p2.encryptmedium());
    }
}
