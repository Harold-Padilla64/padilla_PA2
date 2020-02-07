
public class Decrypter {

	//Nearly same function as Encrypter.encrypt, 
	//just some extra error prevention and reversing encryption operators
	public static String decrypt(int val) {
		
		String result;
		
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
		
		int firstDigit = Integer.parseInt(strVal.substring(0,1));
		int secondDigit = Integer.parseInt(strVal.substring(1,2));
		int thirdDigit = Integer.parseInt(strVal.substring(2,3));
		int fourthDigit = Integer.parseInt(strVal.substring(3,4));
		
		
		//decrypt - add 10 to avoid negative number error
		//subtract 7 instead of add 7 to decrypt
		firstDigit = ((firstDigit - 7) + 10) % 10;
		secondDigit = ((secondDigit - 7) + 10) % 10;
		thirdDigit = ((thirdDigit - 7) + 10) % 10;
		fourthDigit = ((fourthDigit - 7) + 10) % 10;
		
		//build 4 digit result with altered order
		//since encrypting was just switching digits and not rotating, the same code works
		result = Integer.toString(thirdDigit) + Integer.toString(fourthDigit) + Integer.toString(firstDigit) + Integer.toString(secondDigit);
		
		return result;
	}
}
