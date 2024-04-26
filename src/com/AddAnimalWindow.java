package com;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AddAnimalWindow extends JFrame {
	private JPanel title;
	private JButton addBat;
	private JButton addGiraffe;
	private JButton addHorse;
	private JButton addMonkey;
	private JButton addRabbit;
	private JButton addMagpie;
	private JButton addHippopotamus;
	private JButton addCrocodile;
	private JButton addOstrich;
	private JButton addGorilla;
	private JButton addPanda;
	private JButton exit;

	private final ArrayList<String> animalInfoList = new ArrayList<>();

	// create an Animal of type "in_name" by using the information found in
	// AnimalInfo.txt
	private Animal createAnimal(String in_name) {
		for (int i = 0; i < animalInfoList.size(); i++) {
			StringTokenizer tr = new StringTokenizer(animalInfoList.get(i),",");
			String name = tr.nextToken();

			// if we found the correct line with the Animal we're looking for
			if (name.equals(in_name)) {
				String animalClass = tr.nextToken();
				float animalAvgWeight = Float.parseFloat(tr.nextToken());
				float animalMaxAge = Float.parseFloat(tr.nextToken());
				return new Animal(name, animalClass, animalAvgWeight, animalMaxAge);
			}
		}
		return null;
	}

	private void fillAnimalInfoList() {
		FileReader fr = null;
		try {
			fr = new FileReader("AnimalInfo.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println("AnimalInfo.txt not found!!!");
			return;
		}
		BufferedReader br = new BufferedReader(fr);

		try {
			String line = br.readLine();
			while (line != null) {
				animalInfoList.add(line);
				line = br.readLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AddAnimalWindow(ArrayList<Animal> animalList) {
		setContentPane(title);
		setPreferredSize(new Dimension(400,500));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setTitle("Επιλογή ζώου");
		setVisible(true);
		setResizable(false);

		fillAnimalInfoList();

		addBat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Bat"));
				new SuccessWindow();
			}
		});

		addGiraffe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Giraffe"));
				new SuccessWindow();
			}
		});

		addHorse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Horse"));
				new SuccessWindow();
			}
		});

		addMonkey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Monkey"));
				new SuccessWindow();
			}
		});

		addRabbit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Rabbit"));
				new SuccessWindow();
			}
		});

		addMagpie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Magpie"));
				new SuccessWindow();
			}
		});

		addHippopotamus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Hippopotamus"));
				new SuccessWindow();
			}
		});

		addCrocodile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Crocodile"));
				new SuccessWindow();
			}
		});

		addOstrich.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Ostrich"));
				new SuccessWindow();
			}
		});

		addGorilla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Gorilla"));
				new SuccessWindow();
			}
		});

		addPanda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animalList.add(createAnimal("Panda"));
				new SuccessWindow();
			}
		});

		// exit button
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { dispose(); }
		});
	}
}
