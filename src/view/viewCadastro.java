package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.bancoDeDados;
import entity.Paciente;
import entity.Pacientes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.persistence.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class viewCadastro extends JFrame {

	private JPanel contentPane;
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
					viewCadastro frame = new viewCadastro();
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
	public viewCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(10, 121, 150, 14);
		contentPane.add(lblNewLabel_2);
		
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
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new view4Botoes().setVisible(true);
				dispose();;
			}
		});
		btnNewButton.setBounds(491, 326, 104, 23);
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
		
		JButton btnNewButton_1 = new JButton("Voltar ao in\u00EDcio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view4Botoes().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 326, 136, 23);
		contentPane.add(btnNewButton_1);
	}
	
	
	public void cadastrar() throws SQLException {
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
            String comando= "INSERT INTO Pacientes (nome, endereco,observacao,dataDeNascimento) VALUES ('" + paciente.getNome()+
            				"',' "+ paciente.getEndereco()+"',' "+ paciente.getObservacoes()+"',' "+ paciente.getDataDeNascimento()+"')";
            std.execute(comando);
            connection.close();
		
	}
	
}
