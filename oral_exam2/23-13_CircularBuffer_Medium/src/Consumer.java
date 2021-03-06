// Fig. 23.11: Consumer.java
// Consumer with a run method that loops, reading 10 values from buffer.

import java.security.SecureRandom;

/**
 * The class to represent Consumer that checkout buffer and simulates the random threads
 * @see Consumer
 */
public class Consumer implements Runnable {
    /**
     * Stores random thread generated
     */
    private static final SecureRandom generator = new SecureRandom();
    /**
     * Reference to shared object
     */
    private final Buffer sharedLocation; // reference to shared object

    /**
     * Constructor for consumer class
     * @param sharedLocation location of the buffer
     */
    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }


    /**
     * Reads the sharedlocation's value 10 times and sums the value
     */
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            // sleep 0 to 3 seconds, read value from buffer and add to sum
            try {
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.blockingGet();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf("%n%s %d%n%s%n",
                "Consumer read values totaling", sum, "Terminating Consumer");
    }
} // end class Consumer


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