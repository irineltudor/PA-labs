package com.lab10.commands;


import com.lab10.DBPersistance.entities.UsersEntity;
import com.lab10.DBPersistance.entitiesManager.UsersEntityManager;
import com.lab10.commands.exceptions.InvalidNumberOfParametersException;

import java.util.ArrayList;

public class LoginShellCommand extends ShellCommand{
    public LoginShellCommand(ArrayList<String> parameters) {
        super(parameters);
    }

    public int execute() throws Exception {
        ArrayList<String> parameters = this.getParameters();

        if (parameters.size() != 1)
            throw new InvalidNumberOfParametersException("Invalid number of parameters");

        UsersEntityManager userEM = new UsersEntityManager();
        UsersEntity user = userEM.findByName(parameters.get(0));

        return user.getId();
    }
}
