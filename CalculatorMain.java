/**
 *
 * Shay Yosipov
 * id: 324124593
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorMain extends JFrame {

    public static void main(String[] args)
    {
        CalcPanel calc = new CalcPanel();
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setSize(350,450);
        calc.setVisible(true);
    }

} //JavaCalculator