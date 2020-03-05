import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneTimePadTest {

    @Test
    void onetimepadeasy1() {
        OneTimePad p1 = new OneTimePad("MEET ME AT THREE");
        assertEquals("ZRRG ZR NG GUERR", p1.encrypt());
    }

    @Test
    void onetimepadeasy2() {
        OneTimePad p2 = new OneTimePad("HI HOW ARE YOU");
        assertEquals("UV UBJ NER LBH", p2.encrypt());
    }

    public static void main(String[] args) {
        OneTimePad p3 = new OneTimePad("HEHE YOU ARE THE BEST");
        System.out.println(p3.encryptmedium());
    }
}
