package sma;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;
import sma.io.Logger;
import sma.random.IRandom;
import sma.random.MockedRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmaSimulation3Test extends YamlSimulationTestBase {

    public static final Logger log = Logger.init(null, Logger.LOG_MODE.CONSOLE, true);

    @Test
    public void testTandem_RandomList() {
        System.out.println("Final Test " +
                "\nQueue1=G/G/1 Arrivals=1-4 Departure=1-1.5 " +
                "\nQueue2=G/G/3/5 Arrivals=Q1,Q3 Departures=5-10" +
                "\nQueue2=G/G/2/8 Arrivals=Q2,Q3 Departures=10-20");


        Map<String, Queue> queues = new HashMap<>();
        queues.put("Q1", new Queue("Q1", 1, 1000, 1, 4, 1, 1.5f));
        queues.put("Q2", new Queue("Q2", 3, 5, 0, 0, 5, 10));
        queues.put("Q3", new Queue("Q3", 2, 8, 0, 0, 10, 20));

        MultiValuedMap<String, Route> network = new ArrayListValuedHashMap<>();
        network.put("Q1", new Route("Q1", "Q3", 0.2f));
        network.put("Q1", new Route("Q1", "Q2", 0.8f));
        network.put("Q2", new ExitRoute("Q2", 0.2f));
        network.put("Q2", new Route("Q2", "Q1", 0.3f));
        network.put("Q2", new Route("Q2", "Q3", 0.5f));
        network.put("Q3", new ExitRoute("Q3", 0.3f));
        network.put("Q3", new Route("Q3", "Q2", 0.7f));

        IRandom random = new MockedRandom(getRandoms());
        List<Event> arrivals = new ArrayList<>();
        arrivals.add(new Event(Event.ARRIVAL, 1.0f, "Q1"));
        SmaSimulation sim = new SmaSimulation(log, queues, network, random, 100, arrivals);
        sim.run();
    }

    private float[] getRandoms() {
        return new float[] {
                0.00003425449107169541f,
                0.00654260802752446600f,
                0.24963813349000372000f,
                0.68088349682353930000f,
                0.04874789352883356000f,
                0.31084766424004090000f,
                0.37190387008064096000f,
                0.03363918563525617000f,
                0.42508445656675880000f,
                0.19113120448375742000f,
                0.50606005663049940000f,
                0.65747081665821690000f,
                0.57692598195226320000f,
                0.19286255311509200000f,
                0.83674764521540330000f,
                0.81880023637486590000f,
                0.39084514783222324000f,
                0.65142323618746930000f,
                0.42183811203947996000f,
                0.57107939977350750000f,
                0.07616535697277009000f,
                0.54758318203191800000f,
                0.58838776832917210000f,
                0.38206375110468420000f,
                0.97417646122752040000f,
                0.06770409468922961000f,
                0.93148208587568740000f,
                0.91307840248911730000f,
                0.39797487565424530000f,
                0.01320125019368092300f,
                0.52143878722588680000f,
                0.59480836037721020000f,
                0.60839683227997640000f,
                0.20379496570831820000f,
                0.92483845052160880000f,
                0.64414404986011380000f,
                0.03151352351454960000f,
                0.01908299151180419700f,
                0.64485137898743210000f,
                0.16661338683235474000f,
                0.82315688521258630000f,
                0.22296507583682745000f,
                0.58632948506687530000f,
                0.98893164800602660000f,
                0.88594476938391230000f,
                0.21545095256007438000f,
                0.15113193920703513000f,
                0.86620038877654230000f,
                0.44427425655241326000f,
                0.85638300174376350000f,
                0.56915333329166030000f,
                0.70828665893995020000f,
                0.28275185776332940000f,
                0.00560483302874258700f,
                0.07052310872266483000f,
                0.46991376626181230000f,
                0.75352935623898600000f,
                0.92410704187914790000f,
                0.50444499915007760000f,
                0.34899483789764470000f,
                0.65801403868296230000f,
                0.68068138867862620000f,
                0.01014523785042979000f,
                0.93774042966492080000f,
                0.10842206623269784000f,
                0.70861465067811910000f,
                0.34539827975358010000f,
                0.97107143316663720000f,
                0.47464373506053603000f,
                0.65695339679521010000f,
                0.47809878811797700000f,
                0.31686853076644170000f,
                0.52188937662320520000f,
                0.68087093526503420000f,
                0.04634863585435860400f,
                0.85258944841532410000f,
                0.84458464755973780000f,
                0.31566768414274900000f,
                0.29252767149789030000f,
                0.87278525632986900000f,
                0.70198395923782590000f,
                0.07893621465757020000f,
                0.07681699982873949000f,
                0.67204696752207220000f,
                0.36097079694861540000f,
                0.94542221741836780000f,
                0.57564352714108850000f,
                0.94791368418071790000f,
                0.05151367874993715000f,
                0.83911264147082600000f,
                0.27051452116058370000f,
                0.66827354190432010000f,
                0.64024650395797560000f,
                0.28708225620616434000f,
                0.83271093561022400000f,
                0.04778870178562589000f,
                0.12764204128737483000f,
                0.37962988612142334000f,
                0.50930824942468510000f,
                0.27787564034768036000f
        };
    }
}
