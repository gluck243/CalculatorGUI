import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class MyFrame extends JFrame { // implements ActionListener // interface

    JButton button = new JButton(); // button creation point

    MyFrame(){

        this.setTitle("Calculator"); // sets title

        // frame.setResizable(false); // prevents resizing


        /* button.setBounds(10,10,100,100);
        button.addActionListener(this); // adds and action listener created below
        button.setText("Press me!"); // adds text to a button
        button.setFont(new Font("Comic Sans",Font.BOLD,5));
        button.setFocusable(false); // removes border around text
        button.setForeground(Color.lightGray); // changes button color
        button.setBorder(BorderFactory.createEtchedBorder()); // customizes border
        // button.setEnabled(false); */

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits on hitting 'x'
        this.setSize(600, 600); // sets frame size for x and y dimension

        // this.setLayout(new GridLayout(3,3, 10, 10)); // Grid layout organizes items in a grid specified by parameters
        // this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); // All standard directions + TRAILING - sets layout to rightmost border
        // this.setLayout(new BorderLayout()); // sets layout manager, null disables layout,
                                            // new BorderLayout() passed as an argument enables panel positioning
                                            // passing arguments to BorderLayout offsets elements (in px)

        this.setVisible(true); // make visible

        /* this.add(new JButton("1"));
        this.add(new JButton("2"));
        this.add(new JButton("3"));
        this.add(new JButton("4"));
        this.add(new JButton("5"));
        this.add(new JButton("6"));
        this.add(new JButton("7"));
        this.add(new JButton("8"));
        this.add(new JButton("9")); */

        // this.add(button);

        /*JLabel textPanel1 = new JLabel();
        textPanel1.setText("Red Panel text");
        textPanel1.setVerticalAlignment(JLabel.BOTTOM);
        textPanel1.setHorizontalAlignment(JLabel.CENTER); */

        /*
        JPanel panel1 = new JPanel(); // creates a panel
        panel1.setBackground(Color.RED); // sets a background color of a panel
        // panel1.setBounds(0,0,250,250); // sets a size of a panel
        panel1.setPreferredSize(new Dimension(100,100));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        // panel2.setBounds(250,0,250,250);
        panel2.setPreferredSize(new Dimension(100,100));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.setBounds(0,250,500,250);
        // panel3.setLayout(new BorderLayout()); // sets items to desired location on a panel
        panel3.setPreferredSize(new Dimension(100,100));

         */

        // Panels can be inserted into panel by setting up new layout inside the outer panel

        // this.add(panel1, BorderLayout.NORTH);
        // this.add(panel2, BorderLayout.WEST);
        // this.add(panel3, BorderLayout.EAST);

        /* JLabel text1 = new JLabel(); // creation of a label (text placeholder)
        Border border1 = BorderFactory.createLineBorder(Color.black); // creates a border for a label

        text1.setText("Hello World"); // sets text

        text1.setForeground(Color.RED); // sets text color
        text1.setFont(new Font("Arial", Font.BOLD, 20)); // sets font
        text1.setBackground(Color.BLACK); // sets background color of a label, note! : label takes as much space as possible
        text1.setOpaque(true); // makes background color visible/invisible
        text1.setBorder(border1); // sets a chosen border
        text1.setVerticalAlignment(JLabel.CENTER); // sets vertical position of text/image within label
        text1.setHorizontalAlignment(JLabel.CENTER); // sets horizontal position of text/image within label
        text1.setBounds(100, 100, 350, 350); // sets x, y, width, height within frame

        // ImageIcon image new ImageIcon("");
        // this.setIconImage(image.getImage()); // sets logo in the corner of a window to the chosen image

        // this.getContentPane().setBackground(Color.green); // changes the background color

        this.getContentPane().setBackground(new Color(255, 255, 255)); // with a possibility to make a custom color with rgb or HEX

        this.add(text1); // ads a component */

        /* panel1.add(textPanel1); // panels are used as containers
        this.add(panel1); // ads a panel
        this.add(panel2);
        this.add(panel3); */

        // this.pack(); // only works with default layout manager and if all components are added beforehand! sets the initial size of a window to fit label
    };

    /* @Override
    public void actionPerformed(ActionEvent e) { // creation of an action listener
        if(e.getSource() == button) {
            System.out.println("Button pressed");
            button.setText("Yaaaay!");
            button.setBackground(Color.RED);
        }
    } */
}
