package main;

import java.util.Scanner;

import model.List;

public class Main {

	
	public static int turnCurrent=1;
	public static int numTurn=1;
	private Scanner sc=new Scanner(System.in);
	private List listturns=new List();
	public static void main(String[]args) {
		Main obj = new Main();
		int option=0;
		
		do {
			option=obj.init();
			obj.answerOption(option);
		}while(option!=5);
	}
	public int init() {
		System.out.println("----BANCOLOMBIA----");
		System.out.println("1.Give turn");
		System.out.println("2.Show turn");
		System.out.println("3.Pass turn");
		System.out.println("4.Delete turn");
		System.out.println("5.EXIT");
        int option=sc.nextInt();
		
        return option;
	}
	public void answerOption(int option) {
		switch(option) {
		case 1:
			giveTurn();
			break;
		case 2:
			showTurn();
			break;
		case 3:
			passTurn();
			break;
		case 4:
			deleteTurn();
			break;
		}
	}
	public void giveTurn() {
		if(numTurn>50) {
			System.out.println("Turn limit reached");
		}else {
			System.out.println("Turn given : "+numTurn+"\n");
		listturns.addLast(numTurn);
		numTurn++;
	
		
		}
		
	}
	public void showTurn() {
	
		if(listturns.size==0) {
			System.out.println("No current Turn\n");
			turnCurrent=numTurn;
		}else {
		System.out.println("The current turn is "+turnCurrent+"\n");
		}
		
	}
	public void passTurn() {
		if(listturns.size>0) {
			listturns.addCalled(turnCurrent);
		turnCurrent=listturns.turncurrent(turnCurrent);
		
	    listturns.verifyCalled();
	    if(listturns.size>0) {
	    System.out.println("Turn passed\n");
	    }
		}
	    else {
	    	System.out.println("Without turns for pass\n");
	    }
	}
	public void deleteTurn() {
	    if(listturns.size>0) {
		listturns.delete(turnCurrent);
		System.out.println("Turn removed\n");
	    turnCurrent=listturns.turncurrent(turnCurrent);
	    }else {
	    	System.out.println("Without turns for removed\n");
	    }
	}
}
