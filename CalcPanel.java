import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CalcPanel extends JFrame{

    //The buttons of the calculator
    private JButton[] jbNum;
    private JButton jbEqual;
    private JButton jbAdd;
    private JButton jbSubtract;
    private JButton jbMultiply;
    private JButton jbDivide;
    private JButton jbNegative;
    private JButton jbDot;



    private double temp; //the first num in the operation
    private double temp2;//the second num in the operation
    private double solution;

    private boolean isAdd=false;
    private boolean isSub=false;
    private boolean isMul=false;
    private boolean isDiv=false;

    private boolean divByZero=false;
    private boolean wasOper=false;
    private boolean afterEqual=false;

    private JPanel buttonJPanel;
    private JPanel displayJPanel;

    private JTextField jtfResult;
    String display="";



    public CalcPanel()
    {
        //setting up the buttons
        super("Calculator");
        jbNum = new JButton[10];
        for(int i=0; i<10; i++)
        {
            jbNum[i] = new JButton(""+i);
        }

        jbEqual = new JButton("=");
        jbAdd = new JButton("+");
        jbDivide = new JButton("/");
        jbDot = new JButton(".");
        jbMultiply = new JButton("*");
        jbNegative = new JButton("+/-");
        jbSubtract = new JButton("-");


        //the panel of the buttons
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(4,5,10,10));


        //Adding the buttons to the panel. and listeners to those buttons
        buttonJPanel.add(jbNum[7]);
        buttonJPanel.add(jbNum[8]);
        buttonJPanel.add(jbNum[9]);
        buttonJPanel.add(jbDivide);
        buttonJPanel.add(jbMultiply);
        buttonJPanel.add(jbNum[4]);
        buttonJPanel.add(jbNum[5]);
        buttonJPanel.add(jbNum[6]);
        buttonJPanel.add(jbSubtract);
        buttonJPanel.add(jbAdd);
        buttonJPanel.add(jbNum[1]);
        buttonJPanel.add(jbNum[2]);
        buttonJPanel.add(jbNum[3]);
        buttonJPanel.add(jbNegative);
        buttonJPanel.add(jbEqual);
        buttonJPanel.add(jbNum[0]);
        buttonJPanel.add(jbDot);

        jbNum[0].addActionListener(new ButtonListener());
        jbNum[1].addActionListener(new ButtonListener());
        jbNum[2].addActionListener(new ButtonListener());
        jbNum[3].addActionListener(new ButtonListener());
        jbNum[4].addActionListener(new ButtonListener());
        jbNum[5].addActionListener(new ButtonListener());
        jbNum[6].addActionListener(new ButtonListener());
        jbNum[7].addActionListener(new ButtonListener());
        jbNum[8].addActionListener(new ButtonListener());
        jbNum[9].addActionListener(new ButtonListener());
        jbDot.addActionListener(new ButtonListener());
        jbDivide.addActionListener(new ButtonListener());
        jbAdd.addActionListener(new ButtonListener());
        jbSubtract.addActionListener(new ButtonListener());
        jbMultiply.addActionListener(new ButtonListener());
        jbNegative.addActionListener(new ButtonListener());
        jbEqual.addActionListener(new ButtonListener());






        //the panel for the display
        displayJPanel = new JPanel();
        displayJPanel.setLayout(new FlowLayout());
        jtfResult = new JTextField(20);
        displayJPanel.add(jtfResult);
        jtfResult.setEditable(false);



        add(displayJPanel,BorderLayout.NORTH);
        add(buttonJPanel,BorderLayout.CENTER);
    }



    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==jbNum[9])
            {
                if(afterEqual) //if it just finished an operation and the result is on the screen then deletes that result and start a new operation.
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"9");
            }
            else if(e.getSource()==jbNum[8])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"8");
            }
            else if(e.getSource()==jbNum[7])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"7");
            }
            else if(e.getSource()==jbNum[6])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"6");
            }
            else if(e.getSource()==jbNum[5])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"5");
            }
            else if(e.getSource()==jbNum[4])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"4");
            }
            else if(e.getSource()==jbNum[3])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"3");
            }
            else if(e.getSource()==jbNum[2])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"2");
            }
            else if(e.getSource()==jbNum[1])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"1");
            }
            else if(e.getSource()==jbNum[0])
            {
                if(afterEqual)
                {
                    afterEqual=false;
                    jtfResult.setText("");
                }
                display = jtfResult.getText();
                jtfResult.setText(display+"0");
            }


            else if(e.getSource()==jbAdd)
            {
                temp=Double.parseDouble(jtfResult.getText());
                isAdd=true;
                jtfResult.setText("");
            }
            else if(e.getSource()==jbSubtract)
            {
                temp=Double.parseDouble(jtfResult.getText());
                isSub=true;
                jtfResult.setText("");
            }
            else if(e.getSource()==jbMultiply)
            {
                temp=Double.parseDouble(jtfResult.getText());
                isMul=true;
                jtfResult.setText("");
            }
            else if(e.getSource()==jbDivide)
            {
                temp=Double.parseDouble(jtfResult.getText());
                isDiv=true;
                jtfResult.setText("");
            }


            else if(e.getSource()==jbDot)
            {
                display = jtfResult.getText();
                jtfResult.setText(display+".");
            }
            else if(e.getSource()==jbNegative)
            {
                temp2=Double.parseDouble(jtfResult.getText());
                temp2=(-1)*temp2;
                jtfResult.setText(""+temp2);
            }


            else if(e.getSource()==jbEqual)
            {
                temp2=Double.parseDouble(jtfResult.getText());
                //checks which operation it was and calculates the result according to the operation
                if(isAdd)
                {
                    wasOper=true;
                    solution=temp+temp2;
                    isAdd=false;
                }
                else if(isSub)
                {
                    wasOper=true;
                    solution = temp - temp2;
                    isSub=false;
                }
                else if(isMul)
                {
                    wasOper=true;
                    isMul=false;
                    solution=temp*temp2;
                }
                else if(isDiv)
                {
                    wasOper=true;
                    if(temp2==0)
                        divByZero=true;
                    else
                        solution=temp/temp2;
                    isDiv=false;
                }

                //if the operation tried to divide by zero then write an error to the screen else displays the solution
                if(divByZero)
                {
                    wasOper=false;
                    divByZero=false;
                    display="Error, can't divided 0";
                    jtfResult.setText(display);
                }
                else if(wasOper)
                {
                    wasOper=false;
                    display=""+solution;
                    jtfResult.setText(display);
                    display="";
                    afterEqual=true;
                }


            }





        }
    }
}
