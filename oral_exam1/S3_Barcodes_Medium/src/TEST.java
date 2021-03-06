import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TEST class to test the functionality of POSTNET and UPC class
 * @see TEST to test the functionality of POSTNET and UPC class
 */
public class TEST {
    @Test
    public void zipcode1() {
        POSTNET p1 = new POSTNET("52241");
        assertEquals("52241", p1.getZipcode());
        assertEquals(6, p1.checkdigit());
        assertEquals("522416", p1.getZipcode());
        assertEquals("|.|.|...|.|..|.|.|..|...||.||..|", p1.ziptobinary());
        assertEquals("10101000101001010100100011011001", p1.getBinaryZip());
        assertEquals("522416", p1.decrypt());
    }

    @Test
    public void zipcode2() {
        POSTNET p1 = new POSTNET("52242");
        assertEquals("52242", p1.getZipcode());
        assertEquals(5, p1.checkdigit());
        assertEquals("522425", p1.getZipcode());
        assertEquals("|.|.|...|.|..|.|.|..|..|.|.|.|.|", p1.ziptobinary());
        assertEquals("10101000101001010100100101010101", p1.getBinaryZip());
        assertEquals("522425", p1.decrypt());
    }

    @Test
    public void zipcode3() {
        POSTNET p1 = new POSTNET("522416201");
        assertEquals("522416201", p1.getZipcode());
        assertEquals("|.|.|...|.|..|.|.|..|...||.||....|.|||......|||", p1.ziptobinary());
        assertEquals("10101000101001010100100011011000010111000000111", p1.getBinaryZip());
        assertEquals("522416201", p1.decrypt());
    }

    @Test
    public void zipcode4() {
        POSTNET p1 = new POSTNET("5224162015");
        assertEquals("5224162015", p1.getZipcode());
        assertEquals("|.|.|...|.|..|.|.|..|...||.||....|.|||......||.|.|.|", p1.ziptobinary());
        assertEquals("1010100010100101010010001101100001011100000011010101", p1.getBinaryZip());
        assertEquals("5224162015", p1.decrypt());
    }

    @Test
    public void UPC1() {
        UPC u1 = new UPC("01254667375");
        assertEquals(4, u1.checkdigit());
        assertEquals("012546673754", u1.getupc());
        assertEquals("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101", u1.encrypt());
        assertEquals("012546673754", UPC.decrypt(u1.getEncryptedupc()));
    }

    @Test
    public void UPC2() {
        UPC u2 = new UPC("54862532150");
        assertEquals(1, u2.checkdigit());
        assertEquals("548625321501", u2.getupc());
    }

}
