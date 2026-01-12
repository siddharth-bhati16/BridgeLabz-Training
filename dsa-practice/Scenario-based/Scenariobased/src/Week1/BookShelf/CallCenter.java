package Week1.BookShelf;
import java.util.*;

class Customer{
	String name;
	boolean isVIP;
	
	public Customer(String name,boolean isVIP){
		this.name=name;
		this.isVIP=isVIP;	
	}
	
	public String toString() {
		return name + (isVIP );
		
	}
}

public class CallCenter {
     private Queue<Customer>regularQueue=new LinkedList<>();
     private Queue<Customer>vipQueue=new linkedList<>();
     private Map<String,Integer> callCounts=new HashMap<>();
     
     public void addCustomer(String name,boolean isVIP) {
    	 Customer customer =new Customer(name,isVIP);
    	 if(isVIP) {
    		 vipQueue.add(customer);
    	 }else {
    		 regularQueue.add(customer);
    	 }
    	 callCounts.put(name, callCounts.getOrDefault(name,0)+1);
    	 System.out.println(customer+"added call this month :"+callCounts.get(name));
    	 
     }
     public void serveNextCustomer() {
    	 Customer nextCustomer=null;
    	 if(nextCustomer!=null) {
    		 System.out.println("Serving :"+ nextCustomer);
    	 }else {
    		 System.out.println("no customer in queue");
    	 }
     }
     public void displayQueue() {
    	 System.out.println("vip queue" + vipQueue);
    	 System.out.println("regular queue" + regularQueue);
    	 System.out.println("call counts" + callCounts );
     }
     public static void main(String[] args) {
    	 CallCenter manager=new CallCenter();
    	 manager.addCustomer("ram", false);
    	 manager.addCustomer("rohan", true);
    	 manager.addCustomer("shyam",true);
    	 manager.addCustomer("siddharth",false);
    	 manager.addCustomer("gita", false);
    	 
    	 manager.displayQueue();
    	 
    	 manager.serveNextCustomer();
    	 manager.serveNextCustomer();
    	 manager.serveNextCustomer();
    	 manager.serveNextCustomer();
    	 manager.serveNextCustomer();
    	 manager.serveNextCustomer();
    		 
     }
}
