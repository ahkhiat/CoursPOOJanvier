import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    // varibales
        // title
            private String title;
        // size
            private int height;
            private int width;
        // resizable
            private boolean isResizable;
        // location relative to
        // default close operation
        // setVisible
            private boolean isVisible;


    // constructeur
        public MyFrame(String title, int height, int width, boolean isResizable, boolean isVisible) {
            super(title);

            JPanel mainPanel = new JPanel();
            JPanel interPanel = new JPanel();
            JPanel buttonPanel = new JPanel();

            mainPanel.setBackground(Color.pink);
//            mainPanel.setLayout(new BorderLayout());
//
//            mainPanel.add(new JButton("1"), BorderLayout.CENTER);
//            mainPanel.add(new JLabel("label"), BorderLayout.WEST);
//
//            buttonPanel.add(new JButton("2"));
//            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            mainPanel.setLayout(new BorderLayout());

            interPanel.setLayout(new GridLayout(2, 2));

            JTextField tfNom = new JTextField();
            JTextField tfPrenom = new JTextField();

            interPanel.add(new JLabel("     Nom : "));
            interPanel.add(tfNom);

            interPanel.add(new JLabel("     Prénom : "));
            interPanel.add(tfPrenom);

            mainPanel.add(interPanel);

            JButton btn1 = new JButton("OK");
            btn1.addActionListener(new ButtonActionListener(tfNom, tfPrenom));
            tfNom.getActionListeners();

            buttonPanel.add(btn1);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            setContentPane(mainPanel);

            setSize(width, height);
            setResizable(isResizable);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(isVisible);
            // pas besoin de this

        }
    // méthodes


}
