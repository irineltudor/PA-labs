package com.lab7.objects;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    List<Token> tokens=new ArrayList<>();

    public Player(String name)
    {
        this.name=name;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void addToken(Token token)
    {
        tokens.add(token);
    }
    public int getTokensSum()
    { int sum=0;
        for(int i=0;i<=tokens.size()-1;i++)
     {
         sum+=tokens.get(i).cost;
     }
        return sum;

    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}
