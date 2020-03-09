
import java.io.*;

public class TimeStay {

    int[] t, bt, et;
    int n, tt;//tt=total stay time  

    public TimeStay(int city, int tour) {
        n = city;
        tt = tour / 4;
        t = new int[city + 1];
        bt = new int[city + 1];
        et = new int[city + 1];
    }

    void populateTS() {

        try {
            BufferedReader in = null;
            int rows = 0;
            int row = 0, i;
            in = new BufferedReader(new FileReader("Base_Time_Stay_20.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int j = 1; j <= n; j++) {
                    bt[j] = Integer.parseInt(tokens[j - 1]);
                }
            }
            if (in != null) {
                in.close();
            }
            in = null;
            in = new BufferedReader(new FileReader("Excess_Time_Stay_20.txt"));
            line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int j = 1; j <= n; j++) {
                    et[j] = Integer.parseInt(tokens[j - 1]);
                }
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        } finally {
            System.out.println();
            System.out.println("Base TimeStay::");
            for (int i = 1; i <= n; i++) {
                System.out.print(bt[i] + " ");
            }
            System.out.println();
            System.out.println("Excess TimeStay::");
            for (int i = 1; i <= n; i++) {
                System.out.print(et[i] + " ");
            }
            System.out.println();
            System.out.println("Total TimeStay::");
            for (int i = 1; i <= n; i++) {
                t[i] = bt[i] + et[i];
                System.out.print(t[i] + " ");
            }
        }
    }

}
