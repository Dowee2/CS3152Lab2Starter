package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.model.Interest;
import edu.westga.cs3152.model.Network;

public class TestHasInterest {
	
	@Test (expected=IllegalArgumentException.class)
	public void testEmptyNetworkNullArgument() {
		Network network = new Network();
		network.hasInterest(null, null);
	}
	
	@Test
	public void testReturnValueTrue() {
		Network network = new Network();
		network.addMember("member");
		network.addInterest("member", Interest.MUSIC);
		assertTrue(network.hasInterest("member", Interest.MUSIC));
	}
	
	@Test 
	public void testReturnValueFalse() {
		Network network = new Network();
		network.addMember("member");
		assertFalse(network.hasInterest("member", Interest.MUSIC));
	}
}
