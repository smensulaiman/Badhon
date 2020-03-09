import java.io.*;
public class Time_matrix {

    int time[][];
    int n;

    public Time_matrix(int n) {
        this.n = n;
        time = new int[n + 1][n + 1];
    }

    public void print(){
        
        for(int i=0 ; i<time.length; i++){
            for(int j=0 ; j<time[i].length ; j++){
                System.out.println(time[i][j]);
            }
        }
    }
    
    void populateT() {
        try {
             BufferedReader in = null;
            int rows = 0;
            int row = 0, i;
            in = new BufferedReader(new FileReader("Cost_20.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens.length > 0 && tokens.length>=n) {
                    System.out.println("Token Length :"+tokens.length);
                    for (int j = 0; j < n; j++) {
                        if (row < n) {
                            time[row][j] = Integer.parseInt(tokens[j]);
                        }
                    }
                } else {
                    System.out.println("Token Empty");
                }
                row++;

            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
    }
}
