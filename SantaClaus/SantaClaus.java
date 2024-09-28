
import java.util.concurrent.Semaphore;

public class SantaClaus implements Runnable{

    private Semaphore santaSem;
    private Semaphore reindeerSem;
    private Semaphore mutex;
    private int reindeer;
    private int elves;

    public SantaClaus(SantaClausProblem santaClausProblem){
        this.santaSem = santaClausProblem.getSantaSem();
        this.reindeerSem = santaClausProblem.getReindeerSem();
        this.mutex = santaClausProblem.getMutex();
        this.reindeer = santaClausProblem.getReindeer();
        this.elves = santaClausProblem.getElves();
    }

    @Override
    public void run() {
        while (true) { 
            try {
                santaSem.acquire();
                mutex.acquire();
                if (reindeer == 9) {
                    prepareSleigh();
                    reindeerSem.release(9);
                    reindeer = 0;
                } else if (elves == 3) {
                    helpElves();
                }
            mutex.release();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }   

    private void prepareSleigh() throws InterruptedException {
        System.out.println("Santa is preparing the sleigh");
        Thread.sleep(2000);
        System.out.println("Done");
    }

    private void helpElves() throws InterruptedException {
        System.out.println("Santa is helping the elves");
        Thread.sleep(2000);
        System.out.println("Done");
    }

}
