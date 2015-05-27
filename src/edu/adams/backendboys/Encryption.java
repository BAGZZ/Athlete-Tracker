package edu.adams.backendboys;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class Encryption {
	private static final String IV="buEEskxDqLMdhbus";
	private static final String encryptionKey= "ASUATHLETETRACKR";
	public static String tacOn ="\0\0\0\0\0\0\0";
	
	private Encryption(){
		
	}
	
	  public static byte[] encrypt(String plainText) throws Exception {
		  	String data= plainText+Encryption.tacOn;
		    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		    SecretKeySpec key = new SecretKeySpec(Encryption.encryptionKey.getBytes("UTF-8"), "AES");
		    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
		    return cipher.doFinal(data.getBytes("UTF-8"));
	  }
		 
	  public static String decrypt(byte[] cipherText) throws Exception{
		    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		    SecretKeySpec key = new SecretKeySpec(Encryption.encryptionKey.getBytes("UTF-8"), "AES");
		    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
		    return new String(cipher.doFinal(cipherText),"UTF-8");
	  }
	
	public static void main(String[] args){
		String number ="857498578";
		try {
			 
			System.out.println(number+"\n"+new String(Encryption.encrypt(number),"UTF-8")+"\n"+Encryption.decrypt((Encryption.encrypt(number))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
