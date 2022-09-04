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

    public boolean addInterest(Interest interest) {
        if (interest == null) {
            throw new IllegalArgumentException("Interest cannot be null");
        }
        if (this.interests.contains(interest)) {
            return false;
        }
        return this.interests.add(interest);
    }

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

    public boolean addFollow(Member follow) {
        if (follow == null) {
            throw new IllegalArgumentException("Follow cannot be null");
        }
        if (this.follows.contains(follow)) {
            return false;
        }

        return this.follows.add(follow);
    }

    public boolean addFollower(Member follower) {
        if (follower == null) {
            throw new IllegalArgumentException("Follower cannot be null");
        }
        if (this.followers.contains(follower)) {
            return false;
        }

        return this.followers.add(follower);
    }

    public boolean hasInterest(Interest interest) {
        if (interest == null) {
            throw new IllegalArgumentException("Interest cannot be null");
        }
        return this.interests.contains(interest);
    }

    public boolean isFriendOf(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        return this.friends.contains(member);
    }

    public boolean isFollowerOf(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        return this.followers.contains(member);
    }

    public boolean isFollowedBy(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        return this.follows.contains(member);
    }

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

    public String toString() {
        return this.username;
    }

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

    
}
