import javax.swing.*;
import java.awt.*;

public class ExoFrame extends JFrame {

    public ExoFrame(String title, int height, int width) {
        super(title);

        JPanel mainPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel interPanel = new MyCustomGreyPanel(Color.gray);
        JPanel buttonPanel = new JPanel();


        mainPanel.setLayout(new BorderLayout());

        interPanel.setLayout(new GridLayout(3, 2));

        JTextField tfNom = new JTextField();
        JTextField tfPrenom = new JTextField();
        JTextField tfAge = new JTextField();

        JLabel titleLabel = new JLabel("Bonjour !");
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        interPanel.add(new JLabel("Nom : "));
        interPanel.add(tfNom);

        interPanel.add(new JLabel("Prénom : "));
        interPanel.add(tfPrenom);

        interPanel.add(new JLabel("Age : "));
        interPanel.add(tfAge);

        // Exercice 3
//        interPanel.setBackground(Color.gray);

        mainPanel.add(interPanel);

        JButton btn1 = new JButton("OK");
        btn1.addActionListener(new ButtonActionListener(this, tfNom, tfPrenom, tfAge));
        tfNom.getActionListeners();

        buttonPanel.add(btn1);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
