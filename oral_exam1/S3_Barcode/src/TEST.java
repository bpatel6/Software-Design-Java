import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TEST {
    @Test
    void zipcode1() {
        POSTNET p1 = new POSTNET(52241);
        assertEquals(52241, p1.getZipcode());
        assertEquals(6, p1.checksum());
        assertEquals(522416, p1.getZipcode());
        assertEquals("|.|.|...|.|..|.|.|..|...||.||..|", p1.ziptobinary());
        assertEquals("10101000101001010100100011011001", p1.getBinaryZip());
    }

    @Test
    void zipcode2() {
        POSTNET p1 = new POSTNET(52242);
        assertEquals(52242, p1.getZipcode());
        assertEquals(5, p1.checksum());
        assertEquals(522425, p1.getZipcode());
        assertEquals("|.|.|...|.|..|.|.|..|..|.|.|.|.|", p1.ziptobinary());
        assertEquals("10101000101001010100100101010101", p1.getBinaryZip());
    }

    @Test
    void zipcode3() {
        POSTNET p1 = new POSTNET(522416201);
        assertEquals(522416201, p1.getZipcode());
        assertEquals("|.|.|...|.|..|.|.|..|...||.||....|.|||......|||", p1.ziptobinary());
        assertEquals("10101000101001010100100011011000010111000000111", p1.getBinaryZip());
    }

    @Test
    void UPC1() {
        UPC u1 = new UPC("01254667375");
        assertEquals(4, u1.checksum());
        assertEquals("012546673754", u1.getupc());
        assertEquals("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101", u1.encrypt());
        assertEquals("012546673754", UPC.decrypt(u1.getEncryptedupc()));
    }

}
