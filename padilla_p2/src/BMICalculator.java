import java.util.Scanner;

public class BMICalculator {
	
	//initialze private Scanner for security within this class
	private static Scanner sc = new Scanner(System.in);
	
	//declare obvious variables in proper data types
	private double weight;
	private double height;
	private double bmi;
	private String bmiCategory;
	
	//temporary measurement variables initialized from getter methods to compare for BMI Categorization
	public double tempWeight;
	public double tempHeight;
	
	//boolean to break out of "which measurement system?" loop
	private boolean unitGiven = false;
	
	//temporary variable to compare user input of measurement type to Metric/Imperial
	private String tempNextLine;
	
	//Control boolean to determine if calculations are done in metric (true) or imperial (false) from user input
	private boolean isMetric;
	
	
	//One Method to collect all user data,
	//containing other methods to determine measurement system,
	//then record values for selected measurement system
	public void readUserData() {
		readUnitType();
		readMeasurementData();
	}
	
	//Ask user for measurement system using loop and a control boolean for the rest of the calculations
	//Continue asking user for measurement type if not given correctly
	private void readUnitType() {
		while (unitGiven == false) {
			
		System.out.println("What measurement system would you like to use? Metric or Imperial? *CASE SENSITIVE*");
		//temporary String used to be able to use the .equals methods
		tempNextLine = sc.nextLine();
		
		if(tempNextLine.equals("Metric")) {
			unitGiven = true;
			isMetric = true;
		}
		
		if(tempNextLine.equals("Imperial")) {
			unitGiven = true;
			isMetric = false;
		}
		
		}
	}
	
	//Collect measurements depending on selected measurement system using control boolean,
	//referred to proper method
	private void readMeasurementData() {
		if(isMetric == true) {
			readMetricData();
		}
		if (isMetric == false) {
			readImperialData();
		}
	}
	
	//collect metric data if chosen, set within the setter methods referenced in this method
	private void readMetricData() {
		System.out.println("What is your weight in kilograms?");
		setWeight(sc.nextDouble());
		System.out.println("What is your height in meters?");
		setHeight(sc.nextDouble());
	}
	
	//collect imperial data if chosen, set within the setter methods referenced in this method
	private void readImperialData() {
		System.out.println("What is your weight in pounds?");
		setWeight(sc.nextDouble());
		System.out.println("What is your height in inches?");
		setHeight(sc.nextDouble());
	}
	
	//initialize temporary measurement variables using getter methods referenced in this method to calculate BMI
	//reference calculateBmiCategory method to determine BMI category
	public void calculateBmi() {
		tempWeight = getWeight();
		tempHeight = getHeight();
		if (isMetric == true) {
			bmi = tempWeight / (tempHeight * tempHeight);
		}
		if (isMetric == false) {
			bmi = (tempWeight * 703) / (tempHeight * tempHeight);
		}
		calculateBmiCategory();
	}
	
	//calculate bmi category and store the value in the String variables for bmiCategory
	private void calculateBmiCategory() {
		if(bmi < 18.5) {
			bmiCategory = "Underweight";
		}
		else if(bmi < 25.0) {
			bmiCategory = "Normal Weight";
		}
		else if(bmi < 30) {
			bmiCategory = "Overweight";
		}
		else if(bmi >= 30){
			bmiCategory = "Obese";
		}
		else {
			bmiCategory = "Non-Existent";
		}
	}
	
	//Print to the user the BMI and the BMI category
	public void displayBmi() {
		System.out.println("Your BMI is: " + bmi);
		System.out.println("Your BMI category is: " + bmiCategory);
	}
	
	//Simple public getter method to use in other methods
	public double getWeight() {
		return weight;
	}
	
	//Setter method initializing the private variable weight to w
	//EXIT IF NEGATIVE NUMBER ENTERED
	private void setWeight(double w) {
		if(w < 0) {
			System.exit(0);
		}
		weight = w;
	}
	
	//Simple public getter method to use in other methods
	public double getHeight() {
		return height;
	}
	
	//Setter method initializing the private variable height to h
	//EXIT IF NEGATIVE NUMBER ENTERED
	private void setHeight(double h) {
		if(h < 0) {
			System.exit(0);
		}
		height = h;
	}
	
	//Simple public getter method to use in other methods
	public double getBmi() {
		return bmi;
	}
	
	//Simple public getter method to use in other methods
	public String getBmiCategory() {
		return bmiCategory;
	}
	
}
