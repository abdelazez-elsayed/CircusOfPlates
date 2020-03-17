package eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite;

import java.util.ArrayList;
import java.util.List;

public class GateDirector {
    private static GateDirector ourInstance = new GateDirector();

    public static GateDirector getInstance() {
        return ourInstance;
    }

    private GateDirector() {
    }
    private List<Gate> gateList = new ArrayList<>();

    public Gate showGateDetails(int i) {
        return gateList.get(i);
    }

    public void addGate(Gate gate) {
        gateList.add(gate);
    }
}
