
import java.text.DecimalFormat;
import java.lang.*;
import java.io.*;

public class Pso {

    public static void main(String[] args) {
        try {
            DecimalFormat f = new DecimalFormat("##.00");
            BufferedWriter out;
            out = new BufferedWriter(new FileWriter("Output_20.txt"));
            String str, str1, str2, str3;
            double res1, res2[];
            int vCap = 30;
            int nParticle = 20;
            int city = 20;
            int totalTourTime = 100;
            
            System.out.println("vehile capacity: " + vCap + " no. of paticle " + nParticle + " no. of cities " + city + " totao tour time " + totalTourTime);
            Cost_matrix cm = new Cost_matrix(city);
            cm.populateM();
            cm.print();
            Time_matrix tm = new Time_matrix(city);
            tm.populateT();
            tm.print();
            TimeStay ts = new TimeStay(city, totalTourTime);
            ts.populateTS();
            Profit pro = new Profit(city);
            pro.populatePr();
            Particle p = new Particle(city, nParticle);
            p.populateP();
            Velocity v = new Velocity(city, nParticle);
            v.populateV();
            System.out.println("Demand");
            Demand dd = new Demand(city, vCap);
            dd.populateD();
            System.out.println();
            System.out.println("velocity and Particle taken as random");
            System.out.println();
            Sweep sw = new Sweep();
            sw.fit(nParticle, cm.cost, vCap, dd.d, city, p.pArr, tm.time, totalTourTime, ts.t, pro.tpr);
            System.out.println("pbest and gbest are aas follows:");
            System.out.println();
            Pbest pb1 = new Pbest(nParticle, city);

            Pbest pb2 = new Pbest(nParticle, city, sw.fitness, pb1.p_best);
            res2 = pb2.populatePbest(nParticle, city, sw.fitness, pb1.p_best, p.pArr);
            Gbest gb = new Gbest();
            res1 = gb.minGbest(pb2.p_best, city, pb2.part_config, sw.profit, sw.temp, sw.temp1);
            Velo_update vel = new Velo_update(nParticle, city);
            vel.update(nParticle, city, pb2.part_config, p.pArr, gb.gConfig, v.vArr);
            Part_update pu = new Part_update(nParticle, city);
            pu.update(vel.velo, p.pArr);
            
            for (int i = 1; i <= 200; i++) {
                System.out.println();
                System.out.println("loop:" + i);
                for (int k = 1; k <= nParticle; k++) {
                    str = String.valueOf(f.format(res2[k]));
                    out.write(str + "  ");
                }
                str = String.valueOf(f.format(res1));
                str1 = String.valueOf(sw.profit[gb.loc]);
                str2 = String.valueOf(sw.temp[gb.loc]);
                str3 = String.valueOf(sw.temp1[gb.loc]);
                out.write("  -->> " + str);
                out.newLine();
                out.write("Profit: " + str1 + " no. of vehicle: " + str2 + " total time: " + str3);
                out.newLine();
                sw.fit(nParticle, cm.cost, vCap, dd.d, city, pu.pUpdate, tm.time, totalTourTime, ts.t, pro.tpr);
                res2 = pb2.populatePbest(nParticle, city, sw.fitness, pb2.p_best, pu.pUpdate);
                res1 = gb.minGbest(pb2.p_best, city, pb2.part_config, sw.profit, sw.temp, sw.temp1);
                vel.update(nParticle, city, pb2.part_config, p.pArr, gb.gConfig, vel.velo);
                pu.update(vel.velo, pu.pUpdate);
            }
            for (int k = 1; k <= nParticle; k++) {
                str = String.valueOf(f.format(res2[k]));
                out.write(str + "  ");
            }
            str = String.valueOf(f.format(res1));
            str1 = String.valueOf(sw.profit[gb.loc]);
            str2 = String.valueOf(sw.temp[gb.loc]);
            str3 = String.valueOf(sw.temp1[gb.loc]);
            out.write("  -->> " + str);
            out.newLine();
            out.write("Profit: " + str1 + " no. of vehicle: " + str2 + " total time: " + str3);
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
    }
}
