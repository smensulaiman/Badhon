import java.util.Random;
public class Particle {

    int[][] pArr;
    int p, n;

    public Particle(int n, int p) {
        pArr = new int[p + 1][n + 1];
        this.p = p;
        this.n = n;
    }

    void populateP() {
        Random rand = new Random();
        int a;
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= n; j++) {
                a = rand.nextInt(n) + 1;
                pArr[i][j] = a;
                for (int k = 1; k < j; k++) {
                    if (pArr[i][j] == pArr[i][k]) {
                        j--;
                        break;
                    }
                }
            }
        }
    }
}
