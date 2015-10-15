package kukking;

import java.io.IOException;


/**
 * Administrator interface
 */
interface IHM_Administrator {
  boolean ok(Recipe recipeToDelete) throws IOException ;

  Recipe getFormAddRecipe() throws IOException;
}
