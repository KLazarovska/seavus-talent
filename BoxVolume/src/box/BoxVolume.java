package box;

public class BoxVolume {

	/**
	 * @param args
	 */
	
	public static int calculateVolume(Box box){
		return box.getWidth() * box.getDepth() * box.getHeight();
	}
	
	public static void main(String[] args) {
		
		Box box1 = new Box(1, 2, 3);
		Box box2 = new Box(2, 2, 2);
		
		System.out.println("First box volume = " + calculateVolume(box1));
		System.out.println("Second box volume = " + calculateVolume(box2));
		
		if(calculateVolume(box1) > calculateVolume(box2)){
			System.out.println("First box is with a bigger volume!");
			System.out.println(box1.toString());
		}
		else{
			System.out.println("Second box is with a bigger volume!");
			System.out.println(box2.toString());
		}
	}

}
