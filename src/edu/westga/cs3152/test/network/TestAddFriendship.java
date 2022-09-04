package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.Test;

import edu.westga.cs3152.model.Network;

public class TestAddFriendship {

	@Test (expected=IllegalArgumentException.class)
	public void testEmptyNetworkNullArgument() {
		Network network = new Network();
		network.addFriendship(null, null);
	}
	
	@Test
	public void testReturnValueTrue() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		assertTrue(network.addFriendship("member1", "member2"));
	}
	
	@Test 
	public void testFriendshipRelationAdded() {
		Network network = new Network();
		network.addMember("member1");
		network.addMember("member2");
		network.addFriendship("member1", "member2");
		assertAll(() -> assertTrue(network.isFriendOf("member1", "member2")),
				() -> assertTrue(network.isFriendOf("member2", "member1")));
	}
}
