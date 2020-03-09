public class Sweep {

    double[] fitness, profit;
    int[] store_route, vehicle, temp, temp1;
    double alpha = 0.8, beta = 0.4, gama = 0.2;

    void fit(int p, int[][] cost, int vCap, int[] dmnd, int city, int[][] part, int[][] time, int max_time, int[] ts, int tpr) {
        Time_constraint tc = new Time_constraint(p);
        store_route = new int[city + 1];
        vehicle = new int[p + 1];
        for (int i = 1; i <= p; i++) {
            vehicle[i] = 0;
        }
        fitness = new double[p + 1];
        for (int i = 1; i <= p; i++) {
            fitness[i] = 0;
        }
        temp = new int[p + 1];
        temp1 = new int[p + 1];
        profit = new double[p + 1];
        for (int i = 1; i <= p; i++) {
            profit[i] = 0;
        }
        for (int i = 1; i <= p; i++) {
            int c = 0, d = 0, tot = 0, a = 0, s = 0;
            for (int j = 1; j <= city; j++) {

                a = part[i][j];
                d = d + dmnd[a];
                if (d > vCap) {
                    fitness[i] = fitness[i] + tc.check_constraint(store_route, time, max_time, 0, s, cost, ts, i, vehicle);

                    for (int k = 0; k < s; k++) {
                        store_route[k] = 0;
                    }
                    s = 0;
                    c = 0;
                    d = dmnd[a];
                }
                store_route[s++] = a;
                if (j == city) {
                    fitness[i] = fitness[i] + tc.check_constraint(store_route, time, max_time, 0, s, cost, ts, i, vehicle);
                }
                c = a;
            }
        }
        temp = tc.getVehicle();
        temp1 = tc.getTime();
        for (int i = 1; i <= p; i++) {
            double z = tpr - fitness[i];
            profit[i] = z;
            z = (Math.pow(profit[i], alpha) / (Math.pow(temp[i], beta) * Math.pow(temp1[i], gama)));
            fitness[i] = z;
        }

    }
}
