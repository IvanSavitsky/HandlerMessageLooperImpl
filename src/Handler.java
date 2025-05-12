public class Handler {
    public MessageQueue messageQueue;

    public Handler(Looper looper) {
        this.messageQueue = looper.messageQueue;
    }

    public void dispatchMessage(Message message) {
        handleCallback(message);
    }

    public void handleCallback(Message message) {
        message.runnable.run();
    }

    public void enqueueMessage(Message message) { // метод для отправки сообщения в очередь
        messageQueue.enqueueMessage(message);
    }

    public void post(Runnable runnable) {
        Message message = new Message(runnable, this);
        enqueueMessage(message);
    }
}
