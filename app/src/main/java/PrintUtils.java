public class PrintUtils {
    private static final int DELAY_MS = 500;

    public static void delayedPrint(String text) {
        if (text == null) return;
        
        System.out.println(text);
        try {
            Thread.sleep(DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
