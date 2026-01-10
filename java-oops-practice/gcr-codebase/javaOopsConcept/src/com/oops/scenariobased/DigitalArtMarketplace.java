package com.oops.scenariobased;

interface IPurchasable {
 void purchase(User user); 
 void license(User user); 
}

class Artwork implements IPurchasable {
 protected String title;
 protected String artist;
 protected double price;
 protected String licenseType; 
 protected String preview; 

 public Artwork(String title, String artist, double price, String licenseType, String preview) {
     this.title = title;
     this.artist = artist;
     this.price = price;
     this.licenseType = licenseType;
     this.preview = preview;
 }

 public Artwork(String title, String artist, double price, String licenseType) {
     this(title, artist, price, licenseType, "No preview available");
 }

 protected void showLicenseTerms() {
     System.out.println("License Type: " + licenseType);
 }

 @Override
 public void purchase(User user) {
     if (user.getWalletBalance() >= price) {
         user.deductBalance(price); // Operator: deduct balance
         System.out.println(user.getName() + " purchased \"" + title + "\" by " + artist + " for $" + price);
     } else {
         System.out.println(user.getName() + " does not have enough balance to purchase \"" + title + "\".");
     }
 }

 @Override
 public void license(User user) {
     System.out.println("Licensing \"" + title + "\" by " + artist);
     showLicenseTerms();
 }

 public void showDetails() {
     System.out.println("Title: " + title);
     System.out.println("Artist: " + artist);
     System.out.println("Price: $" + price);
     System.out.println("Preview: " + preview);
     System.out.println("-----------------------------");
 }
}

class DigitalArt extends Artwork {
 public DigitalArt(String title, String artist, double price, String licenseType, String preview) {
     super(title, artist, price, licenseType, preview);
 }

 public DigitalArt(String title, String artist, double price, String licenseType) {
     super(title, artist, price, licenseType);
 }

 @Override
 public void license(User user) {
     System.out.println(user.getName() + " licensed digital artwork \"" + title + "\".");
     showLicenseTerms();
 }
}

class PrintArt extends Artwork {
 public PrintArt(String title, String artist, double price, String licenseType, String preview) {
     super(title, artist, price, licenseType, preview);
 }

 public PrintArt(String title, String artist, double price, String licenseType) {
     super(title, artist, price, licenseType);
 }

 @Override
 public void license(User user) {
     System.out.println(user.getName() + " licensed print artwork \"" + title + "\" for display or resale.");
     showLicenseTerms();
 }
}

class User {
 private String name;
 private double walletBalance;

 public User(String name, double walletBalance) {
     this.name = name;
     this.walletBalance = walletBalance;
 }

 public String getName() {
     return name;
 }

 public double getWalletBalance() {
     return walletBalance;
 }

 public void deductBalance(double amount) {
     walletBalance -= amount;
 }

 public void showWallet() {
     System.out.println(name + "'s Wallet Balance: $" + walletBalance);
 }
}

public class DigitalArtMarketplace {
 public static void main(String[] args) {

     User alice = new User("Alice", 1500);
     User bob = new User("Bob", 300);

     Artwork art1 = new DigitalArt("Sunset Bliss", "Emma", 500, "Commercial", "Preview: Sunset image");
     Artwork art2 = new PrintArt("Ocean Waves", "Liam", 350, "Personal");

     art1.showDetails();
     art2.showDetails();

     art1.purchase(alice); 
     art2.purchase(bob);   

     art1.license(alice); 
     art2.license(bob);  
     
     alice.showWallet();
     bob.showWallet();
 }
}
