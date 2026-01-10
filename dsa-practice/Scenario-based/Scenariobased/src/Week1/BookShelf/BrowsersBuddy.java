package Week1.BookShelf;


import java.util.*;

class HistoryNode {
 String url;
 HistoryNode prev;
 HistoryNode next;

 public HistoryNode(String url) {
     this.url = url;
     this.prev = null;
     this.next = null;
 }
}

class Tab {
 private HistoryNode current; 
 private HistoryNode head;    

 public Tab(String homepage) {
     HistoryNode node = new HistoryNode(homepage);
     head = node;
     current = node;
 }

 public void visit(String url) {
     HistoryNode node = new HistoryNode(url);
     current.next = node;
     node.prev = current;
     current = node;
     System.out.println("Visited: " + url);
 }

 public void back() {
     if(current.prev != null) {
         current = current.prev;
         System.out.println("Back to: " + current.url);
     } else {
         System.out.println("No previous page!");
     }
 }

 public void forward() {
     if(current.next != null) {
         current = current.next;
         System.out.println("Forward to: " + current.url);
     } else {
         System.out.println("No forward page!");
     }
 }

 public String getCurrentPage() {
     return current.url;
 }

 public void showHistory() {
     System.out.println("Full History:");
     HistoryNode temp = head;
     while(temp != null) {
         if(temp == current) System.out.println(" -> " + temp.url + " [Current]");
         else System.out.println(" -> " + temp.url);
         temp = temp.next;
     }
 }
}

class BrowserBuddy {
 private List<Tab> openTabs;          
 private Stack<Tab> closedTabs;       

 public BrowserBuddy() {
     openTabs = new ArrayList<>();
     closedTabs = new Stack<>();
 }

 public Tab openTab(String homepage) {
     Tab tab = new Tab(homepage);
     openTabs.add(tab);
     System.out.println("Opened new tab: " + homepage);
     return tab;
 }

 public void closeTab(Tab tab) {
     if(openTabs.remove(tab)) {
         closedTabs.push(tab);
         System.out.println("Closed tab: " + tab.getCurrentPage());
     } else {
         System.out.println("Tab not found!");
     }
 }

 public void reopenTab() {
     if(!closedTabs.isEmpty()) {
         Tab tab = closedTabs.pop();
         openTabs.add(tab);
         System.out.println("Reopened tab: " + tab.getCurrentPage());
     } else {
         System.out.println("No recently closed tabs!");
     }
 }

 public void showOpenTabs() {
     System.out.println("\nOpen Tabs:");
     for(int i=0; i<openTabs.size(); i++) {
         System.out.println((i+1) + ". " + openTabs.get(i).getCurrentPage());
     }
 }
}

public class BrowsersBuddy {
 public static void main(String[] args) {
     BrowserBuddy browser = new BrowserBuddy();

     Tab tab1 = browser.openTab("google.com");
     Tab tab2 = browser.openTab("youtube.com");

     tab1.visit("gmail.com");
     tab1.visit("stackoverflow.com");
     tab1.back();
     tab1.forward();
     tab1.showHistory();

     tab2.visit("music.com");
     tab2.visit("videos.com");
     tab2.back();
     tab2.showHistory();

     browser.showOpenTabs();

     browser.closeTab(tab1);

     browser.showOpenTabs();

     browser.reopenTab();

     browser.showOpenTabs();
 }
}
