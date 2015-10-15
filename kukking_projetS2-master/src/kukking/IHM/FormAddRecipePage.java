package kukking.IHM;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Interface who manage the format of an add recipe
 * @author Martin
 *
 */
public class FormAddRecipePage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton returnHomePage;
	private JButton buttonAdd;
	private JTextField textAreaNameRecipe;
	private JTextField textAreaIngredients;
	private JTextField textAreaQuantities;
	private JTextField textAreaUnits;
	private JTextArea textAreaRecipeOfPrepare;
	private JComboBox<String> DropDownListTypeMealAdd;
	private JComboBox<String> DropDownListTypeKitchenAdd;
	private JSlider sliderPeople;
	private JLabel currentNbPeople;
	private JSlider sliderTimeCook;
	private JLabel currentTimeCook;
	private JSlider sliderTimePrepare;
	private JLabel currentTimePrepare;
	private JPanel cost;
	private JRadioButton faible;
	private JRadioButton moyen;
	private JRadioButton eleve;

	private KukkingDisplay kukkingFrame;
	
	/**
	 * constructor of page
	 * @param kukkingFrame
	 */
	public FormAddRecipePage(KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		JLabel titleAdd = new JLabel("Ajouter une recette");
		titleAdd.setFont(new Font("Calibri", Font.PLAIN, 25));
		this.returnHomePage = new JButton("Retour à la page d'accueil");
		this.buttonAdd = new JButton("Valider");
		this.textAreaNameRecipe = new JTextField("Titre de la recette");
		this.textAreaNameRecipe.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textAreaNameRecipe.selectAll();
			}
		});
		this.textAreaIngredients = new JTextField("Saisissez les ingrédients (séparés par des \" ; \")");
		this.textAreaIngredients.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textAreaIngredients.selectAll();
			}
		});
		this.textAreaQuantities = new JTextField("Saisissez les quantités (séparés par des \" ; \")");
		this.textAreaQuantities.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textAreaQuantities.selectAll();
			}
		});
		this.textAreaUnits = new JTextField("Saisissez les unités (séparés par des \" ; \")");
		this.textAreaUnits.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent onclic){
				textAreaUnits.selectAll();
			}
		});
		this.textAreaRecipeOfPrepare = new JTextArea("Saisissez la préparation");
		this.textAreaRecipeOfPrepare.addFocusListener(new FocusAdapter() {
			   public void focusGained(FocusEvent onclic){
				   textAreaRecipeOfPrepare.setText("");
			   }
			  });
		//textAreaRecipeOfPrepare.setEditable(false);
		this.textAreaRecipeOfPrepare.setPreferredSize(new Dimension(400,100));
		this.textAreaRecipeOfPrepare.setLineWrap(true);
		this.textAreaRecipeOfPrepare.setWrapStyleWord(true);
		
		//drop-down list for new type of meal
		DropDownListTypeMealAdd = new JComboBox<String>();
		DropDownListTypeMealAdd.addItem("Tous les plats");
		DropDownListTypeMealAdd.addItem("Entrée");
		DropDownListTypeMealAdd.addItem("Plat chaud");
		DropDownListTypeMealAdd.addItem("Dessert");
		DropDownListTypeMealAdd.addItem("Cocktails");
		//new drop-down list for new type of kitchen
		DropDownListTypeKitchenAdd = new JComboBox<String>();
		DropDownListTypeKitchenAdd.addItem("Tous type de recettes");
		DropDownListTypeKitchenAdd.addItem("Végétariennes");
		DropDownListTypeKitchenAdd.addItem("Sans gluten");
		DropDownListTypeKitchenAdd.addItem("Tour du monde");
		DropDownListTypeKitchenAdd.addItem("Classiques");
		DropDownListTypeKitchenAdd.addItem("Etudiante");
		DropDownListTypeKitchenAdd.addItem("Fête");
		//new JSlider for nb personnes
		sliderPeople = new JSlider(JSlider.HORIZONTAL,0,50,1);
		this.currentNbPeople = new JLabel("Valeur actuelle : "+sliderPeople.getValue());
		sliderPeople.setPaintLabels(true);
		sliderPeople.setMajorTickSpacing(10);
		sliderPeople.setMinorTickSpacing(5);
		sliderPeople.setPaintTicks(true);
		sliderPeople.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				currentNbPeople.setText("Valeur actuelle : " + ((JSlider)e.getSource()).getValue());			
			}
			});
		//new JSlider for time of cook
		sliderTimeCook = new JSlider(JSlider.HORIZONTAL,0,600,0);
		this.currentTimeCook = new JLabel("Valeur actuelle : "+sliderTimeCook.getValue());
		sliderTimeCook.setPaintLabels(true);
		sliderTimeCook.setMajorTickSpacing(60);
		sliderTimeCook.setMinorTickSpacing(30);
		sliderTimeCook.setPaintTicks(true);
		sliderTimeCook.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				currentTimeCook.setText("Valeur actuelle : " + ((JSlider)e.getSource()).getValue());			
			}
			});
		//new JSlider for time of preparation
		sliderTimePrepare = new JSlider(JSlider.HORIZONTAL,0,320,1);
		this.currentTimePrepare = new JLabel("Valeur actuelle : "+sliderTimePrepare.getValue());
		sliderTimePrepare.setPaintLabels(true);
		sliderTimePrepare.setMajorTickSpacing(60);
		sliderTimePrepare.setMinorTickSpacing(20);
		sliderTimePrepare.setPaintTicks(true);
		sliderTimePrepare.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				currentTimePrepare.setText("Valeur actuelle : " + ((JSlider)e.getSource()).getValue());			
			}
			});
		
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
		
		Box title = Box.createHorizontalBox();
		title.add(new JLabel(new ImageIcon("kukkinglogo.png")));
		title.add(Box.createHorizontalStrut(50));
		title.add(titleAdd);
		
		Box addPageBox = Box.createVerticalBox();
		addPageBox.add(title);
		addPageBox.add(textAreaNameRecipe);
		addPageBox.add(new JLabel("Nombre de personne"));
		addPageBox.add(sliderPeople);
		addPageBox.add(currentNbPeople);
		addPageBox.add(new JLabel("Temps de préparation (en minutes)"));
		addPageBox.add(sliderTimePrepare);
		addPageBox.add(currentTimePrepare);
		addPageBox.add(new JLabel("Temps de cuisson (en minutes)"));
		addPageBox.add(sliderTimeCook);
		addPageBox.add(currentTimeCook);
		addPageBox.add(new JLabel("Choississez un type de plat"));
		addPageBox.add(DropDownListTypeKitchenAdd);
		addPageBox.add(new JLabel("Choississez un type de cuisine"));
		addPageBox.add(DropDownListTypeMealAdd);
		addPageBox.add(new JLabel("Veuillez choisir un coût :"));
		addPageBox.add(cost);
		addPageBox.add(textAreaIngredients);
		addPageBox.add(textAreaQuantities);
		addPageBox.add(textAreaUnits);
		addPageBox.add(new JLabel(""));
		addPageBox.add(textAreaRecipeOfPrepare);
		addPageBox.add(buttonAdd);
		
		this.add(addPageBox);
		returnHomePage.addActionListener(kukkingFrame);
		buttonAdd.addActionListener(kukkingFrame);
	}

	/**
	 * to get quantities in String
	 * @return
	 */
	public String getTextAreaQuantities() {
		return textAreaQuantities.getText();
	}

	/**
	 * to get units in String
	 * @return
	 */
	public String getTextAreaUnits() {
		return textAreaUnits.getText();
	}
	
	/**
	 * to get nameRecipe in String
	 * @return
	 */
	public String getTextAreaNameRecipe() {
		return textAreaNameRecipe.getText();
	}

	/**
	 * to get ingredients in String
	 * @return
	 */
	public String getTextAreaIngredients() {
		return textAreaIngredients.getText();
	}

	/**
	 * to get preparation in String
	 * @return
	 */
	public String getTextAreaRecipeOfPrepare() {
		return textAreaRecipeOfPrepare.getText();
	}

	/**
	 * to get type meal in String
	 * @return
	 */
	public String getDropDownListTypeMealAdd() {
		return DropDownListTypeMealAdd.getSelectedItem().toString();
	}

	/**
	 * to get type kitchen in String
	 * @return
	 */
	public String getDropDownListTypeKitchenAdd() {
		return DropDownListTypeKitchenAdd.getSelectedItem().toString();
	}

	/**
	 * to get nbPeople in int
	 * @return
	 */
	public int getSliderPeople() {
		return sliderPeople.getValue();
	}

	/**
	 * to get time cook in int
	 * @return
	 */
	public int getSliderTimeCook() {
		return sliderTimeCook.getValue();
	}

	/**
	 * to get time prepare in int
	 * @return
	 */
	public int getSliderTimePrepare() {
		return sliderTimePrepare.getValue();
	}

	/**
	 * to get cost in String
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
