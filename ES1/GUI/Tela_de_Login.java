package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_de_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_password;
	private JTextField textField_username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_Login frame = new Tela_de_Login();
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
	public Tela_de_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo");
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBemVindo.setForeground(Color.RED);
		lblBemVindo.setBounds(170, 32, 107, 16);
		contentPane.add(lblBemVindo);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(61, 77, 97, 19);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(61, 120, 91, 16);
		contentPane.add(lblPassword);
		
		textField_password = new JTextField();
		textField_password.setBounds(170, 117, 116, 22);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
		textField_username = new JTextField();
		textField_username.setBounds(170, 74, 116, 22);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
if(textField_username.getText().equals("iran") && textField_password.getText().equals("1234")) {
					
					Tela_2 tela_2= new Tela_2();
					tela_2.setVisible(true);
					dispose();
					
					
				}
				else { JOptionPane.showMessageDialog(null, "Acesso negado");}
				
			
				
				
			
			
			
			
			}
		});
		btnConfirmar.setBounds(171, 165, 115, 25);
		contentPane.add(btnConfirmar);
	}
}
