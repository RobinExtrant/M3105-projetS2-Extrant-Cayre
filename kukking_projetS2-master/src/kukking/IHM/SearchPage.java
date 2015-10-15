package kukking.IHM;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * interface where the user can research receipts
 * @author RO
 *
 */
public class SearchPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton returnHomePage;
	private JButton buttonSearch;
	private JComboBox<String> typeCuisine;
	private JComboBox<String> typePlat;
	private JSlider tempsPrepaMax;
	private JLabel currentTempsPrepaMax;
	
	private JPanel cost;
	private JRadioButton faible;
	private JRadioButton moyen;
	private JRadioButton eleve;

	private KukkingDisplay kukkingFrame;
	
	
	/**
	 * constructor of page
	 * @param kukkingFrame
	 */
	public SearchPage(KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		JLabel search = new JLabel("Recherche");
		search.setFont(new Font("Dom", Font.PLAIN, 50));	
		
		returnHomePage = new JButton("Retour à la page d'accueil");
		buttonSearch = new JButton("Rechercher");
		
		typeCuisine = new JComboBox<String>();
		
		typeCuisine.addItem("Tous type de recettes");
		typeCuisine.addItem("Végétariennes");
		typeCuisine.addItem("Sans gluten");
		typeCuisine.addItem("Tour du monde");
		typeCuisine.addItem("Classiques");
		typeCuisine.addItem("Etudiante");
		typeCuisine.addItem("Fête");
		
		typePlat = new JComboBox<String>();
		
		typePlat.addItem("Tous les plats");
		typePlat.addItem("Entrée");
		typePlat.addItem("Plat chaud");
		typePlat.addItem("Dessert");
		typePlat.addItem("Cocktails");
		
		cost = new JPanel();
		ButtonGroup costButtonGroup = new ButtonGroup();
		
		faible = new JRadioButton("Faible");
		costButtonGroup.add(faible);
		cost.add(faible);
		moyen = new JRadioButton("Moyen");
		costButtonGroup.add(moyen);
		cost.add(moyen);
		eleve = new JRadioButton("Elevé");
		costButtonGroup.add(eleve);
		cost.add(eleve);
		
		currentTempsPrepaMax = new JLabel("Valeur actuelle : 320");
		tempsPrepaMax = new JSlider(0,320,320);
	    tempsPrepaMax.setPaintTicks(true);
	    tempsPrepaMax.setPaintLabels(true);
	    tempsPrepaMax.setMinorTickSpacing(20);
	    tempsPrepaMax.setMajorTickSpacing(60);
	    tempsPrepaMax.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				currentTempsPrepaMax.setText("Valeur actuelle : " + ((JSlider)e.getSource()).getValue());			
			}
			});
		
		Box title = Box.createHorizontalBox();
		title.add(new JLabel(new ImageIcon("kukkinglogo.png")));
		title.add(Box.createHorizontalStrut(50));
		title.add(search);
		
		Box searchPageBox = Box.createVerticalBox();
		searchPageBox.add(title);
		searchPageBox.add(new JLabel("Veuillez choisir un coût :"));
		searchPageBox.add(cost);
		searchPageBox.add(new JLabel("Veuillez choisir un type de cuisine :"));
		searchPageBox.add(typeCuisine);
		searchPageBox.add(new JLabel("Veuillez choisir un type de plat :"));
		searchPageBox.add(typePlat);
		searchPageBox.add(new JLabel("Veuillez choisir un temps de préparation maximum :"));
		searchPageBox.add(tempsPrepaMax);
		searchPageBox.add(currentTempsPrepaMax);
		searchPageBox.add(buttonSearch);
		searchPageBox.add(returnHomePage);
		
		
		this.add(searchPageBox);
		
		returnHomePage.addActionListener(kukkingFrame);
		
		
	    //bouton RCH (recherche) pour accéder au panel de recherche
		buttonSearch.addActionListener(kukkingFrame);
		
	}
	
	/**
	 * to get time Prepa max
	 * @return
	 */
	public int getTempsPrepaMax() {
		return tempsPrepaMax.getValue();
	}

	/**
	 * to get type cook
	 * @return
	 */
	public String getTypeCuisine() {
		return this.typeCuisine.getSelectedItem().toString();
	}


	/**
	 * to get type meal
	 * @return
	 */
	public String getTypePlat() {
		return this.typePlat.getSelectedItem().toString();
	}


	/**
	 * to get cost
	 * @return
	 */
	public String getCost() {
		String costToReturn="Variable";
		if (this.faible.isSelected())
			costToReturn="Faible";
		else if (this.moyen.isSelected())
			costToReturn="Moyen";
		else if (this.eleve.isSelected())
			costToReturn="Elevé";
		
		return costToReturn;
	}
    

}
