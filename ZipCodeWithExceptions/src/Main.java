
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZipCode z = new ZipCode();
		
		try{
			z.setZipCode("12345");
			System.out.println(z.getZipCode());
		}catch(ZipCodeException e){
			System.out.println(e.getMessage());
		}
	}

}
