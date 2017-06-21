import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class Sprite extends JPanel
{
	Color c;
	public int x;
	public int y;

	public Sprite(Color c, int x, int y)
	{
		this.c = c;
		this.x = x;
		this.y = y;

	}

	public void draw(Graphics page)
	{
		page.setColor(c);
		page.fillRect(x, y-15, 15, 25);
		page.fillOval(x, y-30, 15, 15);
		page.fillRect(x, y+10, 5, 10);
		page.fillRect(x+10, y+10, 5, 10);

	}

}
