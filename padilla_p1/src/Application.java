import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		String result;
		
		//Initialize Scanner object
		Scanner scan = new Scanner(System.in);
		
		
		//ask user for the input
		System.out.println("What's the number you would like to encrypt?");
		//encrypt using Encrypter.encrypt
		result = Encrypter.encrypt(scan.nextInt());
		System.out.println(result);
		
		//same thing with decrypt, changing the names around.
		System.out.println("What's the number you would like to decrypt?");
		result = Decrypter.decrypt(scan.nextInt());
		System.out.print(result);
		
		//close scanner
		scan.close();
	}

}