package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.model.Network;

public class TestContains {
	
	@Test 
	public void testEmptyNetworkNullArgument() {
		Network network = new Network();
		assertFalse(network.contains(null));
	}
	
	@Test 
	public void testEmptyNetwork() {
		Network network = new Network();
		assertFalse(network.contains("member"));
	}
	
	@Test 
	public void testNullMember() {
		Network network = new Network();
		network.addMember("member");
		assertTrue(network.contains("member"));
	}
}
