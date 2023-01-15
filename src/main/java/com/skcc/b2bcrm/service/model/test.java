package com.skcc.b2bcrm.service.model;

import java.io.Serializable;
import java.util.Objects;


public class test implements Serializable {
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        test test = (test) o;
        return Objects.equals(role, test.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}
