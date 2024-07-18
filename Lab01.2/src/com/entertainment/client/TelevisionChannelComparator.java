package com.entertainment.client;

import com.entertainment.Television;

import java.util.Comparator;

class TelevisionChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television t1, Television t2) {
        return Integer.compare(t1.getCurrentChannel(), t2.getCurrentChannel());
    }
}