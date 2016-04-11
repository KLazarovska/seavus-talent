
public class ZipCode {
	private String zipCode;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		if (checkSize(zipCode) && isDigit(zipCode)){
			this.zipCode = zipCode;
		}
	}
	
	public boolean isDigit(String zipCode){ 
		
		try{
			int code = Integer.parseInt(zipCode);
		}catch(NumberFormatException e){
			throw new ZipCodeException("invalid input format");
		}
		return true;
	}
	
	public boolean checkSize(String zipCode){
		
		if(zipCode.length() != 5 && zipCode.length() != 9){
			throw new ZipCodeException("invalid size");
		}
		else{
			return true;
		}
	}

}
