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

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
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
import java.util.regex.Pattern;

import com.restfb.types.Post;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import GUI.loginAcessoBDA;
import TelasLogin.TelaLoginMail;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPaneAdjustable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionListener;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class MenuMail extends JFrame {

	/**
	 * @author Grupo31
	 */

	private static final long serialVersionUID = 7669556565803189155L;
	private Folder emailFolder;
	private String user;
	private String pass;
	private JFrame frame;
	private JList<String> list = new JList();;
	private JPanel panel_1;
	private JScrollPane jsp = new JScrollPane();
	Message[] messages;
	private JDateChooser calendarioFim;
	private JDateChooser calendarioInicio;
	private Date dateInicio = new Date(0);
	private Date dateFim = new Date();

	/**
	 * Construtor
	 * 
	 * @param emailFolder
	 * @param user
	 * @param pass
	 * @throws MessagingException
	 */
	public MenuMail(Folder emailFolder, String user, String pass) throws MessagingException {
		this.emailFolder = emailFolder;
		this.user = user;
		this.pass = pass;
		interfaceGrafica();
	}

	/**
	 * Devolve a JList que está na interface
	 * 
	 * @return
	 */
	public JList<String> getList() {
		return list;
	}

	/**
	 * Create the application and initialize the contents of the frame.
	 */
	public void interfaceGrafica() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JLabel lblBemvindousernsame = new JLabel("Bem-Vindo " + user);
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
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});

		JButton button_1 = new JButton("PROCURAR MAIL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					filtrar(textField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.WEST;
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 0;
		panel_2.add(button_1, gbc_button_1);
		button_1.setBounds(6, 111, 139, 26);

		JButton btnCaixaDeEntrada = new JButton("CAIXA DE ENTRADA");
		GridBagConstraints gbc_btnCaixaDeEntrada = new GridBagConstraints();
		gbc_btnCaixaDeEntrada.fill = GridBagConstraints.BOTH;
		gbc_btnCaixaDeEntrada.insets = new Insets(0, 0, 5, 0);
		gbc_btnCaixaDeEntrada.gridx = 0;
		gbc_btnCaixaDeEntrada.gridy = 2;
		panel_3.add(btnCaixaDeEntrada, gbc_btnCaixaDeEntrada);
		btnCaixaDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					printMails();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCaixaDeEntrada.setBounds(6, 57, 176, 26);

		JButton button = new JButton("ENVIAR MAIL");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 3;
		panel_3.add(button, gbc_button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIEnviarMail(user, pass);
			}
		});
		button.setBounds(6, 84, 176, 26);

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

		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String assunto = list.getModel().getElementAt(list.locationToIndex(e.getPoint()));
					try {
						tratarJanelaMensagem(assunto);
					} catch (MessagingException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

		});

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Imprimir os mails do utilizador
	 * 
	 * @throws Exception
	 */
	public void printMails() throws Exception {

		if (emailFolder != null) {
			messages = emailFolder.getMessages();
			ArrayList<Message> listaMails = new ArrayList<Message>();
			DefaultListModel<String> mails = new DefaultListModel<>();

			XmlMenu xm = new XmlMenu();
			String conteudo = "";
			for (int i = 0; i < messages.length; i++) {
				
				if (messages[i].isMimeType("text/*")) {
					conteudo = messages[i].getContent().toString();
				} else if (messages[i].isMimeType("multipart/*")) {
					MimeMultipart message = (MimeMultipart) messages[i].getContent();
					conteudo = getTextFromMimeMultipart(message);
					
				}
				
				listaMails.add(messages[i]);
				xm.addEmail(messages[i].getSubject(), messages[i].getFrom()[0].toString(),
						conteudo);
			}
			Collections.reverse(listaMails);
			mails = filtroData(listaMails);
			trocarDeInformacao(mails);

		} else {
			printSavedMails();
		}
	}

	public void printSavedMails() throws Exception {
		ArrayList<Message> listaMails = new ArrayList<Message>();
		DefaultListModel<String> mails = new DefaultListModel<>();

		XmlMenu xm = new XmlMenu();
		Properties props = new Properties();
		Session session = Session.getInstance(props);
		Node no = xm.getDoc().getElementsByTagName("EmailPost").item(0);
		Node subject = xm.getDoc().getElementsByTagName("Subject").item(0);
		Node remetente = xm.getDoc().getElementsByTagName("Remetente").item(0);
		Node conteudo = xm.getDoc().getElementsByTagName("Conteudo").item(0);
		NamedNodeMap nnmS = subject.getAttributes();
		NamedNodeMap nnmR = remetente.getAttributes();
		NamedNodeMap nnmC = conteudo.getAttributes();
		messages = new Message[nnmS.getLength()];
		for (int i = 0; i < nnmS.getLength(); i++) {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(nnmR.item(i).getTextContent());
			message.setText(nnmC.item(i).getTextContent());
			message.setSubject(nnmS.item(i).getTextContent());
			mails.addElement(nnmS.item(i).getTextContent());
			messages[i] = message;

		}
		trocarDeInformacao(mails);
	}

	/**
	 * Filtra as publicações consoante a palavra que pretende procurar
	 * 
	 * @param palavrachave
	 * @throws Exception
	 */
	public void filtrar(String palavrachave) throws Exception {

		ArrayList<Message> mailsPalavraFiltrada = new ArrayList<Message>();
		DefaultListModel<String> mails = new DefaultListModel<>();

		for (int i = 0, n = messages.length; i < n; i++) {
			if ((messages[i].getSubject().contains(palavrachave))
					|| (messages[i].getFrom()[0].toString().contains(palavrachave))
					|| (messages[i].getContent().toString().contains(palavrachave))) {
				mailsPalavraFiltrada.add(messages[i]);
			}
		}
		if (mailsPalavraFiltrada.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Palavra passe inexistente, por favor tente novamente");
			printMails();
			return;
		}

		Collections.reverse(mailsPalavraFiltrada);
		mails = filtroData(mailsPalavraFiltrada);
		trocarDeInformacao(mails);
	}

	/**
	 * Filtra as publicações consoante a data inserida
	 * 
	 * @param dataPorFiltrar
	 * @return
	 * @throws MessagingException
	 */
	public DefaultListModel<String> filtroData(ArrayList<Message> dataPorFiltrar) throws MessagingException {

		DefaultListModel<String> FilteredMails = new DefaultListModel<>();

		Calendar calMail = Calendar.getInstance();
		Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(dateInicio);
		Calendar calFim = Calendar.getInstance();
		calFim.setTime(dateFim);

		for (Message m : dataPorFiltrar) {
			calMail.setTime(m.getSentDate());
			if ((calMail.get(Calendar.YEAR) > calInicio.get(Calendar.YEAR))
					&& (calMail.get(Calendar.YEAR) < calFim.get(Calendar.YEAR))) {
				FilteredMails.addElement(m.getSubject());
			} else if ((calMail.get(Calendar.YEAR) == calInicio.get(Calendar.YEAR))) {
				if ((calMail.get(Calendar.MONTH) > calInicio.get(Calendar.MONTH))) {
					FilteredMails.addElement(m.getSubject());
				} else if ((calMail.get(Calendar.MONTH) == calInicio.get(Calendar.MONTH))) {
					if ((calMail.get(Calendar.DAY_OF_MONTH) > calInicio.get(Calendar.DAY_OF_MONTH))) {
						FilteredMails.addElement(m.getSubject());
					}
				}
			} else if (calMail.get(Calendar.YEAR) == calFim.get(Calendar.YEAR)) {
				if (calMail.get(Calendar.MONTH) < calFim.get(Calendar.MONTH)) {
					FilteredMails.addElement(m.getSubject());
				} else if (calMail.get(Calendar.MONTH) == calFim.get(Calendar.MONTH)) {
					if ((calMail.get(Calendar.DAY_OF_MONTH) < calFim.get(Calendar.DAY_OF_MONTH))) {
						FilteredMails.addElement(m.getSubject());
					}
				}
			}
		}
		return FilteredMails;
	}

	/**
	 * Troca a informação na JList da interface gráfica
	 * 
	 * @param mails
	 */
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

	/**
	 * Cria uma janela com a informacao da mensagem clicada
	 * 
	 * @param assunto
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void tratarJanelaMensagem(String assunto) throws MessagingException, IOException {
		for (Message m : messages) {
			String conteudo = "";
			if (m.getSubject().equals(assunto)) {
				if (m.isMimeType("text/*")) {
					conteudo = m.getContent().toString();
					new GUIMostrarPublicacao(m.getFrom()[0], m.getSubject(), conteudo);
				} else if (m.isMimeType("multipart/*")) {
					MimeMultipart message = (MimeMultipart) m.getContent();
					conteudo = getTextFromMimeMultipart(message);
					new GUIMostrarPublicacao(m.getFrom()[0], m.getSubject(), conteudo);
				}
			}
		}

	}

	/**
	 * Trata da mensagem obtida ao clicar num elemento da JLit dependendo do seu
	 * tipo
	 * 
	 * @param mimeMultipart
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	public String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		String conteudo = null;
		for (int i = 0; i < mimeMultipart.getCount(); i++) {
			BodyPart tipo = mimeMultipart.getBodyPart(i);
			if (tipo.isMimeType("text/plain")) {
				conteudo = (String) tipo.getContent();
				break;

			} else if (tipo.getContent() instanceof MimeMultipart) {
				conteudo = getTextFromMimeMultipart((MimeMultipart) tipo.getContent());
			}

			else if (tipo.isMimeType("text/html")) {
				conteudo = (String) tipo.getContent();
				break;
			}
		}

		return conteudo;
	}

	static class GUIEnviarMail extends JFrame {

		private JFrame frameEnv;
		private String user;
		private String pass;
		private JTextField assunto;
		private JTextField conteudo;

		public GUIEnviarMail(String user, String pass) {
			this.pass = pass;
			this.user = user;
			abrirJanelaEnviar();
		}

		/**
		 * Abre uma janela para enviar um mail
		 */
		public void abrirJanelaEnviar() {

			frameEnv = new JFrame();
			frameEnv.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));

			JPanel panel = new JPanel();
			frameEnv.getContentPane().add(panel);
			panel.setLayout(new GridLayout(2, 1, 0, 0));

			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel_2.setMaximumSize(new Dimension(100, 50));
			panel.add(panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[] { 73, 204, 0 };
			gbl_panel_2.rowHeights = new int[] { 38, 39, 39, 39, 0 };
			gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_2.setLayout(gbl_panel_2);

			JLabel lblNewLabel = new JLabel("De: ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			panel_2.add(lblNewLabel, gbc_lblNewLabel);

			JLabel lblNewLabel_4 = new JLabel(user);
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 1;
			panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

			JLabel lblNewLabel_1 = new JLabel("Para:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

			JTextField textField_2 = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.fill = GridBagConstraints.BOTH;
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			panel_2.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Assunto:");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

			assunto = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.fill = GridBagConstraints.BOTH;
			gbc_textField_3.gridx = 1;
			gbc_textField_3.gridy = 3;
			panel_2.add(assunto, gbc_textField_3);
			assunto.setColumns(10);

			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.add(panel_3);
			Image outlook = new ImageIcon(this.getClass().getResource("/images/Outlook-icon128.png")).getImage();
			GridBagLayout gbl_panel_3 = new GridBagLayout();
			gbl_panel_3.columnWidths = new int[] { 32, 132, 106, 0 };
			gbl_panel_3.rowHeights = new int[] { 128, 0 };
			gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel_3.setLayout(gbl_panel_3);

			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(outlook));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 0;
			panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);

			JButton btnEnviar = new JButton("ENVIAR");
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					enviarEmail(textField_2.getText());
				}
			});
			GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
			gbc_btnEnviar.fill = GridBagConstraints.BOTH;
			gbc_btnEnviar.gridx = 2;
			gbc_btnEnviar.gridy = 0;
			panel_3.add(btnEnviar, gbc_btnEnviar);

			JPanel panel_1 = new JPanel();
			frameEnv.getContentPane().add(panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[] { 287, 0 };
			gbl_panel_1.rowHeights = new int[] { 342, 0 };
			gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
			gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel_1.setLayout(gbl_panel_1);

			conteudo = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 0;
			panel_1.add(conteudo, gbc_textField);
			conteudo.setColumns(10);
			frameEnv.pack();
			frameEnv.setVisible(true);
		}

		/**
		 * Envia o mail escrito
		 * 
		 * @param to
		 */
		public void enviarEmail(String to) {

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp-mail.outlook.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, pass);
				}
			});

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(assunto.getText());
				message.setText(conteudo.getText());
				Transport.send(message);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		}

	}

	static class GUIMostrarPublicacao extends JFrame {

		private static final long serialVersionUID = -2798607900128322697L;
		private Address remetente;
		private String assunto;
		private String mensagem;
		private JFrame frame;
		private JLabel lblMail;
		private JLabel lblMensagem;
		private JLabel lblNewLabel_2;
		private JLabel lblNewLabel_3;
		private JLabel label;

		public GUIMostrarPublicacao(Address remetente, String assunto, String mensagem) {
			System.out.println(remetente);
			this.remetente = remetente;
			this.assunto = assunto;
			this.mensagem = mensagem;
			abrirJanela();
		}

		/**
		 * Abre uma janela com a informação do mail escolhido
		 */
		public void abrirJanela() {
			frame = new JFrame();
			frame.setBounds(100, 100, 400, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 88, 427, 0 };
			gridBagLayout.rowHeights = new int[] { 41, 0, 0, 0, 195, 0 };
			gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
			frame.getContentPane().setLayout(gridBagLayout);

			lblMail = new JLabel("MAIL");
			lblMail.setFont(new Font("AppleGothic", Font.BOLD, 19));
			GridBagConstraints gbc_lblMail = new GridBagConstraints();
			gbc_lblMail.anchor = GridBagConstraints.SOUTH;
			gbc_lblMail.insets = new Insets(0, 0, 5, 0);
			gbc_lblMail.gridx = 1;
			gbc_lblMail.gridy = 0;
			frame.getContentPane().add(lblMail, gbc_lblMail);

			JLabel lblNewLabel = new JLabel("Remetente:");
			lblNewLabel.setBackground(Color.DARK_GRAY);
			lblNewLabel.setFont(new Font("AppleGothic", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

			lblNewLabel_2 = new JLabel(remetente.toString());
			lblNewLabel_2.setBackground(Color.DARK_GRAY);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 1;
			frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

			JLabel lblNewLabel_1 = new JLabel("Assunto:");
			lblNewLabel_1.setBackground(Color.DARK_GRAY);
			lblNewLabel_1.setFont(new Font("AppleGothic", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

			lblNewLabel_3 = new JLabel(assunto);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 2;
			frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

			lblMensagem = new JLabel("Mensagem:");
			lblMensagem.setFont(new Font("AppleGothic", Font.BOLD, 16));
			GridBagConstraints gbc_lblMensagem = new GridBagConstraints();
			gbc_lblMensagem.anchor = GridBagConstraints.EAST;
			gbc_lblMensagem.insets = new Insets(0, 0, 5, 5);
			gbc_lblMensagem.gridx = 0;
			gbc_lblMensagem.gridy = 3;
			frame.getContentPane().add(lblMensagem, gbc_lblMensagem);

			label = new JLabel();
			String msg = String.format("<html><div WIDTH=%d>%s</div><html>", 830, mensagem);
			label.setText(msg);
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.gridwidth = 2;
			gbc_textArea.insets = new Insets(0, 0, 0, 5);
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 0;
			gbc_textArea.gridy = 4;
			frame.getContentPane().add(label, gbc_textArea);

			frame.pack();
			frame.setVisible(true);
		}
	}

}
