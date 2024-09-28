public class Elf implements Runnable{

    int id;
    SantaClausProblem santaClausProblem;

    public Elf(SantaClausProblem santaClausProblem, int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                santaClausProblem.getElfTex().acquire();
                santaClausProblem.getMutex().acquire();
                santaClausProblem.elves++;
                if (santaClausProblem.elves == 3) {
                    santaClausProblem.getSantaSem().release();
                } else {
                    santaClausProblem.getElfTex().release();
                }
                santaClausProblem.getMutex().release();
                getHelp();
                santaClausProblem.getMutex().acquire();
                santaClausProblem.elves--;
                if (santaClausProblem.elves == 0) {
                    santaClausProblem.getElfTex().release();
                }
                santaClausProblem.getMutex().release();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void getHelp() {
        System.out.println("Elf " + id + " is getting help");
    }
    
}
