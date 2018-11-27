import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class t1 {

	public static void main(String[] args) {
		
		
		
		
		// TODO Auto-generated method stub

		
		
		
		
		
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
	        
	        twitter4j.Twitter tw=tf.getInstance();
	        Status stat= tw.updateStatus("meu");
		
		} catch(Exception e) { System.out.println(e.getMessage()); }
		
	}

}
