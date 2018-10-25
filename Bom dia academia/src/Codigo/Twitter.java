package Codigo;

import java.util.List;
import java.util.List;
import twitter4j.Status;
//import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.api.TweetsResources;
import twitter4j.conf.ConfigurationBuilder;
public class Twitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*
		
		try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("2yLs0GI3Rs3V9o9ncHGLEg3OL")
        	  .setOAuthConsumerSecret("SgRRr42fc1W80pQuKzgCwC286z2teCN17UHCnyhWG15oRDuixM")
        	  .setOAuthAccessToken("1052650934398898176-vgbhRssh1LLXR8hqfRXTN4q5d6eOeA")
        	  .setOAuthAccessTokenSecret("EA7fvBtU7GTIf2Q5ksIgOpbuuPFPRzyX9T5IZiGiBXO3p");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	twitter4j.Twitter twitter = tf.getInstance();        		
            List<Status> statuses = twitter.getHomeTimeline();
            
            
            System.out.println("------------------------\n Showing home timeline \n------------------------");
    
        twitter4j.Twitter tw=tf.getInstance();
            Status stat= tw.updateStatus("kkk");
           
         
            
            int counter=0;
    		int counterTotal = 0;
            for (Status status : statuses) {
            	
				// Filters only tweets from user "catarina"
  	
				if (status.getUser().getName() != null && status.getUser().getName().contains("Iran Carimo")) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
            }
    		System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
        } catch (Exception e) { System.out.println(e.getMessage()); }
        
        
        
        */
		
		

	}
	}

