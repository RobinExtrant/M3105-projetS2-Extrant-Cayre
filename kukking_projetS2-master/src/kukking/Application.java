package kukking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import kukking.IHM.KukkingDisplay;


/**
 * principal class which init IHM and has list of receipts and favoris
 * @author RO
 *
 */
public class Application {
	
	public final static String[] logins = {"Martin","Laure","Robin","Maud","Alexandra"};
	public final static String[] passwords = {"AM","CA","EX","LA","LI"};
	
	private IHM_User user;

	private IHM_Administrator admin;
	
	private KukkingDisplay kukking;

	private ReceiptsList liste_Favoris;
	/**
	 * to get liste favoris
	 * @return
	 */
	public ReceiptsList getListe_Favoris() {
		return liste_Favoris;
	}
	/**
	 * to set liste favoris
	 * @param liste_Favoris
	 */
	public void setListe_Favoris(ReceiptsList liste_Favoris) {
		this.liste_Favoris = liste_Favoris;
	}
	
	private ReceiptsList receiptsList;
	/**
	 * to get receiptslist
	 * @return
	 */
	public ReceiptsList getReceiptsList() {
		return receiptsList;
	}

	private Recipe recetteCourante;

	private boolean accesAdmin;
	/**
	 * to kwnow if user is connect in mode administrator
	 * @return
	 */
	public boolean isAccesAdmin() {
		return accesAdmin;
	}

	/**
	 * constructor application which call several init
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IndexOutOfBoundsException
	 */
	public Application() throws RowsExceededException, WriteException, IndexOutOfBoundsException
	{
		this.user = new UserConsole();
		this.admin = new AdministratorConsole();
		this.receiptsList = new ReceiptsList(this, false);
		this.initFileReceipts();
		this.liste_Favoris = new ReceiptsList(this, true);
		this.kukking = new KukkingDisplay(this);
		this.kukking.setLocationRelativeTo(null);
		this.kukking.setVisible(true);
	}

	/**
	 * to avoid bug about get preparation
	 * @throws IndexOutOfBoundsException 
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	private void initFileReceipts() throws RowsExceededException, WriteException, IndexOutOfBoundsException
	{
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File(Recipe.sourcePath),Workbook.getWorkbook(new File(Recipe.sourcePath)));
			int nbSheet = workbook.getNumberOfSheets();
			for (int numSheet=0; numSheet<nbSheet; numSheet++)
			{
				Label secure = new Label(0,workbook.getSheet(numSheet).getRows(),"");
				workbook.getSheet(numSheet).addCell(secure);
			}
			
			workbook.write(); 

		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (BiffException e) {
			e.printStackTrace();
		}
		finally {
				/* On ferme le worbook pour libérer la mémoire */
				try {
					workbook.close();
				} 
				catch (WriteException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					e.printStackTrace();
				} 
			
		}
	}

	/**
	 * to delete favoris
	 * @param recetteAAsupprimer
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public void supprimerFavori(Recipe recetteAAsupprimer) throws RowsExceededException, WriteException
	{
		recetteAAsupprimer.deleteFavoris();
		this.liste_Favoris.list.remove(recetteAAsupprimer);
	}

	/**
	 * to add favoris
	 * @param recetteAAjouter
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public void ajouterFavori(Recipe recetteAAjouter) throws RowsExceededException, WriteException
	{
		recetteAAjouter.setFavoris();
		this.liste_Favoris.list.add(recetteAAjouter);
	}

	/**
	 * display recipe to console
	 * @param recetteAAfficher
	 */
	public void affichageRecette(Recipe recetteAAfficher) {
		user.afficheElementsRecette(recetteAAfficher);
	}

	/**
	 * ne s'effectue que si on n'est pas à la première page
	 */
	public void pagePrecedente() {
	}

	/**
	 * ne s'effectue que si on n'est pas à la dernière page.
	 */
	public void pageSuivante() {
	}

	
	/**
	 * to search receipts with parameters
	 * @param tempsPrepaMax
	 * @param typeCuisine
	 * @param typePlat
	 * @param cout
	 * @return
	 */
	public ArrayList<Recipe> rechercheRecettes(int tempsPrepaMax, String typeCuisine, String typePlat, String cout)
	{
		ArrayList<Recipe> listWellReceipts = new ArrayList<Recipe>();
		for (Recipe currentRecipe: receiptsList.list)
		{
			if (tempsPrepaMax >= currentRecipe.getPreparationTime())
			{
				boolean typeCuisineValide = false;
				boolean typePlatValide = false;
				for (String categ: currentRecipe.getCategories())
				{
					if (categ.equals(typeCuisine)) typeCuisineValide = true;
					if (categ.equals(typePlat)) typePlatValide = true;
				}
				if (typeCuisine.equals("Tous type de recettes") || typeCuisineValide)
				{
					if (typePlat.equals("Tous les plats") || typePlatValide)
					{
						if (cout.equals("Variable") || cout.equals(currentRecipe.getCost()))
						{
							listWellReceipts.add(currentRecipe);
						}			
					}
				}
			}
		}
		return listWellReceipts;
		
		/*Cette boucle est juste un test
		for(Recipe currentRecipe: listWellReceipts)
		{
			System.out.println (currentRecipe.getNameRecipe());
		}
		// Fin de la boucle test*/
	}

	/*public void requestAdministrativeAccess(String login, String password) throws IOException
	{
		if (valider(login, password))
			user.displayAdministrativePart();
	}*/

	/**
	 * valid or not password give in parameter
	 */
	public boolean valider(String login, String password) {
		int numLogin = 0;
		for (String currentLogin:logins)
		{
			if (login.equals(currentLogin)&&password.equals(passwords[numLogin]))
			{
				accesAdmin = true;
				return true;
			}
			numLogin++;
		}
		return false;
	}

	/**
	 * to get IHM_Administrator
	 * @return
	 */
	public IHM_Administrator getAdmin() {
		return admin;
	}
}
