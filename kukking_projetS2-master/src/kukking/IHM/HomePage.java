package kukking.IHM;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import kukking.*;

/**
 * Inferface of the home page 
 * @author Martin
 *
 */
public class HomePage extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton connection;
	private JButton search;
	private KukkingDisplay kukkingFrame;
	public JPanel favoris;
	public JPanel recettes;
	
	/**
	 * constructor of page
	 * @param kukkingFrame
	 */
	public HomePage(KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		search = new JButton("Lancer une recherche");
		favoris = new JPanel();
		favoris.setLayout(new GridBagLayout());
		recettes = new JPanel();
		recettes.setLayout(new GridBagLayout());
		connection = new JButton("Connexion en tant qu'administrateur");
		
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
		JLabel kukking = new JLabel("Bienvenue sur Kukking !");
		kukking.setFont(new Font("Dom", Font.PLAIN, 50));
		
		this.kukkingFrame.displayListReceipts(this.recettes, newListRandom(kukkingFrame), new Font("Century Gothic", Font.PLAIN, 18), false);
		this.kukkingFrame.displayListReceipts(this.favoris, this.kukkingFrame.application.getListe_Favoris().list, new Font("Century Gothic", Font.PLAIN, 18), false);
		favoris.setBorder(new TitledBorder("Favoris"));
		favoris.setPreferredSize(new Dimension(600,550));
		
		recettes.setBorder(new TitledBorder("Recettes"));
		recettes.setPreferredSize(new Dimension(600,550));
		
		Box button = Box.createHorizontalBox();
		button.add(search);
		button.add(Box.createHorizontalStrut(10));
		button.add(connection);
		
		Box homePageTot = Box.createVerticalBox();
		
		Box kukkingHead = Box.createHorizontalBox();
		kukkingHead.add(kukkingLogo);
		kukkingHead.add(Box.createHorizontalStrut(50));
		kukkingHead.add(kukking);
	
		Box homePageBody = Box.createHorizontalBox();
		homePageBody.add(favoris);
		homePageBody.add(Box.createHorizontalStrut(200));
		homePageBody.add(recettes);
	
		homePageTot.add(kukkingHead);
		homePageTot.add(Box.createVerticalStrut(20));
		homePageTot.add(button);
		homePageTot.add(Box.createVerticalStrut(20));
		homePageTot.add(homePageBody);
		this.add(homePageTot);
		
		connection.addActionListener(kukkingFrame);
		search.addActionListener(kukkingFrame);
		
	}


	/**
	 * to get new listRandom
	 * @param kukkingFrame
	 * @return
	 */
	public ArrayList<Recipe> newListRandom(KukkingDisplay kukkingFrame) {
		ArrayList<Recipe> listRandom= new ArrayList<Recipe>();
		for (int nbReceipts=0;nbReceipts<5;nbReceipts++)
		{
			ArrayList<Recipe> list = kukkingFrame.application.getReceiptsList().list;
			Random aleatoire = new Random();
			int numAleatoire = aleatoire.nextInt(list.size());
			while (listRandom.contains(list.get(numAleatoire)))
			{
				numAleatoire = aleatoire.nextInt(list.size());
			}
			listRandom.add(list.get(numAleatoire));
		}
		return listRandom;
	}


}
