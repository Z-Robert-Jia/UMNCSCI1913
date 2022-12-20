// Members: Zheng Robert Jia
// Daniyal Khan
public class Message {
    private String fromPerson;
    private String toPerson;
    private String message;


    /**
     * Constructor!
     */
    public Message(String fromPerson, String toPerson, String message){
        this.fromPerson = fromPerson;
        this.toPerson = toPerson;
        this.message = message;
    }
    /**
     *
     * @return the people who sent the message
     */
    public String getFrom(){
        return fromPerson;
    }

    /**
     *
     * @return the person who recieved the message
     */
    public String getTo(){
        return toPerson;
    }

    /**
     * change the receiver to toPerson
     * @param toPerson
     */
    public void setTo(String toPerson){
        this.toPerson = toPerson;
    }

    /**
     *
     * @return the message being sent
     */
    public String getMessage(){
        return message;
    }

    /**
     * change the original message into the new message
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * custmoize toString function
     * @return
     */
    @Override
    public String toString() {
        return "Message from: " + fromPerson + " to: " + toPerson + " Message: \""+message + "\"";
    }
}
