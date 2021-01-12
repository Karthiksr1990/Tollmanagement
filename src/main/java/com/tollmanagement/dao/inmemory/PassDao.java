package com.tollmanagement.dao.inmemory;

import com.tollmanagement.model.Pass;

public interface PassDao {
    void storePass(Pass pass);
    void invalidate(Pass pass);
    Pass getPass(String passId);
}
