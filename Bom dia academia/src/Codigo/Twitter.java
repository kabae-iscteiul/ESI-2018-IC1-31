package Codigo;

import java.util.List;
import java.util.List;
import twitter4j.Status;
//import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
public class Twitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("W1f0VvgWPfT8OBqVxvy4Mw")
        	  .setOAuthConsumerSecret("zKH2yAtRyefwsgOO8h8Szc4kru68iEm95QmIG7svw")
        	  .setOAuthAccessToken("36481851-VhzByC4f9MSsZES1QZQ4e4iBvA9bWGLyv9HKFpy7c")
        	  .setOAuthAccessTokenSecret("OahDuXF2Lhl5xlNYALhYZir6xSflAxKP9Zh89T05po");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	twitter4j.Twitter twitter = tf.getInstance();        		
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("------------------------\n Showing home timeline \n------------------------");
    		int counter=0;
    		int counterTotal = 0;
            for (Status status : statuses) {
            	
				// Filters only tweets from user "catarina"
            	
            	// Temos que colocar os nossos Twitters aqui **********
            	
				if (status.getUser().getName() != null && status.getUser().getName().contains("catarina")) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
            }
    		System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
        } catch (Exception e) { System.out.println(e.getMessage()); }

	}

}
