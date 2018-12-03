package TelasLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import TelaAcesso.MenuMail;
import TelaAcesso.menuFacebook;

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

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
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

public class TelaLoginFacebook extends JFrame {

	private static TelaLoginFacebook tlm;
	private JPanel contentPane;
	private JTextField textField_username;
	private User me;
	private String accessToken = "EAAK9JyLgTKkBAB0x7LVkNfAdx8N9Sz0snfmBRXC8ST0pILQ92b3yow0i7aqb9YgYcvfpKpwfmlvT1ZB2kJW5MXZBluJlCtSL6yUkbUZBGS9ZBdy0Xn8bPT6trADXZAvthGzx5SJZC90Q54LQ2e55Y6ZBr4aRqzWzdyZCeh8yF7ySEtiqPmnLdVVDpQWPQaZARVmitwB9CvKddTgZDZD";
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tlm = new TelaLoginFacebook();
					tlm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getAcessToken() {
		return accessToken;
	}

	public TelaLoginFacebook() {
		interfaceGrafica();
	}

	public void interfaceGrafica() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JLabel lblBemVindo = new JLabel("Bem Vindo ao login do Facebook");
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

		textField_username = new JTextField();
		GridBagConstraints gbc_textField_username = new GridBagConstraints();
		gbc_textField_username.fill = GridBagConstraints.BOTH;
		gbc_textField_username.insets = new Insets(0, 0, 5, 5);
		gbc_textField_username.gridx = 2;
		gbc_textField_username.gridy = 2;
		contentPane.add(textField_username, gbc_textField_username);
		textField_username.setColumns(10);
		textField_username.addKeyListener (new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					login();
	        }  
	    });

		JLabel lblNewLabel = new JLabel("");
		Image mail = new ImageIcon(this.getClass().getResource("/images/facebook-icon.png")).getImage();
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
				login();
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 4;
		contentPane.add(btnLogin, gbc_btnLogin);
	}
	
	public void login() {
		if (validateUser()) {
			try {
				new menuFacebook(me.getName(), accessToken);
				dispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	
		} else {
			JOptionPane.showMessageDialog(null, "Dados de acesso incorreto, por favor tente novamente");
			new TelaLoginFacebook().setVisible(true);
			dispose();
			return;
		}
	}

	public boolean validateUser() {
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		me = fbClient.fetchObject("me", User.class);
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("770925739920553","4bfc3a5526da804e21b1dd69ef282d0f");
		if(textField_username.getText().equals(me.getName())) {
			return true;		
		}
		else return false;
	}
	
}
