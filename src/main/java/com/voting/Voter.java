package com.voting;

import java.util.ArrayList;
import java.util.List;

public class Voter {
    private String name;
    private int age;
    private String citizenship;
    private String voterId;
    private boolean isIdValid;

    public Voter(String name, int age, String citizenship, String voterId, boolean isIdValid) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.isIdValid = isIdValid;
    }

    public List<String> evaluateEligibility() {
        List<String> reasons = new ArrayList<>();
        
        if (age < 18) {
            reasons.add("Underage (Must be at least 18 years old)");
        }
        if (!"Indian".equalsIgnoreCase(citizenship)) {
            reasons.add("Not a citizen (Must be an Indian citizen)");
        }
        if (voterId == null || voterId.trim().isEmpty() || !isIdValid) {
            reasons.add("Invalid ID (Must possess a valid Voter ID)");
        }
        
        return reasons;
    }

    public String getName() { return name; }
}
