package minorthird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelCompanionApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Travel Companion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        // Create the buttons
        JButton postAdButton = new JButton("Post an Ad");
        JButton joinTripButton = new JButton("Join a Trip");

        // Add action listeners to the buttons
        postAdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the post ad form
                openPostAdForm();
            }
        });

        joinTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the join trip form
                openJoinTripForm();
            }
        });

        // Add buttons to the frame
        frame.add(postAdButton);
        frame.add(joinTripButton);

        // Display the frame
        frame.setVisible(true);
    }

    private static void openPostAdForm() {
        // Create a new JFrame for the post ad form
        JFrame postAdFrame = new JFrame("Post an Ad");
        postAdFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        postAdFrame.setSize(400, 300);
        postAdFrame.setLayout(new GridLayout(7, 2));

        // Create form fields
        JTextField destinationField = new JTextField();
        JTextField durationField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField budgetField = new JTextField();
        JTextField travelerCountField = new JTextField();
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male only", "Female only", "I'm comfortable with both"});
        JTextField idProofField = new JTextField();
        JTextField emailField = new JTextField();

        // Create labels
        JLabel destinationLabel = new JLabel("Destination:");
        JLabel durationLabel = new JLabel("Duration:");
        JLabel dateLabel = new JLabel("Date:");
        JLabel budgetLabel = new JLabel("Budget (per head):");
        JLabel travelerCountLabel = new JLabel("Number of Travelers:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel idProofLabel = new JLabel("ID Proofs:");
        JLabel emailLabel = new JLabel("Email:");

        // Add labels and fields to the form
        postAdFrame.add(destinationLabel);
        postAdFrame.add(destinationField);
        postAdFrame.add(durationLabel);
        postAdFrame.add(durationField);
        postAdFrame.add(dateLabel);
        postAdFrame.add(dateField);
        postAdFrame.add(budgetLabel);
        postAdFrame.add(budgetField);
        postAdFrame.add(travelerCountLabel);
        postAdFrame.add(travelerCountField);
        postAdFrame.add(genderLabel);
        postAdFrame.add(genderComboBox);
        postAdFrame.add(idProofLabel);
        postAdFrame.add(idProofField);
        postAdFrame.add(emailLabel);
        postAdFrame.add(emailField);

        // Create a button to submit the form
        JButton submitButton = new JButton("Post Ad");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve form field values
                String destination = destinationField.getText();
                String duration = durationField.getText();
                String date = dateField.getText();
                String budget = budgetField.getText();
                String travelerCount = travelerCountField.getText();
                String gender = genderComboBox.getSelectedItem().toString();
                String idProof = idProofField.getText();
                String email = emailField.getText();

                // Process and save the ad details

                // Close the post ad form
                postAdFrame.dispose();
            }
        });

        // Add the submit button to the form
        postAdFrame.add(submitButton);

        // Display the post ad form
        postAdFrame.setVisible(true);
    }

    private static void openJoinTripForm() {
        // Create a new JFrame for the join trip form
        JFrame joinTripFrame = new JFrame("Join a Trip");
        joinTripFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        joinTripFrame.setSize(400, 200);
        joinTripFrame.setLayout(new GridLayout(3, 2));

        // Create form fields
        JTextField destinationField = new JTextField();
        JButton showAdsButton = new JButton("Show Ads");

        // Create labels
        JLabel destinationLabel = new JLabel("Destination:");

        // Add labels and fields to the form
        joinTripFrame.add(destinationLabel);
        joinTripFrame.add(destinationField);
        joinTripFrame.add(showAdsButton);

        // Add action listener to the show ads button
        showAdsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve destination value
                String destination = destinationField.getText();

                // Retrieve ads for the specified destination

                // Open the ads form
                openAdsForm();

                // Close the join trip form
                joinTripFrame.dispose();
            }
        });

        // Display the join trip form
        joinTripFrame.setVisible(true);
    }

    private static void openAdsForm() {
        // Create a new JFrame for the ads form
        JFrame adsFrame = new JFrame("Ads");
        adsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adsFrame.setSize(400, 300);
        adsFrame.setLayout(new GridLayout(3, 1));

        // Create a JList to display the ads

        // Create a DefaultListModel to hold the ad items

        // Add the ad items to the DefaultListModel

        // Create a JScrollPane to scroll through the ads

        // Add the JScrollPane to the ads frame

        // Display the ads frame
        adsFrame.setVisible(true);
    }
}
