package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.model.Network;

public class TestIsFriendOf {
	
	@Test (expected=IllegalArgumentException.class)
	public void testEmptyNetworkNullArgument() {
		Network network = new Network();
		network.isFriendOf(null, null);
	}
	
	@Test
	public void testReturnValueTrue() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		network.addFriendship("member1", "member2");
		assertTrue(network.isFriendOf("member1", "member2"));
	}
	
	@Test 
	public void testReturnValueFalse() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		assertFalse(network.isFriendOf("member1", "member2"));
	}

}
