package edu.westga.cs3152.model;

import java.util.ArrayList;

public class Member {
    
    private String username;
    private ArrayList<Interest> interests;
    private ArrayList<Member> friends;
    private ArrayList<Member> follows;
    private ArrayList<Member> followers;

    public Member(String username) {
        this.username = username;
        this.interests = new ArrayList<Interest>();
        this.friends = new ArrayList<Member>();
        this.follows = new ArrayList<Member>();
        this.followers = new ArrayList<Member>();
    }

    public String getUsername() {
        return this.username;
    }

    public ArrayList<Interest> getInterests() {
        return this.interests;
    }

    public ArrayList<Member> getFriends() {
        return this.friends;
    }

    public ArrayList<Member> getFollows() {
        return this.follows;
    }

    public ArrayList<Member> getFollowers() {
        return this.followers;
    }

    /**
     * Adds an interest to the member's list of interests
     * 
     * @precondition interest != null && !interests.contains(interest)
     * @postcondition getInterests().size() == getInterests().size()@prev + 1
     * @param interest the interest to add
     * @return true if the interest was added, false otherwise
     */

    public boolean addInterest(Interest interest) {
        if (interest == null) {
            throw new IllegalArgumentException("Interest cannot be null");
        }
        if (this.interests.contains(interest)) {
            return false;
        }
        return this.interests.add(interest);
    }

    /**
     * Adds a friend to the member's list of friends
     * 
     * @precondition friend != null && !friends.contains(friend)
     * @postcondition getFriends().size() == getFriends().size()@prev + 1 && friend.getFriends().size() == friend.getFriends().size()@prev + 1 &&
     *                friend.getFriends().contains(this) && this.getFriends().contains(friend)
     * @param friend
     * @return true if the friend was added, false otherwise
     */
    public boolean addFriend(Member friend) {
        if (friend == null) {
            throw new IllegalArgumentException("Friend cannot be null");
        }
        if (this.friends.contains(friend)) {
            return false;
        }
        if (friend.friends.contains(this)) {
            return false;
        }
        this.friends.add(friend);
        friend.friends.add(this);
        return true;
    }

    /**
     * Adds a member to the list of members this member follows
     * 
     * @precondition member != null && !follows.contains(member)
     * @postcondition getFollows().size() == getFollows().size()@prev + 1 && 
     *               member.getFollowers().size() == member.getFollowers().size()@prev + 1 &&
     *               member.getFollowers().contains(this) && getFollows().contains(member)
     * @param follow
     * @return true if the member was added, false otherwise
     */
    public boolean addFollow(Member follow) {
        if (follow == null) {
            throw new IllegalArgumentException("Follow cannot be null");
        }
        if (this.follows.contains(follow)) {
            return false;
        }
        follow.followers.add(this);
        return this.follows.add(follow);
    }

    /**
     * Adds a follower to the member's list of followers
     * 
     * @precondition follower != null && !followers.contains(follower)
     * @postcondition getFollowers().size() == getFollowers().size()@prev + 1 && 
     *                follower.getFollows().size() == follower.getFollows().size()@prev + 1  &&
     *                follower.getFollows().contains(this) && this.getFollowers().contains(follower)
     * @param follower
     * @return true if the follower was added, false otherwise
     */

    public boolean addFollower(Member follower) {
        if (follower == null) {
            throw new IllegalArgumentException("Follower cannot be null");
        }
        if (this.followers.contains(follower)) {
            return false;
        }
        follower.follows.add(this);
        return this.followers.add(follower);
    }

    /**
     * Checks if this member has a given interest
     * @precondition interest != null
     * @param interest
     * @return true if this member has the interest, false otherwise
     */
    public boolean hasInterest(Interest interest) {
        if (interest == null) {
            throw new IllegalArgumentException("Interest cannot be null");
        }
        return this.interests.contains(interest);
    }
    
    /**
     * Checks if this member is friends with the given member
     * 
     * @precondition member != null
     * @postcondition none
     * @param member the member to compare to
     * @return true if this member is friends with the given member, false otherwise
     */
    public boolean isFriendOf(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        return this.friends.contains(member);
    }

    /**
     * Returns true if this member follows the given member
     * 
     * @precondition member != null
     * @postcondition none
     * @param member the member to check
     * @return true if this member follows the given member, false otherwise
     */
    public boolean isFollowerOf(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        return this.follows.contains(member);
    }
    /**
     * Returns if the this is followed by the given member
     * 
     * @precondition member != null
     * @postcondition none
     * 
     * @param member the member to check
     * 
     * @return True if this is followed by the given member, false otherwise
     */
    public boolean isFollowedBy(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        return this.followers.contains(member);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Member other = (Member) obj;
        return this.username.equals(other.username);
    }
    @Override
    public String toString() {
        return this.username;
    }

    /**
     * Returns a list of all members that are perfect matches for this member
     * Where perfect match is defined as: if interests.containsAll(membertoMatch.interests)
     * 
     * @precondition memberToMatch != null && memberToMatch != this
     * @param memberToMatch the member to match
     * 
     * @return True if memberToMatch is a perfect match for this member
     */
    public boolean isPerfectMatch(Member memberToMatch) {
        if (memberToMatch == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        if (this.equals(memberToMatch)) {
            return false;
        }
        if (this.friends.contains(memberToMatch)) {
            return false;
        }
        if (this.follows.contains(memberToMatch)) {
            return false;
        }
        if (this.followers.contains(memberToMatch)) {
            return false;
        }
        for (Interest interest : this.interests) {
            if (!memberToMatch.interests.contains(interest)) {
                return false;
            }
        }
        return true;
    }

    
    /**
     * Returns a list of all members that are friend suggestions for this member
     * Where friend suggestion is defined as: If a member has at least one interests in common with this member
     * 
     * @precondition memberToMatch != null && memberToMatch != this
     * 
     * @param memberToMatch the member to match
     * @return
     */
    public boolean isFriendSuggestion(Member memberToMatch) {
        if (memberToMatch == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        if (this.equals(memberToMatch)) {
            return false;
        }
        if (this.friends.contains(memberToMatch)) {
            return false;
        }
        if (this.follows.contains(memberToMatch)) {
            return false;
        }
        if (this.followers.contains(memberToMatch)) {
            return false;
        }
        for (Interest interest : this.interests) {
            if (memberToMatch.interests.contains(interest)) {
                return true;
            }
        }
        return false;
    }
    
}
