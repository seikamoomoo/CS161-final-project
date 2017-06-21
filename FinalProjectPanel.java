
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class FinalProjectPanel extends JPanel
{
	//sprite stuff; x and y coordinates
	Sprite P1;
	Sprite P2;

	int x1 = 50;
	int y1 = 225;
	int x2 = 50;
	int y2 = 300;

	//health bar stuff; x coordinate and width
	HealthBar H1;
	HealthBar H2;

	int hx1 = 20;
	int hw1 = 200;
	int hx2 = 780;
	int hw2 = 200;

	//constructor
	public FinalProjectPanel()
	{
		//label
		JLabel label = new JLabel("P1 vs. P2");
		label.setPreferredSize(new Dimension(100, 50));
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setForeground(Color.blue);
		add(label, BorderLayout.NORTH);

		//panel
		setPreferredSize(new Dimension(1000, 350));
		setBackground(new Color(124, 229, 249));

		//P1 key bindings
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right1");
		this.getActionMap().put("right1", new MoveAction(1, 1));
		//
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "left1");
		this.getActionMap().put("left1", new MoveAction(1, 2));
		//
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "up1");
		this.getActionMap().put("up1", new MoveAction(1, 3));
		//
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "down1");
		this.getActionMap().put("down1", new MoveAction(1, 4));


		//P2 key bindings
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0, true), "right2");
		this.getActionMap().put("right2", new MoveAction(2, 1));
		//
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0, true), "left2");
		this.getActionMap().put("left2", new MoveAction(2, 2));
		//
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, true), "up2");
		this.getActionMap().put("up2", new MoveAction(2, 3));
		//
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0, true), "down2");
		this.getActionMap().put("down2", new MoveAction(2, 4));

	}

	//action class
    private class MoveAction extends AbstractAction{

        int player;
        int action;

        MoveAction(int player, int action){

            this.player = player;
            this.action = action;
        }

        @Override
        public void actionPerformed(ActionEvent e){
			if(player == 1){
				switch (action) {
					//right
					case 1: //obstacle 1
							if((x1 == 140 && y1 > 205 && y1 < 300)||(x1 == 290 && y1 > 285)||(x1 == 490 && y1 < 245)||(x1 == 630 && y1 > 225 && y1 < 280)||(x1 == 790 && y1 > 260)){
								hw1 -= 50;
							}
							else{
								x1 += 10;
							}
		                    break;
		            //left
		            case 2: x1 -=10;
		                    break;
		            //up
					case 3: if(y1 > 200){
								y1 -= 10;
							}
		                    break;
		            //down
		            case 4: if(y1 < 400){
		            			y1 +=10;
							}
		                    break;

				}
				repaint();
			}

			if(player == 2){
				switch (action) {
					//right
					case 1: //obstacle 1
							if((x2 == 140 && y2 > 205 && y2 < 300)||(x2 == 290 && y2 > 285)||(x2 == 490 && y2 < 245)||(x2 == 630 && y2 > 225 && y2 < 280)||(x2 == 790 && y2 > 260)){
								hw2 -= 50;
							}
								else{
								x2 += 10;
							}
							break;
					//left
					case 2: x2 -=10;
							break;
					//up
					case 3: if(y2 > 200){
								y2 -= 10;
							}
		                    break;
		            //down
		            case 4: if(y2 < 400){
		            			y2 += 10;
							}
		                    break;

				}
				repaint();

				//win conditions
				if(x1 > 930 || hw2 <= 0){
					JOptionPane.showMessageDialog(null, "P1 Wins!");
				}
				if(x2 > 930 || hw1 <= 0){
					JOptionPane.showMessageDialog(null, "P2 Wins!");
				}


			}

        }

    }

	public void paintComponent(Graphics page)
	{
		//sprites
		P1 = new Sprite(Color.blue, x1, y1);
		P2 = new Sprite(Color.red, x2, y2);

		//health bars
		H1 = new HealthBar(hx1, hw1);
		H2 = new HealthBar(hx2, hw2);

		super.paintComponent(page);

		//ground
		page.setColor(new Color(82, 178, 53));
		page.fillRect(0, 180, 1000, 170);

		//finish line
		page.setColor(Color.white);
		page.fillRect(925, 180, 25, 170);

		//obstacles
		page.setColor(new Color(196, 196, 196));
		page.fillRect(150, 220, 15, 90);
		page.fillRect(300, 300, 30, 50);
		page.fillRect(500, 180, 20, 75);
		page.fillRect(640, 240, 30, 50);
		page.fillRect(800, 275, 15, 75);


		P1.draw(page);
		P2.draw(page);

		H1.draw(page);
		H2.draw(page);

	}
}



