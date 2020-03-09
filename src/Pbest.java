import java.text.DecimalFormat;

public class Pbest {

    double[] p_best;
    int[][] part_config;
    DecimalFormat f = new DecimalFormat("##.00");

    public Pbest(int p, int n) {
        p_best = new double[p + 1];
        part_config = new int[p + 1][n + 1];

        for (int i = 1; i <= p; i++) {
            p_best[i] = Integer.MIN_VALUE;
        }

    }

    public Pbest(int p, int n, double[] fit, double[] pb) {
        p_best = new double[p + 1];
        part_config = new int[p + 1][n + 1];
    }

    public double[] populatePbest(int p, int n, double[] fit, double[] pb, int[][] pArr) {
        for (int i = 1; i <= p; i++) {
            if (fit[i] > pb[i]) {
                p_best[i] = fit[i];
                for (int j = 1; j <= p; j++) {
                    for (int k = 1; k <= n; k++) {
                        part_config[j][k] = pArr[j][k];
                    }

                }
            } else {
                p_best[i] = pb[i];
            }
        }
        return p_best;
    }
}
