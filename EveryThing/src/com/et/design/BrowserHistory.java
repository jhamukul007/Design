package com.et.design;

public class BrowserHistory {
	  History history;
	  
	    public BrowserHistory(String homepage) {
	        history=new History(homepage);
	    } 
	    
	    public void visit(String url) {
	        History nextPage=new History(url);
	        history.next=nextPage;
	        nextPage.previous=history;
	        history=history.next;
	        //print(history);
 	    }
	    
	    public String back(int steps) {
	        String url="";
	        int count=0;
	        if(history.previous==null)
	        	return history.url;
	        while(history.previous!=null && count<steps){
	            url=history.previous.url;
	            history=history.previous;
	            count++;
	        }
	        return url;
	    }
	    
	    public String forward(int steps) {
	        String url="";
	        int count=0;
	        if(history.next==null) 
	        	return history.url;
	        
	        while(history.next!=null && count<steps){
	            url=history.next.url;
	            count++;
	            history=history.next;
	        }
	        return url;
	    }
	    
	    public static void main(String[] args) {
	    	String[] commands={"BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"};
	    	String[] values={"leetcode.com","google.com","facebook.com","youtube.com","1","1","1","linkedin.com","2","2","7"};
	    	int i=0;
	    	BrowserHistory browserHistory = null;
	    	while(i<commands.length) {
	    		switch (commands[i]) {
				case "BrowserHistory": browserHistory=new BrowserHistory(values[i]);
					break;
				case "visit":
					browserHistory.visit(values[i]);
					break;
				case "back":
					//browserHistory.print(browserHistory.history);
					String url= browserHistory.back(Integer.parseInt(values[i]));
					System.out.println(url);
					break;
				case "forward":
					String forwardUrl= browserHistory.forward(Integer.parseInt(values[i]));
					System.out.println(forwardUrl);
					break;
				default:
				}
	    		i++;
	    	}
		}
	    void print(History history) {
	    	History node=history;
	    	while (node!=null) {
				System.out.print(history.url+"-> ");
				node=node.next;
			}
	    }
}
class History{
    String url;
    History previous;
    History next;
   public History(String url){
       this.url=url;
       previous=next=null;
   } 
   //[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

}
