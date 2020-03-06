import java.util.UUID;

/**
 * The class to request all the data for the server from DataGenerator
 * @see Request
 */
public class Request extends DataGenerator{
    /**
     * count - to keep count of how many request initiated
     */
    private static int count;
    /**
     * randUUID - to save the randomly generated UUID
     */
    protected UUID randUUID;

    /**
     * Default constructor
     */
    public Request() {
    }

    /**
     * to access the value of count var
     * @return integer - value of the count var
     */
    public static int getCount() {
        return count;
    }

    /**
     * to set the value of count var
     * @param count  integer - value of count to be set
     */
    public static void setCount(int count) {
        Request.count = count;
    }

    /**
     * constructor with UUID initialization
     * @param randUUID UUID to be initialize object with
     */
    public Request(UUID randUUID) {
        this.randUUID = randUUID;
        count++;
    }

    /**
     * Prints the address of an request object and UUID
     * @return String with request object mem. address and UUID
     */
    @Override
    public String toString() {
        return "RequestInheritance." + super.toString() + '\n' + "UUID: " + randUUID;
    }

    /**
     * to access the value of count var.
     * @return integer - value of count var.
     */
    public static int count() {
        return count;
    }

    /**
     * to access the value of randUUID var.
     * @return UUID - value of randUUID var.
     */
    public UUID getRandUUID() {
        return randUUID;
    }

    /**
     * to set the value of randUUID var.
     * @param randUUID UUID - value to be set to randUUID var.
     */
    public void setRandUUID(UUID randUUID) {
        this.randUUID = randUUID;
    }
}
