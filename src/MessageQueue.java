import java.util.LinkedList;

public class MessageQueue {
    private final LinkedList<Message> messages = new LinkedList<>();

    public void enqueueMessage(Message message) {
        //synchronized (this) { // хз надо или нет
            messages.add(message);
        //}
    }

    public Message next() {
        for (; ; ) {
            synchronized (this) { // Без него не работает)
                if (!messages.isEmpty()) {
                    Message message = messages.getFirst();
                    messages.remove(message);
                    return message;
                }
            }
        }
    }
}
