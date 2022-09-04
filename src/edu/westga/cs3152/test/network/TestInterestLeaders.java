package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collection;

import org.junit.Test;

import edu.westga.cs3152.model.Interest;
import edu.westga.cs3152.model.Network;

public class TestInterestLeaders {

	@Test 
	public void testNoLeaders() {
		Network network = new Network();
		network.addMember("member1");
		network.addInterest("member1", Interest.MUSIC);
		network.addMember("member2");
		network.addInterest("member2", Interest.MUSIC);
		Collection<String> leaders = network.getInterestLeaders(Interest.MUSIC);
		assertTrue(leaders.isEmpty());
	}
	
	@Test 
	public void testOneLeader() {
		Network network = new Network();
		network.addMember("member1");
		network.addInterest("member1", Interest.MUSIC);
		network.addMember("member2");
		network.addInterest("member2", Interest.MUSIC);
		network.addFollower("member1", "member2");
		Collection<String> leaders = network.getInterestLeaders(Interest.MUSIC);
		assertAll( () -> assertEquals(1, leaders.size()),
				() -> assertTrue(leaders.contains("member2")) );
	}
	
	@Test 
	public void testTwoLeaders() {
		Network network = new Network();
		network.addMember("member1");
		network.addInterest("member1", Interest.MUSIC);
		network.addMember("member2");
		network.addInterest("member2", Interest.MUSIC);
		network.addMember("member3");
		network.addInterest("member3", Interest.MUSIC);
		network.addFollower("member1", "member2");
		network.addFollower("member3", "member2");
		network.addFollower("member1", "member3");
		network.addFollower("member2", "member3");
		Collection<String> leaders = network.getInterestLeaders(Interest.MUSIC);
		assertAll( () -> assertEquals(2, leaders.size()),
				() -> assertTrue(leaders.contains("member2")),
				() -> assertTrue(leaders.contains("member3")) );
	}
}
