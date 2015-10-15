package kukking.IHM;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Interface who allow someone (User or Admin) to connect to Kukking
 * @author Martin
 *
 */
public class ConnectionPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton returnHomePage = new JButton("Retour à la page d'accueil");
	private JButton connection = new JButton("Se connecter");
	private KukkingDisplay kukkingFrame;
	private JTextField loginTextArea;
	private JTextField passWordTextArea;

	/**
	 * constructor of page
	 * @param kukkingFrame
	 */
	public ConnectionPage(KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
		JLabel connectionTitle = new JLabel(" Connexion en tant qu'administrateur");
		connectionTitle.setFont(new Font("Dom", Font.PLAIN, 50));
		JLabel login = new JLabel("Entrez votre login");
		loginTextArea = new JTextField("Entrez votre login ici");
		JLabel passWord = new JLabel("Entrez votre mot de passe");
		passWordTextArea = new JTextField("Entrez votre mot de passe ici");
		
		
		
		
		Box title = Box.createHorizontalBox();
		title.add(kukkingLogo);
		title.add(connectionTitle);
		
		Box data = Box.createVerticalBox();
		data.add(login);
		data.add(loginTextArea);
		data.add(passWord);
		data.add(passWordTextArea);
		data.add(connection);
		data.add(returnHomePage);
		
		
		Box connectionPageBox = Box.createVerticalBox();
		connectionPageBox.add(title);
		connectionPageBox.add(data);
		
		this.add(connectionPageBox);
		
		loginTextArea.addFocusListener(new FocusAdapter() {
		   public void focusGained(FocusEvent onclic){
		    loginTextArea.setText("");
		   }
		  });
		
		passWordTextArea.addFocusListener(new FocusAdapter() {
			   public void focusGained(FocusEvent onclic){
			    passWordTextArea.setText("");
			   }
			  });
	
		
		returnHomePage.addActionListener(kukkingFrame);
		connection.addActionListener(kukkingFrame);
	}
	
	/**
	 * to get password
	 * @return password
	 */
	public String getPassword() {
		return passWordTextArea.getText();
	}
	
	/**
	 * to get login
	 * @return login
	 */
	public String getLogin() {
		return loginTextArea.getText();
	}
}
