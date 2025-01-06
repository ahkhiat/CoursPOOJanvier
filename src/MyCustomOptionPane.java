import javax.swing.*;
import java.awt.*;

public class MyCustomOptionPane extends JFrame {

    public MyCustomOptionPane(JFrame parent, String message) {
        super();

        // Désactive la fenêtre parente, comme une modale
        parent.setEnabled(false);

        JPanel mainPanel = new JPanel();
        JPanel interPanel = new MyCustomGreyPanel(Color.gray);
        JPanel buttonPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());

        interPanel.setLayout(new FlowLayout());

        interPanel.add(new JLabel(message));

        mainPanel.add(interPanel);

        JButton btn1 = new JButton("OK");
        buttonPanel.add(btn1);
        btn1.addActionListener(e -> dispose());

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setSize(500, 150);
        setResizable(false);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }



}
