package com.lab9;

import com.lab9.manager.ManagerEntity;

import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = ManagerEntity.getEntity();

    }
}
