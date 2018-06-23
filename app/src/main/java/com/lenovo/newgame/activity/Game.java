package com.lenovo.newgame.activity;

public class Game {
   private String username;
    private String profileimage;
    private String score;
    private String id;
public Game(){

}
    public Game(String username, String profileimage, String score,String id) {


        this.username = username;
        this.id=id;
        this.profileimage = profileimage;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
