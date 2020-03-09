import java.io.*;

public class Profit {

    int[] ear, exp, pr;
    int n, tpr;

    public Profit(int city) {
        n = city;
        tpr = 0;
        ear = new int[city + 1];
        exp = new int[city + 1];
        pr = new int[city + 1];
    }

    void populatePr() {
        try {
            BufferedReader in = null;
            int rows = 0;
            int row = 0, i;
            in = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\PSO code\\City_20\\Earning_City_20.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int j = 1; j <= n; j++) {
                    ear[j] = Integer.parseInt(tokens[j - 1]);

                }
            }
            if (in != null) {
                in.close();
            }
            in = null;
            in = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\PSO code\\City_20\\Expense_City_20.txt"));
            line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int j = 1; j <= n; j++) {
                    exp[j] = Integer.parseInt(tokens[j - 1]);
                }
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        } finally {

            System.out.println("Earning of each city::");
            for (int i = 1; i <= n; i++) {
                System.out.print(ear[i] + " ");
            }
            System.out.println();
            System.out.println("Expense of each city::");
            for (int i = 1; i <= n; i++) {
                System.out.print(exp[i] + " ");
            }
            System.out.println();
            System.out.println("Net profit of each city::");
            for (int i = 1; i <= n; i++) {
                pr[i] = ear[i] - exp[i];
                tpr = tpr + pr[i];
                System.out.print(pr[i] + " ");
            }
            System.out.println();
            System.out.println("Total profit from all cities:: " + tpr);
        }
    }
}
