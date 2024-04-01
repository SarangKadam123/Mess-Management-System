import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedbackPage extends JFrame {
    private JLabel titleLabel, ratingLabel;
    private StarRatingPanel starRatingPanel;
    private JLabel feedbackLabel;
    private JTextArea feedbackTextArea;
    private JButton submitButton;

    public FeedbackPage() {
        setTitle("Feedback Page");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title Label
        titleLabel = new JLabel("Meal Feedback");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Rating Components
        ratingLabel = new JLabel("Rating:");
        ratingLabel.setFont(new Font("Arial", Font.BOLD,15));
        starRatingPanel = new StarRatingPanel(5);

        // Feedback Components
        feedbackLabel = new JLabel("Additional Feedback:");
        feedbackLabel.setFont(new Font("Arial", Font.BOLD,13));
        feedbackTextArea = new JTextArea();
        feedbackTextArea.setLineWrap(true);
        feedbackTextArea.setWrapStyleWord(true);
        JScrollPane feedbackScrollPane = new JScrollPane(feedbackTextArea);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rating = starRatingPanel.getSelectedRating();
                String feedback = feedbackTextArea.getText();
                // Handle submission of feedback here (e.g., save to database)
                JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
                clearFields();
                setVisible(false);
                new ClientHome();
            }
        });

        // Main Panel Layout and Components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Change FlowLayout.CENTER to the desired alignment
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel);
        mainPanel.add(Box.createVerticalStrut(20)); // Add spacing
        JPanel ratingPanel = new JPanel();
        ratingPanel.add(ratingLabel);
        ratingPanel.add(starRatingPanel);
        mainPanel.add(ratingPanel);
        mainPanel.add(Box.createVerticalStrut(20)); // Add spacing
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new BorderLayout());
        feedbackPanel.add(feedbackLabel, BorderLayout.NORTH);
        feedbackPanel.add(feedbackScrollPane, BorderLayout.CENTER);
        mainPanel.add(feedbackPanel);
        mainPanel.add(Box.createVerticalStrut(20)); // Add spacing
        // mainPanel.add(submitButton);
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Change FlowLayout.CENTER to the desired alignment
        submitPanel.add(submitButton);
        mainPanel.add(submitPanel);

        mainPanel.add(Box.createVerticalStrut(20)); // Add spacing

        add(mainPanel);
        setVisible(true);
    }

    private void clearFields() {
        starRatingPanel.setSelectedRating(0);
        feedbackTextArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FeedbackPage();
            }
        });
    }
}

// Star Rating Panel Class
class StarRatingPanel extends JPanel {
    private int maxStars;
    private int selectedRating;

    public StarRatingPanel(int maxStars) {
        this.maxStars = maxStars;
        this.selectedRating = 0;
        setLayout(new FlowLayout());

        // Create star labels and add mouse listener
        for (int i = 1; i <= maxStars; i++) {
            JLabel starLabel = new JLabel("\u2605"); // Unicode for star character
            starLabel.setForeground(Color.GRAY);
            starLabel.setFont(new Font(starLabel.getFont().getName(), Font.PLAIN, 30)); // Increase star size
            starLabel.addMouseListener(new StarMouseListener(i));
            add(starLabel);
        }
    }

    public void setSelectedRating(int rating) {
        if (rating >= 0 && rating <= maxStars) {
            selectedRating = rating;
            updateStarColors();
        }
    }

    public int getSelectedRating() {
        return selectedRating;
    }

    private void updateStarColors() {
        Component[] components = getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JLabel) {
                JLabel starLabel = (JLabel) components[i];
                int starNumber = i + 1;
                if (starNumber <= selectedRating) {
                    starLabel.setForeground(Color.YELLOW);
                } else {
                    starLabel.setForeground(Color.GRAY);
                }
            }
        }
    }

    private class StarMouseListener extends MouseAdapter {
        private int starNumber;

        public StarMouseListener(int starNumber) {
            this.starNumber = starNumber;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            setSelectedRating(starNumber);
        }
    }
}