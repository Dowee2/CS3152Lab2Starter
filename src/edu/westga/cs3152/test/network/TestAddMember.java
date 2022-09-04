package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.westga.cs3152.model.Network;

public class TestAddMember {
	
	@Test (expected=IllegalArgumentException.class)
	public void testEmptyNetworkNullArgument() {
		Network network = new Network(new ArrayList<String>());
		network.addMember(null);
	}
	
	@Test
	public void testExistingNewMember() {
		Network network = new Network();
		assertTrue(network.addMember("member"));
	}
	
	@Test
	public void testExistingMember() {
		Network network = new Network();
		network.addMember("member");
		assertFalse(network.addMember("member"));
	}
}
