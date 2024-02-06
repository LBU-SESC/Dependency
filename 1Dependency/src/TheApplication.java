import uk.ac.leedsbeckett.mullier.sesc.Circle;
import uk.ac.leedsbeckett.mullier.sesc.Ellipse;
import uk.ac.leedsbeckett.mullier.sesc.Rectangle;
import uk.ac.leedsbeckett.mullier.sesc.Shape;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;


public class TheApplication extends JFrame{
	
	/**
	 * example of no DI or factory
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	final int XSIZE = 640, YSIZE = 480;
	int headX = 10, headY = 50, headXsize = 150, headYsize = 130;
	int eyeX = headX+(headXsize/4), eyeY = headY+(headYsize/5), eyeSize = headXsize /10, eyeGap = headXsize/3; 
	int mouthX = eyeX,  mouthY = eyeY + headY, mouthXsize = eyeSize*3, mouthYsize = eyeSize;
	ArrayList<Shape> Shapes;
	
	public TheApplication()
	{
		setPreferredSize(new Dimension(XSIZE, YSIZE));
		pack();
		setVisible(true);
		Shape head, lefteye, righteye, mouth;
		Color col;

		//head
		head = new Rectangle();
  		col = new Color(255, 0, 0);
        head.set(col, headX, headY, headXsize, headYsize);
        Shapes = new ArrayList<>();
        Shapes.add(head);
			
        //left eye
        lefteye = new Circle();
        col = new Color(255, 255, 255);
        lefteye.set(col, eyeX, eyeY, eyeSize);
        Shapes.add(lefteye);
			
        //right eye
        righteye = new Circle();
        col = new Color(255, 255, 255);
        righteye.set(col, eyeX+eyeGap, eyeY, eyeSize);
        Shapes.add(righteye);
			
        //mouth
        mouth = new Ellipse();
        col = new Color(0,0,0);
        mouth.set(col, mouthX, mouthY, mouthXsize, mouthYsize);
        Shapes.add(mouth);
	}
	
	public void paint(Graphics g)
	{
        for (Shape shape : Shapes) {
            Shape s;
            s = shape;
            if (s != null) {
                s.draw(g);
                System.out.println(s.ToString());
            } else
                System.out.println("invalid shape in array"); //shouldn't happen as factory does not produce rubbish

        }
		g.setColor(Color.BLACK);
		g.drawString("Shape Example with no factory or DI", 100, 100);
	}
}


