package com.ctw.workstation.common;

import java.util.HashMap;

public abstract class CommonDatabase<T extends CommonData> {
    public final HashMap<Long, T> elementsMap = new HashMap<>();
    private Long lastId = 1L;

    public T add(T element) {
        if (elementsMap.containsKey(lastId)) {
            Long id = lastId++;
            element.setId(id);
            elementsMap.put(id, element);
        } else {
            element.setId(lastId);
            elementsMap.put(lastId, element);
        }
        return element;
    }

    public HashMap<Long, T> getAll() {
        return elementsMap;
    }

    public T getById(Long id) {
        return elementsMap.get(id);
    }

    public T removeById(Long id) {
        return elementsMap.remove(id);
    }

    public T update(T element) {
        return elementsMap.put(element.getId(), element);
    }
}

