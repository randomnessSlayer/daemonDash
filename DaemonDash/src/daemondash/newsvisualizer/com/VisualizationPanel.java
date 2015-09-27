package daemondash.newsvisualizer.com;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class VisualizationPanel extends JPanel {
	
	private JTextField entry;
	private JScrollPane displayPane;
	
	public VisualizationPanel() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel titleLabel = new JLabel("News Visualizer");
		titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 75));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(15, 0, 15, 0);
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		this.add(titleLabel, c);
		
		JPanel entryPanel = new JPanel();
		entryPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		
		entry = new JTextField("Search terms go here.");
		entry.setMaximumSize(new Dimension(200, 30));
		entry.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		entry.setAlignmentX(CENTER_ALIGNMENT);
		entryPanel.add(entry);
		
		JButton entryButton = new JButton("Visualize!");
		entryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XMLParser xmlParser = new XMLParser(StaticVariables.LIST_OF_ALL_SITES, entry.getText());
					if (xmlParser.foundStuff()) {
						WebReader reader = new WebReader(xmlParser.retrieveLinks());
						ArticleParser parser = new ArticleParser(entry.getText(), reader.getOutputs());
						
						int highest = parser.getMostPopTuples().get(0).getValue();
						
						JPanel wordsPanel = new JPanel();
						wordsPanel.setLayout(new BoxLayout(wordsPanel, BoxLayout.Y_AXIS));
						
						for (Tuple<String> tuple : parser.getMostPopTuples()) {
							JLabel label = new JLabel(tuple.getKey());
							label.setFont(new Font(Font.SERIF, Font.BOLD, (int) (75 * ((double) tuple.getValue() / highest))));
							wordsPanel.add(label);
						}
						
						displayPane.setViewportView(wordsPanel);
					}
				} catch (InterruptedException | IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		entryButton.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
		entryButton.setAlignmentX(CENTER_ALIGNMENT);
		entryPanel.add(entryButton);
		
		entryPanel.setOpaque(false);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 1;
		this.add(entryPanel, c);
		
		displayPane = new JScrollPane();
		displayPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		displayPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		c.insets = new Insets(30, 30, 30, 30);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridy = 2;
		this.add(displayPane, c);
		
		JLabel creditsLabel = new JLabel("Made by Weijia Cheng, Maxl Dale, Tommy Hegarty, and Karist Kerdsuwan");
		creditsLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		creditsLabel.setAlignmentX(CENTER_ALIGNMENT);
		c.insets = new Insets(0, 0, 0, 0);
		c.fill = GridBagConstraints.VERTICAL;
		c.weightx = 0;
		c.weighty = 0.1;
		c.gridy = 3;
		this.add(creditsLabel, c);
	}
	
}
