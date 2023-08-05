package com.promineotech;

public class TestDemo {
  
	public int addPositive(int a, int b) {
       
		 if (a <= 0 || b <= 0) {
	            throw new IllegalArgumentException("Both parameters must be positive!");
	        }

	        return a + b;
	    }

   

	public int multiplyPositive(int a, int b) {
		// TODO Auto-generated method stub
		 if (a <= 0 || b <= 0) {
	            throw new IllegalArgumentException("Both parameters must be positive!");
	        }

	        return a * b;
		
	
	}
	public  int getRandomInt() {
	        return (int) (Math.random() * 10) +1;
	    }

	    public int randomNumberSquared() {
	        int randomInt = getRandomInt();
	        return randomInt * randomInt;
	    }
	}
