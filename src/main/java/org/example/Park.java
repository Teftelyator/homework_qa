package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    public String parkName;
    private List<Attraction> attractionList;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractionList = new ArrayList<>();
    }

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void addAttraction(String attractionName, String workingHours, int cost) {
        Attraction attraction = new Attraction(attractionName, workingHours, cost);
        attractionList.add(attraction);
    }

    public void getInfo() {
        System.out.println("The name of the park : " + parkName + '\n' + getAttractionList());
    }


    private class Attraction {
        private String attractionName;
        private String workingHours;
        private int cost;

        public Attraction(String attractionName, String workingHours, int cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return '\n' + "Attraction : " + attractionName + '\n' +
                    "Working hours : " + workingHours + '\n' +
                    "Cost : " + cost + '\n' +
                    "________________________________";
        }
    }
}



