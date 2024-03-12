package gestionGimnasios;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mismetodos.UtilsMenu;
import java.awt.BorderLayout;

public class Principal2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Container contenedor = new Container();

	/**
	 * Create the frame.
	 */
	public Principal2() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UtilsMenu.cierraVentana("Estas seguro que quieres salir", "MenuBBDD", null);
			}
		});
		
		
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		getContentPane().add(contenedor, BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 frame = new Principal2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
