package com.lab9.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerEntity {
    private static EntityManagerFactory factory = null;
    private static boolean flag = false;

    private ManagerEntity() {
    }

    public static EntityManagerFactory getEntity() {
        if (!flag) {

            flag = true;
            factory = Persistence.createEntityManagerFactory("MyApplicationPU");
        }
        return factory;
    }
}
