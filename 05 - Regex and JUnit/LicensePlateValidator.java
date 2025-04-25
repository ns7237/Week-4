package regex;

import java.util.Scanner;

public class LicensePlateValidator {
	public static boolean isValidPlate(String plate) {
		if(plate.length() != 6) {
			return false;
		}
		if(!Character.isUpperCase(plate.charAt(0)) || !Character.isUpperCase(plate.charAt(1))) {
			return false;
		}
		for(int i = 2; i < 6; i++) {
			if (!Character.isDigit(plate.charAt(i))) {
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter license plate number: ");
		String plate = sc.nextLine();
		if(isValidPlate(plate)) {
			System.out.println(plate + " is a valid license plate");
		} else {
			System.out.println(plate + "is an invalid license plate");
		}
		sc.close();
	}

}
