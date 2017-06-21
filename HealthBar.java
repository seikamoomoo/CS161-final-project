import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class HealthBar extends JPanel
{
	public int x;
	public int w;

	public HealthBar(int x, int w)
	{
		this.x = x;
		this.w = w;
	}

	public void draw(Graphics page)
	{
		//red part
		page.setColor(new Color(219, 43, 61));
		page.fillRect(x-5, 15, 210, 30);

		//green part
		page.setColor(new Color(77, 249, 49));
		page.fillRect(x, 20, w, 20);

	}

}
