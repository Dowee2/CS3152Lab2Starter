package edu.westga.cs3152.test.network;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3152.model.Network;

public class TestConstructor {

	@Test 
	public void testDefaultConstructor() {
		Network network = new Network();
		assertTrue(network.getMembers().isEmpty());
	}
	
	@Test (expected=NullPointerException.class) 
	public void testNullArgument() {
		new Network(null);
	}
	
	@Test 
	public void testEmptyMemberCollection() {
		Network network = new Network();
		assertTrue(network.getMembers().isEmpty());
	}
}
