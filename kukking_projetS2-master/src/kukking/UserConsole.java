package kukking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserConsole implements IHM_User {

	@Override
	public int demandeNombrePersonne() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String requestPassword() throws IOException {
		System.out.println("Mot de passe ? ");
		BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
		return entree.readLine();
	}

	@Override
	public void displayAdministrativePart() {
		System.out.println("Bon");
		// TODO displayAdministrativePart

	}

	@Override
	public void afficheElementsRecette(Recipe recipeToDisplay) {
		String recipe = recipeToDisplay.getNameRecipe();
		recipe += "\n" + recipeToDisplay.getNbPers() + " personnes";
		recipe += "\nTemps de préparation : " + recipeToDisplay.getPreparationTime() + " min";
		recipe += "\nTemps de cuisson : " + + recipeToDisplay.getCookingTime() + " min";
		recipe += "\nCout : " + recipeToDisplay.getCost();
		recipe += "\nCatégories :\n";
		for (int numRow=0;numRow<recipeToDisplay.getCategories().size();numRow++)
		{
			recipe += "  " + recipeToDisplay.getCategories().get(numRow)+"\n";
		}
		recipe += "Ingredients :\n";
		for (int numRow=0;numRow<recipeToDisplay.getIngredients().size();numRow++)
		{
			recipe += "- ";
			if (!recipeToDisplay.getQuantities().get(numRow).equals("")) recipe += recipeToDisplay.getQuantities().get(numRow)+" ";
			if (!recipeToDisplay.getUnits().get(numRow).equals("")) recipe += recipeToDisplay.getUnits().get(numRow)+" ";
			recipe += recipeToDisplay.getIngredients().get(numRow)+"\n";
		}
		recipe += "\nPréparation :\n";
		for (int numRow=0;numRow<recipeToDisplay.getPreparation().size();numRow++)
		{
			recipe += "    "+ recipeToDisplay.getPreparation().get(numRow)+"\n";
		}
		
		System.out.println(recipe);

	}

	@Override
	public void afficheListeRecettes(Recipe listeRecettes) {
		// TODO Auto-generated method stub

	}

}
