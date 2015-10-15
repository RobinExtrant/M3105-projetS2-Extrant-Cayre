package kukking;

public class CriteriaToSearchReceipts {
	public int tempsPrepaMax;
	public String typeCuisine;
	public String typePlat;
	public String cout;

	public CriteriaToSearchReceipts(int tempsPrepaMax, String typeCuisine,
			String typePlat, String cout) {
		this.tempsPrepaMax = tempsPrepaMax;
		this.typeCuisine = typeCuisine;
		this.typePlat = typePlat;
		this.cout = cout;
	}
}