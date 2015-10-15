package kukking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserConsole implements IHM_User {

	@Override
	public int askNumberOfPersons() {
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
	public void displayAllElementsOfRecipe(Recipe recipeToDisplay) {
		String recipe = recipeToDisplay.getNameRecipe();
		recipe += "\n" + recipeToDisplay.getAmountOfPersonsOnRecipe() + " personnes";
		recipe += "\nTemps de préparation : " + recipeToDisplay.getPreparationTimeOnRecipe() + " min";
		recipe += "\nTemps de cuisson : " + + recipeToDisplay.getCookingTimeOnRecipe() + " min";
		recipe += "\nCout : " + recipeToDisplay.getCostOnRecipe();
		recipe += "\nCatégories :\n";
		for (int numRow=0;numRow<recipeToDisplay.getCategoriesListOfTheRecipe().size();numRow++)
		{
			recipe += "  " + recipeToDisplay.getCategoriesListOfTheRecipe().get(numRow)+"\n";
		}
		recipe += "Ingredients :\n";
		for (int numRow=0;numRow<recipeToDisplay.getIngredientsListOfTheRecipe().size();numRow++)
		{
			recipe += "- ";
			if (!recipeToDisplay.getAllIngredientsAmountOfRecipe().get(numRow).equals("")) recipe += recipeToDisplay.getAllIngredientsAmountOfRecipe().get(numRow)+" ";
			if (!recipeToDisplay.getAllIngredientsUnitsListOfRecipe().get(numRow).equals("")) recipe += recipeToDisplay.getAllIngredientsUnitsListOfRecipe().get(numRow)+" ";
			recipe += recipeToDisplay.getIngredientsListOfTheRecipe().get(numRow)+"\n";
		}
		recipe += "\nPréparation :\n";
		for (int numRow=0;numRow<recipeToDisplay.getStepsPreparationListOfRecipe().size();numRow++)
		{
			recipe += "    "+ recipeToDisplay.getStepsPreparationListOfRecipe().get(numRow)+"\n";
		}
		
		System.out.println(recipe);

	}

	@Override
	public void displayReceiptsListWithName(Recipe listeRecettes) {
		// TODO Auto-generated method stub

	}

}
