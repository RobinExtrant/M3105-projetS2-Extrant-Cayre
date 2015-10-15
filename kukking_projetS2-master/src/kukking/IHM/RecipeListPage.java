package kukking.IHM;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 * class where is the user if he research a list of receipts
 * @author RO
 *
 */
public class RecipeListPage extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JButton returnHomePage;
	private KukkingDisplay kukkingFrame;
	public JPanel listReceipts;
	
	
	/**
	 * constructor of page
	 * @param kukkingFrame
	 */
	public RecipeListPage(KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		this.listReceipts= new JPanel();
		this.listReceipts.setLayout(new GridBagLayout());
		this.setLayout(new GridBagLayout());
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));

		GridBagConstraints gbc = new GridBagConstraints();
	/* logo */
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(kukkingLogo,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(listReceipts, gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		returnHomePage = new JButton("Retour à la page d'accueil");
		returnHomePage.addActionListener(kukkingFrame);
		this.add(returnHomePage, gbc);
		
	}	
}
