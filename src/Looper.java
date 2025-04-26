public class Looper {
    MessageQueue messageQueue = new MessageQueue();

    public void loop() {
        for (; ; ) {
            Message message = messageQueue.next();
            message.target.dispatchMessage(message);
        }
    }
}
