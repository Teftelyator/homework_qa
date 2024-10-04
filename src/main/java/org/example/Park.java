package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    public String parkName;
    List<Attraction> attractionList = new ArrayList<>();

    public Park(String parkName, List<Attraction> attractionList) {
        this.parkName = parkName;
        this.attractionList = attractionList;
    }


    static class Attraction {
        private String attractionName;
        private String workingHours;
        private int cost;

        private ArrayList<Attraction> list;

        public Attraction(String attractionName, String workingHours, int cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public int getCost() {
            return cost;
        }

        public String getAttractionName() {
            return attractionName;
        }
    }
}



