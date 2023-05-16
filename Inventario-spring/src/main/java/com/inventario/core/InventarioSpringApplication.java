package com.inventario.core;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.inventario.core.entities.Producto;
import com.inventario.core.repositories.ProductoRepository;
import com.inventario.core.service.producto.ProductoServiceImp;
import com.inventario.core.vista.ProductosGUI;

@SpringBootApplication
public class InventarioSpringApplication  extends JFrame{

    private ProductoServiceImp productoServiceImp;

    private JLabel lblId, lblNombre, lblPrecio;
    private JTextField txtId, txtNombre, txtPrecio;
    private JButton btnGuardar, btnActualizar, btnEliminar, btnBuscar;

    public InventarioSpringApplication(ProductoServiceImp productoServiceImp) {
        this.productoServiceImp = productoServiceImp;
        
        setTitle("Productos");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // creación de los componentes
        lblId = new JLabel("ID:");
        lblNombre = new JLabel("Nombre:");
        lblPrecio = new JLabel("Precio:");

        txtId = new JTextField(5);
        txtNombre = new JTextField(20);
        txtPrecio = new JTextField(10);

        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");

        // agregando los componentes al panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));
        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);

        // agregando el panel a la ventana
        getContentPane().add(panel);

        // eventos de botones
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });


        // mostrar la ventana
        setVisible(true);
    }

    private void guardarProducto() {
        Producto producto = new Producto();
        producto.setNombreProd(txtNombre.getText());
        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));        
        productoServiceImp.saveProducto(producto);
    }

    private void actualizarProducto() {
        Producto producto = new Producto();
        producto.setId(Long.parseLong(txtId.getText()));
        producto.setNombreProd(txtNombre.getText());
        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));;
        productoServiceImp.update(producto);
    }

    private void eliminarProducto() {
        long id = Long.parseLong(txtId.getText());
        productoServiceImp.deleteProductById(id);
    }
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InventarioSpringApplication.class,args);
		LocalDate localDate = LocalDate.now();
		
		ProductoRepository repository = context.getBean(ProductoRepository.class);
		Producto sudadera = new Producto(null, "Sudadera", 350, new Date(26/04/2023), new Date(0), null, null, null, null);
		
		Producto NuevoProducto = new Producto(null, "Sudadera", 350, new Date(26/04/2023), new Date(0), null, null, null, null);
		
		repository.save(sudadera);
		System.out.println("El numero de productos en la base de datos es: "+repository.count());
		System.out.println(repository.findAll());
		
		ProductoServiceImp productoServiceImp = new ProductoServiceImp();
        ProductosGUI productosGUI = new ProductosGUI(productoServiceImp);
	}

}
