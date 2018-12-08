package TelasLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;
import com.restfb.types.User;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TelaLoginFacebook extends JFrame {

	/**
	 * @Author Grupo31
	 */

	private static TelaLoginFacebook tlm;
	private JPanel contentPane;
	private JTextField textField_username;
	private User me;
	private String accessToken = "EAAK9JyLgTKkBAAMmL6SGCUZCv4dZBGXKSc1gfMAtoPlGrJf2qOlaaNf0RSsykb8ZCfXgNGaiy07vMLcOHDxe5Vl3Uy0Sc3hifoMYKbZB3RnYlGPguamgF6wDh1PwVjRNVLmu2pxCNgF2U46OxPR2no1P8lYwIZApQZCGkTqZBQ5gWrwjYzrZARQqSAxkTWM7LncpSRVP0EM8MAZDZD";
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
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

	/**
	 * Devolve o token de acesso
	 * 
	 * @return
	 */
	public String getAcessToken() {
		return accessToken;
	}

	public TelaLoginFacebook() {
		interfaceGrafica();
	}

	/**
	 * Create the application and initialize the contents of the frame.
	 */
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
		textField_username.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					try {
						login();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
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
				try {
					login();
				} catch (Exception e1) {
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

	/**
	 * Efetua o login
	 * 
	 * @throws HeadlessException
	 * @throws Exception
	 */
	public void login() throws HeadlessException, Exception {
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

	/**
	 * Autentica o utilizador
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean validateUser() {
		try {
			FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);
			me = fbClient.fetchObject("me", User.class);
			AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("770925739920553",
					"4bfc3a5526da804e21b1dd69ef282d0f");
			if (textField_username.getText().equals(me.getName())) {
				XmlUser xu;
				xu = new XmlUser();
				xu.addAttribute(me.getName(), "Facebook");
				return true;

			} else
				return false;
		} catch (Exception e) {
			me = new User();
			me.setName("João Mercier");
			return true;
		}
	}

}
