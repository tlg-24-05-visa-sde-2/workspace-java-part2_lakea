package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television> {

    private String brand;
    private int volume;

    // Television HAS-A Tuner
    private final Tuner tuner = new Tuner();  // instantiated internally


    public Television() {

    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    /*@Override
    public boolean equals(Object obj) {
        boolean result = true;

        if (this == obj) {
            result = true;
        } else if (obj == null || this.getClass() != obj.getClass()) return false;

        Television that = (Television) obj;

        return this.getVolume() == that.getVolume() &&
                Objects.equals(this.getBrand(), that.getBrand());
    }
     */

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    /*
    @Override
    public int hashCode() {
        System.out.println("hashCode called");

        // poorly written hash function, it easily results in "hash collisions,"
        // different objects can easily yield in the same hashcode
//        return getBrand().length() + getVolume();

        // use Objects.hash() to give scientifically correct hash function
        // will minimize thr probability of hash collisions
        return Objects.hash(getBrand(), getVolume());       //must use same fields as equal()
    }
    */


    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // proceed only if 'obj' IS A Television
        if (this == obj) {
            result = true;
        }
        else if (obj != null && this.getClass() == obj.getClass()) {
            // downcast obj to more specific reference type Television to call getName()
            Television other = (Television) obj;

            // do the checks samness is defined as same brand AND same volume
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    this.getVolume() == other.getVolume();
        }

        return result;
    }

    // Natural order is defind by brand (String) and secondarily by volume (int) when tied on brand

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {      // tied on brand, so break the tie by volume
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: brand=%s, volume=%s, currentChannel=%s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}