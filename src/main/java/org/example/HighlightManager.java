package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HighlightManager {
    public HighlightManager() {
    }
    public Square[] addHighlightFeature(Square[] squares) {
        for (int i = 0; i < 64; ++i) {

            int finalI = i;
            squares[i].addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }


                @Override
                public void mouseEntered(MouseEvent e) {
                    // Highlight the label by setting a border
                    if (squares[finalI].getBorder() == null )
                    {
                        squares[finalI].setBorder(BorderFactory.createLineBorder(Color.BLUE,3)); // Yellow dashed marker
                        squares[finalI].revalidate();
                        squares[finalI].repaint();
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {

                    Border border = (Border) squares[finalI].getBorder();
                    Color borderColor = ((LineBorder) border).getLineColor();
                    // Remove the border when the mouse exits
                    if (borderColor != Color.GREEN)
                    {
                        squares[finalI].repaint();
                        squares[finalI].setBorder(null);
                    }
                }
            });


        }
        return squares;
    }
}


