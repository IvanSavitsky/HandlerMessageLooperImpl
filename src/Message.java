public class Message {
    Runnable runnable;
    Handler target;

    Message(Runnable runnable, Handler handler) {
        this.runnable = runnable;
        this.target = handler;
    }
}
