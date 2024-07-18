package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;

class DuckRacer {

    //fields or instance variables

    private final int id;
    private final String name;
    private final Collection<Reward> rewards = new ArrayList<>();


    // constructors
    public DuckRacer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // action methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // a derived property from the size of the collection
    public int getWins() {
        return rewards.size();
    }

    public Collection<Reward> getRewards() {
        return rewards;
    }

    @Override
    public String toString() {
        return String.format("%s: id=%s, name=%s, wins=%s, Rewards=%s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());  // toString() automatically called

    }
    }