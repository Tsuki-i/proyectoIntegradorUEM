package pi.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pi.control.GestorControl;
import pi.model.Empleado;

public class PModificarEmple extends JPanel {

	
	public static final String BTN_MOD_PROV = "Modificar proveedor";
	public static final String BTN_BUSC_PROV = "Buscar proveedor";
	public static final String BTN_CANCEL_PROV = "Cancelar modificaci�n";
	
	private JTextField txtNombreEmple;
	private JTextField txtIdEmple;
	private JTextField txtApellidoEmple;
	JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	
	public PModificarEmple() {
		
		inicializarComponentes();
		
	}
	
	private void inicializarComponentes() {
		setSize(VInicio.ANCHO, VInicio.ALTO);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Modificar Proveedor");
		lblTitulo.setBounds(0, 0, 800, 25);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitulo);
		
		JLabel lblNombreEmple = new JLabel("Nombre:");
		lblNombreEmple.setBounds(106, 186, 83, 14);
		add(lblNombreEmple);
		
		txtNombreEmple = new JTextField();
		txtNombreEmple.setBounds(213, 183, 129, 20);
		add(txtNombreEmple);
		txtNombreEmple.setColumns(10);
		
		JLabel lblDatos = new JLabel("Rellenar datos del proveedor");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setBounds(230, 121, 339, 14);
		add(lblDatos);
		
		JLabel lblIdEmple = new JLabel("ID:");
		lblIdEmple.setBounds(106, 269, 46, 14);
		add(lblIdEmple);
		
		txtIdEmple = new JTextField();
		txtIdEmple.setEnabled(false);
		txtIdEmple.setBounds(213, 266, 86, 20);
		add(txtIdEmple);
		txtIdEmple.setColumns(10);
		
		JLabel lblApellidoEmple = new JLabel("Apellido:");
		lblApellidoEmple.setBounds(106, 229, 83, 14);
		add(lblApellidoEmple);
		
		txtApellidoEmple = new JTextField();
		txtApellidoEmple.setEnabled(false);
		txtApellidoEmple.setBounds(213, 226, 114, 20);
		add(txtApellidoEmple);
		txtApellidoEmple.setColumns(10);
		
		btnModificar = new JButton(BTN_MOD_PROV);
		btnModificar.setEnabled(false);
		btnModificar.setBounds(39, 498, 178, 23);
		add(btnModificar);
		
		btnBuscar = new JButton(BTN_BUSC_PROV);
		btnBuscar.setBounds(307, 498, 178, 23);
		add(btnBuscar);
		
		btnCancelar = new JButton(BTN_CANCEL_PROV);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(569, 498, 178, 23);
		add(btnCancelar);
		
	}
	
	

	public void setControlador(GestorControl controlador) {
		btnModificar.addActionListener(controlador);	
		btnBuscar.addActionListener(controlador);
		btnCancelar.addActionListener(controlador);
	}



	public void mostrarError(String error) {
		
		JOptionPane.showMessageDialog(this, error, "Error de datos", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void limpiarComponentes() {
		txtNombreEmple.setText("");
		txtIdEmple.setText("");
		txtApellidoEmple.setText("");
	}
	
	public Empleado comprobarDatosModEmple() {
		Empleado modProv = null;
		
		String nombre = txtNombreEmple.getText();
		if (nombre.isBlank()) {
			mostrarError("El nombre no puede estar vac�o");
		} else {
			String id = txtIdEmple.getText();
			if (id.isBlank()) {
				mostrarError("El CIF no puede estar vac�o");
			} else {
				String apellido = txtApellidoEmple.getText();
				if (apellido.isBlank()) {
					mostrarError("El tel�fono no puede estar vac�o");
				} else {
					modProv = new Empleado(id, nombre, apellido);
				}
			}
		}
		
		return modProv;
	}



	public void hacerVisibleMod(boolean bandera) {
		btnBuscar.setVisible(!bandera);
		btnModificar.setVisible(bandera);
		btnCancelar.setVisible(bandera);
		txtIdEmple.setEnabled(bandera);
		txtApellidoEmple.setEnabled(bandera);
		txtNombreEmple.setEnabled(!bandera);
	}
	
	public String obtenerNombre() {
		String nombreProv = txtNombreEmple.getText();
		return nombreProv;
	}
	
	public void rellenarDatos(Empleado proveedor) {
		txtNombreEmple.setText(proveedor.getNombreProv());
		txtIdEmple.setText(proveedor.getCifProv());
		txtApellidoEmple.setText(proveedor.getTelefProv());
		
	}
}









