package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import base.bancoDeDados;
import entity.Paciente;
import entity.Pacientes;

public class viewLista extends JFrame {

	private JPanel panel;
	private JTable pacientes;
	private JButton Inicio;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLista frame = new viewLista();
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
	public viewLista() {
	      JPanel panel = new JPanel();
	      setBounds(100, 100, 687, 450);
	      Object[][] rec = {{" "," "," "," "," "}};
		  try {
				rec = buscarPacientes();
		  } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		  }
	      String[] header ={ "C\u00F3digo", "Nome", "Data de Nascimento", "Endereco", "Observa\u00E7\u00F5es"};
	      panel.setLayout(null);
	      JTable table = new JTable(rec, header);
	      JScrollPane scrollPane = new JScrollPane(table);
	      scrollPane.setBounds(-1, 21, 643, 217);
	      panel.add(scrollPane);
	      setContentPane(panel);
	      
	      JButton btnNewButton = new JButton("Voltar ao in\u00EDcio");
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		new view4Botoes().setVisible(true);
				dispose();
	      	}
	      });
	      btnNewButton.setBounds(10, 377, 143, 23);
	      panel.add(btnNewButton);
	     
	
	}
	
	public Object[][] buscarPacientes() throws SQLException {
		Pacientes pacientes = new Pacientes();
		bancoDeDados bd = new bancoDeDados();
        Connection connection = bd.recuperaConexao();
        Statement std = connection.createStatement();
        String comando= "SELECT * from Pacientes";
        std.execute(comando);
   	    ResultSet resultados = std.getResultSet();
   	    while(resultados.next()) {
   	    	Paciente p = new Paciente();
	   	    p.setCodigo(resultados.getInt("codigo"));
		   	p.setNome(resultados.getString("nome"));
		   	p.setDataDeNascimento(resultados.getString("dataDeNascimento"));
		   	p.setObservacoes(resultados.getString("observacao"));
	       	p.setEndereco(resultados.getString("endereco"));
	       	pacientes.addPaciente(p);
   	 }
   	   Object rows[][] = new Object[pacientes.getPacientes().size()][5];
     for (int i = 0; i < pacientes.getPacientes().size(); i++){
         rows[i][0] = pacientes.getPacientes().get(i).getCodigo();
         rows[i][1] = pacientes.getPacientes().get(i).getNome();
         rows[i][2] = pacientes.getPacientes().get(i).getDataDeNascimento();
         rows[i][3] = pacientes.getPacientes().get(i).getEndereco();
         rows[i][4] = pacientes.getPacientes().get(i).getObservacoes();
     }
		return rows;
	}
}
