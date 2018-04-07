package de.chrisabit.rest;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestNachrichtenGenerator {
    @Test
    public void testGenerate() {
        assertEquals("Docker ist toll!", new NachrichtenGenerator().execute());
    }
}
