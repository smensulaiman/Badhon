import java.lang.*;

class Time_constraint {

    int[] tVehicle, fTime;

    public Time_constraint(int p) {
        tVehicle = new int[p + 1];
        fTime = new int[p + 1];
        for (int i = 1; i <= p; i++) {
            fTime[i] = 0;
        }
    }

    int check_constraint(int[] store_route, int[][] time, int max_time, int low, int s, int[][] costM, int[] ts, int tv, int[] vehicle) {
        int cost = 0, i, tot = 0, d = 0, a = 0, v = 0;
        //int temp[0] = 0;
        int z = s - low;
        for (i = low; i < s; i++) {

            a = time[d][store_route[i]];
            tot = tot + a;
            tot = tot + ts[store_route[i]];
            d = store_route[i];
        }
        tot = tot + time[d][0];
        if (tot <= max_time || z == 1) {
            cost = cost + costM[0][store_route[0]];
            for (i = 1; i < s; i++) {
                cost = cost + costM[store_route[i - 1]][store_route[i]];
            }
            cost = cost + costM[store_route[i - 1]][0];
            vehicle[tv] = vehicle[tv] + (++v);
            tVehicle[tv] = vehicle[tv];
            fTime[tv] = fTime[tv] + tot;
        } else {
            int high = s;
            s = (int) Math.ceil((high + low) / 2);
            check_constraint(store_route, time, max_time, low, s, costM, ts, tv, vehicle);
            check_constraint(store_route, time, max_time, s, high, costM, ts, tv, vehicle);
        }
        return cost;
    }

    int[] getVehicle() {
        return tVehicle;
    }

    int[] getTime() {
        return fTime;
    }
}
