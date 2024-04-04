package view;

import javax.swing.*;
import java.awt.*;

public class EditorView {
	private JTextArea textarea;
	private JButton save;
	private JButton load;

	public EditorView() {
		JFrame frame = new JFrame("Text Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		JScrollPane sc = new JScrollPane(textarea);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(sc);
		save = new JButton("Save");
		load = new JButton("Load");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(save);
		buttonPanel.add(load);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public void setText(String text) {
		textarea.setText(text);
	}

	public JTextArea getTextArea() {
		return textarea;
	}

	public JButton getSaveButton() {
		return save;
	}

	public JButton getLoadButton() {
		return load;
	}
}
