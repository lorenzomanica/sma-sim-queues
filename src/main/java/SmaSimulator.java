import sma.Queue;
import sma.SmaSimulation;

public class SmaSimulator {


    public static void main(String[] args) {
        Queue q1 = new Queue(1, 5, 2f, 4f, 3f, 5f);
        int randoms = 100_000;
        float first = 3f;

        float[] randomsList = new float[] {
                0.2176f,
                0.0103f,
                0.1109f,
                0.3456f,
                0.9910f,
                0.2323f,
                0.9211f,
                0.0322f,
                0.1211f,
                0.5131f,
                0.7208f,
                0.9172f,
                0.9922f,
                0.8324f,
                0.5011f,
                0.2931f
        };


        SmaSimulation sim = new SmaSimulation(q1, randomsList, first);
        sim.run();
    }


}
