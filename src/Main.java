import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame myFrame = new JFrame();

        myFrame.setTitle("un titre");
        myFrame.setSize(300, 300);
        myFrame.setResizable(false); // fenetre non redimensionnable
        myFrame.setLocationRelativeTo(null); // fenetre independant qui ne dépend d'aucune autre
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Kill le processus à la fermeture

//        JButton bouton = new JButton("mon bouton");
//        bouton.setVisible(true);

//        myFrame.add(bouton);

//        myFrame.setVisible(true); // Afficher la fenêtre

//        new MyFrame("User", 150, 500, false, true);

//        new MyFrame("titre3", 500, 500, false, true );

//        new ExoFrame("", 300, 500);

        new CalculatorFrame("Calculator");

    }
}