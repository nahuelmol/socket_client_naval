package myinterface;

import javax.swing.*;
import java.awt.event.*;
import server.Server;
import java.util.ArrayList;
import globals.Element;

public class Interface extends JFrame implements ActionListener {

	public static Element elem;

	private ArrayList<JButton> mytable = new ArrayList<JButton>();

	private JLabel label1;
	private JButton button1;
	private int desp;

	public Interface(){
		setLayout(null);
		int i = 0;

		while (i<9) {
			desp = desp + 40;
            JButton button = new JButton("Exa" + i);
            button.setBounds(desp,100,40,40);
			add(button);
			button.addActionListener(this);

			mytable.add(button);
			i++;
        }

		label1 = new JLabel("First label");
		label1.setBounds(10,20,300,30);
		add(label1);

		button1 = new JButton("Cerrar");
		button1.setBounds(10,400,100,25);
		add(button1);
		button1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e){

		if (e.getSource() == button1){
			System.exit(0);
		}
		if (mytable.contains(e.getSource())){
			elem = new Element();
			Double arg = new Double(mytable.indexOf(e.getSource()));

			elem.add_coordinates(arg, 0.0);
		}
	}

	public static void main(){
		Interface window = new Interface();
		window.setBounds(0,0,600,550);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
	}
}