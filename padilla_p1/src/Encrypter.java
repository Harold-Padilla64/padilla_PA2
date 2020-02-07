
public class Encrypter {

	//Rubric says scan an integer so the required parameter must be int
	//Return type String in the case of a leading zero (ex: 0189 becomes 189)
	public static String encrypt(int val) {
		
		String result;
		
		//declare and initialize digits by converting substrings of the input to integers
		//declare and initialize String for substring manipulation using Integer class and toString method
		//Error prevention - Leading zeros in integers disappear (ex: 0189 turns into 189)
		String strVal = Integer.toString(val);
		switch(strVal.length()) {
		case 3:
			strVal = "0" + strVal;
			break;
		case 2:
			strVal = "00" + strVal;
			break;
		case 1:
			strVal = "000" + strVal;
			break;
		case 0:
			strVal = "0000";
			break;
	}
		
		//separate individual digits in the string using substring method, 
		//initializing them to int variables to encrypt later
		int firstDigit = Integer.parseInt(strVal.substring(0,1));
		int secondDigit = Integer.parseInt(strVal.substring(1,2));
		int thirdDigit = Integer.parseInt(strVal.substring(2,3));
		int fourthDigit = Integer.parseInt(strVal.substring(3,4));
		
		
		//encrypt - add 7, remainder 10
		firstDigit = (firstDigit + 7) % 10;
		secondDigit = (secondDigit + 7) % 10;
		thirdDigit = (thirdDigit + 7) % 10;
		fourthDigit = (fourthDigit + 7) % 10;
		
		//build 4 digit result with altered order
		result = Integer.toString(thirdDigit) + Integer.toString(fourthDigit) + Integer.toString(firstDigit) + Integer.toString(secondDigit);
		
		//return String with a length of 4
		return result;
		
	}
}

