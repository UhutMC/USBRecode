package me.skyblock.dungeons.rooms;

import java.util.HashMap;
import java.util.Map;

public class onebyone extends Room {
    private static final Map<String, Room> ONEBYONE = new HashMap<>();
    public onebyone() {

    }
    private class Well extends Room {
        private String getName() {return "Well";}
        private int getxsize() {return 1;}
        private int getysize() {return 1;}
    }
}
