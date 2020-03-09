
class Part_update {

    int pUpdate[][], city, p;

    public Part_update(int p, int n) {
        pUpdate = new int[p + 1][n + 1];
        this.p = p;
        city = n;
    }

    void update(double[][] velo, int[][] part) {
        double temp[][] = new double[p + 1][city + 1];
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= city; j++) {
                temp[i][j] = velo[i][j] + part[i][j];
                if (temp[i][j] > city) {
                    temp[i][j] = city;
                }
                if (temp[i][j] < 0) {
                    temp[i][j] = 0;
                }
            }
        }

        System.out.println();
        int loc = 1, c = 0;
        double temp1 = Integer.MAX_VALUE;
        for (int i = 1; i <= p; i++) {
            c = 0;
            for (int k = 1; k <= city; k++) {
                for (int j = 1; j <= city; j++) {
                    if (temp[i][j] < temp1) {

                        loc = j;
                        temp1 = temp[i][j];
                    }
                    if (temp[i][j] == temp1) {
                        if (velo[i][j] < velo[i][loc]) {
                            loc = j;
                            temp1 = temp[i][j];
                        }
                    }
                }
                pUpdate[i][loc] = ++c;
                temp[i][loc] = Integer.MAX_VALUE;
                temp1 = Integer.MAX_VALUE;
            }

        }
    }
}
