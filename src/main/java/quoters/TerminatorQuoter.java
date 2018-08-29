package quoters;

public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @Override
    public void sayQuote() {
        System.out.println("message" + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
