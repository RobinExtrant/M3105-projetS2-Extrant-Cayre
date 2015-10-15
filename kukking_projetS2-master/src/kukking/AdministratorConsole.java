package kukking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * old class (when the beginning of application was test in console
 * @author RO
 *
 */
public class AdministratorConsole implements IHM_Administrator {

	@Override
	public boolean ok(Recipe recipeToDelete) throws IOException {
		System.out.println("Etes vous sûr de vouloir supprimer la recette :"+ recipeToDelete.getNameRecipe());
		BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
	    if (entree.readLine()=="0") return true;
		return false;
	}

	@Override
	public Recipe formAddRecipe() throws IOException {
		System.out.println("Titre de la recette ?");
		BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
		String title = entree.readLine();
		
		System.out.println("Nombre de personnes ?");
		int nbPers = Integer.parseInt(entree.readLine());
		
		System.out.println("Temps de préparation (en min) ?");
		int preparationTime = Integer.parseInt(entree.readLine());
		
		System.out.println("Temps de cuisson total (en min) ?");
		int cookingTime = Integer.parseInt(entree.readLine());
		
		System.out.println("Coût ?");
		String cost = entree.readLine();
		
		System.out.println("Catégories ? (entrez une catégorie à la fois, puis rappuyez quand vous avez fini)");
		ArrayList <String> categories = new ArrayList <String>();
		String category = entree.readLine();
		while (!category.equals(""))
		{
			categories.add(category);
			category = entree.readLine();			
		}
		
		System.out.println("Ingrédients ? (De même que pour les catégories, en renseignant la quantité)\nNom :");
		ArrayList <String> ingredients = new ArrayList <String>();
		String ingredient = entree.readLine();
		System.out.println("Quantité :");
		ArrayList <String> quantities = new ArrayList <String>();
		String quantity = entree.readLine();
		System.out.println("Unité :");
		ArrayList <String> units = new ArrayList <String>();
		String unit = entree.readLine();
		while (!ingredient.equals(""))
		{
			ingredients.add(ingredient);
			quantities.add(quantity);
			units.add(unit);
			System.out.println("Nom :");
			ingredient = entree.readLine();
			System.out.println("Quantité :");
			quantity = entree.readLine();
			System.out.println("Unité :");
			unit = entree.readLine();
		}
		
		System.out.println("Préparation ? (De même que pour les catégories, entrez étape par étape)");
		ArrayList <String> preparation = new ArrayList <String>();
		String step = entree.readLine();
		while (!step.equals(""))
		{
			preparation.add(step);
			step = entree.readLine();
		}
		
		return new Recipe(title, nbPers, preparationTime, cookingTime, cost, categories, ingredients, quantities, units, preparation);
	}

}
