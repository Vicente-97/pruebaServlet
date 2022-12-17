package com.jacaranda.primerSpring.model;

import java.util.Objects;

public class Calculator {

	private double numero1;
	private double numero2;
	private Integer simbolo;
	
	
	
	public Calculator() {
		// TODO Auto-generated constructor stub
	}



	public Calculator(double num1, double num2) {
		super();
		this.numero1 = num1;
		this.numero2 = num2;
	}


	public double Operaciones() {
		double resultado=0.0;
		if(this.simbolo==1) {
			resultado=this.numero1+this.numero2;
		}else if(this.simbolo==2) {
			resultado=this.numero1-this.numero2;
		}else if(this.simbolo==3) {
			resultado=this.numero1*this.numero2;
		}else if(this.simbolo==4) {
			resultado=this.numero1/this.numero2;
		}
		return resultado;
	}
	

	public double getNumero1() {
		return numero1;
	}



	public void setNumero1(double numero1) {
		this.numero1 = numero1;
	}



	public double getNumero2() {
		return numero2;
	}



	public void setNumero2(double numero2) {
		this.numero2 = numero2;
	}



	public Integer getSimbolo() {
		return simbolo;
	}



	public void setSimbolo(Integer simbolo) {
		this.simbolo = simbolo;
	}



	@Override
	public int hashCode() {
		return Objects.hash(numero1, numero2, simbolo);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Double.doubleToLongBits(numero1) == Double.doubleToLongBits(other.numero1)
				&& Double.doubleToLongBits(numero2) == Double.doubleToLongBits(other.numero2)
				&& Objects.equals(simbolo, other.simbolo);
	}



	



	
}
