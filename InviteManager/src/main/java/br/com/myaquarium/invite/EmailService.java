package br.com.myaquarium.invite;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void send(String name, String toEmail) {

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("myquariumteam@gmail.com", ""));
			email.setSSLOnConnect(true);

			email.setFrom("myquariumteam@gmail.com");
			email.setSubject("Bem vindo ao MyQuarium !");
			email.setMsg("Olá " + name
					+ ". Esperamos que você tenha uma ótima experiencia com o nosso serviço. Qualquer problema não deixe de nos informar myquariumteam@gmail.com");
			email.addTo(toEmail);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

}
