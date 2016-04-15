package imageDevics;

import java.util.Scanner;

public class Camera implements ImageCapturingDevice{

	@Override
	public String getImage() {
		Scanner input = new Scanner(System.in);
		System.out.println("(input string)");
		String img = input.nextLine();
		return img;
	}

}
