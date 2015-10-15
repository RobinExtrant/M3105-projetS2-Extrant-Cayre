package kukking;

import java.io.IOException;


/**
 * User interface
 */
interface IHM_User {
  /**
   * Ne s'effectue seulement si c'est un utilisateur qui est à la base de la recherche
   */
  int demandeNombrePersonne() ;

  String requestPassword() throws IOException;

  /**
   * Est réalisée à condition que le mot de passe renvoyé par l'utilisateur soit valide
   */
  void displayAdministrativePart() ;

  /**
   * Display all recipe's elements
 * @param RecipeToDisplay
 */
void afficheElementsRecette(Recipe RecipeToDisplay) ;

  /**
   * affiche la liste des recettes (seulement les noms)
   */
  void afficheListeRecettes(Recipe listeRecettes) ;
}
