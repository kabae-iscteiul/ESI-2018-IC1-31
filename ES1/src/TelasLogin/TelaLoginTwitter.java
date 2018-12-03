package TelasLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;
import TelaAcesso.MenuMail;
import TelaAcesso.menuTwitter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterStream;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

public class TelaLoginTwitter extends JFrame {

	protected static final TwitterFactory ImageLoader = null;
	private static TelaLoginTwitter tlt;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tlt = new TelaLoginTwitter();
					tlt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLoginTwitter() {
		interfaceGrafica();
	}

	public void interfaceGrafica() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 32, 72, 198, 31, 65, 76, 0 };
		gbl_contentPane.rowHeights = new int[] { 45, 33, 26, 26, 0, 29, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblBemVindo = new JLabel("Bem Vindo ao login do Twitter");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBemVindo.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
		gbc_lblBemVindo.anchor = GridBagConstraints.NORTH;
		gbc_lblBemVindo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBemVindo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBemVindo.gridwidth = 2;
		gbc_lblBemVindo.gridx = 1;
		gbc_lblBemVindo.gridy = 1;
		contentPane.add(lblBemVindo, gbc_lblBemVindo);

		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Ayuthaya", Font.BOLD, 13));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.BOTH;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 2;
		contentPane.add(lblUsername, gbc_lblUsername);

		JTextField textField_username = new JTextField();
		GridBagConstraints gbc_textField_username = new GridBagConstraints();
		gbc_textField_username.fill = GridBagConstraints.BOTH;
		gbc_textField_username.insets = new Insets(0, 0, 5, 5);
		gbc_textField_username.gridx = 2;
		gbc_textField_username.gridy = 2;
		contentPane.add(textField_username, gbc_textField_username);
		textField_username.setColumns(10);
		textField_username.addKeyListener (new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						try {
							autenticar(textField_username.getText());
						} catch (TwitterException e1) {
							e1.printStackTrace();
						} catch (MessagingException e1) {
						e1.printStackTrace();
					}
			}	
	        }  
	    });

		JLabel lblNewLabel = new JLabel("");
		Image mail = new ImageIcon(this.getClass().getResource("/images/twitter.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(mail));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridheight = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
	   
		JButton btnLogin = new JButton("Autenticar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						autenticar(textField_username.getText());
					} catch (MessagingException e1) {
						e1.printStackTrace();
					}
				} catch (TwitterException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 4;
		contentPane.add(btnLogin, gbc_btnLogin);
	}
	
	public void autenticar(String username) throws TwitterException, MessagingException {
		if(username.equals("Iran Jacinto")) {	
	    	menuTwitter mm = new menuTwitter(username); 
			mm.setVisible(true);
			this.dispose();
		}
		else {
		JOptionPane.showMessageDialog(null, "Dados de acesso incorretos. Por favor tente novamente.");
		new TelaLoginTwitter().setVisible(true);
		this.dispose();
		return;
		}
		
		
	}	
}
