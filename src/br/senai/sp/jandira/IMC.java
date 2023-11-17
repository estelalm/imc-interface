package br.senai.sp.jandira;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IMC extends JFrame implements ActionListener {

	JButton btnCalcular = new JButton("Calcular IMC");
	JButton btnSair = new JButton("Sair");

	JLabel lblTitulo = new JLabel("Cálculo do IMC");
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

		lblTitulo.setBounds(220, 50, 300, 20);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 24));
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(180, 300, 100, 30);
		btnCalcular.setBackground(Color.pink);
		btnCalcular.setBorder(BorderFactory.createLineBorder(Color.black));
		btnCalcular.setForeground(Color.black);

		btnSair.addActionListener(this);
		btnSair.setBounds(320, 300, 100, 30);
		btnSair.setBackground(Color.pink);
		btnSair.setBorder(BorderFactory.createLineBorder(Color.black));
		btnSair.setForeground(Color.black);

		txtPeso.setBackground(Color.white);
		txtPeso.setBounds(250, 140, 100, 30);

		lblPeso.setBounds(170, 140, 200, 30);

		txtAltura.setBackground(Color.white);
		txtAltura.setBounds(250, 200, 100, 30);

		lblAltura.setBounds(150, 200, 400, 30);

		add(lblTitulo);
		add(btnCalcular);
		add(btnSair);
		add(txtPeso);
		add(lblPeso);
		add(txtAltura);
		add(lblAltura);
	}

	double calcularIMC(double peso, double altura) {
		double imc = peso / Math.pow(altura, 2);
		return imc;
	}
	String verSituacao(double imc){
		
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
					double peso = Double.parseDouble(txtPeso.getText());
					double altura = Double.parseDouble(txtAltura.getText().replace(',', '.'));
					double imc = Math.round(calcularIMC(peso, altura)); 
					
					JOptionPane.showMessageDialog(null, "IMC: " + imc + "\nSituação: " + verSituacao(imc));
				}catch(Exception err){
				}
		}
		}
	}

	public static void main(String[] args) {
		new IMC();
	}
}
