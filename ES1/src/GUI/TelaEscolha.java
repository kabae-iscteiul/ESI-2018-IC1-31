package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextPane;

import TelasLogin.TelaLoginFacebook;
import TelasLogin.TelaLoginMail;
import TelasLogin.TelaLoginTwitter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.DropMode;

public class TelaEscolha {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnTwitter;
	private JButton btnFacebook;
	private JButton btnMail;
	private JLabel lblSelecioneAAplicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TelaEscolha();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEscolha() {
		interfaceGrafica();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void interfaceGrafica() {
		frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 8));
		
		lblSelecioneAAplicao = new JLabel("SELECIONE A APLICAÇÃO COM A QUAL DESEJA INTERAGIR");
		lblSelecioneAAplicao.setFont(lblSelecioneAAplicao.getFont().deriveFont(lblSelecioneAAplicao.getFont().getStyle() | Font.BOLD));
		lblSelecioneAAplicao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSelecioneAAplicao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{149, 149, 149, 0};
		gridBagLayout.rowHeights = new int[]{128, 46, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image twitter = new ImageIcon(this.getClass().getResource("/images/twitter.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(twitter));
		lblNewLabel.setBounds(10, 100, 15, 15);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image facebook = new ImageIcon(this.getClass().getResource("/images/facebook-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(facebook));
		lblNewLabel_1.setBounds(10, 100, 15, 15);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		btnMail = new JButton("Mail");
		btnMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginMail tlm = new TelaLoginMail();
				tlm.setVisible(true);
			}
		});
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		Image mail = new ImageIcon(this.getClass().getResource("/images/Outlook-icon128.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(mail));
		lblNewLabel_2.setBounds(10, 100, 15, 15);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		btnTwitter = new JButton("Twitter");
		btnTwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginTwitter tlt = new TelaLoginTwitter();
				tlt.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnTwitter = new GridBagConstraints();
		gbc_btnTwitter.fill = GridBagConstraints.BOTH;
		gbc_btnTwitter.insets = new Insets(0, 0, 0, 5);
		gbc_btnTwitter.gridx = 0;
		gbc_btnTwitter.gridy = 1;
		panel_1.add(btnTwitter, gbc_btnTwitter);
		
		btnFacebook = new JButton("Facebook");
		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginFacebook tlf = new TelaLoginFacebook();
				tlf.setVisible(true);
			}
		});
		btnFacebook.setSize(new Dimension(10, 10));
		GridBagConstraints gbc_btnFacebook = new GridBagConstraints();
		gbc_btnFacebook.fill = GridBagConstraints.BOTH;
		gbc_btnFacebook.insets = new Insets(0, 0, 0, 5);
		gbc_btnFacebook.gridx = 1;
		gbc_btnFacebook.gridy = 1;
		panel_1.add(btnFacebook, gbc_btnFacebook);
		GridBagConstraints gbc_btnMail = new GridBagConstraints();
		gbc_btnMail.fill = GridBagConstraints.BOTH;
		gbc_btnMail.gridx = 2;
		gbc_btnMail.gridy = 1;
		panel_1.add(btnMail, gbc_btnMail);
		
		frame.pack();
		frame.setVisible(true);
	}

}
