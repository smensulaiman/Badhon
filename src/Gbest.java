
import java.text.DecimalFormat;

public class Gbest {

    double g_best;
    int loc;
    int[] gConfig;
    DecimalFormat f = new DecimalFormat("##.00");

    public double minGbest(double[] p_best, int n, int[][] part_config, double[] profit, int[] temp, int[] temp1) {
        gConfig = new int[n + 1];
        double min = Integer.MIN_VALUE;
        for (int i = 1; i < p_best.length; i++) {
            if (min < p_best[i]) {
                min = p_best[i];
                loc = i;
            }

        }
        g_best = min;

        for (int i = 1; i <= n; i++) {
            gConfig[i] = part_config[loc][i];
        }

        return g_best;
    }
}
