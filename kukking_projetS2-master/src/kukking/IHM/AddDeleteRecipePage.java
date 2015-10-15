package kukking.IHM;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Interface who allow user to delete/add any recipe
 * @author Martin
 *
 */
public class AddDeleteRecipePage extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton returnHomePage = new JButton("Retour à la page d'accueil");
	private JButton addRecipe = new JButton("Ajouter une recette");
	private JButton deleteRecipe = new JButton("Supprimer une recette");
	private KukkingDisplay kukkingFrame;

	
	/**
	 * constructor of page
	 * @param kukkingFrame
	 */
	public AddDeleteRecipePage(KukkingDisplay kukkingFrame)
	{
		this.kukkingFrame = kukkingFrame;
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
		JLabel connectionTitle = new JLabel(" Saisie / Suppression de recette");
		connectionTitle.setFont(new Font("Dom", Font.PLAIN, 50));
		
		Box title = Box.createHorizontalBox();
		title.add(kukkingLogo);
		title.add(connectionTitle);
		
		Box data = Box.createVerticalBox();
		data.add(addRecipe);
		data.add(deleteRecipe);
		data.add(returnHomePage);
		
		Box connectionPageBox = Box.createVerticalBox();
		connectionPageBox.add(title);
		connectionPageBox.add(data);
		
		this.add(connectionPageBox);
		
		
		
		addRecipe.addActionListener(kukkingFrame);
		deleteRecipe.addActionListener(kukkingFrame);
		returnHomePage.addActionListener(kukkingFrame);
	}
}
