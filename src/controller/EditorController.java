package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.List;
import model.Document;
import view.EditorView;
import java.util.ArrayList;
import java.util.Arrays;

public class EditorController {
	public Document document;
	public EditorView view;

	public EditorController(Document document, EditorView view) {
		this.document = document;
		this.view = view;
		initView();
	}

	private void initView() {
		view.setText(document.getAllText());
		view.getTextArea().setCaretPosition(0);
		view.getTextArea().requestFocusInWindow();
		view.getSaveButton().addActionListener(e -> saveDocument());
		view.getLoadButton().addActionListener(e -> loadDocument());
	}

	private void saveDocument() {
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showSaveDialog(view.getTextArea());
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write(document.getAllText());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void loadDocument() {
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showOpenDialog(view.getTextArea());
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				StringBuilder text = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					text.append(line).append("\n");
				}
				document.getLines().clear();

				document.addLines(new ArrayList<>(Arrays.asList(text.toString().split("\n"))));
				view.setText(text.toString());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Document d = new Document();
		EditorView v = new EditorView();
		EditorController c = new EditorController(d, v);
		c.loadDocument();
	}
}
