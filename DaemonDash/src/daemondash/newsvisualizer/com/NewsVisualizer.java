package daemondash.newsvisualizer.com;

import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class NewsVisualizer {
	
	public final VisualizationPanel visualization = new VisualizationPanel();
	
	private JFrame frame;
	private JPanel panel;
	private CardLayout layout;
	
	public void setGUI() throws IOException {
		visualization.setName("Visualization");
		
		layout = new CardLayout();
		layout.addLayoutComponent(visualization, "Visualization");
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setLayout(layout);
		panel.add(visualization);
		panel.setVisible(true);
		
		frame = new JFrame("News Visualizer");
		frame.setIconImage(ImageIO.read(new File("pics/Icon512.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	
	public static void main(String[] args) throws IOException {
		NewsVisualizer visualizer = new NewsVisualizer();
		visualizer.setGUI();
	}
}
