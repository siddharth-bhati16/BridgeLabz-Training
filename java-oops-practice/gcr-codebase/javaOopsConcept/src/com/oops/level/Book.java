package com.oops.level;

public class Book {
	
    String title;
    String author;
    double price;
    
    //constructor
    
    
    Book(String title, String author , double price){
    	this.title=title;
    	this.author=author;
    	this.price=price;
    }
    public void displayBook() {
    	System.out.println("book title"+ title);
    	System.out.println("book author"+ author);
    	System.out.println("book price"+ price);
        
    }

	public static void main(String[] args) {
       Book book=new Book(" hii"," ram", 200);
       book.displayBook();
	}

}
