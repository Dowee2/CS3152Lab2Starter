package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.model.Interest;
import edu.westga.cs3152.model.Network;

public class TestAddInterest {

	@Test (expected=IllegalArgumentException.class)
	public void testEmptyNetworkNullArgument() {
		Network network = new Network();
		network.addInterest(null, null);
	}
	
	@Test
	public void testReturnValueTrue() {
		Network network = new Network();
		network.addMember("member");
		assertTrue(network.addInterest("member", Interest.MUSIC));
	}
	
	@Test 
	public void testInterestAdded() {
		Network network = new Network();
		network.addMember("member");
		network.addInterest("member", Interest.MUSIC);
		assertTrue(network.hasInterest("member", Interest.MUSIC));
	}
}
