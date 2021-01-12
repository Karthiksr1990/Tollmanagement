package com.tollmanagement.dao.inmemory;

import com.tollmanagement.model.Booth;
import com.tollmanagement.model.Toll;

public interface TollDao extends PassDao {
    void addBooth(Booth booth);

    void createToll(Toll toll);
}
