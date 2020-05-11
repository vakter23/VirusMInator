package modele;

public class Test {
    public static void main(String[] args) {
        Action action = new Action();
        Timer timer = new Timer (action, 65000, true);
        timer.start();
        action.start();
    }
}
