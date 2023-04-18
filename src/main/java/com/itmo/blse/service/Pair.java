package com.itmo.blse.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Pair<T> {
    T first;
    T second;

    public List<T> toList() {
        ArrayList<T> list = new ArrayList<>();
        if (first != null) list.add(first);
        if (second != null) list.add(second);
        return list;
    }

}
