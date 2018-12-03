package TelasLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import TelaAcesso.MenuMail;

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

public class TelaLoginMail extends JFrame {

	private static TelaLoginMail tlm;
	private JPanel contentPane;
	private JTextField textField_username;
	private String host = "pop.outlook.com";
	private String mailStoreType = "pop3";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tlm = new TelaLoginMail();
					tlm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getHost() {
		return host;
	}

	public String getStoreType(){
		return mailStoreType;
	}
	
	public TelaLoginMail() {
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

		JLabel lblBemVindo = new JLabel("Bem Vindo ao login do Outlook");
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

		JLabel lblUsername = new JLabel("E-MAIL:");
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

		JLabel lblNewLabel = new JLabel("");
		Image mail = new ImageIcon(this.getClass().getResource("/images/Outlook-icon128.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(mail));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridheight = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Ayuthaya", Font.BOLD, 13));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);

		JPasswordField password = new JPasswordField();
		String pass = new String(password.getPassword());
		password.setEchoChar('*');
		GridBagConstraints gbc_textField_password = new GridBagConstraints();
		gbc_textField_password.fill = GridBagConstraints.BOTH;
		gbc_textField_password.insets = new Insets(0, 0, 5, 5);
		gbc_textField_password.gridx = 2;
		gbc_textField_password.gridy = 3;
		contentPane.add(password, gbc_textField_password);
		password.setColumns(10);
		password.addKeyListener (new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					try {
						acessoMail(mailStoreType, textField_username.getText(), new String((password.getPassword())));
					} catch (MessagingException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	        }  
	    });
	   
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					acessoMail(mailStoreType, textField_username.getText(), new String((password.getPassword())));
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
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

	public void acessoMail(String mailStoreType, String user, String pass) throws MessagingException, IOException {

		Properties properties = new Properties();

		properties.put("mail.pop3s.host", host);
		properties.put("mail.pop3s.port", "995");
		properties.put("mail.pop3s.starttls.enable", "true");

		Session emailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		
		Store store = emailSession.getStore("pop3s");
		try {
			store.connect();
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			MenuMail mm = new MenuMail(emailFolder, user, pass);
			mm.setVisible(true);
			this.dispose();
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "Dados de acesso incorretos. Por favor tente novamente.");
			new TelaLoginMail().setVisible(true);
			this.dispose();
			return;
		}
	}
}
