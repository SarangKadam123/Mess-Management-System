import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SeeFeedback extends JFrame {
    private Map<Integer, Integer> ratingCounts;
    private Map<Integer, String> ratingMessages;

    public SeeFeedback() {
        setTitle("Feedback Analysis");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ratingCounts = new HashMap<>();
        ratingMessages = new HashMap<>();

        // Retrieve feedback data from the database and calculate averages
        retrieveFeedbackData();

        // Create bar graph panel
        BarGraphPanel barGraphPanel = new BarGraphPanel(ratingCounts, ratingMessages);

        // Add bar graph panel to frame
        add(barGraphPanel);

        // Add back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ManagerPage().setVisible(true);
            }
        });
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void retrieveFeedbackData() {
        // Connect to the database and retrieve feedback data
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT rating, COUNT(*) AS count FROM feedback GROUP BY rating");

            int totalFeedbacks = 0;
            int maxRating = 0;

            while (resultSet.next()) {
                int rating = resultSet.getInt("rating");
                int count = resultSet.getInt("count");

                ratingCounts.put(rating, count);

                totalFeedbacks += count;
                maxRating = Math.max(maxRating, rating);
            }

            // Calculate averages
            for (Map.Entry<Integer, Integer> entry : ratingCounts.entrySet()) {
                int rating = entry.getKey();
                int count = entry.getValue();
                double average = (double) count / totalFeedbacks;
                ratingCounts.put(rating, (int) (average * 100)); // Scale for bar graph
            }

            // Load text messages corresponding to ratings
            loadRatingMessages(maxRating);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadRatingMessages(int maxRating) {
        // You can load text messages corresponding to each rating from a file or database
        // For demonstration purposes, I'm just assigning some generic messages here
        for (int i = 1; i <= maxRating; i++) {
            ratingMessages.put(i, "Message for rating " + i);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SeeFeedback::new);
    }
}

class BarGraphPanel extends JPanel {
    private Map<Integer, Integer> ratingCounts;
    private Map<Integer, String> ratingMessages;

    public BarGraphPanel(Map<Integer, Integer> ratingCounts, Map<Integer, String> ratingMessages) {
        this.ratingCounts = ratingCounts;
        this.ratingMessages = ratingMessages;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int barWidth = 50;
        int spacing = 20;
        int x = 50;
        int y = 50;

        for (Map.Entry<Integer, Integer> entry : ratingCounts.entrySet()) {
            int rating = entry.getKey();
            int count = entry.getValue();
            int barHeight = count;

            // Draw bar
            g.setColor(Color.BLUE);
            g.fillRect(x, y - barHeight, barWidth, barHeight);

            // Draw rating label
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(rating), x + barWidth / 2 - 5, y + 15);

            // Draw message
            g.drawString(ratingMessages.get(rating), x, y + 30);

            x += barWidth + spacing;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }
}
