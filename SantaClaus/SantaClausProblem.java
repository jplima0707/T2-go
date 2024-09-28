
import java.util.concurrent.Semaphore;

public class SantaClausProblem extends Thread{
    
    Semaphore santaSem = new Semaphore(0);
    Semaphore elfTex = new Semaphore(1);
    Semaphore reindeerSem = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);
    int elves = 0;
    int reindeer = 0;

    public SantaClausProblem() {
        SantaClaus santaClaus = new SantaClaus(this);
        santaClaus.run();
        for (int i = 0; i < 9; i++) {
            Reindeer reindeer = new Reindeer(this, i);
            reindeer.run();
        }
        for (int i = 0; i < 10; i++) {
            Elf elf = new Elf(this, i);
            elf.run();
        }
    }

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