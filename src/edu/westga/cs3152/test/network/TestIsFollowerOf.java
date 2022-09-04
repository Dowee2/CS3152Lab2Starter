package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.model.Network;

public class TestIsFollowerOf {
	
	@Test (expected=IllegalArgumentException.class)
	public void testEmptyNetworkNullArgument() {
		Network network = new Network();
		network.isFollowerOf(null, null);
	}
	
	@Test
	public void testReturnValueTrue() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		network.addFollower("member1", "member2");
		assertTrue(network.isFollowerOf("member1", "member2"));
	}
	
	@Test 
	public void testReturnValueFalse() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		assertFalse(network.isFollowerOf("member1", "member2"));
	}
}
