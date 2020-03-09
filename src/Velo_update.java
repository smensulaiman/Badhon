class Velo_update {

    double[][] velo;
    int part, city;

    public Velo_update(int p, int n) {
        velo = new double[p + 1][n + 1];
        part = p;
        city = n;
    }

    void update(int p, int n, int[][] pConfig, int[][] pArr, int[] gConfig, double[][] vel) {
        double res;
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= n; j++) {
                velo[i][j] = vel[i][j];
            }
        }
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= n; j++) {
                res = 0.6 * velo[i][j] + 0.2 * 0.3 * (pConfig[i][j] - pArr[i][j]) + 0.2 * 0.5 * (gConfig[j] - pArr[i][j]);  //Dont Know
                velo[i][j] = res;
            }
        }
    }

}
