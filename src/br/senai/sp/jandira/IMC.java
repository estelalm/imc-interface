package br.senai.sp.jandira;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IMC extends JFrame implements ActionListener {

	JButton btnCalcular = new JButton("Calcular IMC");
	JButton btnSair = new JButton("Sair");

	JLabel lblTitulo = new JLabel("Cálculo do IMC");
	JLabel lblTituloSombra = new JLabel("Cálculo do IMC");
	JLabel lblPeso = new JLabel("Peso (kg)");
	JLabel lblAltura = new JLabel("Altura (metros)");

	TextField txtPeso = new TextField();
	TextField txtAltura = new TextField();

	public IMC() {
		
		setTitle("Calculadora de IMC");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		Container c = getContentPane();
		c.setBackground(Color.getHSBColor(5,54,100));

		lblTitulo.setBounds(190, 50, 300, 30);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		//lblTitulo.setForeground(Color.getHSBColor(6,100,100));
		lblTitulo.setForeground(Color.pink);
		lblTituloSombra.setBounds(192, 50, 300, 30);
		lblTituloSombra.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblTituloSombra.setForeground(Color.black);
		
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(180, 300, 100, 30);
		btnCalcular.setBackground(Color.pink);
		btnCalcular.setBorder(BorderFactory.createLineBorder(Color.black));
		btnCalcular.setForeground(Color.black);
		btnCalcular.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		btnSair.addActionListener(this);
		btnSair.setBounds(320, 300, 100, 30);
		btnSair.setBackground(Color.pink);
		btnSair.setBorder(BorderFactory.createLineBorder(Color.black));
		btnSair.setForeground(Color.black);
		btnSair.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		txtPeso.setBackground(Color.white);
		txtPeso.setBounds(250, 140, 100, 30);

		lblPeso.setBounds(170, 140, 200, 30);
		lblPeso.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		txtAltura.setBackground(Color.white);
		txtAltura.setBounds(250, 200, 100, 30);

		lblAltura.setBounds(120, 200, 400, 30);
		lblAltura.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

		add(lblTitulo);
		add(lblTituloSombra);
		add(btnCalcular);
		add(btnSair);
		add(txtPeso);
		add(lblPeso);
		add(txtAltura);
		add(lblAltura);
	}

	private double calcularIMC(double peso, double altura) {
		double imc = peso / Math.pow(altura, 2);
		return imc;
	}
	
	private String verSituacao(double imc){
		
		String situacao = "";
		
		if(imc < 18.5)
			situacao = "Abaixo do peso";
			else if (imc >= 25)
				situacao = "Sobrepeso";
			else if(imc >= 30)
				situacao = "Obesidade";
			else
				situacao = "Peso normal";
		
		return situacao;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnSair) {
			System.exit(0);
		}
		if(e.getSource() == btnCalcular) {
			
			if (!txtPeso.getText().equals("") && !txtAltura.getText().equals("")) {
				try {
					
					DecimalFormat duasCasas = new DecimalFormat("#.#");
					double peso = Double.parseDouble(txtPeso.getText().replace(',', '.'));
					double altura = Double.parseDouble(txtAltura.getText().replace(',', '.'));
					double imc = calcularIMC(peso, altura); 
					
					
					JOptionPane.showMessageDialog(null, "IMC: " + duasCasas.format(imc) + "\nSituação: " + verSituacao(imc));
				}catch(Exception err){
					JOptionPane.showInternalMessageDialog(null, "Valores inválidos.");
				}
		}
		}
	}


}
