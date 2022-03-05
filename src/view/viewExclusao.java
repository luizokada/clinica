package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.bancoDeDados;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Color;

public class viewExclusao extends JFrame {

	private JPanel contentPane;
	private JTextField cd;
	private JTextField nome;
	private JTextField data;
	private JTextField endereco;
	private JTextField obs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewExclusao frame = new viewExclusao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewExclusao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cd = new JTextField();
		cd.setBounds(10, 75, 527, 20);
		contentPane.add(cd);
		cd.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(214, 106, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluir();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(204, 300, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(214, 50, 89, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Voltar ao in\u00EDcio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view4Botoes().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 321, 136, 23);
		contentPane.add(btnNewButton_2);
		
		nome = new JTextField();
		nome.setBounds(10, 159, 136, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		data = new JTextField();
		data.setBounds(10, 215, 136, 20);
		contentPane.add(data);
		data.setColumns(10);
		
		endereco = new JTextField();
		endereco.setBounds(204, 159, 333, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		obs = new JTextField();
		obs.setBounds(204, 215, 333, 78);
		contentPane.add(obs);
		obs.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 133, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento");
		lblNewLabel_2.setBounds(10, 190, 136, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setBounds(204, 129, 46, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observa\u00E7\u00F5es");
		lblNewLabel_4.setBounds(204, 190, 89, 14);
		contentPane.add(lblNewLabel_4);
	}
	
	public void buscar() throws SQLException {
		String id = cd.getText();
		bancoDeDados bd = new bancoDeDados();
        Connection connection = bd.recuperaConexao();
        Statement std = connection.createStatement();
        String comando= "SELECT * from Pacientes WHERE codigo = "+id;
        
        
        try {
       	 std.execute(comando);
       	 ResultSet paciente = std.getResultSet();
       	 if(paciente.next()) {
	        	 nome.setText(paciente.getString("nome"));
	        	 nome.setEditable(false);
	        	 data.setText(paciente.getString("dataDeNascimento"));
	        	 data.setEditable(false);
	        	 obs.setText(paciente.getString("observacao"));
	        	 obs.setEditable(false);
	        	 endereco.setText(paciente.getString("endereco")); 
	        	 endereco.setEditable(false);
       	 }
            
            else {
           	 JOptionPane.showMessageDialog(null,"Id invalido!\n"); 
            }
            
			} catch (SQLException e1) {
				
		        JOptionPane.showMessageDialog(null,"Id invalido!\n");
			}
       
 
        connection.close();
	}
	
	public void excluir() throws SQLException {
		String id = cd.getText();
		String comando = "DELETE from pacientes WHERE codigo = "+ id;
		bancoDeDados bd = new bancoDeDados();
        Connection connection = bd.recuperaConexao();
        Statement std = connection.createStatement();
        std.execute(comando);
        connection.close();
        new view4Botoes().setVisible(true);
		dispose();
		
	}
	
}
