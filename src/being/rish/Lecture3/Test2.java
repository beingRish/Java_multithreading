package being.rish.Lecture3;

public class Test2 {
    public static void main(String[] args) {
        World2 world2 = new World2();
        Thread t1 = new Thread(world2);
        t1.start();

        for(; ;){
            System.out.println("Hello");
        }
    }
}
