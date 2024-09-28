
import java.util.concurrent.Semaphore;

public class SantaClausProblem extends Thread{
    
    Semaphore santaSem = new Semaphore(0);
    Semaphore elfTex = new Semaphore(1);
    Semaphore reindeerSem = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);
    int elves = 0;
    int reindeer = 0;

    public Semaphore getSantaSem() {
        return santaSem;
    }

    public Semaphore getElfTex() {
        return elfTex;
    }

    public Semaphore getReindeerSem() {
        return reindeerSem;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public int getElves() {
        return elves;
    }

    public int getReindeer() {
        return reindeer;
    }

}