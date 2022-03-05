package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import base.bancoDeDados;
import entity.Paciente;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class viewEditar extends JFrame {

	private JPanel contentPane;
	private JTextField cd;
	private JTextField nome;
	private JTextField data;
	private JTextField rua;
	private JTextField obs;
	private JTextField num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewEditar frame = new viewEditar();
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
	public viewEditar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(10, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(10, 121, 158, 14);
		contentPane.add(lblNewLabel_2);
		
		cd = new JTextField();
		cd.setBounds(10, 40, 86, 20);
		contentPane.add(cd);
		cd.setColumns(10);
		
		nome = new JTextField();
		nome.setBounds(10, 96, 231, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		data = new JTextField();
		data.setBounds(10, 146, 231, 20);
		contentPane.add(data);
		data.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Observa\u00E7\u00F5es");
		lblNewLabel_3.setBounds(10, 171, 104, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					editar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new view4Botoes().setVisible(true);
				dispose();;
			}
		});
		btnNewButton.setBounds(506, 326, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Rua");
		lblNewLabel_5.setBounds(270, 71, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("N\u00FAmero");
		lblNewLabel_7.setBounds(270, 121, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		rua = new JTextField();
		rua.setBounds(270, 96, 203, 20);
		contentPane.add(rua);
		rua.setColumns(10);
		
		obs = new JTextField();
		obs.setBounds(10, 196, 231, 90);
		contentPane.add(obs);
		obs.setColumns(10);
		
		num = new JTextField();
		num.setBounds(270, 146, 200, 20);
		contentPane.add(num);
		num.setColumns(10);
		
		JButton Inicio = new JButton("Voltar ao inicio");
		Inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view4Botoes().setVisible(true);
				dispose();
			}
		});
		Inicio.setBounds(7, 326, 118, 23);
		contentPane.add(Inicio);
		
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buscar.setBounds(392, 326, 89, 23);
		contentPane.add(buscar);
	}
	
	
	public void buscar() throws SQLException {
		 String id = cd.getText();
		 System.out.print(id);
		 bancoDeDados bd = new bancoDeDados();
         Connection connection = bd.recuperaConexao();
         Statement std = connection.createStatement();
         String comando= "SELECT * from Pacientes WHERE codigo = "+id;
         
         
         try {
        	 std.execute(comando);
        	 ResultSet paciente = std.getResultSet();
        	 if(paciente.next()) {
	        	 nome.setText(paciente.getString("nome"));
	        	 data.setText(paciente.getString("dataDeNascimento"));
	        	 obs.setText(paciente.getString("observacao"));
	        	 String[] endereco = paciente.getString("endereco").split(",", 2);
	        	 rua.setText(endereco[0]);
	        	 num.setText(endereco[1]);
	        	 cd.setEditable(false);
        	 }
             
             else {
            	 JOptionPane.showMessageDialog(null,"Id invalido!\n"); 
             }
             
			} catch (SQLException e1) {
				
		        JOptionPane.showMessageDialog(null,"Id invalido!\n");
			}
        
  
         connection.close();
	}
	
	
	public void editar() throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setNome(nome.getText());
        String endereco = rua.getText().concat(",");
        endereco=endereco.concat(num.getText());
        paciente.setEndereco(endereco);
        paciente.setDataDeNascimento(data.getText());
        paciente.setObservacoes(obs.getText());
        bancoDeDados bd = new bancoDeDados();
        Connection connection = bd.recuperaConexao();
        Statement std = connection.createStatement();
        String comando= "UPDATE Pacientes SET nome = '"+ paciente.getNome()+"', endereco= '"
        				+paciente.getEndereco()+"',observacao= '"+paciente.getObservacoes()+
        				"',dataDeNascimento= '"+paciente.getDataDeNascimento()+"' where codigo = "
        				+ cd.getText();
        std.execute(comando);
        connection.close();
	
}
}