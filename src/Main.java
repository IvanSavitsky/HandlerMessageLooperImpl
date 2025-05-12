public class Main {
    public static void main(String[] args) {
        Looper looper = new Looper();
        Handler handler = new Handler(looper);

        new Thread(() -> {
            System.out.println("post action 1 from: " + Thread.currentThread());
            handler.post(() -> System.out.println("some action 1 executed in: " + Thread.currentThread()));
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("post action 2 from: " + Thread.currentThread());
            handler.post(() -> System.out.println("some action 2 executed in: " + Thread.currentThread()));
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("post action 3 from: " + Thread.currentThread());
            handler.post(() -> System.out.println("some action 3 executed in: " + Thread.currentThread()));
        }).start();

        looper.loop();
    }
}