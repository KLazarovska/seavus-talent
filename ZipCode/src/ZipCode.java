
public class ZipCode {
	
	private String zipCode;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		if ((zipCode.length() == 5 || zipCode.length() == 9) && isDigit(zipCode)){
			this.zipCode = zipCode;
		}
	}
	
	public boolean isDigit(String zipCode){
		char character[] = zipCode.toCharArray();
		
		for (int i = 0; i < zipCode.length(); i++){
			if(!Character.isDigit(character[i])){
				return false;
			}
		}
		return true;
	}

}
