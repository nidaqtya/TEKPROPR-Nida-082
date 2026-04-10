class Sum {
    private int total = 0;

    // synchronized agar thread aman
    public synchronized void add(int value) {
        total += value;
    }

    public int getTotal() {
        return total;
    }
}

class SumTask implements Runnable {
    private int start;
    private int end;
    private Sum sum;

    public SumTask(int start, int end, Sum sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

   public void run() {
        int partial = 0;

        for (int i = start; i <= end; i++) {
            partial += i;
        }

        System.out.println(
            Thread.currentThread().getName() +
            " menghitung dari " + start + " sampai " + end + "\n" +
            Thread.currentThread().getName() +
            " hasil parsial: " + partial + "\n" +
            "--------------------------------"
        );

        sum.add(partial);
    }
}

public class ParallelSum {
    public static void main(String[] args) throws InterruptedException {

        int jumlahThread = 4;
        int angkaAkhir = 1000;

        Sum sum = new Sum();
        Thread[] threads = new Thread[jumlahThread];

        int range = angkaAkhir / jumlahThread;

        for (int i = 0; i < jumlahThread; i++) {

            int start = i * range + 1;
            int end = (i == jumlahThread - 1)
                    ? angkaAkhir
                    : (i + 1) * range;

            threads[i] = new Thread(
                    new SumTask(start, end, sum),
                    "Thread-" + (i + 1)
            );

            threads[i].start();
        }

        for (int i = 0; i < jumlahThread; i++) {
            threads[i].join();
        }

        System.out.println("\nHasil akhir: " + sum.getTotal());
    }
}