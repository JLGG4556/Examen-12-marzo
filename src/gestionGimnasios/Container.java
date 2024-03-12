package gestionGimnasios;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import gestionGimnasios.controladores.ControladorAsistente;
import gestionGimnasios.controladores.ControladorGimnasio;
import gestionGimnasios.controladores.ControladorLocalidad;
import gestionGimnasios.entidades.Asistente;
import gestionGimnasios.entidades.Gimnasio;
import gestionGimnasios.entidades.Localidad;
import mismetodos.UtilsFecha;
import mismetodos.UtilsMenu;
import mismetodos.UtilsString;
import mismetodos.UtilsValidacion;

import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Container extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfFiltro;
	private JTextField jtfid;
	private JTextField jtfdni;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JTextField jtfFecha;
	private JTextField jtfCuota;
	private JComboBox<Gimnasio> jcGimnasio;
	private JComboBox<Asistente> jcAsistente;
	private JComboBox<Localidad> jcLocalidad;
	private JCheckBox jcheckboxActivo;

	/**
	 * Create the panel.
	 */
	public Container() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion de asistentes del gimnasio");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 11;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Gimnasio:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 1;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcGimnasio = new JComboBox<Gimnasio>();
		GridBagConstraints gbc_jcGimnasio = new GridBagConstraints();
		gbc_jcGimnasio.gridwidth = 14;
		gbc_jcGimnasio.insets = new Insets(0, 0, 5, 5);
		gbc_jcGimnasio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcGimnasio.gridx = 6;
		gbc_jcGimnasio.gridy = 1;
		add(jcGimnasio, gbc_jcGimnasio);
		
		JLabel lblNewLabel_4 = new JLabel("Filtro apellidos asistente:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 5;
		gbc_lblNewLabel_4.gridy = 2;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfFiltro = new JTextField();
		GridBagConstraints gbc_jtfFiltro = new GridBagConstraints();
		gbc_jtfFiltro.gridwidth = 10;
		gbc_jtfFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltro.gridx = 6;
		gbc_jtfFiltro.gridy = 2;
		add(jtfFiltro, gbc_jtfFiltro);
		jtfFiltro.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAsisitentes();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.gridwidth = 4;
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnFiltrar.gridx = 16;
		gbc_btnFiltrar.gridy = 2;
		add(btnFiltrar, gbc_btnFiltrar);
		
		JLabel lblNewLabel_5 = new JLabel("Asistentes filtrados:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 3;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcAsistente = new JComboBox<Asistente>();
		jcAsistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEnPantalla();
			}
		});
		GridBagConstraints gbc_jcAsistente = new GridBagConstraints();
		gbc_jcAsistente.insets = new Insets(0, 0, 5, 5);
		gbc_jcAsistente.gridwidth = 14;
		gbc_jcAsistente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcAsistente.gridx = 6;
		gbc_jcAsistente.gridy = 3;
		add(jcAsistente, gbc_jcAsistente);
		
		JLabel lblNewLabel_1 = new JLabel("Datos del asistente");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridwidth = 25;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel jlabelid = new JLabel("id:");
		GridBagConstraints gbc_jlabelid = new GridBagConstraints();
		gbc_jlabelid.anchor = GridBagConstraints.EAST;
		gbc_jlabelid.insets = new Insets(0, 0, 5, 5);
		gbc_jlabelid.gridx = 5;
		gbc_jlabelid.gridy = 6;
		add(jlabelid, gbc_jlabelid);
		
		jtfid = new JTextField();
		GridBagConstraints gbc_jtfid = new GridBagConstraints();
		gbc_jtfid.insets = new Insets(0, 0, 5, 5);
		gbc_jtfid.gridwidth = 14;
		gbc_jtfid.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfid.gridx = 6;
		gbc_jtfid.gridy = 6;
		add(jtfid, gbc_jtfid);
		jtfid.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("DNI/NIE/Pasaporte:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfdni = new JTextField();
		GridBagConstraints gbc_jtfdni = new GridBagConstraints();
		gbc_jtfdni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfdni.gridwidth = 14;
		gbc_jtfdni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdni.gridx = 6;
		gbc_jtfdni.gridy = 7;
		add(jtfdni, gbc_jtfdni);
		jtfdni.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 5;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jcLocalidad = new JComboBox<Localidad>();
		GridBagConstraints gbc_jcLocalidad = new GridBagConstraints();
		gbc_jcLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_jcLocalidad.gridwidth = 14;
		gbc_jcLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcLocalidad.gridx = 6;
		gbc_jcLocalidad.gridy = 8;
		add(jcLocalidad, gbc_jcLocalidad);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 5;
		gbc_lblNewLabel_8.gridy = 9;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.gridwidth = 14;
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 6;
		gbc_jtfNombre.gridy = 9;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 5;
		gbc_lblNewLabel_9.gridy = 10;
		add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellidos.gridwidth = 14;
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 6;
		gbc_jtfApellidos.gridy = 10;
		add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);
		
		jcheckboxActivo = new JCheckBox("");
		GridBagConstraints gbc_jcheckboxActivo = new GridBagConstraints();
		gbc_jcheckboxActivo.anchor = GridBagConstraints.EAST;
		gbc_jcheckboxActivo.insets = new Insets(0, 0, 5, 5);
		gbc_jcheckboxActivo.gridx = 5;
		gbc_jcheckboxActivo.gridy = 11;
		add(jcheckboxActivo, gbc_jcheckboxActivo);
		
		JLabel lblNewLabel_2 = new JLabel("Activo");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 11;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_10 = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 5;
		gbc_lblNewLabel_10.gridy = 12;
		add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.gridwidth = 14;
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 6;
		gbc_jtfFecha.gridy = 12;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Cuota mensua (Eur):");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 5;
		gbc_lblNewLabel_11.gridy = 13;
		add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		jtfCuota = new JTextField();
		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCuota.gridwidth = 14;
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 6;
		gbc_jtfCuota.gridy = 13;
		add(jtfCuota, gbc_jtfCuota);
		jtfCuota.setColumns(10);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 11;
		gbc_btnSave.gridy = 18;
		add(btnSave, gbc_btnSave);
		
		cargarTodosLosGimnasios();
		cargarTodasLasLocalidades();
		jcLocalidad.setSelectedIndex(0);

	}
	
	private void mostrarEnPantalla() {
		
		Asistente a = (Asistente) jcAsistente.getSelectedItem();
		
		jtfid.setText("" + a.getId());
		jtfdni.setText(a.getDniNiePasaporte());
		
		for (int i = 0; i < jcLocalidad.getItemCount(); i++) {
			Localidad localidad = (Localidad) jcLocalidad.getItemAt(i);
			
			if (localidad.getId() == a.getIdLocalidad()) {
				jcLocalidad.setSelectedIndex(i);
			}
		}
			
		jtfNombre.setText(a.getNombre());
		jtfApellidos.setText(a.getApellidos());
		jcheckboxActivo.setSelected(a.isActivo());
		
		if (a.getFechaNac() != null) {
			
			jtfFecha.setText(UtilsFecha.sqlDateAString(a.getFechaNac(), "dd/MM/yyyy"));
		}
		
		else {
			jtfFecha.setText(null);
		}
		
		jtfCuota.setText("" + a.getCuota());
	}
	
	private void cargarTodasLasLocalidades () {
		
		List<Localidad> l = ControladorLocalidad.getall();
		
		jcLocalidad.removeAllItems();
		
		for (Localidad localidad : l) {
			jcLocalidad.addItem(localidad);
		}
		
	}
	
	/**
	 * 
	 */
	private void cargarTodosLosGimnasios() {
		
		List<Gimnasio> l = ControladorGimnasio.getall();
		
		jcGimnasio.removeAllItems();
		
		for (Gimnasio gimnasio : l) {
			jcGimnasio.addItem(gimnasio);
		}
		
		jcGimnasio.setSelectedIndex(0);
		
	}
	
	private void cargarAsisitentes () {
		
		if (jtfFiltro.getText() != null) {
		List<Asistente> l = ControladorAsistente.getall(jtfFiltro.getText());
		
		jcAsistente.removeAllItems();
		
		for (Asistente asistente : l) {
			jcAsistente.addItem(asistente);
		}
		
		jcAsistente.setSelectedIndex(0);
		}
	}
	
	private void guardar() {
		boolean todocorrecto = true;
		
		Asistente a = new Asistente();
		
		if (!UtilsValidacion.isValidCode(jtfdni.getText(), "/d{8}")) {
			System.out.println("no valido");
		}
		
		if (jtfCuota.getText() == null || jtfCuota.getText().trim().equals("")) {
			todocorrecto = false;
		}
		
		try {
			
			if (jtfCuota.getText() != null) {
				a.setCuota(Float.parseFloat(jtfCuota.getText()));
			}

			else {
				UtilsMenu.mensajemenu("No se a introducido uno cuota");
				todocorrecto = false;
			}
			
		} catch (Exception e) {
			UtilsMenu.mensajemenu("Cuota no valida");
			todocorrecto = false;
		}
		
		if (todocorrecto) {
			UtilsMenu.mensajemenu("Guardado realizado");
		}
		
		
		
	}

}
