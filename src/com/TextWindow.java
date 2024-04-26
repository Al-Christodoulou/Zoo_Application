package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// the TextWindow, unlike the other ones, is fully dynamically created,
// without using a form
public class TextWindow extends JFrame {
	private final JPanel panel = new JPanel(new GridBagLayout());
	// used for the correct placement of dynamic text
	private final GridBagConstraints gbc = new GridBagConstraints();
	private final int heightIncreaser = 20;
	// the actual window height is only setup near the end, after all
	// the text is placed in the correct locations
	private int extraHeight = 0;
	private int width = 1275;

	private void addAnimalInfo(Animal animal) {
		JFormattedTextField textField = new JFormattedTextField(animal);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setEditable(false);
		// add the animal info into the JPanel using GridBagConstraints
		panel.add(textField, gbc);
		// increase the y grid so the next text field will appear below
		// this one
		gbc.gridy++;
		extraHeight += heightIncreaser;
	}

	private void addAnimalArray(ArrayList<Animal> animalList) {
		for (int i = 0; i < animalList.size(); i++) {
			addAnimalInfo(animalList.get(i));
			extraHeight += heightIncreaser;
		}
	}

	private void addText(String str) {
		JFormattedTextField textField = new JFormattedTextField(str);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setEditable(false);
		panel.add(textField, gbc);
		gbc.gridy++;
		extraHeight += heightIncreaser;
	}

	private void setupGUI() {
		setContentPane(panel);
		setPreferredSize(new Dimension(width,125 + extraHeight));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setTitle("Text Window");
		setVisible(true);
	}

	private void addExitButton() {
		JButton exit = new JButton("Έξοδος");
		exit.setBackground(new Color(254, 185, 177));
		exit.setHorizontalAlignment(SwingConstants.CENTER);

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { dispose();	}
		});

		panel.add(exit, gbc);
	}

	private TextWindow() {
		// gridy gets increased by 1 for each new text field, so it appears
		// below the previous one
		gbc.gridy = 0;
		// weighty = 0.7 so that each new text field has a reasonable
		// distance from the previous one
		gbc.weighty = 0.7;
	}

	public TextWindow(String str) {
		this();
		addText(str);
		addExitButton();
		width = 450;
		setupGUI();
	}

	public TextWindow(String str1, Animal an) {
		this();
		addText(str1);
		addAnimalInfo(an);
		addExitButton();
		setupGUI();
	}

	public TextWindow(ArrayList<Animal> animalList) {
		this();
		addAnimalArray(animalList);
		addExitButton();
		setupGUI();
	}
}
