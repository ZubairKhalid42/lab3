/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    @Test
    public static void testCanUseCode() {
        boolean writtenByYourself = false;
        boolean availableToOthers = true;
        boolean writtenAsCourseWork = true;
        boolean citingYourSource = true;
        boolean implementationRequired = true;

        boolean result = RulesOf6005.mayUseCodeInAssignment(writtenByYourself, availableToOthers, writtenAsCourseWork, citingYourSource, implementationRequired);

        // In this scenario, the code is available to others, written as coursework, properly cited, and required by the assignment.
        // Therefore, the method should return true.
        assert result == true : "Expected result: true, Actual result: " + result;
    }
    @Test
    public static void testCannotUseCode() {
        boolean writtenByYourself = false;
        boolean availableToOthers = true;
        boolean writtenAsCourseWork = false; // Not written as coursework
        boolean citingYourSource = true;
        boolean implementationRequired = false; // Not required by the assignment

        boolean result = RulesOf6005.mayUseCodeInAssignment(writtenByYourself, availableToOthers, writtenAsCourseWork, citingYourSource, implementationRequired);

        // In this scenario, the code is available to others but not written as coursework and not required by the assignment.
        // Therefore, the method should return false.
        assert result == false : "Expected result: false, Actual result: " + result;
    }

}
