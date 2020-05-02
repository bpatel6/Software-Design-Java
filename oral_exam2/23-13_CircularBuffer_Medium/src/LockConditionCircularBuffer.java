import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Fig. 23.18: CircularBuffer.java
// Synchronizing access to a shared three-element bounded buffer.

/**
 * The class represents the lock and condition implementation of the circular buffer
 * @see LockConditionCircularBuffer
 */
public class LockConditionCircularBuffer implements Buffer {
    private final int[] buffer = {-1, -1, -1}; // shared buffer

    private int occupiedCells = 0; // count number of buffers used
    private int writeIndex = 0; // index of next element to write to
    private int readIndex = 0; // index of next element to read

    // Lock to control synchronization with this buffer
    private final Lock accessLock = new ReentrantLock();

    // Condition to control reading and writing
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    // place value into buffer

    /**
     * Method to place values into the buffer
     * @param value to be stored in buffer
     * @throws InterruptedException
     */
    public void blockingPut(int value)
            throws InterruptedException {
        accessLock.lock(); // locks the object
        // Output thread information and buffer information, then wait
        try {
            // while buffer is not empty, place thread in waiting state
            while (occupiedCells == buffer.length) {
                System.out.println("Producer tries to write.");
                displayState("Buffer is full. Producer waits.%n");
                canWrite.await(); // wait until a buffer is empty
            }

            buffer[writeIndex] = value; // set new buffer value

            // indicate producer cannot store another value
            occupiedCells++;
            // until consumer retrieves current buffer value
            writeIndex = (writeIndex + 1) % buffer.length;


            displayState("Producer writes " + value);
            canRead.signalAll(); // Signal any thread waiting to read from buffer
        }
        finally {
            accessLock.unlock(); // unlock this object
        }
    }

    // return value from buffer

    /**
     * Method to return the value from the buffer
     * @return value from the buffer
     * @throws InterruptedException
     */
    public int blockingGet() throws InterruptedException {
        int readValue = 0; // Initialize value read from buffer
        accessLock.lock(); // lock this object

        // Output thread information and buffer information, then wait
        try {
            // if there is no data to read, place thread in waiting state
            while (occupiedCells == 0) {
                System.out.println("Consumer tries to read.");
                displayState("Buffer is empty. Consumer waits.%n");
                canRead.await(); // wait until a buffer cell is filled
            }

            readValue = buffer[readIndex]; // read value from buffer

            // update circular read index
            // indicate that producer can store another value
            // because consumer just retrieved buffer value
            readIndex = (readIndex + 1) % buffer.length;

            occupiedCells--; // one fewer buffer cells are occupied

            displayState("Consumer reads " + readValue);

            canWrite.signalAll(); // signal any thread waiting for buffer to be empty
        }
        finally {
            accessLock.unlock(); // unlock this object
        }
        return readValue;
    }

    // display current operation and buffer state

    /**
     * Method to display current operation and the state of the buffer
     * @param operation current operation
     */
    public void displayState(String operation) {
        try {
            accessLock.lock();
            // output operation and number of occupied buffer cells
            System.out.printf("%s%s%d)%n%s", operation,
                    " (buffer cells occupied: ", occupiedCells, "buffer cells:  ");

            for (int value : buffer)
                System.out.printf(" %2d  ", value); // output values in buffer

            System.out.printf("%n               ");

            for (int i = 0; i < buffer.length; i++)
                System.out.print("---- ");

            System.out.printf("%n               ");

            for (int i = 0; i < buffer.length; i++) {
                if (i == writeIndex && i == readIndex)
                    System.out.print(" WR"); // both write and read index
                else if (i == writeIndex)
                    System.out.print(" W   "); // just write index
                else if (i == readIndex)
                    System.out.print("  R  "); // just read index
                else
                    System.out.print("     "); // neither index
            }

            System.out.printf("%n%n");
        }
        finally {
            accessLock.unlock(); // unlock this object
        }
    }
} // end class CircularBuffer


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