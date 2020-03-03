import java.util.UUID;

public class Request extends DataGenerator{
    private static int count;
    protected UUID randUUID;
    //private UUID randUUID;

    public Request() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Request.count = count;
    }

    public Request(UUID randUUID) {
        this.randUUID = randUUID;
        count++;
    }

    @Override
    public String toString() {
        return "RequestInheritance." + super.toString() + '\n' + "UUID: " + randUUID;
    }

    public static String count() {
        return String.valueOf(count);
    }

    public UUID getRandUUID() {
        return randUUID;
    }

    public void setRandUUID(UUID randUUID) {
        this.randUUID = randUUID;
    }
}
