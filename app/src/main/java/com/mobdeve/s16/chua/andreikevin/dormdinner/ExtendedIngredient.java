package com.mobdeve.s16.chua.andreikevin.dormdinner;

import java.util.List;

public class ExtendedIngredient {
    private int id;
    private String aisle;
    public String image;
    private String consistency;
    public String name;
    private String nameClean;
    public String original;
    private String originalName;
    public double amount;
    private String unit;
    private List<String> meta;
    private Measures measures;


    // Constructor, getters, and setters for each field
    // ...

    // Nested class for measures
    public static class Measures {
        private MeasureDetails us;

        public MeasureDetails getUs() {
            return us;
        }

        public void setUs(MeasureDetails us) {
            this.us = us;
        }

        public MeasureDetails getMetric() {
            return metric;
        }

        public void setMetric(MeasureDetails metric) {
            this.metric = metric;
        }

        private MeasureDetails metric;
    }

    public static class MeasureDetails {
        private double amount;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getUnitShort() {
            return unitShort;
        }

        public void setUnitShort(String unitShort) {
            this.unitShort = unitShort;
        }

        public String getUnitLong() {
            return unitLong;
        }

        public void setUnitLong(String unitLong) {
            this.unitLong = unitLong;
        }

        private String unitShort;
        private String unitLong;

        // Constructor, getters, and setters for amount, unitShort, and unitLong
        // ...
    }
}

