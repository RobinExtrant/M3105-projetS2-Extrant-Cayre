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

	public ReceiptsList getListe_Favoris() {
		return liste_Favoris;
	}

	public void setListe_Favoris(ReceiptsList liste_Favoris) {
		this.liste_Favoris = liste_Favoris;
	}
	
	private ReceiptsList receiptsList;

	public ReceiptsList getReceiptsList() {
		return receiptsList;
	}

	private Recipe recetteCourante;

	private boolean accesAdmin;

	public boolean userHaveAccesAdmin() {
		return accesAdmin;
	}

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

	
	public void deleteRecipeFromFavorisList(Recipe recetteAAsupprimer) throws RowsExceededException, WriteException
	{
		recetteAAsupprimer.deleteRecipeFromFavorisInDatasheet();
		this.liste_Favoris.list.remove(recetteAAsupprimer);
	}

	public void addRecipeInFavorisList(Recipe recetteAAjouter) throws RowsExceededException, WriteException
	{
		recetteAAjouter.setRecipeInFavorisInDatasheet();
		this.liste_Favoris.list.add(recetteAAjouter);
	}

	public void displayRecipe(Recipe recetteAAfficher) {
		user.displayAllElementsOfRecipe(recetteAAfficher);
	}

	public void previousPage() {
	}

	public void followPage() {
	}

	
	/**
	 * to search receipts with parameters
	 * @param searchingCriteria TODO
	 * @return
	 */
	public ArrayList<Recipe> rechercheRecettes(CriteriaToSearchReceipts searchingCriteria)
	{
		ArrayList<Recipe> listWellReceipts = new ArrayList<Recipe>();
		for (Recipe currentRecipe: receiptsList.list)
		{
			if (searchingCriteria.tempsPrepaMax >= currentRecipe.getPreparationTimeOnRecipe())
			{
				boolean typeCuisineValide = false;
				boolean typePlatValide = false;
				for (String categ: currentRecipe.getCategoriesListOfTheRecipe())
				{
					if (categ.equals(searchingCriteria.typeCuisine)) typeCuisineValide = true;
					if (categ.equals(searchingCriteria.typePlat)) typePlatValide = true;
				}
				if (searchingCriteria.typeCuisine.equals("Tous type de recettes") || typeCuisineValide)
				{
					if (searchingCriteria.typePlat.equals("Tous les plats") || typePlatValide)
					{
						if (searchingCriteria.cout.equals("Variable") || searchingCriteria.cout.equals(currentRecipe.getCostOnRecipe()))
						{
							listWellReceipts.add(currentRecipe);
						}			
					}
				}
			}
		}
		return listWellReceipts;
	}


	public boolean validatePasswordAccordingToLogin(String login, String password) {
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

	public IHM_Administrator getIHMAdmin() {
		return admin;
	}
}
