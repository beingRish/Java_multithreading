package being.rish.Lecture14;

/*
Lambda Expression:- Anonymous Function
*/

public class LambdaExpression {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello world");
            }
        });
        t1.start();
    }
}