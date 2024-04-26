package com;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class SearchAnimalWindow extends JFrame {
	private JPanel panel;
	private JTextField textField;
	private JButton OKButton;
	private JButton exit;

	public SearchAnimalWindow(ArrayList<Animal> animalList, boolean byName) {
		setContentPane(panel);
		setPreferredSize(new Dimension(300,200));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setTitle("Αναζήτηση ζώου");
		setVisible(true);
		setResizable(false);

		// change the JPanel title when we're searching for an animal's code instead
		// of a name
		if (!byName) {
			TitledBorder tb = new TitledBorder("Δώστε κωδικό ζώου για αναζήτηση:");
			tb.setTitlePosition(TitledBorder.TOP);
			tb.setTitleJustification(TitledBorder.CENTER);
			panel.setBorder(tb);
		}

		OKButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animalList.size() == 0) {
					new TextWindow("Ο ζωολογικός κήπος είναι άδειος...");
				}
				else {
					ArrayList<Animal> searchedAnimalList = new ArrayList<>();
					for (int i = 0; i < animalList.size(); i++) {
						// if we're searching by name, compare the strings. if not, compare
						// the code integer
						if (byName) {
							if (animalList.get(i).getName().equals(textField.getText()))
								searchedAnimalList.add(animalList.get(i));
						}
						else {
							if (animalList.get(i).getCode() == Integer.parseInt(textField.getText()))
								searchedAnimalList.add(animalList.get(i));
						}
					}

					// if we found anything
					if (searchedAnimalList.size() > 0)
						new TextWindow(searchedAnimalList);
					else
						if (byName)
							new TextWindow("Δεν βρέθηκε ζώο με αυτό το όνομα.");
						else
							new TextWindow("Δεν βρέθηκε ζώο με αυτόν τον κωδικό.");
				}
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { dispose();	}
		});
	}
}
