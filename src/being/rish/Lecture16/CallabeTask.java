package being.rish.Lecture16;

import java.util.concurrent.Callable;

public class CallabeTask implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(1);
        return null;
    }
}
