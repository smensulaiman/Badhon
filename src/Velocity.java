
import java.util.Random;

public class Velocity {

    double[][] vArr;
    int p, n;

    public Velocity(int n, int p) {
        vArr = new double[p + 1][n + 1];
        this.p = p;
        this.n = n;
    }

    void populateV() {
        Random rand = new Random();
        double a;
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= n; j++) {
                a = rand.nextDouble();
                a = (a * 5.2) + (0.2 * 0.9);
                if (a > n || a < 0) {
                    j--;
                    break;
                }
                vArr[i][j] = a;
            }
        }

    }
}
