package com.epam.array.repository.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.repository.ArrayRepository;
import com.epam.array.repository.spec.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {

    private List<CustomArray> customArrays;

    public ArrayRepositoryImpl(List<CustomArray> customArrays) {
        this.customArrays = new ArrayList<>();
    }
    public ArrayRepositoryImpl() {
        this.customArrays = new ArrayList<>();
    }

    public List<CustomArray> queryStream(Specification specification) {
        List<CustomArray> results =
                customArrays.stream().filter(array -> specification.specify(array)).toList();
        return results;
    }

    public CustomArray get(int index) {
        return customArrays.get(index);
    }

    @Override
    public boolean add(CustomArray array) {
        return customArrays.add(array);
    }

    @Override
    public boolean remove(CustomArray array) {
        return customArrays.remove(array);
    }

    public List<CustomArray> query(Specification specification) {
        List<CustomArray> results = new ArrayList<>();

        for (CustomArray array : customArrays) {
            if (specification.specify(array)) {
                results.add(array);
            }
        }
        return results;
    }


    @Override
    public String toString() {
        return "ArrayRepositoryImpl{" +
                "customArrays=" + customArrays +
                '}';
    }
}
