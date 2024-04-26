package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessWindow extends JFrame {
	private JPanel panel;
	private JButton ΟΚButton;

	public SuccessWindow() {
		setContentPane(panel);
		setPreferredSize(new Dimension(300,100));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setTitle("Επιτυχία");
		setVisible(true);

		ΟΚButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close this window
				dispose();
			}
		});
	}
}
