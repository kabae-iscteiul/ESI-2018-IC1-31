import static org.junit.Assert.*;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.internet.HeaderTokenizer.Token;
import javax.swing.JList;

import org.junit.Assert;
import org.junit.Test;

import GUI.loginAcessoBDA;
import TelaAcesso.MenuMail;
import TelaAcesso.menuFacebook;
import TelaAcesso.menuTwitter;
import TelasLogin.TelaLoginFacebook;
import TelasLogin.TelaLoginMail;
import TelasLogin.TelaLoginTwitter;
import twitter4j.examples.directmessage.ShowDirectMessage;

public class Testes {

	@Test
	public void janelaInicialFace() throws Exception {
		TelaLoginFacebook tlf = new TelaLoginFacebook();
		
		assertEquals(false, tlf.validateUser());
		
		String token = "EAAK9JyLgTKkBAB0x7LVkNfAdx8N9Sz0snfmBRXC8ST0pILQ92b3yow0i7aqb9YgYcvfpKpwfmlvT1ZB2kJW5MXZBluJlCtSL6yUkbUZBGS9ZBdy0Xn8bPT6trADXZAvthGzx5SJZC90Q54LQ2e55Y6ZBr4aRqzWzdyZCeh8yF7ySEtiqPmnLdVVDpQWPQaZARVmitwB9CvKddTgZDZD";		
		assertEquals(token, tlf.getAcessToken());
		
		
	}
	
	@Test
	public void janelaInicialMail() throws MessagingException {
		TelaLoginMail tlm = new TelaLoginMail();
		
		String hostTest = "pop.outlook.com";
		assertEquals(hostTest, tlm.getHost());

		String st = "pop3";
		assertEquals(st, tlm.getStoreType());
	}
	


}
