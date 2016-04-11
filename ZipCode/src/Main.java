
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZipCode z = new ZipCode();
		
		z.setZipCode("12345");
		System.out.println(z.getZipCode());
		
		z.setZipCode("aaaaa");
		System.out.println(z.getZipCode());

	}

}
