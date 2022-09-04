package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collection;

import org.junit.Test;

import edu.westga.cs3152.model.Interest;
import edu.westga.cs3152.model.Network;

public class TestPerfectMatches {
	
	@Test 
	public void testNoMatch() {
		Network network = new Network();
		network.addMember("member1");
		network.addInterest("member1", Interest.MUSIC);
		network.addMember("member2");
		network.addInterest("member1", Interest.ART);
		Collection<String> suggestions = network.getPerfectMatches("member1");
		assertTrue(suggestions.isEmpty());
	}
	
	@Test 
	public void testOneMatch() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		network.addInterest("member1", Interest.MUSIC);
		network.addInterest("member1", Interest.ART);
		network.addInterest("member2", Interest.MUSIC);
		network.addInterest("member2", Interest.ART);
		Collection<String> suggestions = network.getPerfectMatches("member1");
		assertAll( () -> assertEquals(1, suggestions.size()),
				() -> assertTrue(suggestions.contains("member2")) );
	}
	
	@Test 
	public void testTwoSuggestions() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		network.addMember("member3");
		network.addInterest("member1", Interest.MUSIC);
		network.addInterest("member1", Interest.ART);
		network.addInterest("member2", Interest.MUSIC);
		network.addInterest("member2", Interest.ART);
		network.addInterest("member3", Interest.MUSIC);
		network.addInterest("member3", Interest.ART);
		Collection<String> suggestions = network.getPerfectMatches("member1");
		assertAll( () -> assertEquals(2, suggestions.size()),
				() -> assertTrue(suggestions.contains("member2")),
				() -> assertTrue(suggestions.contains("member3")) );
	}
}
