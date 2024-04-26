package com;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class ModifyAnimalWindow extends JFrame {
	private JPanel panel;

	private JTextField animalCodeField;
	private JButton OKButton;

	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel classLabel;
	private JTextField classField;
	private JLabel avgWeightLabel;
	private JTextField avgWeightField;
	private JLabel maxAgeLabel;
	private JTextField maxAgeField;

	private JButton exit;

	private JButton nameApplyButton;
	private JButton classApplyButton;
	private JButton avgWeightApplyButton;
	private JButton maxAgeApplyButton;

	// the Animal we've searched for and is currently "selected"
	private Animal selectedAnimal = null;

	private void enableFieldsButtons(boolean option) {
		nameField.setEditable(option);
		classField.setEditable(option);
		avgWeightField.setEditable(option);
		maxAgeField.setEditable(option);

		nameApplyButton.setEnabled(option);
		classApplyButton.setEnabled(option);
		avgWeightApplyButton.setEnabled(option);
		maxAgeApplyButton.setEnabled(option);
	}

	// update all the text fields based on the Animal we have "selected" at
	// the current moment
	private void updateFields() {
		nameField.setText(selectedAnimal.getName());
		classField.setText(selectedAnimal.getAnimalClass());
		avgWeightField.setText(String.valueOf(selectedAnimal.getAvgWeight()));
		maxAgeField.setText(String.valueOf(selectedAnimal.getMaxAge()));
	}

	private void flushFields() {
		nameField.setText("");
		classField.setText("");
		avgWeightField.setText("");
		maxAgeField.setText("");
	}

	ModifyAnimalWindow(ArrayList<Animal> animalList) {
		setContentPane(panel);
		setPreferredSize(new Dimension(500,300));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setTitle("Αλλαγή ζώου");
		setVisible(true);
		setResizable(false);
		// the fields & buttons remain uneditable until we give a valid
		// animal code
		enableFieldsButtons(false);

		OKButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// reset the selected animal
				selectedAnimal = null;
				for (int i = 0; i < animalList.size(); i++) {
					if (animalList.get(i).getCode() == Integer.parseInt(animalCodeField.getText())) {
						selectedAnimal = animalList.get(i);
						enableFieldsButtons(true);
						updateFields();
					}
				}
				// if we didn't find anything
				if (selectedAnimal == null) {
					enableFieldsButtons(false);
					flushFields();
					new TextWindow("Δεν υπάρχει ζώο με αυτόν τον κωδικό.");
				}
			}
		});

		// update the fields for when we've successfully found the Animal
		// with the specific code
		nameApplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnimal.setName(nameField.getText());
			}
		});
		classApplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnimal.setClass(classField.getText());
			}
		});
		avgWeightApplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnimal.setAvgWeight(Float.parseFloat(avgWeightField.getText()));
			}
		});
		maxAgeApplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedAnimal.setMaxAge(Float.parseFloat(maxAgeField.getText()));
			}
		});


		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { dispose();	}
		});
	}
}
