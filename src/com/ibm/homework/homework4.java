package com.ibm.homework;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class homework4 {

	public static void main(String[] args) {
		Prediction(1000,2,0.5,2,0.5);
	}
	public static void Prediction(double start,int Increnumber,double increPer,int deductNumber,double deductPer){
		if(start<1){
			System.out.println("not accept a number less than 1 for the starting salary");
			return;
		}
		if(increPer < 0 || deductPer < 0){
			System.out.println("not accept a negative number for increment or deduction");
			return;
		}
		if(Increnumber < 1 || deductNumber < 1){
			System.out.println("not accept a number less than 1 for frequency of increment or deductions");
			return;
		}
		double startOri = start;
		List amountList = new ArrayList<>();
		List amountList1 = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("Increment Report");
		System.out.println(" Year "+" Starting Salary "+" Number of increments "+" increment% "+" increment amount " );
		for(int i=0;i<3;i++){
			double per = Math.pow((1 + increPer), Increnumber);
			double amount = per * start;
			double amount1 = amount - start;
			amountList.add(amount1);
			System.out.println("  "+(i+1)+"   "+"     "+start+"            "+Increnumber+"                 "+increPer+"       "+amount1+"    ");
			start = amount;
		}
		System.out.println();
		start = startOri;
		System.out.println("Deduction Report");
		System.out.println(" Year "+" Starting Salary "+" Number of increments "+" increment% "+" deduction amount " );
		for(int i=0;i<3;i++){
			double per = Math.pow((1 - deductPer), deductNumber);
			start = new BigDecimal(start).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			double amount = per * start;
			double amount1 = new BigDecimal(start - amount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			amountList1.add(amount1);
			System.out.println("  "+(i+1)+"   "+"     "+start+"            "+Increnumber+"                 "+increPer+"       "+amount1+"    ");
			start = amount;
		}
		System.out.println();
		start = startOri;
		System.out.println("Prediction");
		System.out.println(" Year "+" Starting Salary "+" increment amount "+" deduction amount "+" salary growth " );
		for(int i=0;i<3;i++){
			double increAmt = (double)amountList.get(i); 
			double deductAmt = (double)amountList1.get(i); 
			double amount = start + increAmt - deductAmt;
			double growth = new BigDecimal(amount - start).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println("  "+(i+1)+"   "+"     "+start+"            "+increAmt+"              "+deductAmt+"       "+growth+"    ");
			start = amount;
		}
	}
}
