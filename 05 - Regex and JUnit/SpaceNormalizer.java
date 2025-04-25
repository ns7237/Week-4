package regex;
import java.util.Scanner;

public class SpaceNormalizer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENter a sentence with multiple spaces: ");
		String input = sc.nextLine();
		String result = input.replaceAll("\\s{2,}", " ");
		System.out.println("Normalized outpur: ");
		System.out.println(result);
		sc.close();
	}

}
