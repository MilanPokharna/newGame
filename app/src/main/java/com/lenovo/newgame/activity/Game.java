package com.lenovo.newgame.activity;

public class Game {
   private String username;
    private String profileimage;
    private String score;
public Game(){

}
    public Game(String username, String profileimage, String score) {


        this.username = username;
        this.profileimage = profileimage;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileimage() {
        return profileimage;
    }

    public String getScore() {
        return score;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
