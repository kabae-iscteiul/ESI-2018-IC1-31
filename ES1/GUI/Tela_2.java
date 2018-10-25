package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;

public class Tela_2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField10;
	private JLabel lblDigiteOSeu;
	private JButton btnListarTodosTweets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_2 frame = new Tela_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Twettar");
		btnNewButton.setBackground(Color.CYAN);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		            Status stat= tw.updateStatus(textField10.getText());
				
				} catch(Exception e) { System.out.println(e.getMessage()); }
				
				JOptionPane.showMessageDialog(contentPane, "Tweet publicado com sucesso.");
			
			}
		});
		
		btnNewButton.setBounds(158, 127, 151, 25);
		contentPane.add(btnNewButton);
		
		textField10 = new JTextField();
		textField10.setBounds(40, 72, 324, 22);
		contentPane.add(textField10);
		textField10.setColumns(10);
		
		lblDigiteOSeu = new JLabel("Digite o seu Tweet aqui");
		lblDigiteOSeu.setBounds(126, 43, 163, 16);
		contentPane.add(lblDigiteOSeu);
		
		btnListarTodosTweets = new JButton("Listar todos Tweets");
		btnListarTodosTweets.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
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
		            Collections.reverse(statuses);
		           // System.out.println("------------------------\n Showing home timeline \n------------------------");
		    		
		           //twitter4j.Twitter tw = tf.getInstance();
		            
		          
		           JFrame frame = new JFrame("Tweets publicados");
		    		
		    		// para que o botao de fechar a janela termine a aplicacao
		           frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    		
		    	
		    		
		    		frame.setLayout(new GridLayout(0,2));
		    		
		    		// para que a janela se redimensione de forma a ter todo o seu conteudo visivel
		    		frame.pack();
		            
		            
		            //Status stat = ((TweetsResources) tf).updateStatus(" Welcome to my twitter");
		            
		            int counter=0;
		    		int counterTotal = 0;
		            for (Status status : statuses) {
		            	
						// Filters only tweets from user "catarina"
		            	
		            	// Temos que colocar os nossos Twitters aqui **********
		            	
						if (status.getUser().getName() != null && status.getUser().getName().contains("Iran Carimo")) {
							counter++;
							frame.add(new JLabel("Tweet número " + counter + " : "));
						    frame.add(new JLabel(status.getText()));   
							frame.add(new JLabel("---------------"));
							frame.add(new JLabel("---------------"));
							
							
						}
						counterTotal++;
		            }
		            
		            frame.add(new JLabel("Nº de tweets: " + counter + "/" + counterTotal));
		            
		            frame.pack();
		            frame.setVisible(true);
		    		
		        } catch (Exception e) { System.out.println(e.getMessage()); }

				
				
				
				
			
			
			
			
			}
		});
		btnListarTodosTweets.setBounds(158, 161, 151, 25);
		contentPane.add(btnListarTodosTweets);
	}

}
