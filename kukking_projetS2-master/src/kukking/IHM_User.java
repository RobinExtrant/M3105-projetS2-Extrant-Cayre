package kukking;

import java.io.IOException;


/**
 * User interface
 */
interface IHM_User {
  
  int askNumberOfPersons() ;

  String requestPassword() throws IOException;

  void displayAdministrativePart() ;

void displayAllElementsOfRecipe(Recipe RecipeToDisplay) ;

  void displayReceiptsListWithName(Recipe listeRecettes) ;
}
