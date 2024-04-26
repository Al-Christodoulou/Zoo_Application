package com;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteAnimalWindow extends JFrame {
	private JPanel panel;
	private JTextField textField;
	private JButton OKButton;
	private JButton exit;

	DeleteAnimalWindow(ArrayList<Animal> animalList) {
		setContentPane(panel);
		setPreferredSize(new Dimension(300,200));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setTitle("Διαγραφή ζώου");
		setVisible(true);
		setResizable(false);

		OKButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animalList.size() == 0)
					new TextWindow("Ο ζωολογικός κήπος είναι άδειος...");
				else {
					for (int i = 0; i < animalList.size(); i++) {
						if (animalList.get(i).getCode() == Integer.parseInt(textField.getText())) {
							new TextWindow("Το ακόλουθο ζώο διαγράφηκε με επιτυχία:", animalList.get(i));
							animalList.remove(i);
							return;
						}
					}
					new TextWindow("Δεν υπάρχει ζώο με αυτόν τον κωδικό.");
				}
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { dispose();	}
		});
	}
}
