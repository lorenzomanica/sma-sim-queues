package sma;

import java.util.Locale;

public class Event {

    public static final int ARRIVAL = 0;
    public static final int DEPARTURE = 1;
    public static final int TRANSITION = 2;

    private int type;
    private float time;
    private String queue;
    private String destination;

    public Event(int type, float time, String queue) {
        this(type, time, queue, null);
    }

    public Event(int type, float time, String queue, String destination) {
        this.type = type;
        this.time = time;
        this.queue = queue;
        this.destination = destination;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getDestinationQueue() {
        return destination;
    }

    public void setDestinationQueue(String queue) {
        this.destination = queue;
    }

    @Override
    public String toString() {
        String t = type == 0 ? "ARRIVAL" : type == 1 ? "DEPARTURE" : "TRANSITION";
        if (type == 0) {
            return String.format(Locale.ROOT, "\tEvent: %s in %s at %f %n",t, queue, time);
        } else if (type == 1) {
            return String.format(Locale.ROOT, "\tEvent: %s from %s at %f %n", t, queue, time);
        } else {
            return String.format(Locale.ROOT, "\tEvent: %s from %s to %s at %f %n", t, queue, destination, time);
        }
    }
}
