
import java.io.*;

public class Demand {

    int[] d, bd, ed;
    int n, vC;

    public Demand(int city, int vCap) {
        n = city;
        vC = vCap;
        d = new int[city + 1];
        bd = new int[city + 1];
        ed = new int[city + 1];
    }

    void populateD() {
        try {
            BufferedReader in = null;
            int rows = 0;
            int row = 0, i;
            in = new BufferedReader(new FileReader("Base_Demand_20.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");

                for (int j = 1; j <= n; j++) {
                    bd[j] = Integer.parseInt(tokens[j - 1]);
                }
            }
            if (in != null) {
                in.close();
            }
            in = null;
            in = new BufferedReader(new FileReader("Excess_Demand_20.txt"));
            line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int j = 1; j <= n; j++) {
                    ed[j] = Integer.parseInt(tokens[j - 1]);
                }
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        } finally {
            System.out.println();
            System.out.println("Base Demand::");
            for (int i = 1; i <= n; i++) {
                System.out.print(bd[i] + " ");
            }
            System.out.println();
            System.out.println("Excess Demand::");
            for (int i = 1; i <= n; i++) {
                System.out.print(ed[i] + " ");
            }
            System.out.println();
            System.out.println("Total Demand::");
            for (int i = 1; i <= n; i++) {
                d[i] = bd[i] + ed[i];
                System.out.print(d[i] + " ");
            }
        }
    }
}
