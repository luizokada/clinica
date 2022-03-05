package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Pacientes;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view4Botoes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					view4Botoes frame = new view4Botoes();
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
	public view4Botoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewCadastro().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 87, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewEditar().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(119, 87, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Listar ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewLista().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(218, 87, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewExclusao().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(317, 87, 89, 23);
		contentPane.add(btnNewButton_3);
		
		
		JLabel lblNewLabel = new JLabel("Tela Inicial");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 26, 188, 50);
		contentPane.add(lblNewLabel);
	}
}
