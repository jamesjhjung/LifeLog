package ui;

import model.LifeLog;
import model.LogEntry;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

// Represents the main GUI window for LifeLog
public class MainFrame extends JFrame {

    private static final String JSON_STORE = "./data/lifelog.json";

    private LifeLog lifeLog;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private DefaultListModel<LogEntry> listModel;
    private JList<LogEntry> entryList;

    // EFFECTS: constructs and displays GUI
    public MainFrame() {
        super("LifeLog");

        lifeLog = new LifeLog();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initializeUI();

        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("methodlength")
    // MODIFIES: this
    // EFFECTS: initializes UI components
    private void initializeUI() {
        setLayout(new BorderLayout());

        // ===== CENTER: DISPLAY PANEL =====
        listModel = new DefaultListModel<>();
        entryList = new JList<>(listModel);
        add(new JScrollPane(entryList), BorderLayout.CENTER);

        // ===== TOP: VISUAL COMPONENT =====
        ImageIcon icon = new ImageIcon("data/LifeLogBanner.png");
        Image scaled = icon.getImage().getScaledInstance(700, 315, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));

        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        // ===== BOTTOM: BUTTON PANEL =====
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Entry");
        JButton filterCategoryButton = new JButton("Filter by Category");
        JButton filterDateButton = new JButton("Filter by Date");
        JButton viewAllButton = new JButton("View All");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        buttonPanel.add(addButton);
        buttonPanel.add(filterCategoryButton);
        buttonPanel.add(filterDateButton);
        buttonPanel.add(viewAllButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ===== ACTIONS =====
        addButton.addActionListener(this::handleAddEntry);
        filterCategoryButton.addActionListener(this::handleFilterCategory);
        filterDateButton.addActionListener(this::handleFilterDate);
        viewAllButton.addActionListener(e -> refreshList());
        saveButton.addActionListener(e -> saveData());
        loadButton.addActionListener(e -> loadData());
    }

    @SuppressWarnings("methodlength")
    // MODIFIES: lifeLog, listModel
    // EFFECTS: creates LogEntry from user input
    private void handleAddEntry(ActionEvent e) {
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField hoursField = new JTextField();
        JTextField dateField = new JTextField(); // format: YYYY-MM-DD

        Object[] fields = {
                "Title:", titleField,
                "Category:", categoryField,
                "Description:", descriptionField,
                "Hours:", hoursField,
                "Date (YYYY-MM-DD):", dateField
        };

        int option = JOptionPane.showConfirmDialog(
                this, fields, "Add New Entry", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText().trim();
                String category = categoryField.getText().trim();
                String description = descriptionField.getText().trim();
                double hours = Double.parseDouble(hoursField.getText().trim());
                LocalDate date = LocalDate.parse(dateField.getText().trim());

                if (title.isEmpty() || category.isEmpty()) {
                    throw new IllegalArgumentException();
                }

                LogEntry entry = new LogEntry(title, category, description, hours, date);

                lifeLog.addEntry(entry);
                listModel.addElement(entry);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
            }
        }
    }

    // MODIFIES: listModel
    // EFFECTS: filters entries by category
    private void handleFilterCategory(ActionEvent e) {
        String category = JOptionPane.showInputDialog(this, "Enter category:");

        if (category == null || category.trim().isEmpty()) {
            return;
        }

        listModel.clear();
        for (LogEntry entry : lifeLog.getEntriesByCategory(category)) {
            listModel.addElement(entry);
        }
    }

    // MODIFIES: listModel
    // EFFECTS: filters entries by date
    private void handleFilterDate(ActionEvent e) {
        String input = JOptionPane.showInputDialog(this, "Enter date (YYYY-MM-DD):");

        if (input == null || input.trim().isEmpty()) {
            return;
        }

        try {
            LocalDate date = LocalDate.parse(input.trim());

            listModel.clear();
            for (LogEntry entry : lifeLog.getEntriesByDate(date)) {
                listModel.addElement(entry);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format.");
        }
    }

    // MODIFIES: listModel
    // EFFECTS: refreshes list to show all entries
    private void refreshList() {
        listModel.clear();
        for (LogEntry entry : lifeLog.getEntries()) {
            listModel.addElement(entry);
        }
    }

    // EFFECTS: saves LifeLog to file
    private void saveData() {
        try {
            jsonWriter.open();
            jsonWriter.write(lifeLog);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Saved successfully!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Save failed.");
        }
    }

    // MODIFIES: lifeLog, listModel
    // EFFECTS: loads LifeLog from file
    private void loadData() {
        try {
            lifeLog = jsonReader.read();
            refreshList();
            JOptionPane.showMessageDialog(this, "Loaded successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Load failed.");
        }
    }
}