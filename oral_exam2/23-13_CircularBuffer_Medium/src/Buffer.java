// Fig. 23.9: Buffer.java
// Buffer interface specifies methods called by Producer and Consumer.
/**
 * The interface Buffer to place and obtain buffer value;
 * @see Buffer
 */
public interface Buffer {
    // place int value into Buffer

    /**
     * Place int value into buffer
     * @param value to put in buffer
     * @throws InterruptedException
     */
    public void blockingPut(int value) throws InterruptedException;

    /**
     * Obtain int value from Buffer
     * @return int value of the buffer
     * @throws InterruptedException
     */
    // obtain int value from Buffer
    public int blockingGet() throws InterruptedException;
} // end interface Buffer


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/