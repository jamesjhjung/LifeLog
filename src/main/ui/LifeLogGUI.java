package ui;

import javax.swing.SwingUtilities;

// EFFECTS: launches the LifeLog GUI application
public class LifeLogGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}