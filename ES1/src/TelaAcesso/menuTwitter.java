package TelaAcesso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import GUI.TelaEscolha;
import TelasLogin.TelaLoginMail;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPaneAdjustable;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class menuTwitter extends JFrame {

	private Folder emailFolder;
	private String username;
	private TwitterFactory tf;
	private Twitter tt;
	private JFrame frame;
	private JList<String> list = new JList();;
	private JPanel panel_1;
	private JScrollPane jsp = new JScrollPane();
	private JDateChooser calendarioFim;
	private JDateChooser calendarioInicio;
	private Date dateInicio = new Date(0);
	private Date dateFim = new Date();

	// Terminar sessao
	// emailFolder.close(false);
	// store.close();

	public menuTwitter(String username) {
		this.username = username;
		autenticar();
		interfaceGrafica();
		this.frame.setVisible(true);
	}
	
	public void autenticar() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("2yLs0GI3Rs3V9o9ncHGLEg3OL")
    	  .setOAuthConsumerSecret("SgRRr42fc1W80pQuKzgCwC286z2teCN17UHCnyhWG15oRDuixM")
    	  .setOAuthAccessToken("1052650934398898176-vgbhRssh1LLXR8hqfRXTN4q5d6eOeA")
    	  .setOAuthAccessTokenSecret("EA7fvBtU7GTIf2Q5ksIgOpbuuPFPRzyX9T5IZiGiBXO3p");
    	tf = new TwitterFactory(cb.build());
    	tt = tf.getInstance(); 
	}

	public void interfaceGrafica() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] { 452 };
		gridBagLayout.columnWidths = new int[] { 185, 320 };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 286, 0 };
		gbl_panel_3.rowHeights = new int[] { 62, 48, 38, 38, 44, 57, 41, 130, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblBemvindousernsame = new JLabel("Bem-Vindo " + username);
		GridBagConstraints gbc_lblBemvindousernsame = new GridBagConstraints();
		gbc_lblBemvindousernsame.fill = GridBagConstraints.VERTICAL;
		gbc_lblBemvindousernsame.insets = new Insets(0, 0, 5, 0);
		gbc_lblBemvindousernsame.gridx = 0;
		gbc_lblBemvindousernsame.gridy = 0;
		panel_3.add(lblBemvindousernsame, gbc_lblBemvindousernsame);
		lblBemvindousernsame.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblBemvindousernsame.setForeground(Color.BLACK);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_3.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 179, 80, 0 };
		gbl_panel_2.rowHeights = new int[] { 29, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JTextField textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)

					try {

						filtrar(textField.getText());
					} catch (MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					} catch (TwitterException e1) {
						e1.printStackTrace();
					}

			}
		});

		JButton btnProcurarTweet = new JButton("PROCURAR TWEET");
		btnProcurarTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					filtrar(textField.getText());
				} catch (TwitterException e1) {
					e1.printStackTrace();

				} catch (MessagingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnProcurarTweet = new GridBagConstraints();
		gbc_btnProcurarTweet.anchor = GridBagConstraints.WEST;
		gbc_btnProcurarTweet.gridx = 1;
		gbc_btnProcurarTweet.gridy = 0;
		panel_2.add(btnProcurarTweet, gbc_btnProcurarTweet);
		btnProcurarTweet.setBounds(6, 111, 139, 26);

		JButton btnCaixaDeEntrada = new JButton("LISTA DE TWEETS");
		GridBagConstraints gbc_btnCaixaDeEntrada = new GridBagConstraints();
		gbc_btnCaixaDeEntrada.fill = GridBagConstraints.BOTH;
		gbc_btnCaixaDeEntrada.insets = new Insets(0, 0, 5, 0);
		gbc_btnCaixaDeEntrada.gridx = 0;
		gbc_btnCaixaDeEntrada.gridy = 2;
		panel_3.add(btnCaixaDeEntrada, gbc_btnCaixaDeEntrada);
		btnCaixaDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarTweets();
				} catch (TwitterException e1) {
					e1.printStackTrace();

				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCaixaDeEntrada.setBounds(6, 57, 176, 26);

		JButton btnPublicarTweet = new JButton("PUBLICAR TWEET");
		GridBagConstraints gbc_btnPublicarTweet = new GridBagConstraints();
		gbc_btnPublicarTweet.fill = GridBagConstraints.BOTH;
		gbc_btnPublicarTweet.insets = new Insets(0, 0, 5, 0);
		gbc_btnPublicarTweet.gridx = 0;
		gbc_btnPublicarTweet.gridy = 3;
		panel_3.add(btnPublicarTweet, gbc_btnPublicarTweet);
		btnPublicarTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIEnviarTweet gem = new GUIEnviarTweet(tt);
				gem.setVisible(true);
			}
		});
		btnPublicarTweet.setBounds(6, 84, 176, 26);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 4;
		panel_3.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 102, 87, 0 };
		gbl_panel_5.rowHeights = new int[] { 16, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		JLabel lblDataDeIncio = new JLabel("Data de início");
		GridBagConstraints gbc_lblDataDeIncio = new GridBagConstraints();
		gbc_lblDataDeIncio.insets = new Insets(0, 0, 0, 5);
		gbc_lblDataDeIncio.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDataDeIncio.gridx = 0;
		gbc_lblDataDeIncio.gridy = 0;
		panel_5.add(lblDataDeIncio, gbc_lblDataDeIncio);
		lblDataDeIncio.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 5;
		panel_3.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 281, 0 };
		gbl_panel_7.rowHeights = new int[] { 45, 0, 0 };
		gbl_panel_7.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		calendarioInicio = new JDateChooser();
		calendarioInicio.setPreferredSize(new Dimension(70, 40));
		GridBagConstraints gbc_calendarioInicio = new GridBagConstraints();
		gbc_calendarioInicio.insets = new Insets(0, 0, 5, 0);
		gbc_calendarioInicio.fill = GridBagConstraints.BOTH;
		gbc_calendarioInicio.gridx = 0;
		gbc_calendarioInicio.gridy = 0;
		panel_7.add(calendarioInicio, gbc_calendarioInicio);

		JButton submeterInicio = new JButton("SUBMETER");
		submeterInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateInicio = calendarioInicio.getDate();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panel_7.add(submeterInicio, gbc_btnNewButton);

		JLabel lblDataDeFim = new JLabel("Data de fim");
		GridBagConstraints gbc_lblDataDeFim = new GridBagConstraints();
		gbc_lblDataDeFim.anchor = GridBagConstraints.SOUTH;
		gbc_lblDataDeFim.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDataDeFim.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataDeFim.gridx = 0;
		gbc_lblDataDeFim.gridy = 6;
		panel_3.add(lblDataDeFim, gbc_lblDataDeFim);
		lblDataDeFim.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 7;
		panel_3.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 285, 0 };
		gbl_panel_8.rowHeights = new int[] { 45, 0, 0 };
		gbl_panel_8.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);

		calendarioFim = new JDateChooser();
		GridBagConstraints gbc_calendarioFim = new GridBagConstraints();
		gbc_calendarioFim.insets = new Insets(0, 0, 5, 0);
		gbc_calendarioFim.fill = GridBagConstraints.BOTH;
		gbc_calendarioFim.gridx = 0;
		gbc_calendarioFim.gridy = 0;
		panel_8.add(calendarioFim, gbc_calendarioFim);
		calendarioFim.setPreferredSize(new Dimension(70, 40));

		JButton submeterFim = new JButton("SUBMETER");
		submeterFim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateFim = calendarioFim.getDate();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_8.add(submeterFim, gbc_btnNewButton_1);

		panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);

		frame.pack();
	}

	public void listarTweets() throws TwitterException, MessagingException {

		List<Status> statuses = tt.getHomeTimeline();

		DefaultListModel<String> tweets = new DefaultListModel<>();

		tweets = filtroData(statuses);

		trocarDeInformacao(tweets);
	}

	public void filtrar(String palavrachave) throws MessagingException, IOException, TwitterException {

		List<Status> statuses = tt.getHomeTimeline();
		Collections.reverse(statuses);

		List<Status> statusesFiltered = new ArrayList<Status>();
		DefaultListModel<String> tweets = new DefaultListModel<>();

		for (Status stat : statuses) {
			if (stat.getText().equals(palavrachave))
				statusesFiltered.add(stat);
		}

		tweets = filtroData(statusesFiltered);
		trocarDeInformacao(tweets);
	}

	public DefaultListModel<String> filtroData(List<Status> dataPorFiltrar) throws MessagingException {

		DefaultListModel<String> FilteredPosts = new DefaultListModel<>();

		Calendar calMail = Calendar.getInstance();
		Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(dateInicio);
		Calendar calFim = Calendar.getInstance();
		calFim.setTime(dateFim);

		for (Status s: dataPorFiltrar) {
			calMail.setTime(s.getCreatedAt());
			if ((calMail.get(Calendar.YEAR) > calInicio.get(Calendar.YEAR)) && (calMail.get(Calendar.YEAR) < calFim.get(Calendar.YEAR))) {
				FilteredPosts.addElement(s.getText());
			}
			else if((calMail.get(Calendar.YEAR) == calInicio.get(Calendar.YEAR))) {
				if ((calMail.get(Calendar.MONTH) > calInicio.get(Calendar.MONTH))) {
					FilteredPosts.addElement(s.getText());
				}
				else if((calMail.get(Calendar.MONTH) == calInicio.get(Calendar.MONTH))) {
					if((calMail.get(Calendar.DAY_OF_MONTH) > calInicio.get(Calendar.DAY_OF_MONTH))) {
						FilteredPosts.addElement(s.getText());
					}
				}
			}
			else if(calMail.get(Calendar.YEAR) == calFim.get(Calendar.YEAR)) {
				if (calMail.get(Calendar.MONTH) < calFim.get(Calendar.MONTH)) {
					FilteredPosts.addElement(s.getText());
				}
				else if(calMail.get(Calendar.MONTH) == calFim.get(Calendar.MONTH)) {
					if((calMail.get(Calendar.DAY_OF_MONTH) < calFim.get(Calendar.DAY_OF_MONTH))) {
						FilteredPosts.addElement(s.getText());
					}
				}
			}
		}
		
		return FilteredPosts;
	}

	public void trocarDeInformacao(DefaultListModel<String> mails) {
		list.setModel(mails);
		list.setVisibleRowCount(30);
		panel_1.remove(jsp);
		jsp = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setPreferredSize(new Dimension(320, 470));
		panel_1.add(jsp);
		frame.validate();
		frame.pack();
	}

	static class GUIEnviarTweet extends JFrame {

		private JFrame frame;
		private Twitter tt;

		public GUIEnviarTweet(Twitter tt) {
			this.tt = tt;
			abrirJanelaEnviar();
		}

		public void abrirJanelaEnviar() {

			frame = new JFrame();
			frame.getContentPane().setForeground(Color.BLACK);
			frame.setTitle("PUBLICAÇÃO");
			frame.setBounds(100, 100, 449, 172);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 447, 0 };
			gridBagLayout.rowHeights = new int[] { 110, 0, 0 };
			gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			frame.getContentPane().setLayout(gridBagLayout);

			JTextField textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 0;
			frame.getContentPane().add(textField, gbc_textField);
			textField.setColumns(10);

			JButton btnPublicar = new JButton("PUBLICAR");
			GridBagConstraints gbc_btnPublicar = new GridBagConstraints();
			gbc_btnPublicar.gridx = 0;
			gbc_btnPublicar.gridy = 1;
			frame.getContentPane().add(btnPublicar, gbc_btnPublicar);
			btnPublicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						postarTweet(textField.getText());
					} catch (TwitterException e1) {
						e1.printStackTrace();
					}
				}
			});

			frame.pack();
			frame.setVisible(true);
		}

		public void postarTweet(String conteudo) throws TwitterException {
			tt.updateStatus(conteudo);
			this.dispose();
		}

	}

}
