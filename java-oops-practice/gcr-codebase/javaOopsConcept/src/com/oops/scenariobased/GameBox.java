package com.oops.scenariobased;

import java.util.*;

interface IDownloadable {
 void download();
 void playDemo();
}

class Game {
 protected String title;
 protected String genre;
 protected double price;
 protected double rating;

 public Game(String title, String genre, double price, double rating) {
     this.title = title;
     this.genre = genre;
     this.price = price;
     this.rating = rating;
 }

 public Game(String title, String genre) {
     this(title, genre, 0.0, 0.0);
 }

 public void applyOffer(double discountPercent) {
     price = price - (price * discountPercent / 100);
 }

 public String getTitle() {
     return title;
 }
}

class ArcadeGame extends Game implements IDownloadable {

 public ArcadeGame(String title, double price, double rating) {
     super(title, "Arcade", price, rating);
 }

 @Override
 public void download() {
     System.out.println(title + " (Arcade) downloaded.");
 }

 @Override
 public void playDemo() {
     System.out.println("Playing fast-paced arcade demo of " + title);
 }
}

class StrategyGame extends Game implements IDownloadable {

 public StrategyGame(String title, double price, double rating) {
     super(title, "Strategy", price, rating);
 }

 @Override
 public void download() {
     System.out.println(title + " (Strategy) downloaded.");
 }

 @Override
 public void playDemo() {
     System.out.println("Playing turn-based strategy demo of " + title);
 }
}

class User {
 private String username;
 private List<Game> ownedGames;

 public User(String username) {
     this.username = username;
     this.ownedGames = new ArrayList<>();
 }

 public void buyGame(Game game) {
     ownedGames.add(game);
     System.out.println(username + " purchased: " + game.getTitle());
 }

 public void showLibrary() {
     System.out.println("\n" + username + "'s Game Library:");
     for (Game g : ownedGames) {
         System.out.println("- " + g.getTitle());
     }
 }
}

public class GameBox {
 public static void main(String[] args) {

     IDownloadable game1 = new ArcadeGame("Speed Racer", 10.0, 4.5);
     IDownloadable game2 = new StrategyGame("Empire Builder", 20.0, 4.8);

     game1.playDemo();
     game2.playDemo();

     game1.download();
     game2.download();

     ArcadeGame arcade = (ArcadeGame) game1;
     arcade.applyOffer(20); 
     User user = new User("Alex");
     user.buyGame(arcade);
     user.buyGame((Game) game2);

     user.showLibrary();
 }
}
