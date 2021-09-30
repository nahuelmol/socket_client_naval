package myinterface;

import javax.swing.*;
import java.awt.event.*;
import server.Server;
import java.util.ArrayList;
import globals.Element;

public class Interface extends JFrame implements ActionListener {

	public static Element elem;

	private JLabel label1;
	private JButton button1;
	private int desp;
	private int size = 10;
	private ArrayList<ArrayList<JButton>> mytable = new ArrayList(size);

	public Interface(){
		setLayout(null);
		
		int i = 0;
		int j = 0;
		int desp_x = 25;
		int desp_y = 100;

		for(i=0; i < size; i++) {
    		mytable.add(new ArrayList());
		}

		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
            	JButton button = new JButton("Exa" + i);
            	button.setBounds(desp_x,desp_y,40,40);
				add(button);
				button.addActionListener(this);

				desp_x = desp_x + 40;
				mytable.get(i).add(button);
			}
			desp_x = 25;
			desp_y = desp_y + 40;
        }

		label1 = new JLabel("First label");
		label1.setBounds(10,20,300,30);
		add(label1);

		button1 = new JButton("Cerrar");
		button1.setBounds(150,20,100,25);
		add(button1);
		button1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e){

		if (e.getSource() == button1){
			System.exit(0);
		}

		for(int k = 0;mytable.size() > k;k++){
			if(mytable.get(k).contains(e.getSource())){
				int x = mytable.get(k).indexOf(e.getSource());
				int y = mytable.indexOf(mytable.get(k));
				System.out.println("["+x+","+y+"]");
				
				elem = new Element();
				elem.add_coordinates(x,y);
				elem.show_coordinates();
			}
		}
	}

	public static void main(){
		Interface window = new Interface();
		window.setBounds(0,0,900,550);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
	}
}