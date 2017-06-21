import javax.swing.JFrame;

public class FinalProject
{
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("Cool Game");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jf.getContentPane().add(new FinalProjectPanel());

		jf.pack();
		jf.setVisible(true);
	}
}