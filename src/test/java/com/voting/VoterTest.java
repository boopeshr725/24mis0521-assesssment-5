package com.voting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class VoterTest {

    @Test
    public void testEligibleVoter() {
        Voter voter = new Voter("Amit Kumar", 25, "Indian", "VID12345", true);
        List<String> reasons = voter.evaluateEligibility();
        assertTrue(reasons.isEmpty(), "Voter should be eligible.");
    }

    @Test
    public void testUnderageAndForeignCitizen() {
        Voter voter = new Voter("John Doe", 16, "American", "VID999", true);
        List<String> reasons = voter.evaluateEligibility();
        assertEquals(2, reasons.size());
        assertTrue(reasons.contains("Underage (Must be at least 18 years old)"));
        assertTrue(reasons.contains("Not a citizen (Must be an Indian citizen)"));
    }

    @Test
    public void testInvalidVoterId() {
        Voter voter = new Voter("Priya Sharma", 19, "Indian", "VID777", false);
        List<String> reasons = voter.evaluateEligibility();
        assertEquals(1, reasons.size());
        assertTrue(reasons.contains("Invalid ID (Must possess a valid Voter ID)"));
    }
}
