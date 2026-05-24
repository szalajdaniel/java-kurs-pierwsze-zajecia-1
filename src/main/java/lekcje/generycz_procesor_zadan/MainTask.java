package main.java.lekcje.generycz_procesor_zadan;
public class MainTask {
    public static void main(String[] args) {
        Task<String> printTask = new StringPrinterTask();
        TaskRunner<String> stringRunner = new TaskRunner<>(printTask, "kurs javy");
        stringRunner.run();

        Task<Integer> squareTask = new NumberSquareTask();
        TaskRunner<Integer> numberRunner = new TaskRunner<>(squareTask, 5);
        numberRunner.run();

    }
}