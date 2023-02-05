package org.example.StaticVsNonStatic;

import java.util.ArrayList;
import java.util.List;

public class House {
    public static List<House> allHouses = new ArrayList<>();

    private Integer sqrMeters;
    private Integer floors;
    private String outerWallsColor;

    public House(Integer sqrMeters, Integer floors, String outerWallsColor) {
        this.sqrMeters = sqrMeters;
        this.floors = floors;
        this.outerWallsColor = outerWallsColor;

        allHouses.add(this);
    }

    public House(House original) {
        this.sqrMeters = original.sqrMeters;
        this.floors = original.floors;
        this.outerWallsColor = original.outerWallsColor;

        allHouses.add(this);
    }

    public static void example() {
        House houseA = new House(150, 2, "Yellow");
        House houseB = new House(200, 1, "Green");
        House houseC = new House(houseB);

        for (House house : House.allHouses) {
            System.out.println(house.getSqrMeters());
        }
    }

    public Integer getSqrMeters() {
        return sqrMeters;
    }

    public Integer getFloors() {
        return floors;
    }

    public String getOuterWallsColor() {
        return outerWallsColor;
    }
}
