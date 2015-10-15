package kukking.IHM;


import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.JTextPane;

/**
 * Interface who give to the User a short help about the application  
 * @author Martin
 *
 */
public class HelpPage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KukkingDisplay kukkingFrame;
	private JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
	private JButton backToHome = new JButton("Retour à la page d'accueil");;

	/**
	 * constructor of page
	 * @param kukkingFrame
	 */
	public HelpPage(KukkingDisplay kukkingFrame)
	{


		JTextPane help = new JTextPane();
		JLabel title = new JLabel("Bienvenue sur la page d'aide");
		title.setFont(new Font("Calibri", Font.BOLD, 27));



		Box titleBox = Box.createHorizontalBox();
		titleBox.add(kukkingLogo); 
		titleBox.add(title);

		Box tot = Box.createVerticalBox();
		tot.add(titleBox);
		tot.add(help);
		tot.add(backToHome);




		help.setOpaque(false); 
		help.setFocusable(false);
		help.setText("\n"
				+ "\nL'application Java Kukking a pour objectif premier d'aider n'importe quel utilisateur à trouver des recettes de cuisines et ce quelque soit le type de cuisine (végétarienne, sans gluten, classique, …), ou même le type de plat recherché (dessert, plat chaud, entrée,…)."
				+ "\nCette application fait pour vous les modifications de quantités au sein des recettes selon votre choix. "
				+ "\n"
				+ "\nFaire une recherche :"
				+ "\nPour effectuer une recherche au sein de notre application, vous devez cliquer sur le bouton «Effectuer une recherche». "
				+ "\nUn formulaire se présentera alors à vous. Vous n'êtes pas obligé de remplir le formulaire, vous pouvez directement cliquer sur «Rechercher» et la liste de toutes nos recettes s'afficheront."
				+ "\nSi vous remplissez des champs du formulaire correctement, puis cliquez sur «Rechercher», la liste de toutes les recettes correspondant à votre recherche s'afficheront. "
				+ "\n"
				+ "\nSe connecter en tant qu'administrateur :"
				+ "\nVous pouvez vous connecter en tant qu'administrateur quand vous le souhaitez grâce au menu"
				+ "\n> Fichier > Se connecter en tant qu'administrateur"
				+ "\n"
				+ "\nIl vous sera donc possible de rentrer votre login et votre mot de passe."
				+ "\nEn cliquant sur «Connexion», vous serez alors connecter en tant qu'administrateur. Et vous pourrez retournez sur n'importe quelle page de l'application."
				+ "\n \n");


		help.setPreferredSize(new Dimension(800,400));



		this.backToHome.addActionListener(kukkingFrame);
		this.kukkingFrame=kukkingFrame;
		this.add(tot);




	}
}


