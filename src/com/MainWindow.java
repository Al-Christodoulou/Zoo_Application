package com;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {
	private JPanel welcometext;
	private JButton previewAnimals;
	private JButton addAnimal;
	private JButton searchAnimalByName;
	private JButton searchAnimalByCode;
	private JButton modifyAnimal;
	private JButton deleteAnimal;
	private JButton exit;

	private ArrayList<Animal> animalList = new ArrayList<>();

	public void saveToFile() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("AnimalList.ser");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Animal list save failed.");
			return;
		}

		try {
			// only save the animal list if it exists
			if (animalList != null)
				oos.writeObject(animalList);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Animal list save failed.");
			return;
		}
		System.out.println("Animal list save successful!");
	}

	private void restoreFromFile() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("AnimalList.ser");
		}
		catch (FileNotFoundException e) {
			System.out.println("AnimalList not found, ignoring restore.");
			return;
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Animal list restore failed.");
			return;
		}

		try {
			animalList = (ArrayList<Animal>) ois.readObject();
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Animal list restore failed.");
			return;
		}
		System.out.println("Animal list restore successful!");

		// update the static max code integer based on the last animal's code in the animal
		// array list
		if (animalList.size() > 0)
			Animal.updateMaxCode(animalList.get(animalList.size() - 1).getCode() + 1);
	}

	public MainWindow() {
		setContentPane(welcometext);
		setPreferredSize(new Dimension(400,350));

		// the animal array list doesn't get properly saved if you close the program via
		// "X", so it's disallowed. all the other windows are set to DISPOSE_ON_CLOSE
		// instead of EXIT_ON_CLOSE so that the main window never shuts down unexpectedly
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setTitle("Ζωολογικός Κήπος");
		setVisible(true);
		setResizable(false);

		// restore the animal array list from a file
		restoreFromFile();

		previewAnimals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animalList.size() > 0)
					new TextWindow(animalList);
				else
					new TextWindow("Ο ζωολογικός κήπος είναι άδειος...");
			}
		});

		addAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new AddAnimalWindow(animalList); }
		});

		searchAnimalByName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new SearchAnimalWindow(animalList, true); }
		});

		searchAnimalByCode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new SearchAnimalWindow(animalList, false); }
		});

		modifyAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new ModifyAnimalWindow(animalList); }
		});

		deleteAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { new DeleteAnimalWindow(animalList); }
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveToFile();
				System.exit(0);
			}
		});
	}
}
