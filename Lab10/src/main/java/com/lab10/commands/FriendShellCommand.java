package com.lab10.commands;

import com.lab10.commands.exceptions.InvalidNumberOfParametersException;
import com.lab10.dbpersistance.entities.FriendshipsEntity;
import com.lab10.dbpersistance.entities.UsersEntity;
import com.lab10.dbpersistance.entitiesManager.FriendshipsEntityManager;
import com.lab10.dbpersistance.entitiesManager.UsersEntityManager;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class FriendShellCommand extends ShellCommand{
    public FriendShellCommand(ArrayList<String> parameters) {
        super(parameters);
    }

    public void execute(int userId) throws Exception {
        ArrayList<String> parameters = this.getParameters();

        if (parameters.size() != 1)
            throw new InvalidNumberOfParametersException("Invalid number of parameters");

        UsersEntityManager usersEM = new UsersEntityManager();
        UsersEntity user = usersEM.findByName(parameters.get(0));

        FriendshipsEntityManager friendshipEM = new FriendshipsEntityManager();
        FriendshipsEntity friendship = new FriendshipsEntity();

        friendship.setFriendship(userId, user.getId());
        friendshipEM.create(friendship);
    }
}
