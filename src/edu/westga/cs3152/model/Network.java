package edu.westga.cs3152.model;

import java.util.Collection;
/**
 * The Class Network
 * 
 * Maintains relationships among members of a social network and their
 * interests. Members are represented by their usernames which are strings.
 * 
 * @author CS3152
 * @version Fall 2022
 */
public class Network {

	/**
	 * Instantiates a network without members.
	 * 
	 * @pre none
	 * @post getMembers().isEmpty()
	 */
	public Network() {
	}

	/**
	 * Instantiates a network with the specified list of members.
	 * 
	 * @pre members != null AND !members.contains(null)
	 * @post getMembers().containsAll(members) AND members.containsAll(getMembers())
	 * @param members a collection of the usernames of the members
	 * @throws NullPointerException     if members == null
	 * @throws IllegalArgumentException if members.contains(null)
	 */
	public Network(Collection<String> members) {
		// TODO
	}

	/**
	 * Returns a collection of usernames of all members in this network. The
	 * returned collection does not contain duplicates.
	 * 
	 * @pre none
	 * @post none
	 * @return a collection of all members in this network without duplicates
	 */
	public Collection<String> getMembers() {
		// TODO
		return null;
	}

	/**
	 * Checks if the specified member is in this network. Has the same effect as
	 * calling getMembers().contains(member)
	 * 
	 * @pre none
	 * @post none
	 * @param member the username of the member to be checked
	 * @return true if the specified member is in this network
	 */
	public boolean contains(String member) {
		// TODO
		return false;
	}

	/**
	 * Checks if the given member has the specified interest.
	 * 
	 * @pre contains(member)
	 * @post none
	 * @param member   the username of the member
	 * @param interest the interest to be checked
	 * @return true if the specified member has the specified interest
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public boolean hasInterest(String member, Interest interest) {
		// TODO
		return false;
	}

	/**
	 * Checks if the specified members are friends.
	 * 
	 * @pre contains(member1) AND contains(member2)
	 * @post none
	 * @param member1 the username of the first member
	 * @param member2 the username of the second member
	 * @return true if the members with the specified usernames are friends
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public boolean isFriendOf(String member1, String member2) {
		// TODO
		return false;
	}

	/**
	 * Checks if the given follower follows the specified leader.
	 * 
	 * @pre contains(follower) AND contains(leader)
	 * @post none
	 * @param follower the username of the follower
	 * @param leader   the username of the leader
	 * @return true if the members with the username follower follows the member
	 *         with the username leader
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public boolean isFollowerOf(String follower, String leader) {
		// TODO
		return false;
	}

	/**
	 * Adds the specified member to this network.
	 * 
	 * @pre member != null
	 * @post contains(member) AND contains(member)@pre implies that for all members
	 *       M and all interests I: isFriendOf(M, member)@pre = isFriendOf(M,
	 *       member) AND isFollowerOf(M, member)@pre = isFollowerOf(M, member) AND
	 *       isFollowerOf(member, M)@pre = isFollowerOf(member, M) AND
	 *       hasInterest(member, I)@pre = hasInterest(member, I)
	 * @param member the username of the member to be added
	 * @return true if size.getMembers() = size.getMembers()@pre + 1
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public boolean addMember(String member) {
		// TODO
		return false;
	}

	/**
	 * Adds the given interest to the interests of the specified member.
	 * 
	 * @pre contains(member)
	 * @post hasInterest(member, interest)
	 * @param member   the username of the member
	 * @param interest the interest to be added
	 * @return true if the interests of the member have changed
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public boolean addInterest(String member, Interest interest) {
		// TODO
		return false;
	}

	/**
	 * Adds the friendship relation between the specified members.
	 * 
	 * @pre contains(member1) AND contains(member2) AND !member1.equals(member2)
	 * @post isFriendOf(member1, member2) AND isFriendOf(member2, member1)
	 * @param member1 the username of the first member
	 * @param member2 the username of the second member
	 * @return true if the two specified members have not been friends before
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public boolean addFriendship(String member1, String member2) {
		// TODO
		return false;
	}

	/**
	 * Makes the given member follower to be a follower of the specified member
	 * leader.
	 * 
	 * @pre contains(follower) AND contains(leader) AND !follower.equals(leader)
	 * @post isFollowerOf(follower, leader)
	 * @param follower the username of the follower
	 * @param leader   the username of the leader
	 * @return true if the members with the specified username follower has not been
	 *         following the member with username leader before
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public boolean addFollower(String follower, String leader) {
		// TODO
		return false;
	}

	/**
	 * Returns a collection of members that perfectly match the specified member in
	 * respect to their interests. In particular, the returned collection contains
	 * all members M in getMembers() such that:
	 * 
	 * (1) !M.equals(member) AND
	 * 
	 * (2) for all interests I in Interest.values() (hasInterest(M, I) if and only
	 * if hasInterest(member, I))
	 * 
	 * Time complexity:
	 * 
	 * @pre contains(member)
	 * @post none
	 * @param member the username of the member whose perfect matches are returned
	 * @return a collection of members that are perfect matches for the specified
	 *         member
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public Collection<String> getPerfectMatches(String member) {
		// TODO
		return null;
	}

	/**
	 * Returns a collection of members that have some interests in common with the
	 * the specified member. In particular, the returned collection contains all
	 * members M such that
	 * 
	 * (1) !M.equals(member) AND
	 * 
	 * (2) !isFriendOf(M, member) AND
	 * 
	 * (3) there exists interests I1 and I2 in Interest.values() such that I1 != I2
	 * AND hasInterest(M, I1) AND hasInterest(M, I2) AND hasInterest(member, I1) AND
	 * hasInterest(member, I2))
	 * 
	 * Time complexity:
	 * 
	 * @pre contains(member)
	 * @post none
	 * @param member the username of the member whose friend suggestions are
	 *               returned
	 * @return a collection of members that serve as good candidates for friends of
	 *         the specified member
	 * @throws IllegalArgumentException if the precondition is not met
	 */
	public Collection<String> getFriendSuggestions(String member) {
		// TODO
		return null;
	}

	/**
	 * Returns a collection of members that are followed by all members with the
	 * specified interest. In particular, the returned collection contains all
	 * members L in getMembers() such that
	 * 
	 * (1) hasInterest(L, interest) AND
	 * 
	 * (2) there is a member M in getMembers() with hasInterest(M, I) AND
	 * !M.equals(L) AND
	 * 
	 * (3) for all members M in getMembers() (hasInterest(M, interest) AND
	 * !M.equals(L)) implies isFollowerOf(M, L))
	 * 
	 * Time complexity:
	 * 
	 * @pre none
	 * @post none
	 * @param interest the interest for which leaders are determined
	 * @return a collection of members that are interest leaders
	 */
	public Collection<String> getInterestLeaders(Interest interest) {
		// TODO
		return null;
	}
}
