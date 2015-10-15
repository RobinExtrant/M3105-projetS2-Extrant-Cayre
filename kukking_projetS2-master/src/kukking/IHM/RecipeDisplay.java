package kukking.IHM;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import jxl.write.WriteException;
import kukking.*;

/**
 * class where the recipe is completely display
 * @author RO
 *
 */
public class RecipeDisplay extends JPanel implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JButton returnHomePage;
	public KukkingDisplay kukkingFrame;
	public JLabel title;
	
	/**
	 * constructor of Recipe display
	 * @param recipeToDisplay
	 * @param kukkingFrame
	 */
	public RecipeDisplay(Recipe recipeToDisplay, KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		this.title = new JLabel(recipeToDisplay.getNameRecipe());
		JPanel recipe = this;
		recipe.setLayout(new GridBagLayout());
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));

		JCheckBox favoris = new JCheckBox("Favoris");
		
		JLabel ingredient = new JLabel("Ingredients");
		//JLabel categorie = new JLabel("Catégories");
		JLabel tempsPrepa = new JLabel("Temps de préparation");
		JLabel tempsCuisson = new JLabel("Temps de cuisson");
		JLabel cout = new JLabel("Coût");
		JLabel preparation = new JLabel("Préparation");
		JLabel bonApp = new JLabel("Bon appétit !");
		
		

		GridBagConstraints gbc = new GridBagConstraints();
		
		/* logo */
		gbc.gridx=0;
		gbc.gridy=0;
		recipe.add(kukkingLogo,gbc);


		/* titre */
		title.setFont(new Font("Dom", Font.PLAIN, 50));
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=8;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.CENTER;
		recipe.add(title, gbc);

		/* favoris */
		favoris.setFont(new Font("Dom", Font.PLAIN, 13));
		favoris.addActionListener(this);
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		recipe.add(favoris, gbc);
		if (recipeToDisplay.isFavoris())
		{
			favoris.setSelected(true);
		}
			

		/* personnes */
		gbc.gridx=7;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.anchor = GridBagConstraints.EAST;
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getNbPers())),gbc);
		gbc.gridx=8;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel(" personnes"),gbc);

		/* ingredients */
		ingredient.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx=0;
		gbc.gridy=1;
		recipe.add(ingredient,gbc);

		ArrayList<String> ingre = recipeToDisplay.getIngredients();
		ArrayList<String> qte = recipeToDisplay.getQuantities();
		ArrayList<String> unit = recipeToDisplay.getUnits();

		int i;
		for (i=0; i<ingre.size();i++){
			gbc.gridx=0;
			gbc.gridy=2+i;
			gbc.anchor = GridBagConstraints.WEST;
			JLabel ingredients = new JLabel(ingre.get(i));
			ingredients.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			recipe.add(ingredients,gbc);
			gbc.gridx=1;
			gbc.gridy=2+i;
			gbc.anchor = GridBagConstraints.CENTER;
			JLabel quantities = new JLabel(qte.get(i));
			quantities.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			recipe.add(quantities,gbc);
			gbc.gridx=2;
			gbc.gridy=2+i;
			gbc.ipadx=2;
			JLabel units = new JLabel(unit.get(i));
			units.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			recipe.add(units,gbc);
		}
		
	/* info complementaire (tps prépa ...) */
		/* tps prepa */
		tempsPrepa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=6;
		gbc.gridy=6;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 375, 0, 0);
		recipe.add(tempsPrepa,gbc);
		gbc.gridx=7;
		gbc.gridy=6;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 0);
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getPreparationTime())), gbc);
		gbc.gridx=8;
		gbc.gridy=6;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel(" min"),gbc);
		
		/* tps cuisson */
		tempsCuisson.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=6;
		gbc.gridy=7;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 375, 0, 0);
		recipe.add(tempsCuisson, gbc);
		gbc.gridx=7;
		gbc.gridy=7;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 0);
		recipe.add(new JLabel(Integer.toString(recipeToDisplay.getCookingTime())), gbc);
		gbc.gridx=8;
		gbc.gridy=7;
		gbc.anchor = GridBagConstraints.WEST;
		recipe.add(new JLabel(" min"), gbc);
		
		/* cout */
		cout.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=6;
		gbc.gridy=8;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 375, 0, 0);
		recipe.add(cout, gbc);
		gbc.gridx=7;
		gbc.gridy=8;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 0);
		recipe.add(new JLabel(recipeToDisplay.getCost()), gbc);
		
	/* preparation */
		preparation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gbc.gridx=0;
		gbc.gridy=9+i;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 0, 0, 0);
		recipe.add(preparation, gbc);
		JTextPane listStep = new JTextPane();
		ArrayList<String> prepa = recipeToDisplay.getPreparation();
		int numStep;
		for( numStep=0; numStep<prepa.size(); numStep++){
			listStep.setText(listStep.getText()+prepa.get(numStep));
			if (numStep+1<prepa.size()) listStep.setText(listStep.getText()+"\n");
		}
		listStep.setOpaque(false); 
		listStep.setFocusable(false);
		int width = (int)KukkingDisplay.dimension.getWidth()-15;
		listStep.setMinimumSize(new Dimension(width,listStep.getText().length()/(23/2)));
		listStep.setFont(new Font("Calibri", Font.PLAIN, 14));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx=0;
		gbc.gridy=10+i;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		recipe.add(listStep, gbc);
		bonApp.setFont(new Font("Curlz MT", Font.PLAIN, 30));
		gbc.gridx=0;
		gbc.gridy=(12+i)+numStep;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		recipe.add(bonApp, gbc);
		gbc.gridx=0;
		gbc.gridy=(13+i)+numStep;
		returnHomePage = new JButton("Retour à la page d'accueil");
		returnHomePage.addActionListener(kukkingFrame);
		recipe.add(returnHomePage, gbc);
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox source = (JCheckBox)e.getSource();
		if (source.isSelected())
		{
			try {
				this.kukkingFrame.application.getReceiptsList().getRecipeWithName(this.title.getText()).setFavoris();
			} catch (WriteException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			try {
				this.kukkingFrame.application.getReceiptsList().getRecipeWithName(this.title.getText()).deleteFavoris();
			} catch (WriteException e1) {
				e1.printStackTrace();
			}
		}
		this.kukkingFrame.application.setListe_Favoris(new ReceiptsList(this.kukkingFrame.application, true));
		this.kukkingFrame.displayListReceipts(this.kukkingFrame.homePage.favoris, this.kukkingFrame.application.getListe_Favoris().list, new Font("Century Gothic", Font.PLAIN, 18), false);
	}
}
