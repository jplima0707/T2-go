public class Reindeer implements Runnable {

    int id;
    SantaClausProblem santaClausProblem;

    public Reindeer(SantaClausProblem santaClausProblem, int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                santaClausProblem.getReindeerSem().acquire();
                santaClausProblem.getMutex().acquire();
                santaClausProblem.reindeer++;
                if (santaClausProblem.reindeer == 9){
                    santaClausProblem.getSantaSem().release();
                }
                santaClausProblem.getMutex().release();

                santaClausProblem.getReindeerSem().acquire();
                getHitched();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getHitched() {
        System.out.println("Reindeer are getting hitched");
    }   

}
