package com.lab7.objects;


import java.util.LinkedList;
import java.util.List;

public class Board {
    LinkedList<Token> tokens=new LinkedList<>();
    public Board() {}
    public Board(LinkedList<Token> tokens)
    {
        this.tokens=tokens;
    }
    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(LinkedList<Token> tokens) {
        this.tokens = tokens;
    }

    public Token getNextToken(){
        if(tokens.size() >= 1)
        {
            Token token = tokens.get(tokens.size() - 1);
            tokens.remove(tokens.size() - 1);
            return token;
        }
        return null;
    }

    public Token getToken(int a ,int b)
    {
        if(tokens.size() >=1)
        {
            for (Token token: tokens
                 ) {
                if(token.a==a&&token.b==b)
                {
                    tokens.remove(token);
                    return token;
                }

            }
            return new Token(0,0,0);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }
}
