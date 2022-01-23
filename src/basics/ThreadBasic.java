package basics;

public class ThreadBasic implements Runnable{
    public static void main(String[] args) {

        Thread t = new Thread(new ThreadBasic());
        t.start();
    }



    @Override
    public void run() {

        for(int i=1; i<=10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
